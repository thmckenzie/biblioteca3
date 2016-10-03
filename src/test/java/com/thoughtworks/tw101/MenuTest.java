package com.thoughtworks.tw101;

import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tafarii on 9/28/16.
 */
public class MenuTest {
    PrintStream printStream;
    Menu menu;
    private Biblioteca biblioteca;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        inputReader = mock(InputReader.class);
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, biblioteca, inputReader);
    }

    @Test
    public void shouldDisplayOptionListBooksWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        verify(printStream).println("1: List Books");
    }

    @Test
    public void shouldPrintPromptWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        verify(printStream).println("Please select an option");
    }

    @Test
    public void shouldListBooksWhenUserInputsOne() throws Exception {
        when(inputReader.getString()).thenReturn("1", "q");
        menu.display();
        menu.performOption();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldDisplayErrorMessageWhenSelectingInvalidOption() throws Exception {
        when(inputReader.getString()).thenReturn("x", "q");
        menu.display();
        menu.performOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldBeAbleToContinueChoosingOptionsWhenFirstOptionIsInvalid() throws Exception {
        when(inputReader.getString()).thenReturn("x", "1", "q");
        menu.display();
        menu.performOption();
        verify(biblioteca).listBooks();

    }

    @Test
    public void shouldDisplayCheckoutOptionWhenMenuIsDisplayed() throws Exception {
        when(inputReader.getString()).thenReturn("q");
        menu.display();
        menu.performOption();
        verify(printStream).println("2: Checkout Books");

    }

    @Test
    public void shouldDisplayListOfBooksWhenCheckoutOptionIsSelected() throws Exception {
        when(inputReader.getString()).thenReturn("2", "1", "q");
        menu.display();
        menu.performOption();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldPromptUserForBookToCheckout() throws Exception {
        when(inputReader.getString()).thenReturn("2","1", "q");
        menu.display();
        menu.performOption();
        verify(printStream).println("Select a book to checkout");
    }


    @Test
    public void shouldRemoveSelectedBookFromBookListWhenBookIsCheckedOut() throws Exception {
        when(inputReader.getString()).thenReturn("2", "1","q");
        menu.display();
        menu.performOption();
        verify(biblioteca).removeBook(1);

    }
}
