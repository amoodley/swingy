package amoodley.factories;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;
import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;
import amoodley.utilities.Coordinates;
import amoodley.utilities.Formula;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFactory {

    public static String[] enemyName = {"Zombie", "Skeleton", "Troll", "Ogre", "Rogue", "Assassin", "Thief", "Bandit", "Dark Knight", "Bandit"};

    public static List<Enemy> getEnemyList(Hero hero){

        List<Enemy> enemyList = new ArrayList<Enemy>();
        Random random = new Random();
        int mapSize = Formula.sizeMap(hero.getLevel());
        int level = hero.getLevel();
        int numberOfEnemies = Formula.getNumberOfEnemies(level);

        for (int i = 0; i <= numberOfEnemies; i++){

            Enemy enemy = new Enemy(enemyName[random.nextInt(6)],
                    CharacterType.enemy,
                    level,
                    5 + random.nextInt(hero.getHitPoints()),
                    10 + random.nextInt(hero.getAttack()),
                    5 + random.nextInt(hero.getDefense()),
                    20 + random.nextInt(hero.getHitPoints() - 10),
                    WeaponType.values()[random.nextInt(WeaponType.values().length)],
                    ArmorType.values()[random.nextInt(ArmorType.values().length)],
                    HelmType.values()[random.nextInt(HelmType.values().length)],
                    "");

            enemy.setCoordinates(new Coordinates(random.nextInt(mapSize), random.nextInt(mapSize)));
            if (isSamePosition(enemyList, enemy) || enemy.getCoordinates().isEquals(hero.getCoordinates())){

                i--;
                continue;
            }
            enemyList.add(enemy);
        }
        return (enemyList);
    }

    private static Boolean isSamePosition(List<Enemy> enemyList, Enemy enemy){

        for (Enemy e: enemyList){

            if (enemy.getCoordinates().isEquals(e.getCoordinates())){

                return (true);
            }
        }
        return (false);
    }
}
