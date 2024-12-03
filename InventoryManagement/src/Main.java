import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InventoryUI inventoryUI = new InventoryUI();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Pharmacy Inventory System!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Add New Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    // Display Inventory
                    inventoryUI.displayInventory();
                    break;

                case 2:
                    // Add New Item
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume newline character

                    inventoryUI.addNewItem(name, quantity, price);
                    break;

                case 3:
                    // Update Item Quantity
                    System.out.print("Enter the name of the item to update: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter the new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline character

                    inventoryUI.updateItemQuantity(itemName, newQuantity);
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}