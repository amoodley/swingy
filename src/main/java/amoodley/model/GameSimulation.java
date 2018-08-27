package amoodley.model;

import amoodley.config.Config;
import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;
import amoodley.providers.DataProvider;
import amoodley.utilities.WriteFile;

import java.util.Random;

public class GameSimulation {

    private Hero        hero;
    private Enemy       enemy;
    private String      simulationOutput = "";
    private int         simulationCount = 0;
    private int         simulationMiliSecs = 1500;
    private static int  copyHP;
    private Random      rand;
    private static int  artifactType;
    private String      attacks[] = {"Gomu Gomu no Bazooka", "Fireball", "Hadouken", "Shockwave", "Blizzard", "Twisting Bolt", "Falcon Punch", "Serpent Sting", "Dual Slash", "Paralyzing Chain"};
    public static int   oldX;
    public static int   oldY;

    public GameSimulation(Hero hero, Enemy enemy){

        this.hero = hero;
        this.enemy = enemy;
        setCopyHP(this.hero.getHitPoints());
        this.rand = new Random();

        WriteFile.write(WriteFile.SimulationOutputName, "", false);
        WriteFile.write(WriteFile.SimulationOutputName, this.getVSmessage() + "\n", true);
    }

    public Boolean nextFight() throws InterruptedException {

        if (this.isHeroAlive(this.hero) && this.isHeroAlive(this.enemy)){

            int rn = this.rand.nextInt(2);
            int attackRan = this.rand.nextInt(10);
            int dmg = 0;
            String attacker, attacked;
            simulationCount++;

            if (rn == 0){
                dmg = this.fixDmg(this.hero.getAttack() - this.enemy.getDefense());
                this.enemy.setHitPoints(this.enemy.getHitPoints() - dmg);
                attacked = enemy.getName();
                attacker = hero.getName();
            } else {

                dmg = this.fixDmg(this.enemy.getAttack() - this.hero.getDefense());
                this.hero.setHitPoints(this.hero.getHitPoints() - dmg);
                attacked = hero.getName();
                attacker = enemy.getName();
            }
            simulationOutput = attacker + " hits " + attacked + " with a " + this.attacks[attackRan] + " Attack, Causing " + dmg + " damage.";
            WriteFile.write(WriteFile.SimulationOutputName, simulationOutput + "\n", true);
            WriteFile.write(WriteFile.SimulationOutputName, hero.getName() + ": " + hero.getHitPoints() + "HP - " + enemy.getName() + ": " + enemy.getHitPoints() + "HP\n", true);
            Thread.sleep(this.simulationMiliSecs);
            return (true);
        }
        return (false);
    }

    private int fixDmg(int dmg){

        if (dmg <= 0){
            return (0);
        }
        return (dmg);
    }

    public static void setCopyHP(int hp){

        copyHP = hp;
    }

    public static void resetHero(Hero hero){

        hero.setHitPoints(copyHP);
    }

    public static void lostGame(Hero hero){

        resetHero(hero);

        DataProvider dp = new DataProvider(Config.DATA_PROVIDER);
        dp.updateHero(hero);
    }

    public String getVSmessage(){

        return (this.hero.getName() + " (" + this.hero.getHitPoints() + "HP) VS " + this.enemy.getName() + " (" + this.enemy.getHitPoints() + "HP)");
    }

    public static void winFight(Hero hero, Enemy enemy){

        hero.setExperience(hero.getExperience() + enemy.getExperience());
    }

    public static void winGame(Hero hero){

        resetHero(hero);
        hero.setExperience(hero.getExperience() + 200);
        DataProvider dp = new DataProvider(Config.DATA_PROVIDER);
        dp.updateHero(hero);
    }

    public static String dropArtifact(Enemy enemy){

        Random rand = new Random();

        switch (rand.nextInt(3)){

            case 0:
                artifactType = 0;
                return enemy.getWeapon().toString();
            case 1:
                artifactType = 1;
                return enemy.getArmor().toString();
            case 2:
                artifactType = 2;
                return enemy.getHelm().toString();
        }
        return (null);
    }

    public static void setArtifact(Hero hero, Enemy enemy){

        if (artifactType == 0){

            hero.setWeapon(enemy.getWeapon());
            hero.setAttack(hero.getAttack() + 2);
        } else if (artifactType == 1){

            hero.setArmor(enemy.getArmor());
            hero.setDefense(hero.getDefense() + 2);
        } else {

            hero.setHelm(enemy.getHelm());
            hero.setHitPoints(hero.getHitPoints() + 2);
        }
    }

    public int getSimulationCount(){

        return (this.simulationCount);
    }

    public String getSimulationOutput(){

        return (this.simulationOutput);
    }

    public Boolean isHeroAlive(Hero hero){

        return (hero.getHitPoints() > 0);
    }

    public Hero getHero(){

        return (this.hero);
    }

    public Enemy getEnemy(){

        return (this.enemy);
    }

    public void setSimulationMiliSecs(int value){

        this.simulationMiliSecs = value;
    }

    public int getSimulationMiliSecs(){

        return (this.simulationMiliSecs);
    }

}
