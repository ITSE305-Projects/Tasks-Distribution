import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BusinessLayerTest {

    @Test
    void testHandlePayment_FailedPayment() {
        DataLayer dataLayer = new DataLayer();
        BusinessLayer businessLayer = new BusinessLayer(dataLayer);
        businessLayer.handlePayment(0.0, "Credit Card");

        // Assuming transactionId is not generated due to failed payment
        String transactionId = "TXN" + System.currentTimeMillis();
        Double amountSaved = dataLayer.getPayment(transactionId);

        assertNull(amountSaved, "Payment should not be saved for an invalid amount.");
    }

    @Test
    void testHandlePayment_ValidPayment() {
        DataLayer dataLayer = new DataLayer();
        BusinessLayer businessLayer = new BusinessLayer(dataLayer);
        businessLayer.handlePayment(100.0, "Credit Card");

        String transactionId = businessLayer.getLastTransactionId();
        assertNotNull(transactionId, "Transaction ID should not be null.");

        Double amountSaved = dataLayer.getPayment(transactionId);
        assertNotNull(amountSaved, "Payment should be saved for a valid amount.");
        assertEquals(100.0, amountSaved, "The saved payment amount should be 100.0.");
    }

}
