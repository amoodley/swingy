package amoodley.cli.view;

import amoodley.utilities.Menus;
import amoodley.enums.CharacterType;
import amoodley.providers.Cache;
import amoodley.model.characters.Character;
import amoodley.model.characters.Hero;

import java.util.Scanner;


public class ConsoleView {

    public static Hero _hero;

    public static void start(){

        Scanner read = new Scanner(System.in);
        Menus.menu();
        while (read.hasNextLine()){

            if (read.hasNextInt()){

                int n = read.nextInt();

                switch(n) {
                    case 1:
                        createHero();
                        break;
                    case 2:
                        // existingHero();
                        break;
                    case 3:
                        System.out.println("\tThank you for playing !");
                        System.exit(0);
                    default:
                        System.out.println("\tUnrecognised option selected");
                        start();
                        break;
                }
            } else {
                System.out.println("\tPlease enter the number of your choice");
                start();
            }
        }
        read.close();
    }

    public static void createHero(){

        Scanner reader = new Scanner(System.in);
        Menus.heroMenu();

        while (reader.hasNextLine()){

            if (reader.hasNextInt()){

                int n = reader.nextInt();

                switch (n){

                    case 0:
                        // Go Back
                        start();
                        break;
                    case 1:
                        // Warrior
                        declareHero(CharacterType.warrior);
                        break;
                    case 2:
                        // Hunter
                        declareHero(CharacterType.hunter);
                        break;
                    case 3:
                        //Mage
                        declareHero(CharacterType.mage);
                        break;
                    default:
                        System.out.println("\tUnrecognised option selected");
                }
            } else {

                System.out.println("\tPlease enter the number of your choice");
                createHero();
            }
        }
        reader.close();
    }

    public static void declareHero(CharacterType hType) {

        System.out.println("\tGive your " + hType + " a name:");
        Scanner reader = new Scanner(System.in);
        String name = null;
        if (Cache.HeroList != null &&Cache.HeroList.size() != 0){

            while (true) {

                boolean isFound = false;
                name = reader.nextLine();

                for (Hero hero : Cache.HeroList){

                    if (hero.getName().equalsIgnoreCase(name) && isFound == false){
                        System.out.println("A Hero with name already exists. Please try another name.");
                        isFound = true;
                    }
                }
                if (!isFound){

                    break;
                }
            }
        } else {

            name = reader.nextLine();
        }
        _hero = HeroFactory.newHero(name, hType, null);
    }
}
