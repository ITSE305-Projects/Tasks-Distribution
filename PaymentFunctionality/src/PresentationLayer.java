
import java.util.Scanner;

//The PresentationLayer class is responsible for handling user interactions in the online pharmacy system.
// It prompts users for necessary payment information, such as the payment amount and method, through the console.
// Using the Scanner class, it captures user input and communicates with the BusinessLayer to process the payment.
// This layer serves as the bridge between the user and the application's backend logic, ensuring a smooth user experience.
// For instance, when a user is prompted to enter a payment amount, the class collects this input and forwards it to the 
//BusinessLayer for further processing, making it a vital component for user engagement in the payment process.




public class PresentationLayer {
    private final BusinessLayer businessLayer;
     // Reference to the BusinessLayer for processing payments
    // Constructor for the PresentationLayer class.
    // @param businessLayer An instance of BusinessLayer used for handling payments.
    public PresentationLayer(BusinessLayer businessLayer) {
        this.businessLayer = businessLayer; // Initialize the business layer
    }
    // Starts the payment process by prompting the user for payment details.
    public void startPaymentProcess() {
        try (Scanner scanner = new Scanner(System.in)) { // Use try-with-resources for automatic resource management

            System.out.println("Enter payment amount:"); // Prompt for payment amount

            double amount = scanner.nextDouble(); // Read the payment amount

            System.out.println("Enter payment method (e.g., Credit Card, PayPal):"); // Prompt for payment method

            String method = scanner.next(); // Read the payment method

            businessLayer.handlePayment(amount, method); // Pass the collected data to the business layer for processing
        } 
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle any exceptions that occur
        }
    }
}
