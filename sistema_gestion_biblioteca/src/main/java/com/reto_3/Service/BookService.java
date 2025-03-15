package com.reto_3.Service;

import java.util.ArrayList;
import java.util.List;
import com.reto_3.Model.Book;
import com.reto_3.Model.User;

public class BookService {

private List<Book> books = new ArrayList<Book>();

public void addBook(Book book) {
    books.add(book);
}

public void getBooks() {
    for (Book book : books) {
        System.out.println(book.getTitle());
    }
}
 




}
