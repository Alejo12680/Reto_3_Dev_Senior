# 📚 Sistema de Gestión de Biblioteca - Reto 3

Este proyecto es una aplicación de consola en Java que permite gestionar libros, usuarios y préstamos. Además, incluye pruebas unitarias con JUnit 5 y simulaciones con Mockito.


## ✅ Funcionalidades

- Agregar, buscar y eliminar libros.
- Registrar y buscar usuarios.
- Realizar y devolver préstamos de libros.
- Registro de eventos con logging profesional.
- Pruebas unitarias para cada servicio.


## 🧱 Estructura del Proyecto

src/  `\`
│  `\`
├── exceptiones/  `\`
│   ├── NotFoundException.java  `\`
│  `\`
├── model/  `\`
│   ├── Book.java  `\`       
│   ├── User.java  `\`     
│   ├── Loan.java  `\`   
│   └── LoanState.java  `\`
├── service/  `\`
│   ├── BookService.java  `\`        
│   ├── LoanService.java  `\`
│   └── UserService.java  `\`  
│  `\`
├── resources/  `\`
│  `\`
│  `\`
└── test/  `\`
    └── LibraryServiceTest.java   // Pruebas unitarias con JUnit 5 y Mockito  `\`


## 🚀 Cómo Ejecutar

1. Clona o descarga el repositorio.
2. Compila el proyecto:
   ```bash
  javac -d bin src/com/reto_3/**/*.java
  Ejecuta el archivo Main.java

  `java -cp bin com.reto_3.Main`

  Si usas Maven:

  `mvn test`


##  🧾 Logging

- El sistema registra eventos importantes como:

- Agregado de libros.
- Préstamos realizados o errores.
- Excepciones capturadas.
- Logs visibles directamente en la terminal.


## 🛠 Tecnologías Usadas

- Java 17+
- JUnit 5: V-5.11.4
- Mockito: V-5.15.2
- Logger (java.util.logging)


## 🔧 2. Script `Main.java` con Logging

```java
package com.reto_3;

import com.reto_3.Service.*;
import com.reto_3.Exeptions.NotFoundException;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
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
```
