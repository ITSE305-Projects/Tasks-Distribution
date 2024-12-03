import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
    }

    @Test
    void testAddItem() {
        // Act
        inventoryService.addItem("Widget", 10, 19.99);

        // Assert
        List<InventoryItem> items = inventoryService.getAllItems();
        assertEquals(1, items.size());
        InventoryItem addedItem = items.get(0);
        assertEquals("Widget", addedItem.getName());
        assertEquals(10, addedItem.getQuantity());
        assertEquals(19.99, addedItem.getPrice(), 0.001);
    }

    @Test
    void testGetAllItems() {
        // Arrange
        inventoryService.addItem("Widget", 10, 19.99);
        inventoryService.addItem("Gadget", 5, 9.99);

        // Act
        List<InventoryItem> items = inventoryService.getAllItems();

        // Assert
        assertEquals(2, items.size());
        assertTrue(items.stream().anyMatch(item -> item.getName().equalsIgnoreCase("Widget")));
        assertTrue(items.stream().anyMatch(item -> item.getName().equalsIgnoreCase("Gadget")));
    }

    @Test
    void testUpdateQuantitySuccess() {
        // Arrange
        inventoryService.addItem("Widget", 10, 19.99);

        // Act
        boolean result = inventoryService.updateQuantity("Widget", 20);

        // Assert
        assertTrue(result);
        InventoryItem updatedItem = inventoryService.getAllItems().get(0);
        assertEquals(20, updatedItem.getQuantity());
    }

    @Test
    void testUpdateQuantityItemNotFound() {
        // Act
        boolean result = inventoryService.updateQuantity("NonExistentItem", 20);

        // Assert
        assertFalse(result);
    }

    @Test
    void testUpdateQuantityCaseInsensitive() {
        // Arrange
        inventoryService.addItem("Widget", 10, 19.99);

        // Act
        boolean result = inventoryService.updateQuantity("widget", 15);

        // Assert
        assertTrue(result);
        InventoryItem updatedItem = inventoryService.getAllItems().get(0);
        assertEquals(15, updatedItem.getQuantity());
    }
}