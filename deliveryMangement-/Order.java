//data layer 
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<String> medicines;  // List of medicine names
    private double totalAmount;
    private String status;  // e.g., "Pending", "Shipped", "Delivered"

    public Order(String orderId, Customer customer, List<String> medicines, double totalAmount) {
        this.orderId = orderId;
        this.customer = customer;
        this.medicines = medicines;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<String> getMedicines() {
        return medicines;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
