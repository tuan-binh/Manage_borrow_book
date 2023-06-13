package controller;

import modal.User;
import service.UserService;

public class UserController {
   private UserService userService = new UserService();

   public User[] getAll() {
      return userService.getAll();
   }

   public int getSize() {
      return userService.getSize();
   }

   public void save(User user) {
      userService.save(user);
   }

   public void delete(int id) {
      userService.deleteUser(id);
   }

   public User findById(int id) {
      return userService.findById(id);
   }

   public User login(String username, String password) {
      return userService.login(username, password);
   }

   public int getNewId() {
      return userService.getNewId();
   }
}
