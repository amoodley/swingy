package amoodley;

import amoodley.cli.view.ConsoleView;

import static amoodley.content.Colors.ANSI_GREEN;
import static amoodley.content.Colors.ANSI_RESET;

public class App {

    public static void main(String[] args) {

        ConsoleView consoleView = new ConsoleView();

        if (args[0].equalsIgnoreCase("cli")){

            System.out.println(" ");
            System.out.println(ANSI_GREEN + "\tWelcome to Swingy " + ANSI_RESET);

            consoleView.start();

        } else if (args[0].equalsIgnoreCase("gui")){

            System.out.println("GUI");
        }

    }

}
