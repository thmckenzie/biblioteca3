package com.thoughtworks.tw101;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by tafarii on 9/27/16.
 */
public class Biblioteca {
    private List<Book> books;
    private PrintStream printStream;

    public Biblioteca(List<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        int i = 1;
        for (Book book : books) {
            printStream.print(i + ") ");
            book.display();
            i++;
        }
    }

    public void removeBook(int book) {
        books.remove(book-1);
    }
}
