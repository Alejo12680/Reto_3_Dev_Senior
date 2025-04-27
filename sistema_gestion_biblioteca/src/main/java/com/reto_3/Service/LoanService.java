package com.reto_3.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.reto_3.Exeptions.NotFoundException;
import com.reto_3.Model.Loan;
import com.reto_3.Model.LoanState;

public class LoanService {

  private static final Logger logger = Logger.getLogger(LoanService.class.getName());
  // Logger para registrar eventos
  private List<Loan> loans;
  private BookService bookService;
  private UserService userService;

  public LoanService(BookService bookService, UserService userService) {
    this.bookService = bookService;
    this.userService = userService;
    this.loans = new ArrayList<>();
    logger.info("LoanService inicializado.");
  }

  public void addLoan(String id, String isbn) throws NotFoundException {
    var user = userService.getUserById(id);
    var book = bookService.getBookByIsbn(isbn);

    for (var loan : loans) { // Itera sobre cada préstamo en la lista loans
      if (loan.getBook().getIsbn().equals(isbn)
          && loan.getState().equals(LoanState.STARTED)) {
        logger.warning("El libro ya está prestado: " + isbn);
        throw new NotFoundException("El libro con el isbn: " + isbn + " se encuentra prestado");
      }
    }

    loans.add(new Loan(user, book));
    logger.info("Préstamo agregado - Usuario: " + id + ", Libro: " + isbn);
  }

  public void returnBook(String id, String isbn) throws NotFoundException {
    for (var loan : loans) {
      if (loan.getUser().getId().equals(id)
          && loan.getBook().getIsbn().equals(isbn)
          && loan.getState().equals(LoanState.STARTED)) {
        loan.setState(LoanState.FINISHED);
        logger.info("Libro devuelto - Usuario: " + id + ", Libro: " + isbn);
        return;
      }
    }
    logger.severe("Intento de devolución fallida - Usuario: " + id + ", Libro: " + isbn);
    throw new NotFoundException("No hay un prestamo del libro: " + isbn + " para el usuario: " + id);
  }

  public List<Loan> getLoans() {
    logger.fine("Obteniendo todos los préstamos.");
    return loans;
  }

}
