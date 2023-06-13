package controller;

import modal.Book;
import modal.Cart;
import service.CartService;

public class CartController {
   private CartService cartService = new CartService();

   public Cart[] getAll() {
      return cartService.getAll();
   }

   public int getSize() {
      return cartService.getSize();
   }

   public void save(Cart book) {
      cartService.save(book);
   }

   public void delete(int id) {
      cartService.deleteCart(id);
   }

   public Cart findById(int id) {
      return cartService.findById(id);
   }

   public int getNewId() {
      return cartService.getNewId();
   }
}
