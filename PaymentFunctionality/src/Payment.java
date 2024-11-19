public class Payment {
    private final double amount;
    private final String paymentMethod;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment() {
        if (amount <= 0) {
            System.out.println("Invalid payment amount: $" + amount);
            return false;  // Fail for invalid amounts
        }
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
        return true;  // Success for valid amounts
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
