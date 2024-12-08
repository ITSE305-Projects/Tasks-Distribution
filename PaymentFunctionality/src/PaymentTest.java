import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test
    void testProcessPayment_Success() {
        // Given
        double amount = 100.0;
        String paymentMethod = "Credit Card";
        Payment payment = new Payment(amount, paymentMethod);

        // When
        boolean result = payment.processPayment();

        // Then
        assertTrue(result, "Payment should be processed successfully.");
    }

    @Test
    void testGetAmount() {
        // Given
        double amount = 50.0;
        String paymentMethod = "PayPal";
        Payment payment = new Payment(amount, paymentMethod);

        // When
        double result = payment.getAmount();

        // Then
        assertEquals(amount, result, "Payment amount should match.");
    }

    @Test
    void testGetPaymentMethod() {
        // Given
        double amount = 50.0;
        String paymentMethod = "PayPal";
        Payment payment = new Payment(amount, paymentMethod);

        // When
        String result = payment.getPaymentMethod();

        // Then
        assertEquals(paymentMethod, result, "Payment method should match.");
    }
}
