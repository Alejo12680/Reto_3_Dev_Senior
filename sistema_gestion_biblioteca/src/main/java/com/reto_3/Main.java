package com.reto_3;

import com.reto_3.Model.Book;
import com.reto_3.Model.User;
import com.reto_3.Service.BookService;
import com.reto_3.Service.UserService;

import java.util.Scanner;

;

public class Main {


    static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
    
    
    
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("Bienvenido a la biblioteca");
            System.out.println(1 + " - Agregar un libro");
            System.out.println(2 + " - Agregar un usuario");
            System.out.println(3 + " - Prestar un libro");
            System.out.println(4 + " - Devolver un libro");
            System.out.println(5 + " - Salir");
    
            int option = scanner.nextInt();
    
            switch (option) {
                case 1:
                    addBook();
                break;
                case 2:
                    addUser();
                break;
                case 3:
                    lendBook();
                break;
                case 4:
                    returnBook();
                break;
                case 5:
                    System.exit(0);
                break;
                            
                default:
                System.out.println("Opcion no valida");      
                break;
            }   
                        
                    
                           
                        }
                    
        public static void addBook() {
            System.out.println("Ingrese el nombre del libro");
                    String title = scanner.nextLine();
        System.out.println("Ingrese el autor del libro");
        String author = scanner.nextLine();
        System.out.println("Ingrese el genero del libro");
        String genre = scanner.nextLine();

        Book book = new Book(title, author, genre);
        BookService bookService = new BookService();
                bookService.addBook(book);
    }

    public static void addUser() {
        System.out.println("Ingrese el nombre del usuario");
        String name = scanner.nextLine();
        System.out.println("Ingrese el correo del usuario");
        String email = scanner.nextLine();
        System.out.println("Ingrese la contrasena del usuario");
        String password = scanner.nextLine();
        User user = new User(name, email, password);
        UserService userService = new UserService();
        userService.addUser(user);
    }

    public static void lendBook() {
        System.out.println("Ingrese el titulo del libro");
        String title = scanner.nextLine();
        System.out.println("Ingrese el nombre del usuario");
        String name = scanner.nextLine();
        BookService bookService = new BookService();
        UserService userService = new UserService();
        bookService.getBooks();
        userService.getUsers();
        
    }


    public static void returnBook() {
        System.out.println("Ingrese el titulo del libro");
        String title = scanner.nextLine();
        System.out.println("Ingrese el nombre del usuario");
        String name = scanner.nextLine();
        BookService bookService = new BookService();
        UserService userService = new UserService();
        bookService.getBooks();
        userService.getUsers();
    }
}

