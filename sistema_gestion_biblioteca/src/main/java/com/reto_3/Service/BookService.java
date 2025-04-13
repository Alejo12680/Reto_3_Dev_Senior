package com.reto_3.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.reto_3.Exeptions.NotFoundException;
import com.reto_3.Model.Book;

public class BookService {
  private static final Logger logger = Logger.getLogger(BookService.class.getName());
  private List<Book> books;

  public BookService() {
    books = new ArrayList<>();
    logger.info("BookService inicializado");
  }

  public void addBook(String isbn, String title, String author) {
    books.add(new Book(isbn, title, author));
    logger.info("Libro agregado: " + title + " (ISBN: " + isbn + ")");
  }

  public Book getBookByIsbn(String isbn) throws NotFoundException {
    for (var book : books) {
      if (book.getIsbn().equals(isbn)) {
        logger.fine("Libro encontrado con ISBN: " + isbn);
        return book;
      }
    }
    throw new NotFoundException("No fue encontrado el libro con isbn: " + isbn);
  }

  public void deleteBook(String isbn) throws NotFoundException {
    for (var book : books) {
      if (book.getIsbn().equals(isbn)) {
        books.remove(book);
        logger.info("Libro eliminado: " + isbn);
        return;
      }
    }
    logger.warning("Intento de eliminar libro inexistente: " + isbn);
    throw new NotFoundException("No se puede eliminar el libro con isbn: " + isbn);
  }

  public List<Book> getAllBooks() {
    logger.fine("Obteniendo lista de todos los libros.");
    return books;
  }

}
