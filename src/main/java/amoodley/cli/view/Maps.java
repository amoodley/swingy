package amoodley.cli.view;

import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;
import amoodley.utilities.Formula;

import java.util.List;
import java.util.Random;

public class Maps {

    private Random rand = new Random();
    private int mapSize;

    private static List<Enemy> enemyList;
    private static Enemy enemy;

    public void init(Hero hero){

        this.mapSize = Formula.sizeMap(hero.getLevel());
        hero.setXpos(this.mapSize / 2);
        hero.setYpos(this.mapSize / 2);
        enemyList = EnemyFactory.getEnemyList(hero);
    }
}
