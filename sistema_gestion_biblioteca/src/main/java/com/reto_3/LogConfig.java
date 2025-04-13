package com.reto_3;

import java.io.IOException;
import java.util.logging.*;

public class LogConfig {
  public static void setupLogger() {
    Logger rootLogger = Logger.getLogger("");
    Handler[] handlers = rootLogger.getHandlers();

    // Eliminar handler por defecto de consola (opcional)
    if (handlers[0] instanceof ConsoleHandler) {
      rootLogger.removeHandler(handlers[0]);
    }

    // Crear formateador simple
    SimpleFormatter formatter = new SimpleFormatter();

    // Handler para consola
    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setFormatter(formatter);
    rootLogger.addHandler(consoleHandler);

    try {
      // Crear Handler para archivo
      FileHandler fileHandler = new FileHandler("library.log", true); // true para modo append
      fileHandler.setFormatter(formatter);
      rootLogger.addHandler(fileHandler);
    } catch (IOException e) {
      System.err.println("No se pudo crear el archivo de log: " + e.getMessage());
    }

    // Puedes cambiar a FINE, WARNING, SEVERE, INFO
    rootLogger.setLevel(Level.FINE);
  }
}
