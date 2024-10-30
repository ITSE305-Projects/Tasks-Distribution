// PresentationLayer.java
import java.util.Scanner;

public class PresentationLayer {
    private final BusinessLayer businessLayer;

    // Constructor
    public PresentationLayer(BusinessLayer businessLayer) {
        this.businessLayer = businessLayer;
    }

    // Method to start the payment process
    public void startPaymentProcess() {
      try (Scanner scanner = new Scanner(System.in)) { // Use try-with-resources
        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        System.out.println("Enter payment method (e.g., Credit Card, PayPal):");
        String method = scanner.next();

        businessLayer.handlePayment(amount, method);
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
}
