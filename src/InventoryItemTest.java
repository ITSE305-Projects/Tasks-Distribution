import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryItemTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String name = "Widget";
        int quantity = 10;
        double price = 19.99;

        // Act
        InventoryItem item = new InventoryItem(name, quantity, price);

        // Assert
        assertEquals(name, item.getName());
        assertEquals(quantity, item.getQuantity());
        assertEquals(price, item.getPrice(), 0.001);
    }

    @Test
    void testSetQuantity() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);

        // Act
        item.setQuantity(20);

        // Assert
        assertEquals(20, item.getQuantity());
    }

    @Test
    void testSetPrice() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);

        // Act
        item.setPrice(29.99);

        // Assert
        assertEquals(29.99, item.getPrice(), 0.001);
    }

    @Test
    void testToString() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);
        String expected = "Name: Widget, Quantity: 10, Price: $19.99";

        // Act
        String actual = item.toString();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testEqualsSameName() {
        // Arrange
        InventoryItem item1 = new InventoryItem("Widget", 10, 19.99);
        InventoryItem item2 = new InventoryItem("widget", 5, 15.99);

        // Act & Assert
        assertTrue(item1.equals(item2));
    }

    @Test
    void testEqualsDifferentName() {
        // Arrange
        InventoryItem item1 = new InventoryItem("Widget", 10, 19.99);
        InventoryItem item2 = new InventoryItem("Gadget", 10, 19.99);

        // Act & Assert
        assertFalse(item1.equals(item2));
    }

    @Test
    void testEqualsWithNonInventoryItem() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);
        String otherObject = "NotAnInventoryItem";

        // Act & Assert
        assertFalse(item.equals(otherObject));
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        InventoryItem item = new InventoryItem("Widget", 10, 19.99);

        // Act & Assert
        assertFalse(item.equals(null));
    }
}