package com.reto_3;

import com.reto_3.Service.*;
import com.reto_3.Exeptions.NotFoundException;

import java.util.logging.Logger;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    // Configurar logger
    LogConfig.setupLogger();

    BookService bookService = new BookService();
    UserService userService = new UserService();
    LoanService loanService = new LoanService(bookService, userService);

    try {
      logger.info("Iniciando sistema de biblioteca...");

      bookService.addBook("B1", "Programación Java", "Juan Pérez");
      userService.addUser("U1", "María García", "maria@example.com");

      loanService.addLoan("U1", "B1");

      logger.info("Préstamo realizado correctamente.");
      System.out.println("Préstamos activos: " + loanService.getLoans().size());

    } catch (NotFoundException e) {
      logger.severe("Error durante operación: " + e.getMessage());
    }
  }
}
