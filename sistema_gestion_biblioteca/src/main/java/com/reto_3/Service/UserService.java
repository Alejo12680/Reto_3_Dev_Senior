package com.reto_3.Service;

import java.util.ArrayList;
import java.util.List;

import com.reto_3.Model.User;

public class UserService {

private List<User> users = new ArrayList<User>();

public void addUser(User user) {
    users.add(user);
}

public void getUsers() {
    for (User user : users) {
        System.out.println(user.getName());
    }
}


}
