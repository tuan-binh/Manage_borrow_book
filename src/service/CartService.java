package service;

import modal.Book;
import modal.Cart;

public class CartService {
   private Cart[] listCart = new Cart[100];
   private int size = 0;

   public Cart[] getAll() {
      return listCart;
   }

   public int getSize() {
      return size;
   }

   public boolean save(Cart cart) {
      if (findById(cart.getId()) == null) {
//      Them moi add new user
         if (size == listCart.length) {
            System.err.println(" ~~ Danh sách cart đã đầy vui lòng thêm sau ~~ ");
            return false;
         } else {
            for (int i = 0; i < listCart.length; i++) {
               if (listCart[i] == null) {
                  listCart[i] = cart;
                  size++;
                  break;
               }
            }
            System.out.println(" ~~ Thêm mới thành công ~~ ");
            return true;
         }
      } else {
//         sua thong tin
         for (int i = 0; i < listCart.length; i++) {
            if (listCart[i] != null && cart.getId() == listCart[i].getId()) {
               listCart[i] = cart;
               break;
            }
         }
         System.out.println(" ~~ Sửa thành công ~~ ");
         return true;
      }
   }

   //   Xóa người dùng
   public boolean deleteCart(int id) {
      if (findById(id) != null) {
         for (int i = 0; i < listCart.length; i++) {
            if (listCart[i].getId() == id) {
               listCart[i] = null;
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
   public Cart findById(int id) {
      for (Cart u : listCart) {
         if (u != null && u.getId() == id) {
            return u;
         }
      }
      return null;
   }

   public int getNewId() {
      int idMax = 0;
      for (Cart u : listCart) {
         if (u != null && idMax < u.getId()) {
            idMax = u.getId();
         }
      }
      return idMax + 1;
   }
}
