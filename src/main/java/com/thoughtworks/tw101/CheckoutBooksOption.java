package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 9/30/16.
 */
public class CheckoutBooksOption implements Option {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private InputReader inputReader;

    public CheckoutBooksOption(Biblioteca biblioteca, PrintStream printStream, InputReader inputReader) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    @Override
    public void run() {
        biblioteca.listBooks();
        printStream.println("Select a book to checkout");
        int book = Integer.parseInt(inputReader.getString());
        biblioteca.removeBook(book);

    }
}
