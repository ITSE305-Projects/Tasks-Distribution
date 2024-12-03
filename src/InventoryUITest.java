import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryUITest {

    private InventoryUI inventoryUI;

    @BeforeEach
    void setUp() {
        inventoryUI = new InventoryUI();
    }

    @Test
    void testAddNewItem() {
        inventoryUI.addNewItem("Test Item", 10, 20.0);
        // Add your assertions here to verify the behavior of adding a new item
    }

    @Test
    void testUpdateItemQuantity() {
        inventoryUI.addNewItem("Existing Item", 5, 15.0);
        inventoryUI.updateItemQuantity("Existing Item", 8);
        // Add your assertions here to verify the behavior of updating item quantity
    }

    @Test
    void testUpdateItemQuantity_ItemNotFound() {
        inventoryUI.addNewItem("Another Item", 3, 25.0);
        inventoryUI.updateItemQuantity("Non Existing Item", 8);
        // Add your assertions here to verify the behavior when the item is not found
    }

    // Add more test methods to cover other scenarios as needed
}