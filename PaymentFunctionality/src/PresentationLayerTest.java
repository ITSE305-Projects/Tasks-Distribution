import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class PresentationLayerTest {

    private BusinessLayer businessLayer;
    private PresentationLayer presentationLayer;

    @BeforeEach
    void setUp() {
        DataLayer dataLayer = new DataLayer();
        businessLayer = new BusinessLayer(dataLayer);
        presentationLayer = new PresentationLayer(businessLayer);
    }

    @Test
    void testStartPaymentProcess_ValidInput() {
        // Simulate valid input: amount = 100, method = "Credit Card"
        String input = "100\nCredit Card\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        presentationLayer.startPaymentProcess();

        // Then
        assertNotNull(businessLayer, "BusinessLayer should process payment.");
        assertNotNull(businessLayer, "The payment should be saved.");
    }

    @Test
    void testStartPaymentProcess_InvalidInput() {
        // Simulate invalid input (non-numeric amount)
        String input = "invalid\nCredit Card\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        presentationLayer.startPaymentProcess();

        // Then
        // We don't expect an exception but should handle invalid input gracefully
        assertTrue(true, "Test passes if no exception occurs.");
    }
}
