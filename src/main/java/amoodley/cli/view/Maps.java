package amoodley.cli.view;

import amoodley.config.Config;
import amoodley.factories.EnemyFactory;
import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;
import amoodley.model.GameSimulation;
import amoodley.utilities.Coordinates;
import amoodley.utilities.Formula;
import amoodley.utilities.Menus;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Maps {

    private Random rand = new Random();
    private int mapSize;

    private static List<Enemy> enemyList;
    private static Enemy enemy;

    public void init(Hero hero){

        this.mapSize = Formula.sizeMap(hero.getLevel());
        hero.setCoordinates(new Coordinates(this.mapSize / 2, this.mapSize / 2));
        enemyList = EnemyFactory.getEnemyList(hero);
    }

    public void move(Scanner scan, Hero hero, int mapSize){

        if (hero.getCoordinates().getX() == mapSize || hero.getCoordinates().getY() == mapSize ||
                hero.getCoordinates().getX() == -1 || hero.getCoordinates().getY() == -1){

            System.out.println("_______________YOU WON THE GAME_______________");
            GameSimulation.winGame(hero);
            ConsoleView.start();
        }
        for (Enemy enemyLoop: enemyList){

            if (enemyLoop.getCoordinates().isEquals(hero.getCoordinates())){

                Menus.SimulationChoice();
                FightOrRun(hero, enemyLoop);
            }
        }

        while (scan.hasNextLine()){

            if (scan.hasNextInt()){

                int n = scan.nextInt();
                GameSimulation.oldX = hero.getCoordinates().getX();
                GameSimulation.oldY = hero.getCoordinates().getY();

                switch (n){

                    case 1:
                        hero.getCoordinates().advance(1);
                        break;
                    case 2:
                        hero.getCoordinates().advance(2);
                        break;
                    case 3:
                        hero.getCoordinates().advance(3);
                        break;
                    case 4:
                        hero.getCoordinates().advance(4);
                        break;
                    case 0:
                        ConsoleView.start();
                        break;
                    default:
                        break;
                }
                drawMap(hero);
            } else {

                System.out.println("Input must be numeric, please select another option");
                drawMap(hero);
            }
        }
    }

    public void drawMap(Hero hero){

        System.out.println(" ");
        System.out.println("YOUR COORDINATES: " + hero.getCoordinates().getX() + ", " + hero.getCoordinates().getY());

        for (int x = 0; x < this.mapSize; x++){

            for (int y = 0; y < this.mapSize; y++){

                Coordinates loopCoordinates = new Coordinates(x, y);
                boolean didShow = false;
                if (loopCoordinates.isEquals(hero.getCoordinates())){

                    System.out.print("0 ");
                } else {

                    for (Enemy enemyModel: enemyList){

                        if (loopCoordinates.isEquals(enemyModel.getCoordinates())){

                            if (Config.IS_DEVELOPMENT)
                                System.out.print("E ");
                            else
                                System.out.print("* ");
                            didShow = true;
                        } else if (hero.getCoordinates().isEquals(enemyModel.getCoordinates())){

                            enemy = enemyModel;
                        }
                    }
                    if (!didShow){

                        System.out.print("* ");
                    }
                }
            }
            System.out.print("\n");
        }
        Menus.printMovementMenu();
        Scanner reader = new Scanner(System.in);
        move(reader, hero, mapSize);
    }

    private void FightOrRun(Hero hero, Enemy enemyModel){

        if (enemy.getHitPoints() > 0){

            Scanner _reader = new Scanner(System.in);
            while (_reader.hasNextInt()){

                if (_reader.hasNextInt()){

                    int n = _reader.nextInt();
                    switch(n){

                        case 1:
                            int rn = rand.nextInt(2);
                            if (rn == 0){

                                System.out.println("YOU HAVE MANAGED TO EVADE THE ENEMY");
                                hero.getCoordinates().setX(GameSimulation.oldX);
                                hero.getCoordinates().setY(GameSimulation.oldY);
                                drawMap(hero);
                            } else if (rn == 1){

                                System.out.println("UNFORTUNATELY YOU DIDN'T MANAGE TO ESCAPE");
                                Fight(hero, enemyModel);
                            }
                            break;
                        case 2:
                            Fight(hero, enemyModel);
                            break;
                        default:
                            break;
                    }
                } else {

                    System.out.println("Input must be numeric, please select another option");
                    FightOrRun(hero, enemyModel);
                }
            }
        }
    }

    private void Fight(Hero hero, Enemy enemy){

        String artifact;

        Menus.PrintFightOpponents(hero, enemy);
        try {

            GameSimulation gs = new GameSimulation(hero, enemy);
            gs.setSimulationMiliSecs(500);
            while (gs.nextFight()){

                System.out.println(gs.getSimulationOutput());
                System.out.println("HERO: " + hero.getHitPoints() + "\t|\t" + "ENEMY: " + enemy.getHitPoints());
            }
            if (!gs.isHeroAlive(gs.getHero()) && !gs.isHeroAlive(gs.getEnemy())){

                System.out.println("Seems everyone has died. Including You!");
            } else {

                String msg = "";
                if (gs.isHeroAlive(gs.getHero())){

                    msg = gs.getHero().getName() + " WON THE FIGHT!";
                    System.out.println("FIGHT WON: " + msg);
                    GameSimulation.resetHero(hero);
                    GameSimulation.winFight(hero, enemy);
                    artifact = GameSimulation.dropArtifact(enemy);
                    System.out.println("THE ENEMY DROPPED A " + artifact + ". DO YOU WISH TO KEEP IT?");
                    System.out.println("\t1. YES");
                    System.out.println("\t2. NO");
                    PickOrNot(hero, enemy);
                    enemyList.remove(enemy);
                    drawMap(hero);
                } else {

                    msg = gs.getEnemy().getName() + " WON THE FIGHT";
                    System.out.println("FIGHT LOST: " + msg);
                    System.out.println(" ");
                    System.out.println("_______________GAME OVER_______________");
                    System.out.println(" ");
                    GameSimulation.lostGame(hero);
                    ConsoleView.start();
                }
            }
        } catch (Exception e){

            System.out.println("SOMETHING WENT WRONG.");
        }
    }

    private void PickOrNot(Hero hero, Enemy enemy){

        Scanner read = new Scanner(System.in);
        int choice = 0;

        while (choice != -1){

            choice = read.nextInt();
            switch (choice){

                case 1:
                    GameSimulation.setArtifact(hero, enemy);
                    choice = -1;
                    break;
                case 2:
                    choice = -1;
                    break;
            }
        }
    }
}
