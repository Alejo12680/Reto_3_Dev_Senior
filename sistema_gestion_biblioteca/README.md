# 📚 Sistema de Gestión de Biblioteca - Reto 3

Este proyecto es una aplicación de consola en Java que permite gestionar libros, usuarios y préstamos. Además, incluye pruebas unitarias con JUnit 5 y simulaciones con Mockito.


## ✅ Funcionalidades

- Agregar, buscar y eliminar libros.
- Registrar y buscar usuarios.
- Realizar y devolver préstamos de libros.
- Registro de eventos con logging profesional.
- Pruebas unitarias para cada servicio.


## 🧱 Estructura del Proyecto

src/ <br>
│  <br>
├── exceptiones/  <br>
│   ├── NotFoundException.java  <br>
│  <br>
├── model/  <br>
│   ├── Book.java <br>       
│   ├── User.java     
│   ├── Loan.java <br>   
│   └── LoanState.java  <br>
├── service/  <br>
│   ├── BookService.java <br>        
│   ├── LoanService.java 
│   └── UserService.java <br>  
│  <br>
│  <br>
└── test/  <br>
    └── LibraryServiceTest.java   // Pruebas unitarias con JUnit 5 y Mockito  <br>


## 🚀 Cómo Ejecutar

1. Clona o descarga el repositorio.
2. Compila el proyecto:
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
