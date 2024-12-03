import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class DeliveryServiceTest {

    private DeliveryService deliveryService; // Instance of the class under test
    private Order order;                    // Shared `Order` instance for tests

    @Before
    public void setUp() {
        deliveryService = new DeliveryService();

        // Initialize a valid Order object for testing
        Customer customer = new Customer("CUST123", "Ahmed Hussain", "123 Manama St.", "00973-39275131");
        order = new Order("ORD001", customer, Arrays.asList("Paracetamol", "Ibuprofen"), 45.0);
    }

    @Test
    public void testCreateDelivery() {
        Delivery delivery = deliveryService.createDelivery(order, "2024-11-01 15:00");

        assertNotNull(delivery);
        assertEquals("Shipped", order.getStatus());
        assertEquals("Out for Delivery", delivery.getDeliveryStatus());
        assertEquals("2024-11-01 15:00", delivery.getEstimatedDeliveryTime());

        // Ensure the delivery is stored in the map
        assertNotNull(deliveryService.getDelivery(delivery.getDeliveryId()));
    }

    @Test
    public void testUpdateDeliveryStatusToDelivered() {
        Delivery delivery = deliveryService.createDelivery(order, "2024-11-01 15:00");
        deliveryService.updateDeliveryStatus(delivery.getDeliveryId(), "Delivered");

        assertEquals("Delivered", delivery.getDeliveryStatus());
        assertEquals("Delivered", order.getStatus());
    }

    @Test
    public void testUpdateDeliveryStatusToOtherStatus() {
        Delivery delivery = deliveryService.createDelivery(order, "2024-11-01 15:00");
        deliveryService.updateDeliveryStatus(delivery.getDeliveryId(), "Out for Delivery");

        assertEquals("Out for Delivery", delivery.getDeliveryStatus());
        assertEquals("Shipped", order.getStatus()); // Ensure the order status does not change
    }

    @Test
    public void testUpdateDeliveryStatusWithInvalidId() {
        deliveryService.updateDeliveryStatus("INVALID_ID", "Delivered");

        // Since there is no exception thrown, ensure there is no crash or effect on other logic
        assertNull(deliveryService.getDelivery("INVALID_ID"));
    }

    @Test
    public void testGetDelivery() {
        Delivery delivery = deliveryService.createDelivery(order, "2024-11-01 15:00");
        Delivery fetchedDelivery = deliveryService.getDelivery(delivery.getDeliveryId());

        assertNotNull(fetchedDelivery);
        assertEquals(delivery, fetchedDelivery);
    }
}
