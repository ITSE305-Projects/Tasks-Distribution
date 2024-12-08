import java.util.List;

public class InventoryService {

    private InventoryRepository inventoryRepository;

    // Constructor initializes InventoryRepository (data layer)
    public InventoryService() {
        this.inventoryRepository = new InventoryRepository();
    }

    // Fetches all items in the inventory
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.getAllItems();
    }

    // Adds a new item to the inventory by interacting with the data layer
    public void addItem(String name, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(name, quantity, price);
        inventoryRepository.addItem(newItem);
    }

    // Updates the quantity of an item if it exists in the inventory
    public boolean updateQuantity(String itemName, int newQuantity) {
        InventoryItem item = inventoryRepository.getItemByName(itemName);
        if (item != null) {
            item.setQuantity(newQuantity);
            inventoryRepository.updateItem(item);
            return true;
        }
        return false;
    }
}