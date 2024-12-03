import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("CUST123", "Ahmed Hussain", "123 Manama St.", "00973-39275131");
        order = new Order("ORD001", customer, Arrays.asList("Paracetamol", "Ibuprofen"), 45.0);
    }

    @Test
    public void testOrderConstructorAndGetters() {
        assertEquals("ORD001", order.getOrderId());
        assertEquals(customer, order.getCustomer());
        assertEquals(Arrays.asList("Paracetamol", "Ibuprofen"), order.getMedicines());
        assertEquals(45.0, order.getTotalAmount(), 0.001);
        assertEquals("Pending", order.getStatus());
    }

    @Test
    public void testSetStatus() {
        order.setStatus("Shipped");
        assertEquals("Shipped", order.getStatus());
    }
}
