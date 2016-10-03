package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tafarii on 9/28/16.
 */
public class ApplicationTest {
    private PrintStream printStream;
    private Application application;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        application = new Application(printStream, menu);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() throws Exception {
        application.start();

        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldDisplayMenuWhenStarting() throws Exception {
        application.start();
        verify(menu).display();
    }

}