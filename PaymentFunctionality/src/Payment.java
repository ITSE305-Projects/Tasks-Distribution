// Payment.java
public class Payment {
  private final double amount;
  private final String paymentMethod;

  // Constructor
  public Payment(double amount, String paymentMethod) {
      this.amount = amount;
      this.paymentMethod = paymentMethod;
  }

  // Method to process the payment
  public boolean processPayment() {
      // Simulate payment processing
      System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
      return true; // Return true for successful payment
  }

  // Getters
  public double getAmount() {
      return amount;
  }

  public String getPaymentMethod() {
      return paymentMethod;
  }
}
