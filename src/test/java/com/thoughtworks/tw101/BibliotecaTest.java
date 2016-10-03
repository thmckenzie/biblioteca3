package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tafarii on 9/27/16.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private List<Book> books;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(books, printStream);
    }

    @Test
    public void shouldDisplayOneBookWhenStartingWithOneBook() throws Exception {
        Book book = mock(Book.class);
        books.add(book);
        biblioteca.listBooks();
        verify(book).display();
    }

    @Test
    public void shouldDisplayTwoBooksWhenStartingWithTwoBooks() throws Exception {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        biblioteca.listBooks();
        verify(book1).display();
        verify(book2).display();
    }

    @Test
    public void shouldUpdateBookListWhenRemovingBook() throws Exception {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        biblioteca.removeBook(1);
        assertEquals(books.size(), 1);

    }
}