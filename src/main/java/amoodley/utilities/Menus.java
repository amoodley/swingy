package amoodley.utilities;

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
}
