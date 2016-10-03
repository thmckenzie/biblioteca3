package com.thoughtworks.tw101;

/**
 * Created by lduan on 9/30/16.
 */
public class ListBooksOption implements Option {
    private Biblioteca biblioteca;

    public ListBooksOption(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.listBooks();
    }
}
