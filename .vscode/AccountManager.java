import java.util.HashMap;
import java.util.Scanner;

public class AccountManager {
    // HashMap to store accounts with username as key and password as value
    private HashMap<String, String> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean isLoggedIn = false;  // Tracks if a user is logged in

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.run();  // Start the program
    }

    // Main method to run the account management program
    public void run() {
        while (true) {
            if (!isLoggedIn) {
                displayInitialMenu();
            } else {
                displayAccountManagementMenu();
            }
        }
    }

    // Display the initial menu with Register and Login options
    private void displayInitialMenu() {
        System.out.println("\n--- Account Management System ---");
        System.out.println("1. Register");
        System.out.println("2. Log in");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                registerAccount();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    // Display account management options after login
    private void displayAccountManagementMenu() {
        System.out.println("\n--- Account Management ---");
        System.out.println("1. Change Password");
        System.out.println("2. Delete Account");
        System.out.println("3. Log out");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                changePassword();
                break;
            case 2:
                deleteAccount();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    // Method to register a new account
    private void registerAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (accounts.containsKey(username)) {
            System.out.println("Username already exists. Choose another one.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        accounts.put(username, password);  // Add username and password to accounts HashMap
        System.out.println("Account registered successfully!");
    }

    // Method to log in an existing account
    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (!accounts.containsKey(username)) {
            System.out.println("Account does not exist.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (accounts.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username);
            isLoggedIn = true;  // Set logged-in status to true
        } else {
            System.out.println("Incorrect password.");
        }
    }

    // Method to change the password for the logged-in user
    private void changePassword() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        if (!accounts.containsKey(username)) {
            System.out.println("Account does not exist.");
            return;
        }
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();
        if (accounts.get(username).equals(currentPassword)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            accounts.put(username, newPassword);  // Update the password in accounts HashMap
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }

    // Method to delete the account of the logged-in user
    private void deleteAccount() {
        System.out.print("Enter your username to confirm deletion: ");
        String username = scanner.nextLine();
        if (accounts.containsKey(username)) {
            accounts.remove(username);  // Remove account from HashMap
            isLoggedIn = false;  // Set logged-in status to false after deletion
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to log out the current user
    private void logout() {
        isLoggedIn = false;  // Set logged-in status to false
        System.out.println("You have logged out successfully.");
    }
}
