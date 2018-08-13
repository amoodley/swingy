package amoodley;

import amoodley.cli.view.ConsoleView;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        ConsoleView consoleView = new ConsoleView();

        if (args[0].equalsIgnoreCase("cli")){

            System.out.println(" Console View ");
            System.out.println(" ");
            System.out.println(" Welcome to Swingy ");

            consoleView.start();

        } else if (args[0].equalsIgnoreCase("gui")){

            System.out.println("GUI");
        }

    }

}
