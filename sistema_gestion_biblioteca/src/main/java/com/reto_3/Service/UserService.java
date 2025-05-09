package com.reto_3.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.reto_3.Exeptions.NotFoundException;
import com.reto_3.Model.User;

public class UserService {
  private static final Logger logger = Logger.getLogger(UserService.class.getName());
  private List<User> users = new ArrayList<>();

  public UserService() {
    users = new ArrayList<>();
    logger.info("UserService inicializado.");
  }

  public void addUser(String id, String name, String email) {
    users.add(new User(id, name, email));
    logger.info("Usuario registrado: " + name + " (ID: " + id + ")");
  }

  
  public List<User> getAllUsers() {
    logger.fine("Obteniendo todos los usuarios.");
    return users;
  }

  public User getUserById(String id) throws NotFoundException {
    for (var user : users) {
      if (user.getId().equals(id)) {
        logger.fine("Usuario encontrado: " + id);
        return user;
      }

    }
    logger.warning("Usuario no encontrado: " + id);
    throw new NotFoundException("No existe un usaurio con el id: " + id);
  }


  public void deleteUser(String id) throws NotFoundException {
    var user = getUserById(id);
    users.remove(user);
  }

}
