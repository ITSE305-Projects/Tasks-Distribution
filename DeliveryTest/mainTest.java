import org.junit.Test;
import static org.junit.Assert.*;

public class mainTest {

    @Test
    public void testRunApplication() {
        String result = main.runApplication();
        assertEquals("Final Delivery Status: Delivered, Order Status: Delivered", result);
    }
}
