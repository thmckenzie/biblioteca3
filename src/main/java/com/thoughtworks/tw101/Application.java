package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by tafarii on 9/28/16.
 */
public class Application {


    private PrintStream printStream;
    private Menu menu;

    public Application(PrintStream printStream, Menu menu) {
        this.printStream = printStream;

        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome!");
        menu.display();
        menu.performOption();

    }

}
