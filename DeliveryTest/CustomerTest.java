import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {


    @Test
    public void testGetCustomerId() {
        String customerId;
        customerId = "CUST123";
        assertEquals("CUST123", customerId);
    }

    @Test
    public void testGetName() {
        String name;
        name = "Ahmed Hussain";
        assertEquals("Ahmed Hussain", name);
    }

    @Test
    public void testGetAddress() {
        String address;
        address = "123 Manama St.";
        assertEquals( "123 Manama St.", address);
    }

    @Test
    public void testGetContactNumber() {
        String ContactNumber;
        ContactNumber = "00973-39275131";
        assertEquals( "00973-39275131", ContactNumber);
    }
}