package com.reto_3;

import com.reto_3.Exeptions.NotFoundException;
import com.reto_3.Model.Book;
import com.reto_3.Service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void testAddBookAndGetBookByIsbn() throws NotFoundException {
        bookService.addBook("123", "El Principito", "Antoine de Saint-Exupéry");
        Book book = bookService.getBookByIsbn("123");

        assertNotNull(book);
        assertEquals("123", book.getIsbn());
        assertEquals("El Principito", book.getTitle());
    }

    @Test
    public void testGetBookNotFound() {
        assertThrows(NotFoundException.class, () -> {
            bookService.getBookByIsbn("999");
        });
    }

    @Test
    public void testDeleteBook() throws NotFoundException {
        bookService.addBook("456", "1984", "George Orwell");
        bookService.deleteBook("456");

        assertThrows(NotFoundException.class, () -> bookService.getBookByIsbn("456"));
    }
}

