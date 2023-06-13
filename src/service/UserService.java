package service;

import modal.User;

public class UserService {
   private User[] listUser = new User[100];
   private int size = 0;

   public UserService() {
//      tai khoan admin
      User user = new User(1,"binh123","1234",1);
      listUser[0] = user;
      size++;
   }

   public User[] getAll() {
      return listUser;
   }

   public int getSize() {
      return size;
   }

//   Thêm người dùng hoặc sửa người dùng
   public boolean save(User user) {
      if (findById(user.getId()) == null) {
//      Them moi add new user
         if (size == listUser.length) {
            System.err.println(" ~~ Danh sách người dùng đã đầy vui lòng đăng ký sau ~~ ");
            return false;
         } else {
            for (int i = 0; i < listUser.length; i++) {
               if (listUser[i] == null) {
                  listUser[i] = user;
                  size++;
                  break;
               }
            }
            System.out.println(" ~~ Tạo tài khoản thành công ~~ ");
            return true;
         }
      } else {
//         sua thong tin
         for (int i = 0; i < listUser.length; i++) {
            if(listUser[i] != null && user.getId() == listUser[i].getId()) {
               listUser[i] = user;
               break;
            }
         }
         System.out.println(" ~~ Sửa thành công ~~ ");
         return true;
      }
   }
//   Xóa người dùng
   public boolean deleteUser(int id) {
      if(findById(id) != null) {
         for (int i = 0; i < listUser.length; i++) {
            if(listUser[i].getId() == id) {
               listUser[i] = null;
               size--;
               break;
            }
         }
         System.out.println(" ~~ Xóa thành công ~~ ");
         return true;
      } else {
         System.err.println(" ~~ Không có người dùng đó ~~ ");
         return false;
      }
   }


//   Tìm người dùng
   public User findById(int id) {
      for (User u : listUser) {
         if (u != null && u.getId() == id) {
            return u;
         }
      }
      return null;
   }

//   Login
   public User login(String username, String password) {
      for (User user:listUser) {
         if(user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return user;
         }
      }
      return null;
   }

   public int getNewId() {
      int idMax = 0;
      for (User u:listUser) {
         if(u != null && idMax < u.getId()) {
            idMax = u.getId();
         }
      }
      return idMax + 1;
   }

//   register

}
