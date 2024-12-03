import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class DeliveryTest {

    private Delivery delivery;
    private Order order;

    @Before
    public void setUp() {
        // Create a mock order for testing
        Customer customer = new Customer("CUST123", "Ahmed Hussain", "123 Manama St.", "00973-39275131");
        order = new Order("ORD001", customer, Arrays.asList("Paracetamol", "Ibuprofen"), 45.0);

        // Create a delivery instance for testing
        delivery = new Delivery("DEL123", order, "2024-11-01 15:00");
    }

    @Test
    public void testGetDeliveryId() {
        assertEquals("DEL123", delivery.getDeliveryId());
    }

    @Test
    public void testGetOrder() {
        assertEquals(order, delivery.getOrder());
    }

    @Test
    public void testInitialDeliveryStatus() {
        assertEquals("Out for Delivery", delivery.getDeliveryStatus());
    }

    @Test
    public void testSetDeliveryStatus() {
        delivery.setDeliveryStatus("Delivered");
        assertEquals("Delivered", delivery.getDeliveryStatus());
    }

    @Test
    public void testGetEstimatedDeliveryTime() {
        assertEquals("2024-11-01 15:00", delivery.getEstimatedDeliveryTime());
    }

    @Test
    public void testSetEstimatedDeliveryTime() {
        delivery.setEstimatedDeliveryTime("2024-11-01 18:00");
        assertEquals("2024-11-01 18:00", delivery.getEstimatedDeliveryTime());
    }
}
