// Payment.java
//The Payment class encapsulates the details of a payment transaction, including the amount and the method of payment (e.g., credit card, PayPal). It provides a clear structure for representing a payment and includes the functionality to process the payment through the processPayment() method, which simulates the transaction. This class is essential for handling the specifics of each payment instance, and it ensures that all relevant information is bundled together. For example, when a user enters the payment amount and method, a Payment object is created to manage these details throughout the payment workflow.






public class Payment {
    private final double amount; // The amount of the payment in double so we can have numbers with fractions for more accuracy
    private final String paymentMethod; // The method used for the payment ( Credit Card, PayPal, etc)
    // Constructor for the Payment class.
    // @param amount        The amount to be paid.
    // @param paymentMethod The method used for the payment.
    public Payment(double amount, String paymentMethod) {
        this.amount = amount; // Initialize the amount
        this.paymentMethod = paymentMethod; // Initialize the payment method
    }
    // Processes the payment transaction.
    public boolean processPayment() {
        // Simulate payment processing
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
        return true; // Return true for successful payment
    }
    // Getters
    // Gets the amount of the payment.
    public double getAmount() {
        return amount; // Return the payment amount
    }
    // Gets the payment method used.
    public String getPaymentMethod() {
        return paymentMethod; // Return the payment method
    }
}
