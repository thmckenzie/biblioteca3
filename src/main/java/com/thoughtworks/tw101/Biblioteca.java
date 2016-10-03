package com.thoughtworks.tw101;

import java.util.List;

/**
 * Created by tafarii on 9/27/16.
 */
public class Biblioteca {
    private List<Book> books;

    public Biblioteca(List<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    public void removeBook(int book) {
        books.remove(book-1);
    }
}
