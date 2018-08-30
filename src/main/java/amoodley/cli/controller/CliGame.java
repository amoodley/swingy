package amoodley.cli.controller;

import amoodley.cli.view.ConsoleView;
import amoodley.cli.view.Maps;
import amoodley.model.characters.Hero;
import amoodley.utilities.Menus;

import java.io.Console;
import java.util.Scanner;

import static amoodley.content.Colors.ANSI_CYAN;
import static amoodley.content.Colors.ANSI_GREEN;
import static amoodley.content.Colors.ANSI_RESET;

public class CliGame {

    private static Hero _hero;

    public static void run(Hero hero){

        Scanner scan = new Scanner(System.in);
        int i;
        _hero = hero;
        Menus.printStats(_hero);
        System.out.println("\n___________ " + ANSI_GREEN + "DARE TO START THE GAME" + ANSI_RESET + " __________");
        System.out.println("\n\t"+ ANSI_GREEN +"DO YOU WISH TO CONTINUE WITH THIS HERO?: " + hero.getName());
        System.out.println(ANSI_CYAN + "\t1. Yes");
        System.out.println("\t2. No" + ANSI_RESET);

        i = ConsoleView.getSafeNum(scan.nextLine());
        switch(i){

            case 1:
                System.out.println("YOUR MISSION IS TO GET TO THE END OF THE MAP. ENJOY!");
                Maps map = new Maps();
                map.init(_hero);
                map.drawMap(_hero);
            case 2:
                ConsoleView.existingHero();
            default:
                run(hero);
        }
    }
}
