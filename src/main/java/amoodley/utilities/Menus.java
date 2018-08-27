package amoodley.utilities;

import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;

public class Menus {

    public static void menu(){

        System.out.println("-------------------------------");
        System.out.println("\tSELECT AN OPTION");
        System.out.println("\t1. Create a Hero");
        System.out.println("\t2. Select a Hero");
        System.out.println("\t3. Exit");
    }

    public static void heroMenu(){

        System.out.println("-------------------------------");
        System.out.println("\tSELECT A HERO TYPE");
        System.out.println("\t1. Warrior");
        System.out.println("\t2. Hunter");
        System.out.println("\t3. Mage");
        System.out.println("\t4. Exit");
    }

    public static void printStats(Hero _hero){

        String hero_info = "\nYOUR HERO STATS\n" +
                "\tName: " + _hero.getName() + "\n" +
                "\tType: " + _hero.getType() + "\n" +
                "\tLevel: " + _hero.getLevel() + "\n" +
                "\tExperience: " + _hero.getExperience() + "\n" +
                "\tAttack: " + _hero.getAttack() + "\n" +
                "\tDefense: " + _hero.getDefense() + "\n" +
                "\tHit Points: " + _hero.getHitPoints() + "\n" +
                "\tWeapon: " + _hero.getWeapon() + "\n" +
                "\tArmor: " + _hero.getArmor() + "\n" +
                "\tHelm: " + _hero.getHelm() + "\n";

        System.out.print(hero_info);
    }

    public static String printHeroNames(Hero hero){

        String heroNames = hero.getName() + "\n";
        return (heroNames);
    }

    public static void printMovementMenu(){

        String movement = "\nCHOOSE A DIRECTION TO MOVE IN\n" +
                "\t1. North\n" +
                "\t2. East\n" +
                "\t3. West\n" +
                "\t4. South\n" +
                "\t0. Back\n";
        System.out.print(movement);
    }

    public static void SimulationChoice(){

        String choice = "\nYOU HAVE ENCOUNTERED AN ENEMY, WHAT WILL YOU DO?\n\n" +
                "\t1. RUN\n" +
                "\t2. FIGHT\n";
        System.out.print(choice);
    }

    public static void PrintFightOpponents(Hero hero, Enemy enemy){

        System.out.println(hero.getName() + "\tVS\t" + enemy.getName());
        System.out.println("Attack: " + hero.getAttack() + "\t|\t" + enemy.getAttack());
        System.out.println("Defense: " + hero.getDefense() + "\t|\t" + enemy.getDefense());
        System.out.println("Hit Points: " + hero.getHitPoints() + "\t|\t" + enemy.getHitPoints());
        System.out.println("Weapon: " + hero.getWeapon() + "\t|\t" + enemy.getWeapon());
        System.out.println("Armor: " + hero.getArmor() + "\t|\t" + enemy.getArmor());
        System.out.println("Helm: " + hero.getHelm() + "\t|\t" + enemy.getHelm());
    }
}
