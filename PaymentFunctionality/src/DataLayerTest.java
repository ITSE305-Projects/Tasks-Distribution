import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class DataLayerTest {

    @Test
    void testSavePayment() {
        // Given
        DataLayer dataLayer = new DataLayer();
        String transactionId = "TXN123";
        double amount = 100.0;

        // When
        dataLayer.savePayment(transactionId, amount);

        // Then
        assertEquals(amount, dataLayer.getPayment(transactionId), "The payment amount should be correctly saved.");
    }

    @Test
    void testGetPayment() {
        // Given
        DataLayer dataLayer = new DataLayer();
        String transactionId = "TXN123";
        double amount = 100.0;
        dataLayer.savePayment(transactionId, amount);

        // When
        Double retrievedAmount = dataLayer.getPayment(transactionId);

        // Then
        assertNotNull(retrievedAmount, "Payment should exist in the records.");
        assertEquals(amount, retrievedAmount, "The retrieved payment amount should match.");
    }

    @Test
    void testGetPayment_NotFound() {
        // Given
        DataLayer dataLayer = new DataLayer();
        String transactionId = "TXN999";  // Non-existing transaction ID

        // When
        Double retrievedAmount = dataLayer.getPayment(transactionId);

        // Then
        assertNull(retrievedAmount, "Payment should not be found.");
    }
}
