package modal;

import java.util.Date;

public class Cart {
   private int id;
   private String bookName;
   private double bookPrice;
   private String bookAuthor;
   private int quantity;

   private String categoryName;
   private Date borrowDate;
   private Date dueDate;

   public Cart() {
   }

   public Cart(int id, String bookName, double bookPrice, String bookAuthor, int quantity, String categoryName, Date borrowDate, Date dueDate) {
      this.id = id;
      this.bookName = bookName;
      this.bookPrice = bookPrice;
      this.bookAuthor = bookAuthor;
      this.quantity = quantity;
      this.categoryName = categoryName;
      this.borrowDate = borrowDate;
      this.dueDate = dueDate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public double getBookPrice() {
      return bookPrice;
   }

   public void setBookPrice(double bookPrice) {
      this.bookPrice = bookPrice;
   }

   public String getBookAuthor() {
      return bookAuthor;
   }

   public void setBookAuthor(String bookAuthor) {
      this.bookAuthor = bookAuthor;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getCategoryName() {
      return categoryName;
   }

   public void setCategoryName(String categoryName) {
      this.categoryName = categoryName;
   }

   public Date getBorrowDate() {
      return borrowDate;
   }

   public void setBorrowDate(Date borrrowDate) {
      this.borrowDate = borrrowDate;
   }

   public Date getDueDate() {
      return dueDate;
   }

   public void setDueDate(Date dueDate) {
      this.dueDate = dueDate;
   }


   @Override
   public String toString() {
      return "-----------------------------------\n" +
              "ID: " + id + " | Name: " + bookName + " | Author: " + bookAuthor +
              "\nPrice: " + bookAuthor + " | quantity: " + quantity +
              "\nBorrowDate: " + borrowDate + " | DueDate: " + dueDate;
   }
}
