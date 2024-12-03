// presentation layer 

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("CUST123", "Ahmed Hussain", "123 Manama St.", "00973-39275131");

        // Create an order
        Order order = new Order("ORD001", customer, Arrays.asList("Paracetamol", "Ibuprofen"), 45.0);

        // Create the delivery service and initiate delivery
        DeliveryService deliveryService = new DeliveryService();
        Delivery delivery = deliveryService.createDelivery(order, "2024-11-01 15:00");

        // Update delivery status
        deliveryService.updateDeliveryStatus(delivery.getDeliveryId(), "Out for Delivery");
        deliveryService.updateDeliveryStatus(delivery.getDeliveryId(), "Delivered");

        // Output final delivery status
        System.out.println("Final Delivery Status: " + delivery.getDeliveryStatus());
        System.out.println("Order Status: " + order.getStatus());
    }
}
