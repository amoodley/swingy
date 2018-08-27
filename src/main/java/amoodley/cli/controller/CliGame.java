package amoodley.cli.controller;

import amoodley.cli.view.ConsoleView;
import amoodley.cli.view.Maps;
import amoodley.model.characters.Hero;
import amoodley.utilities.Menus;

import java.util.Scanner;

public class CliGame {

    private static Hero _hero;

    public static void run(Hero hero){

        Scanner scan = new Scanner(System.in);
        int i;
        _hero = hero;
        Menus.printStats(_hero);
        System.out.println("___________ DARE TO START THE GAME __________");
        System.out.println("\tDO YOU WISH TO CONTINUE WITH THIS HERO?: " + hero.getName());
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");

        i = ConsoleView.getSafeNum(scan.nextLine());
        switch(i){

            case 1:
                System.out.println("YOUR MISSION IS TO GET TO THE END OF THE MAP. ENJOY!");
                Maps map = new Maps();
        }
    }
}
