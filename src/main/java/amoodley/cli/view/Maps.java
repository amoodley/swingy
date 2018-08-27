package amoodley.cli.view;

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

        
    }
}
