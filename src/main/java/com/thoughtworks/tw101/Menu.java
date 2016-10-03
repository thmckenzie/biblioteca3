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
        display();

        String choice = inputReader.getString();

        while (!choice.equals( "q")) {
            //choice = getString(choice);
            processInput(choice);

            display();

            choice = inputReader.getString();
        }
        printStream.println("Exiting application");

    }


    private void processInput(String input){
        Map<String, Option> options = new HashMap<>();
        options.put("1", new ListBooksOption(biblioteca));
        options.put("2", new CheckoutBooksOption(biblioteca, printStream, inputReader));

        if (options.containsKey(input)) {
            options.get(input).run();
        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
