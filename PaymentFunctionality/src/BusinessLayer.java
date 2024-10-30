// BusinessLayer.java
public class BusinessLayer {
  private final DataLayer dataLayer;

  // Constructor
  public BusinessLayer(DataLayer dataLayer) {
      this.dataLayer = dataLayer;
  }

  // Method to handle payment
  public void handlePayment(double amount, String paymentMethod) {
      Payment payment = new Payment(amount, paymentMethod);
      if (payment.processPayment()) {
          // Simulate transaction ID generation
          String transactionId = "TXN" + System.currentTimeMillis();
          dataLayer.savePayment(transactionId, amount);
      }
  }
}
