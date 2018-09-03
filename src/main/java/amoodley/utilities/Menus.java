package amoodley.utilities;

import amoodley.model.characters.Enemy;
import amoodley.model.characters.Hero;

import static amoodley.content.Colors.ANSI_RESET;
import static amoodley.content.Colors.ANSI_BLACK;
import static amoodley.content.Colors.ANSI_RED;
import static amoodley.content.Colors.ANSI_GREEN;
import static amoodley.content.Colors.ANSI_YELLOW;
import static amoodley.content.Colors.ANSI_BLUE;
import static amoodley.content.Colors.ANSI_PURPLE;
import static amoodley.content.Colors.ANSI_CYAN;
import static amoodley.content.Colors.ANSI_WHITE;

public class Menus {

    public static void menu(){

        System.out.println("------------------------------------");
        System.out.println(ANSI_GREEN + "\tSELECT AN OPTION");
        System.out.println(ANSI_CYAN + "\t1. Create a Hero");
        System.out.println("\t2. Select a Hero");
        System.out.println("\t3. Exit" + ANSI_RESET);
    }

    public static void heroMenu(){

        System.out.println("------------------------------------");
        System.out.println(ANSI_GREEN + "\tSELECT A HERO TYPE");
        System.out.println(ANSI_CYAN + "\t1. Warrior");
        System.out.println("\t2. Hunter");
        System.out.println("\t3. Mage");
        System.out.println("\t0. Exit" + ANSI_RESET);
    }

    public static void printStats(Hero _hero){

        String hero_info = ANSI_GREEN + "\n\tYOUR HERO STATS\n" +
                ANSI_CYAN + "\tName: " + _hero.getName() + "\n" +
                "\tType: " + _hero.getType() + "\n" +
                "\tLevel: " + _hero.getLevel() + "\n" +
                "\tExperience: " + _hero.getExperience() + "\n" +
                "\tAttack: " + _hero.getAttack() + "\n" +
                "\tDefense: " + _hero.getDefense() + "\n" +
                "\tHit Points: " + _hero.getHitPoints() + "\n" +
                "\tWeapon: " + _hero.getWeapon() + "\n" +
                "\tArmor: " + _hero.getArmor() + "\n" +
                "\tHelm: " + _hero.getHelm() + "\n" + ANSI_RESET;

        System.out.print(hero_info);
    }

    public static String printHeroNames(Hero hero){

        String heroNames = hero.getName() + "\n";
        return (heroNames);
    }

    public static void printMovementMenu(){

        String movement = ANSI_GREEN + "\nCHOOSE A DIRECTION TO MOVE IN\n" +
                ANSI_CYAN + "\t1. North\n" +
                "\t2. East\n" +
                "\t3. West\n" +
                "\t4. South\n" +
                "\t0. Back\n" + ANSI_RESET;
        System.out.print(movement);
    }

    public static void SimulationChoice(){

        String choice = ANSI_GREEN + "\nYOU HAVE ENCOUNTERED AN ENEMY, WHAT WILL YOU DO?\n\n" +
                ANSI_CYAN + "\t1. RUN\n" +
                "\t2. FIGHT\n" + ANSI_RESET;
        System.out.print(choice);
    }

    public static void PrintFightOpponents(Hero hero, Enemy enemy){

        System.out.println(ANSI_GREEN + hero.getName() + ANSI_RESET + "\t\tVS\t" + ANSI_RED + enemy.getName());
        System.out.println(ANSI_GREEN + "Attack: " + hero.getAttack() + ANSI_RESET + "\t|\t" + ANSI_RED +  enemy.getAttack());
        System.out.println(ANSI_GREEN + "Defense: " + hero.getDefense() + ANSI_RESET +"\t|\t" + ANSI_RED + enemy.getDefense());
        System.out.println(ANSI_GREEN +"Hit Points: " + hero.getHitPoints() + ANSI_RESET +"\t|\t" + ANSI_RED + enemy.getHitPoints());
        System.out.println(ANSI_GREEN + "Weapon: " + hero.getWeapon() + ANSI_RESET + "\t|\t" + ANSI_RED + enemy.getWeapon());
        System.out.println(ANSI_GREEN + "Armor: " + hero.getArmor() + ANSI_RESET + "\t|\t" + ANSI_RED + enemy.getArmor());
        System.out.println(ANSI_GREEN + "Helm: " + hero.getHelm() + ANSI_RESET + "\t|\t" + ANSI_RED + enemy.getHelm() + ANSI_RESET);
    }
}
