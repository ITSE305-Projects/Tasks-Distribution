import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {

    @Test
    void testMainMethod() {
        // Simulate user input for the payment process (amount = 100, method = "Credit Card")
        String input = "100\nCredit Card\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirect System.in to simulate user input

        // Initialize the DataLayer, BusinessLayer, and PresentationLayer
        DataLayer dataLayer = new DataLayer();
        BusinessLayer businessLayer = new BusinessLayer(dataLayer);
        PresentationLayer presentationLayer = new PresentationLayer(businessLayer);

        // Start the payment process
        presentationLayer.startPaymentProcess();

        // After the payment process, check if the payment is saved in the DataLayer
        String transactionId = "TXN" + System.currentTimeMillis();  // This is just to simulate the expected format
        Double amountSaved = dataLayer.getPayment(transactionId);

        // Check that the payment amount is saved correctly in the DataLayer
        assertNotNull(amountSaved, "Payment should be saved.");
        assertEquals(100.0, amountSaved, "The saved amount should match the entered payment amount.");
    }
}
