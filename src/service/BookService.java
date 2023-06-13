package service;

import modal.Book;
import modal.Category;

public class BookService {
   private Book[] listBook = new Book[100];
   private int size = 0;

   private CategoryService categoryService = new CategoryService();

   public BookService() {
      listBook[0] = new Book(1,"Nhà giả kim",categoryService.findById(1),1200,"hai dang",20,200,true);
      listBook[1] = new Book(2,"Đắc nhân tâm",categoryService.findById(1),1200,"dang hai",22,250,true);
      listBook[3] = new Book(3,"Thế giới phẳng",categoryService.findById(2),2000,"binh pham",30,190,true);
   }

   public Book[] getAll() {
      return listBook;
   }

   public int getSize() {
      return size;
   }

   public boolean save(Book book) {
      if (findById(book.getId()) == null) {
//      Them moi add new user
         if (size == listBook.length) {
            System.err.println(" ~~ Danh sách book đã đầy vui lòng thêm sau ~~ ");
            return false;
         } else {
            for (int i = 0; i < listBook.length; i++) {
               if (listBook[i] == null) {
                  listBook[i] = book;
                  size++;
                  break;
               }
            }
            System.out.println(" ~~ Thêm mới thành công ~~ ");
            return true;
         }
      } else {
//         sua thong tin
         for (int i = 0; i < listBook.length; i++) {
            if (listBook[i] != null && book.getId() == listBook[i].getId()) {
               listBook[i] = book;
               break;
            }
         }
         System.out.println(" ~~ Sửa thành công ~~ ");
         return true;
      }
   }

   //   Xóa người dùng
   public boolean deleteBook(int id) {
      if (findById(id) != null) {
         for (int i = 0; i < listBook.length; i++) {
            if (listBook[i].getId() == id) {
               listBook[i] = null;
               size--;
               break;
            }
         }
         System.out.println(" ~~ Xóa thành công ~~ ");
         return true;
      } else {
         System.err.println(" ~~ Không có sách đó ~~ ");
         return false;
      }
   }


   //   Tìm người dùng
   public Book findById(int id) {
      for (Book u : listBook) {
         if (u != null && u.getId() == id) {
            return u;
         }
      }
      return null;
   }

   public int getNewId() {
      int idMax = 0;
      for (Book u : listBook) {
         if (u != null && idMax < u.getId()) {
            idMax = u.getId();
         }
      }
      return idMax + 1;
   }
}
