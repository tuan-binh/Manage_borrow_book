package modal;

public class User {
   private int id;
   private String fullName;
   private String username;
   private String password;
   private String address;
   private String phoneNumber;
   private String email;
   private boolean status = true;
   private int role = 0;

   private Cart[] Carts = new Cart[10];

   public User() {
   }

   public User(int id, String username, String password, int role) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.role = role;
   }

   public User(int id, String fullName, String username, String password, String address, String phoneNumber, String email, boolean status, int role, Cart[] carts) {
      this.id = id;
      this.fullName = fullName;
      this.username = username;
      this.password = password;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.status = status;
      this.role = role;
      Carts = carts;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean isStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   public int getRole() {
      return role;
   }

   public void setRole(short role) {
      this.role = role;
   }

   public Cart[] getCarts() {
      return Carts;
   }

   public void setCarts(Cart[] carts) {
      Carts = carts;
   }
}
