import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class InventoryRepositoryTest {

    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InventoryRepository();
    }

    @Test
    void testAddItem() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);

        // Act
        repository.addItem(item);

        // Assert
        List<InventoryItem> items = repository.getAllItems();
        assertEquals(1, items.size());
        assertEquals(item, items.get(0));
    }

    @Test
    void testGetAllItems() {
        // Arrange
        InventoryItem item1 = new InventoryItem("Widget", 10, 19.99);
        InventoryItem item2 = new InventoryItem("Gadget", 5, 9.99);
        repository.addItem(item1);
        repository.addItem(item2);

        // Act
        List<InventoryItem> items = repository.getAllItems();

        // Assert
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    void testUpdateItem() {
        // Arrange
        InventoryItem originalItem = new InventoryItem("Widget", 10, 19.99);
        repository.addItem(originalItem);

        InventoryItem updatedItem = new InventoryItem("Widget", 20, 29.99);

        // Act
        repository.updateItem(updatedItem);

        // Assert
        InventoryItem itemFromRepo = repository.getItemByName("Widget");
        assertNotNull(itemFromRepo);
        assertEquals(20, itemFromRepo.getQuantity());
        assertEquals(29.99, itemFromRepo.getPrice(), 0.001);
    }

    @Test
    void testUpdateItemNotInInventory() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);

        // Act
        repository.updateItem(item);

        // Assert
        assertNull(repository.getItemByName("Widget"));
    }

    @Test
    void testGetItemByNameFound() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);
        repository.addItem(item);

        // Act
        InventoryItem foundItem = repository.getItemByName("Widget");

        // Assert
        assertNotNull(foundItem);
        assertEquals(item, foundItem);
    }

    @Test
    void testGetItemByNameNotFound() {
        // Act
        InventoryItem foundItem = repository.getItemByName("NonExistentItem");

        // Assert
        assertNull(foundItem);
    }

    @Test
    void testGetItemByNameCaseInsensitive() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);
        repository.addItem(item);

        // Act
        InventoryItem foundItem = repository.getItemByName("widget");

        // Assert
        assertNotNull(foundItem);
        assertEquals(item, foundItem);
    }
}