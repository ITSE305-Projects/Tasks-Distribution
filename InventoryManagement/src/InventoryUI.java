public class InventoryUI {

  private InventoryService inventoryService;

  // Constructor initializes InventoryService (business layer)
  public InventoryUI() {
      this.inventoryService = new InventoryService();
  }

  // Displays the inventory list to the user
  public void displayInventory() {
      System.out.println("Inventory List:");
      for (InventoryItem item : inventoryService.getAllItems()) {
          System.out.println(item);
      }
  }

  // Adds a new item to the inventory
  public void addNewItem(String name, int quantity, double price) {
      inventoryService.addItem(name, quantity, price);
      System.out.println("Item added successfully.");
  }
  
  // Updates an existing item in the inventory
  public void updateItemQuantity(String itemName, int newQuantity) {
      if (inventoryService.updateQuantity(itemName, newQuantity)) {
          System.out.println("Item quantity updated successfully.");
      } else {
          System.out.println("Item not found.");
      }
      
  }
}