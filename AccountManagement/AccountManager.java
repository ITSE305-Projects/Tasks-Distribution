import java.util.HashMap;
import java.util.Scanner;

public class AccountManager {
    // Constants for menu options
    private static final String REGISTER_OPTION = "1. Register";
    private static final String LOGIN_OPTION = "2. Log in";
    private static final String CHANGE_PASSWORD_OPTION = "1. Change Password";
    private static final String DELETE_ACCOUNT_OPTION = "2. Delete Account";
    private static final String LOGOUT_OPTION = "3. Log out";
    
    public HashMap<String, String> accounts = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    public boolean isLoggedIn = false;  // Tracks if a user is logged in
    private boolean isRunning = true;  // Used to control the main loop

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.run();  // Start the program
    }

    // Main method to run the account management program
    public void run() {
        while (isRunning) { // Loop controlled by isRunning
            if (!isLoggedIn) {
                displayInitialMenu();
            } else {
                displayAccountManagementMenu();
            }
        }
    }

    // Stop the loop (used for testing purposes)
    public void stop() {
        isRunning = false;
    }

    // Display the initial menu with Register and Login options
    private void displayInitialMenu() {
        System.out.println("\n--- Account Management System ---");
        System.out.println(REGISTER_OPTION);
        System.out.println(LOGIN_OPTION);
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        handleUserChoice(choice);
    }

    // Handle user choice from the initial menu
    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                registerAccountInteractive();
                break;
            case 2:
                loginInteractive();
                break;
            default:
                System.out.println("Invalid option. Please select a valid number from the menu.");
        }
    }

    // Display account management options after login
    private void displayAccountManagementMenu() {
        System.out.println("\n--- Account Management ---");
        System.out.println(CHANGE_PASSWORD_OPTION);
        System.out.println(DELETE_ACCOUNT_OPTION);
        System.out.println(LOGOUT_OPTION);
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        handleAccountManagementChoice(choice);
    }

    // Handle user choice from the account management menu
    private void handleAccountManagementChoice(int choice) {
        switch (choice) {
            case 1:
                changePasswordInteractive();
                break;
            case 2:
                deleteAccountInteractive();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid option. Please select a valid number from the menu.");
        }
    }

    // Interactive method to register a new account
    public void registerAccountInteractive() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        boolean isRegistered = registerAccount(username, password);
        if (isRegistered) {
            System.out.println("Account registered successfully!");
        } else {
            System.out.println("Username already exists. Choose another one.");
        }
    }

    // Method to register a new account
    public boolean registerAccount(String username, String password) {
        if (accounts.containsKey(username)) {
            return false; // Username already exists
        }
        accounts.put(username, password);
        return true; // Account registered successfully
    }

    // Interactive method to log in an existing account
    public void loginInteractive() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        boolean isLoggedIn = login(username, password);
        if (isLoggedIn) {
            System.out.println("Login successful! Welcome, " + username);
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    // Method to log in an existing account
    public boolean login(String username, String password) {
        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            isLoggedIn = true;
            return true; // Login successful
        }
        return false; // Login failed
    }

    // Interactive method to change the password for the logged-in user
    public void changePasswordInteractive() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        boolean isPasswordChanged = changePassword(username, currentPassword, newPassword);
        if (isPasswordChanged) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect current password or username not found.");
        }
    }

    // Method to change password
    public boolean changePassword(String username, String currentPassword, String newPassword) {
        if (accounts.containsKey(username) && accounts.get(username).equals(currentPassword)) {
            accounts.put(username, newPassword);
            return true; // Password changed successfully
        }
        return false; // Password change failed
    }

    // Interactive method to delete the account of the logged-in user
    public void deleteAccountInteractive() {
        System.out.print("Enter your username to confirm deletion: ");
        String username = scanner.nextLine();
        boolean isDeleted = deleteAccount(username);
        if (isDeleted) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to delete an account
    public boolean deleteAccount(String username) {
        if (accounts.containsKey(username)) {
            accounts.remove(username);
            isLoggedIn = false; // Logout after deletion
            return true; // Account deleted successfully
        }
        return false; // Account not found
    }

    // Method to log out the current user
    public void logout() {
        isLoggedIn = false; // Set logged-in status to false
        System.out.println("You have logged out successfully.");
    }
}