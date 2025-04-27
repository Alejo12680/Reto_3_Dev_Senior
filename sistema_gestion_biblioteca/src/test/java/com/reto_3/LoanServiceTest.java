package com.reto_3;


import com.reto_3.Service.*;
import com.reto_3.Exeptions.NotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    private BookService bookService;
    private UserService userService;
    private LoanService loanService;

    @BeforeEach
    public void setUp() {
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        loanService = new LoanService(bookService, userService);

        bookService.addBook("ISBN1", "Clean Code", "Robert C. Martin");
        userService.addUser("U1", "Alice", "alice@mail.com");
    }

    @Test
    public void testAddLoan() throws NotFoundException {
        loanService.addLoan("U1", "ISBN1");

        assertEquals(1, loanService.getLoans().size());
        assertEquals("U1", loanService.getLoans().get(0).getUser().getId());
    }

    @Test
    public void testLoanBookAlreadyLoaned() throws NotFoundException {
        loanService.addLoan("U1", "ISBN1");

        Exception ex = assertThrows(NotFoundException.class, () -> {
            loanService.addLoan("U1", "ISBN1");
        });

        assertTrue(ex.getMessage().contains("se encuentra prestado"));
    }

    @Test
    public void testReturnBookSuccessfully() throws NotFoundException {
        loanService.addLoan("U1", "ISBN1");

        loanService.returnBook("U1", "ISBN1");

        assertEquals(1, loanService.getLoans().size());
        assertEquals("FINISHED", loanService.getLoans().get(0).getState().name());
    }

    @Test
    public void testReturnBookNotFound() {
        Exception ex = assertThrows(NotFoundException.class, () -> {
            loanService.returnBook("U1", "ISBN1");
        });

        assertTrue(ex.getMessage().contains("No hay un prestamo"));
    }
}

