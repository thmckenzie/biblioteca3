package com.thoughtworks.tw101;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tafarii on 9/28/16.
 */
public class BookTest {
    @Test
    public void shouldDisplayTitleAuthorAndYearWhenCallingDisplay() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book(printStream, "Title", "Author", "Year");
        book.display();
        verify(printStream).println("Title | Author | Year");
    }
}
