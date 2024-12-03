import java.util.logging.Logger;

/**
 * Represents a payment with an amount and a method of payment.
 */
public class Payment {
    private static final Logger logger = Logger.getLogger(Payment.class.getName());
    private static final String INVALID_AMOUNT_MESSAGE = "Invalid payment amount: $";
    private static final String PROCESSING_PAYMENT_MESSAGE = "Processing payment of $";

    private final double amount;
    private final String paymentMethod;

    /**
     * Constructs a Payment object.
     *
     * @param amount        the payment amount. Must be greater than zero.
     * @param paymentMethod the payment method. Must not be null or empty.
     * @throws IllegalArgumentException if the amount is less than or equal to zero,
     *                                  or if the payment method is null or empty.
     */
    public Payment(double amount, String paymentMethod) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be null or empty.");
        }
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Processes the payment. Returns true if successful, false otherwise.
     *
     * @return true if the payment is processed successfully, false otherwise.
     */
    public boolean processPayment() {
        if (amount <= 0) {
            logger.warning(INVALID_AMOUNT_MESSAGE + amount);
            return false; // Fail for invalid amounts
        }
        logger.info(PROCESSING_PAYMENT_MESSAGE + amount + " using " + paymentMethod);
        return true; // Success for valid amounts
    }

    /**
     * Gets the payment amount.
     *
     * @return the payment amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the payment method.
     *
     * @return the payment method.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Returns a string representation of the Payment object.
     *
     * @return a string representation of the Payment object.
     */
    @Override
    public String toString() {
        return "Payment{amount=$" + amount + ", paymentMethod='" + paymentMethod + "'}";
    }
}
