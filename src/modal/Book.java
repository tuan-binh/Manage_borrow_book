package modal;

public class Book {
   private int id;
   private String name;
   private Category category;
   private double price;
   private String author;
   private int quantity;
   private int totalPage;
   private boolean status = true;

   public Book() {
   }

   public Book(int id, String name, Category category, double price, String author, int quantity, int totalPage, boolean status) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.price = price;
      this.author = author;
      this.quantity = quantity;
      this.totalPage = totalPage;
      this.status = status;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public int getTotalPage() {
      return totalPage;
   }

   public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
   }

   public boolean isStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "--------------------------------\n" +
              "ID: " + id + " | Name: " + name + " | Author: " + author +
              "\nCategory: " + category.getName() + " | Price: " + price;
   }
}
