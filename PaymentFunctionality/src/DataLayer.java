// DataLayer.java
import java.util.HashMap;

public class DataLayer {
    private final HashMap<String, Double> paymentRecords;

    // Constructor
    public DataLayer() {
        paymentRecords = new HashMap<>();
    }

    // Method to save payment record
    public void savePayment(String transactionId, double amount) {
        paymentRecords.put(transactionId, amount);
        System.out.println("Payment record saved: " + transactionId + " - $" + amount);
    }

    // Method to retrieve payment record
    public Double getPayment(String transactionId) {
        return paymentRecords.get(transactionId);
    }
}
