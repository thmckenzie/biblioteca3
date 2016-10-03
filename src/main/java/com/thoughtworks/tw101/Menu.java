package com.thoughtworks.tw101;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tafarii on 9/28/16.
 */
public class Menu {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private InputReader inputReader;

    public Menu(PrintStream printStream, Biblioteca biblioteca, InputReader inputReader) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.inputReader = inputReader;
    }

    public void display() {
        printStream.println("Please select an option");
        printStream.println("1: List Books");
        printStream.println("2: Checkout Books");
        printStream.println("q: Quit");
    }

    public void performOption() {
        String choice = inputReader.getString();

        while (choice != "q") {
            //choice = getString(choice);
            choice = processInput(choice);
        }
    }


    private String processInput(String input){
        display();

        Map<String, Option> options = new HashMap<>();
        options.put("1", new ListBooksOption(biblioteca));
        options.put("2", new CheckoutBooksOption(biblioteca, printStream, inputReader));
        // options.put("q", new QuitOption());
        if (options.containsKey(input)) {
            options.get(input).run();
        }


        else if(input.equals("q")) {
            printStream.println("Exiting application");
            return "q";
        }
        else {
            printStream.println("Select a valid option!");
        }
        return inputReader.getString();

    }

}
