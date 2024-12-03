import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    private List<InventoryItem> inventory;

    // Constructor initializes the inventory list as an in-memory data source
    public InventoryRepository() {
        this.inventory = new ArrayList<>();
    }

    // Returns all items in the inventory
    public List<InventoryItem> getAllItems() {
        return inventory;
    }
    public boolean removeItem(String name) {
        InventoryItem item = getItemByName(name);
        if (item != null) {
            inventory.remove(item);
            return true;
        }
        return false;
    }

    // Adds a new item to the inventory
    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    // Updates an item in the inventory list
    public void updateItem(InventoryItem item) {
        int index = inventory.indexOf(item);
        if (index != -1) {
            inventory.set(index, item);
        }
    }

    // Finds an item by its name
    public InventoryItem getItemByName(String name) {
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}