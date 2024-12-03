public class InventoryItem {

  private String name;
  private int quantity;
  private double price;

  // Constructor initializes the item with name, quantity, and price
  public InventoryItem(String name, int quantity, double price) {
      this.name = name;
      this.quantity = quantity;
      this.price = price;
  }

  // Getters and setters for item properties
  public String getName() {
      return name;
  }

  public int getQuantity() {
      return quantity;
  }

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }

  public double getPrice() {
      return price;
  }

  public void setPrice(double price) {
      this.price = price;
  }

  // toString method to display item details
  @Override
  public String toString() {
      return "Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
  }

  // Overriding equals method to check items by name for inventory updates
  @Override
  public boolean equals(Object obj) {
      if (obj instanceof InventoryItem) {
          InventoryItem other = (InventoryItem) obj;
          return this.name.equalsIgnoreCase(other.name);
      }
      return false;
  }
}