// DataLayer.java
import java.util.HashMap;
 //The DataLayer class is designed to manage the storage and retrieval of payment records within the online 
 //pharmacy system. It utilizes a HashMap to store transaction IDs alongside their corresponding payment amounts,
 // allowing for efficient data management. When a payment is processed, the savePayment() method is called to 
 //record the transaction, providing a clear and accessible way to keep track of all payments made. Additionally, 
 //the getPayment() method enables retrieval of payment information based on the transaction ID. This separation of data management from business logic enhances the system's organization and makes it easier to maintain.
 




public class DataLayer {
    private final HashMap<String, Double> paymentRecords; // the hashMap to store payment records
     // Constructor for DataLayer.
     // Initializes the paymentRecords HashMap to store payment information.
    public DataLayer() {
        paymentRecords = new HashMap<>(); }
     // Saves a payment record in the data storage.
    // @param transactionId The unique identifier for the payment transaction.
     // @param amount        The amount of money for the payment.
    public void savePayment(String transactionId, double amount) {
        paymentRecords.put(transactionId, amount); // Store the transaction ID and amount in the HashMap
        System.out.println("Payment record saved: " + transactionId + " - $" + amount); // Log the save action
    }
     // Retrieves a payment record based on the transaction ID.     
     // @param transactionId The unique identifier for the payment transaction.
     // @return The amount of the payment associated with the transaction ID, or null if not found.
    public Double getPayment(String transactionId) {
        return paymentRecords.get(transactionId); // Retrieve the amount from the HashMap
    }
}
