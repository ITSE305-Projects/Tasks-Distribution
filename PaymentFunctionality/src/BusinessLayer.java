// BusinessLayer.java
//The BusinessLayer class is responsible for handling the core logic related to payment processing in the online pharmacy system. It acts as an intermediary between the presentation and data layers, ensuring that payment transactions are properly processed and recorded. For example, when a payment is initiated, this class creates a Payment object that contains the payment amount and method. It then calls the processPayment() method to simulate the payment process and, upon successful completion, generates a unique transaction ID to save the payment details using the DataLayer. This class ensures that the business rules and logic for payment handling are encapsulated and maintainable.
 





public class BusinessLayer {
  private final DataLayer dataLayer; // Reference to the DataLayer for data persistence
     // Constructor for BusinessLayer.
     // @param dataLayer An instance of DataLayer used for saving payment data.
  // Constructor
  public BusinessLayer(DataLayer dataLayer) {
      this.dataLayer = dataLayer;}
     // Handles the payment process.
     // @param amount        The amount to be processed for the payment.
     // @param paymentMethod The method used for the payment (e.g., Credit Card, PayPal).
     // Method to handle payment
  public void handlePayment(double amount, String paymentMethod) {
      Payment payment = new Payment(amount, paymentMethod); // Creating a new Payment object
      if (payment.processPayment()) {// if statement to process the payment
          // Simulate transaction ID generation
          String transactionId = "TXN" + System.currentTimeMillis();
          dataLayer.savePayment(transactionId, amount); // Saves payment details in the DataLayer
      }
  }
}
