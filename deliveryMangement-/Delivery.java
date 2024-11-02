//data layer 2

public class Delivery {
    private String deliveryId;
    private Order order;
    private String deliveryStatus;  // e.g., "Out for Delivery", "Delivered"
    private String estimatedDeliveryTime;

    public Delivery(String deliveryId, Order order, String estimatedDeliveryTime) {
        this.deliveryId = deliveryId;
        this.order = order;
        this.deliveryStatus = "Out for Delivery";
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public Order getOrder() {
        return order;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
