package service;

import modal.Category;
import modal.User;

public class CategoryService {
   private Category[] categories = new Category[100];
   private int size = 0;

   public CategoryService() {
      categories[0] = new Category(1,"anime","kaka",true);
      categories[1] = new Category(2,"actions","huhu",true);
   }

   public Category[] getAll() {
      return categories;
   }

   public int getSize() {
      return size;
   }

   //   Thêm người dùng hoặc sửa người dùng
   public boolean save(Category category) {
      if (findById(category.getId()) == null) {
//      Them moi add new user
         if (size == categories.length) {
            System.err.println(" ~~ Danh sách category đã đầy vui lòng thêm sau ~~ ");
            return false;
         } else {
            for (int i = 0; i < categories.length; i++) {
               if (categories[i] == null) {
                  categories[i] = category;
                  size++;
                  break;
               }
            }
            System.out.println(" ~~ Thêm mới thành công ~~ ");
            return true;
         }
      } else {
//         sua thong tin
         for (int i = 0; i < categories.length; i++) {
            if (categories[i] != null && category.getId() == categories[i].getId()) {
               categories[i] = category;
               break;
            }
         }
         System.out.println(" ~~ Sửa thành công ~~ ");
         return true;
      }
   }

   //   Xóa người dùng
   public boolean deleteCategory(int id) {
      if (findById(id) != null) {
         for (int i = 0; i < categories.length; i++) {
            if (categories[i].getId() == id) {
               categories[i] = null;
               size--;
               break;
            }
         }
         System.out.println(" ~~ Xóa thành công ~~ ");
         return true;
      } else {
         System.err.println(" ~~ Không có loại đó ~~ ");
         return false;
      }
   }


   //   Tìm người dùng
   public Category findById(int id) {
      for (Category u : categories) {
         if (u != null && u.getId() == id) {
            return u;
         }
      }
      return null;
   }

   public int getNewId() {
      int idMax = 0;
      for (Category u : categories) {
         if (u != null && idMax < u.getId()) {
            idMax = u.getId();
         }
      }
      return idMax + 1;
   }
}
