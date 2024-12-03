// data layer 
public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String contactNumber;

    public Customer(String customerId, String name, String address, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.co = contactNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
