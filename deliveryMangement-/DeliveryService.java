//business layer : 

import java.util.HashMap;
import java.util.Map;

public class DeliveryService {

      // A Map to store deliveries by their ID
    private Map<String, Delivery> deliveries = new HashMap<>();

    public Delivery createDelivery(Order order, String estimatedDeliveryTime) {
        // Generate a unique delivery ID
        String deliveryId = "DEL" + System.currentTimeMillis();
        Delivery delivery = new Delivery(deliveryId, order, estimatedDeliveryTime);
        //Store the new delivery in the map with the delivery ID
        deliveries.put(deliveryId, delivery);
        order.setStatus("Shipped");
        System.out.println("Delivery created with ID: " + deliveryId);
        return delivery;
    }

    //Updates the status of an existing delivery.
    public void updateDeliveryStatus(String deliveryId, String newStatus) {
        Delivery delivery = deliveries.get(deliveryId);
        if (delivery != null) {
            delivery.setDeliveryStatus(newStatus);
            if (newStatus.equals("Delivered")) {
                delivery.getOrder().setStatus("Delivered");
            }
            System.out.println("Delivery status updated to: " + newStatus);
        } else {
            System.out.println("Delivery not found for ID: " + deliveryId);
        }
    }

    public Delivery getDelivery(String deliveryId) {
        return deliveries.get(deliveryId);
    }
}
