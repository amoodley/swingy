package amoodley.cli.view;

import amoodley.cli.controller.CliGame;
import amoodley.providers.DataProvider;
import amoodley.utilities.Menus;
import amoodley.enums.CharacterType;
import amoodley.providers.Cache;
import amoodley.factories.HeroFactory;
import amoodley.model.characters.Hero;
import amoodley.config.Config;

import java.util.List;
import java.util.Scanner;


public class ConsoleView {

    public static List<Hero> heroList;
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
        _hero = HeroFactory.newHero(name, hType);
        DataProvider dataProvider = new DataProvider(Config.DATA_PROVIDER);
        dataProvider.insertHero(_hero);
        CliGame.run(_hero);
    }

    public static void existingHero(){

        Scanner reader= new Scanner(System.in);
        Hero hero = null;
        int count  = 1;
        int i = 0;
        String tempHeroNamestr = "";
        String seperator = ". ";
        boolean isMatch = false;
        heroList = Cache.HeroList;

        if (heroList== null || heroList.size() <= 0){
            System.out.println("THERE ARE NO HEROES YOU CAN CHOOSE");
            start();
        } else {
            System.out.println("CHOOSE YOUR CHARACTER");
            for (int index = 0; index < heroList.size(); index++){
                System.out.print(count);
                System.out.print(seperator);
                System.out.print(Menus.printHeroNames(heroList.get(index)));
            }
        }

    }


    public static int getSafeNum(String num){

        try {
            return (Integer.parseInt(num));
        } catch (Exception e) {
            return (-1);
        }
    }

    private static Hero getHeroAtIndex(int index, List<Hero> heroList){

        if (index > heroList.size() || index <= 0){

            return (null);
        } else {
            return (heroList.get(index - 1));
        }
    }
}
