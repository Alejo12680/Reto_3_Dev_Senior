package com.reto_3.Repository;

import com.reto_3.Model.Book;
import com.reto_3.Model.User;

public class Loan {

    private Book book;
    private User user;
    private boolean loanDate;

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = false;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoanDate() {
        return loanDate;
    }

    public void setLoanDate(boolean loanDate) {
        this.loanDate = loanDate;
    }

    
    public void startLoan() {
        this.loanDate = true;
    }

    
    public void endLoan() {
        this.loanDate = false;
    }

    public String getLoanInfo() {
        return "Libro: " + book.getTitle() + ", Usuario: " + user.getName() + ", Prestado: " + (loanDate ? "Sí" : "No");
    }

    public void lendBook(Book book, User user) {
        if (this.book == null) {
            this.book = book;
            this.user = user;
            this.loanDate = true;
        }
    }

    


}
