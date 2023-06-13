package run;

import config.Config;
import controller.BookController;
import controller.CartController;
import controller.CategoryController;
import controller.UserController;
import modal.Book;
import modal.Cart;
import modal.Category;
import modal.User;

import java.util.Calendar;
import java.util.Date;

public class Library {
   private static UserController userController = new UserController();
   private static CategoryController categoryController = new CategoryController();
   private static BookController bookController = new BookController();
   private static CartController cartController = new CartController();

   public static int idLogin;

   public static void main(String[] args) {
      int choose;
//      listUser = userController.getAll();
//      listCategory = categoryController.getAll();
//      listBook = bookController.getAll();


      while (true) {
         System.out.println(">>================ LIBRARY ================<<");
         System.out.println("1. Đăng Nhập");
         System.out.println("2. Đăng Ký");
         System.out.println("3. Thoát");
         System.out.println(">>=========================================<<");
         System.out.println("Nhập vào lựa chọn của bạn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
               login();
               break;
            case 2:
               register();
               break;
            case 3:
               System.out.println("Say goodbye!!!");
               System.exit(0);
               break;
            default:
               System.err.println(" ~~ Vui lòng nhập 1 số (1 -> 3) ~~ ");
               break;
         }
      }
   }

   public static void login() {
      System.out.print("Nhập username: ");
      String username = Config.scanner().nextLine();
      System.out.print("Nhập password: ");
      String password = Config.scanner().nextLine();
      User user = userController.login(username, password);
      if (user == null) {
         System.err.println(" ~~ Sai tài khoản hoặc mật khẩu ~~ ");
//         menu điều hướng đăng ký đăng nhập
      } else {
         if (user.getRole() == 1) {
//            admin
//            Tạo con trỏ nhấp nháy
//            Config.scanner().nextLine();
            menuAdmin();
         } else {
//            user
//            System.out.println(" ~~ Đây là người dùng ~~ ");
//            Tạo con trỏ nhấp nháy
//            Config.scanner().nextLine();
            idLogin = user.getId();
            menuUser();
         }
      }
   }

   public static void register() {
      User newUser = new User();
      newUser.setId(userController.getNewId());
      System.out.print("Nhập username: ");
      newUser.setUsername(Config.scanner().nextLine());
      System.out.print("Nhập password: ");
      newUser.setPassword(Config.scanner().nextLine());
      System.out.print("Nhập FullName: ");
      newUser.setFullName(Config.scanner().nextLine());
      System.out.print("Nhập Phone Number: ");
      newUser.setPhoneNumber(Config.scanner().nextLine());
      userController.save(newUser);
      System.out.println(">>================= Đăng Nhập =================<<");
      login();
   }

   // Điều hướng trang admin
   public static void menuAdmin() {
      int choose;
      while (true) {
         System.out.println(">>================ Admin ================<<");
         System.out.println("1. Quản lý danh mục");
         System.out.println("2. Quản lý sách");
         System.out.println("3. Quản lý tài khoản");
         System.out.println("4. Lịch sử mượn sách");
         System.out.println("5. Đăng xuất");
         System.out.println(">>=======================================<<");
         System.out.print("Mời bạn lựa chọn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
//            Danh mục
               menuCategory();
               break;
            case 2:
               menuBook();
               break;
            case 3:
               menuManagerUser();
               break;
            case 4:
               break;
            case 5:
               System.out.println("~~ Đăng xuất thành công ~~");
               break;
            default:
               System.err.println(" ~~ Nhập số (1 -> 5) ~~ ");
               break;
         }
         if (choose == 5) {
            break;
         }
      }
   }

   // Điều hướng trang người dùng
   public static void menuUser() {
      int choose;
      while (true) {
         System.out.println(">>================ User ================<<");
         System.out.println("1. Xem danh sách book");
         System.out.println("2. Mượn sách");
         System.out.println("3. Trả sách");
         System.out.println("4. Xem những sách đã mượn");
         System.out.println("5. Chỉnh sửa thông tin cá nhân");
         System.out.println("6. Đăng xuất");
         System.out.println(">>=======================================<<");
         System.out.print("Mời bạn lựa chọn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
               // show list book
               showListBook();
               break;
            case 2:
               // mượn sách
               addNewBookToListCart();
               break;
            case 3:
               // trả sách
               removeBookInListCart();
               break;
            case 4:
               // xem danh sách mượn
               showListCart();
               break;
            case 5:
               // chỉnh sửa thông tin cá nhân
               editInformation();
               break;
            case 6:
               // đăng xuất
               break;
            default:
               System.err.println(" ~~ Nhập số (1 -> 5) ~~ ");
               break;
         }
         if (choose == 6) {
            break;
         }
      }
   }

   // show list book in user
   public static void showListBook() {
      for (Book book : bookController.getAll()) {
         if (book != null) {
            System.out.println(book);
         }
      }
   }

   // borrow book
   public static void addNewBookToListCart() {
      Date borrowDate = new Date();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(borrowDate);
      // tính ngày hết hạn 7 ngày
      calendar.add(Calendar.DATE, 7);
      // Ngày hết hạn
      Date dueDate = calendar.getTime();
      //  Lấy thông tin sách
      System.out.println("Nhập vào id sách bạn muốn thêm: ");
      int id = Config.scanner().nextInt();
      Book book = bookController.findById(id);
      if(book == null) {
         System.err.println("~~ Không có sách đấy ~~");
         return;
      }
      Cart cart = new Cart();
      cart.setId(cartController.getNewId());
      cart.setBookName(book.getName());
      cart.setBookPrice(book.getPrice());
      cart.setBookAuthor(book.getAuthor());
      cart.setQuantity(book.getQuantity());
      cart.setCategoryName(book.getCategory().getName());
      cart.setBorrowDate(borrowDate);
      cart.setDueDate(dueDate);
      cartController.save(cart);
   }

   //   Trả sách
   public static void removeBookInListCart() {
      System.out.println("Nhập vào id sách mà bạn muốn xóa: ");
      int id = Config.scanner().nextInt();
      cartController.delete(id);
   }

   // show list cart
   public static void showListCart() {
      if(cartController.getSize() == 0) {
         System.err.println("~~ Cart trống ~~");
         return;
      }
      for (Cart cart: cartController.getAll()) {
         if(cart != null) {
            System.out.println(cart);
         }
      }
   }

   // edit profile
   public static void editInformation() {
      User user = userController.findById(idLogin);
      System.out.printf("Nhập tên mới (tên cũ: %s): ", user.getFullName());
      user.setFullName(Config.scanner().nextLine());
      System.out.printf("Nhập vào password mới (password cũ: %s): ", user.getUsername());
      user.setPassword(Config.scanner().nextLine());
      System.out.print("Nhập vào địa chỉ mới : ");
      user.setAddress(Config.scanner().nextLine());
      System.out.printf("Nhập vào Số điện thoại mới (sdt cũ: %s): ",user.getPhoneNumber());
      user.setPhoneNumber(Config.scanner().nextLine());
      System.out.print("Nhập vào email: ");
      user.setEmail(Config.scanner().nextLine());
      userController.save(user);
   }


   //   Quản lý tài khoản
   public static void menuManagerUser() {
      int choose;
      while (true) {
         System.out.println(">>================ Book ================<<");
         System.out.println("1. hiện thị danh sách user");
         System.out.println("2. Chặn người dùng");
         System.out.println("3. Mở chăn người dùng");
         System.out.println("4. Quay lại");
         System.out.println(">>=======================================<<");
         System.out.print("Mời bạn lựa chọn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
               // show user
               showAllUser();
               break;
            case 2:
               // chăn người dùng
               blockUser();
               break;
            case 3:
               // mở chặn người dùng
               unBlockUser();
               break;
            case 4:
               // quay loại
               break;
            default:
               System.err.println(" ~~ Nhập số (1 -> 4) ~~ ");
               break;
         }
         if (choose == 4) {
            break;
         }
      }
   }

   // show all users
   public static void showAllUser() {
      if(userController.getSize() == 0) {
         System.err.println("~~ Chưa có user nào ~~");
         return;
      }
      for (User user : userController.getAll()) {
         if (user != null) {
            System.out.println(user);
         }
      }
   }

   // block user
   public static void blockUser() {
      System.out.println("Bạn muốn khóa id nào: ");
      int id = Config.scanner().nextInt();
      User user = userController.findById(id);
      if (user == null) {
         System.err.println("~~ Không có người dùng này ~~");
      } else {
         if (user.isStatus() == false) {
            System.err.println("~~ Tài khoản này đã bị khóa rồi mà ~~");
         } else {
            user.setStatus(false);
         }
      }
   }

   // unblock user
   public static void unBlockUser() {
      System.out.println("Bạn muốn mở khóa id nào: ");
      int id = Config.scanner().nextInt();
      User user = userController.findById(id);
      if (user == null) {
         System.err.println("~~ Không có người dùng này ~~");
      } else {
         if (user.isStatus() == true) {
            System.err.println("~~ tài khoản này vẫn mở mà ~~");
         } else {
            user.setStatus(true);
         }
      }
   }

   //   Quản lý sách
   public static void menuBook() {
      int choose;
      while (true) {
         System.out.println(">>================ Book ================<<");
         System.out.println("1. hiện thị danh sách BOOk");
         System.out.println("2. Thêm mới BOOK");
         System.out.println("3. Chỉnh sửa BOOK");
         System.out.println("4. Xóa BOOK");
         System.out.println("5. Quay lại");
         System.out.println(">>=======================================<<");
         System.out.print("Mời bạn lựa chọn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
               // show all book
               showAllBook();
               break;
            case 2:
               // add new item book
               addNewBook();
               break;
            case 3:
               // update book
               updateBook();
               break;
            case 4:
               // delete book
               deleteBook();
               break;
            case 5:
               break;
            default:
               System.err.println(" ~~ Nhập số (1 -> 5) ~~ ");
         }
         if (choose == 5) {
            break;
         }
      }
   }

   //   show all book
   public static void showAllBook() {
      if (bookController.getSize() == 0) {
         System.err.println("~~ Danh sách BOOK trống ~~");
         return;
      }
      for (Book b : bookController.getAll()) {
         if (b != null) {
            System.out.println(b);
         }
      }
   }

   //   add new item book
   public static void addNewBook() {
      System.out.print("Bạn muốn thêm bao nhiêu: ");
      int n = Config.scanner().nextInt();
      for (int i = 0; i < n; i++) {
         System.out.println("Book thứ " + (i + 1));
         Book newBook = new Book();
         newBook.setId(bookController.getNewId());
         System.out.print("Nhập tên sách: ");
         newBook.setName(Config.scanner().nextLine());
         System.out.print("Nhập thể loại sách: ");
         while (true) {
            Category result = chooseCategory();
            if (result != null) {
               newBook.setCategory(result);
               break;
            }
         }
         System.out.print("Nhập giá sách: ");
         newBook.setPrice(Config.scanner().nextDouble());
         System.out.print("Nhập tên tác giả: ");
         newBook.setAuthor(Config.scanner().nextLine());
         System.out.print("Nhập số lượng: ");
         newBook.setQuantity(Config.scanner().nextInt());
         System.out.print("Nhập tổng số trang: ");
         newBook.setTotalPage(Config.scanner().nextInt());
         bookController.save(newBook);
      }
   }

   //   update item book
   public static void updateBook() {
      System.out.println("Nhập vào id bạn muốn sửa: ");
      int id = Config.scanner().nextInt();
      Book book = bookController.findById(id);
      if (book == null) {
         System.err.println("~~ Sách này không có trong danh sách ~~");
         return;
      }
      System.out.printf("Nhập tên mới (tên cũ: %s): ", book.getName());
      book.setName(Config.scanner().nextLine());
      System.out.printf("Nhập thể loại mới (thể loại cũ: %s):", book.getCategory().getName());
      while (true) {
         Category result = chooseCategory();
         if (result != null) {
            book.setCategory(result);
            break;
         }
      }
      System.out.printf("Nhập giá mới (giá cũ: %f): ", book.getPrice());
      book.setPrice(Config.scanner().nextDouble());
      System.out.printf("Nhập tên tác giả mới (tên cũ: %s):", book.getAuthor());
      book.setAuthor(Config.scanner().nextLine());
      System.out.printf("Nhập tên sô lượng mới (số lượng cũ: %d):", book.getQuantity());
      book.setQuantity(Config.scanner().nextInt());
      System.out.printf("Nhập tổng số trang (số trang cũ: %d): ", book.getQuantity());
      bookController.save(book);
   }

   // delete item book
   public static void deleteBook() {
      System.out.println("Nhập vào id bạn muốn xóa: ");
      int id = Config.scanner().nextInt();
      bookController.delete(id);
   }

   // lựa chọn category
   public static Category chooseCategory() {
      System.out.println("Danh sách thể loại: ");
      for (Category c : categoryController.getAll()) {
         if (c != null) {
            System.out.println(c);
         }
      }
      System.out.println("--------------------------------");
      System.out.print("Bạn chọn thể loại nào: ");
      int id = Config.scanner().nextInt();
      return categoryController.findById(id);
   }


   //   Quản lý danh mục
   public static void menuCategory() {
      int choose;
      while (true) {
         System.out.println(">>================ Category ================<<");
         System.out.println("1. hiện thị danh mục");
         System.out.println("2. Thêm mới danh mục");
         System.out.println("3. Chỉnh sửa danh mục");
         System.out.println("4. Xóa danh mục");
         System.out.println("5. Quay lại");
         System.out.print(">>=======================================<<");
         System.out.println("Mời bạn lựa chọn: ");
         choose = Config.scanner().nextInt();
         switch (choose) {
            case 1:
//            Hiện thị
               showCategory();
               break;
            case 2:
               addNewCategory();
               break;
            case 3:
               updateCategory();
               break;
            case 4:
               deleteCategory();
               break;
            case 5:
               break;
            default:
               System.err.println(" ~~ Nhập số (1 -> 5) ~~ ");
         }
         if (choose == 5) {
            break;
         }
      }
   }

   //   Show all categories
   public static void showCategory() {
      if (categoryController.getSize() == 0) {
         System.err.println("~~ Danh sách trống ~~");
         return;
      }
      for (Category category : categoryController.getAll()) {
         if (category != null) {
            System.out.println(category);
         }
      }
   }

   //   Add new category
   public static void addNewCategory() {
      System.out.println("Nhập số lượng bạn muốn thêm: ");
      int n = Config.scanner().nextInt();
      for (int i = 0; i < n; i++) {
         System.out.println("Sản phẩm thứ " + (i + 1));
         Category newCategory = new Category();
         newCategory.setId(categoryController.getNewId());
         System.out.print("Nhập tên: ");
         newCategory.setName(Config.scanner().nextLine());
         System.out.print("Nhập mô tả: ");
         newCategory.setDescription(Config.scanner().nextLine());
         categoryController.save(newCategory);
      }
   }

   //   update item category
   public static void updateCategory() {
      System.out.println("Nhập vào id bạn muốn sửa: ");
      int id = Config.scanner().nextInt();
      Category category = categoryController.findById(id);
      if (category != null) {
         System.out.printf("Nhập tên mới (tên cũ : %s): ", category.getName());
         category.setName(Config.scanner().nextLine());
         System.out.printf("Nhập mô tả (mô tả cũ : %s): ", category.getDescription());
         category.setDescription(Config.scanner().nextLine());
         categoryController.save(category);
      } else {
         System.err.println("~~ Không có loại này trong danh sách ~~");
      }
   }

   //   delete item category
   public static void deleteCategory() {
      System.out.println("Nhập vào id bạn muốn xóa: ");
      int id = Config.scanner().nextInt();
      categoryController.delete(id);
   }
}
