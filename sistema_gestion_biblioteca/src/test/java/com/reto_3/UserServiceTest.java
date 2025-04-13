package com.reto_3;

import com.reto_3.Model.User;
import com.reto_3.Service.UserService;
import com.reto_3.Exeptions.NotFoundException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddUserAndRetrieve() throws NotFoundException {
        userService.addUser("U1", "Juan", "juan@mail.com");
        User user = userService.getUserById("U1");

        assertNotNull(user);
        assertEquals("Juan", user.getName());
    }

    @Test
    public void testGetUserNotFound() {
        assertThrows(NotFoundException.class, () -> {
            userService.getUserById("U404");
        });
    }

    @Test
    public void testGetAllUsers() {
        userService.addUser("U1", "Ana", "ana@mail.com");
        userService.addUser("U2", "Carlos", "carlos@mail.com");

        assertEquals(2, userService.getAllUsers().size());
    }
}

