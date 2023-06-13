package controller;

import modal.Book;
import modal.Category;
import service.BookService;

public class BookController {

   private BookService bookService = new BookService();

   public Book[] getAll() {
      return bookService.getAll();
   }

   public int getSize() {
      return bookService.getSize();
   }

   public void save(Book book) {
      bookService.save(book);
   }

   public void delete(int id) {
      bookService.deleteBook(id);
   }

   public Book findById(int id) {
      return bookService.findById(id);
   }

   public int getNewId() {
      return bookService.getNewId();
   }
}
