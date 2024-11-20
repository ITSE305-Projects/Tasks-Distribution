import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();
    }

    @Test
    void testRegisterAccount_Success() {
        boolean isRegistered = accountManager.registerAccount("newuser", "newpassword");
        assertTrue(isRegistered, "Account should be registered successfully");
        assertTrue(accountManager.accounts.containsKey("newuser"), "Account should exist in the accounts HashMap");
        assertEquals("newpassword", accountManager.accounts.get("newuser"), "Password should match");
    }

    @Test
    void testRegisterAccount_UsernameAlreadyExists() {
        accountManager.registerAccount("existinguser", "password123");
        boolean isRegistered = accountManager.registerAccount("existinguser", "anotherpassword");
        assertFalse(isRegistered, "Duplicate username should return false");
    }

    @Test
    void testLogin_Success() {
        accountManager.registerAccount("testuser", "testpassword");
        boolean isLoggedIn = accountManager.login("testuser", "testpassword");
        assertTrue(isLoggedIn, "Login should be successful");
        assertTrue(accountManager.isLoggedIn, "isLoggedIn should be true after successful login");
    }

    @Test
    void testLogin_Failure_WrongPassword() {
        accountManager.registerAccount("testuser", "testpassword");
        boolean isLoggedIn = accountManager.login("testuser", "wrongpassword");
        assertFalse(isLoggedIn, "Login should fail with incorrect password");
        assertFalse(accountManager.isLoggedIn, "isLoggedIn should remain false after failed login");
    }

    @Test
    void testChangePassword_Success() {
        accountManager.registerAccount("user1", "oldpassword");
        boolean isPasswordChanged = accountManager.changePassword("user1", "oldpassword", "newpassword");
        assertTrue(isPasswordChanged, "Password should be changed successfully");
        assertEquals("newpassword", accountManager.accounts.get("user1"), "Password should match the new password");
    }

    @Test
    void testChangePassword_Failure_WrongCurrentPassword() {
        accountManager.registerAccount("user1", "oldpassword");
        boolean isPasswordChanged = accountManager.changePassword("user1", "wrongpassword", "newpassword");
        assertFalse(isPasswordChanged, "Password change should fail with incorrect current password");
        assertEquals("oldpassword", accountManager.accounts.get("user1"), "Password should not be changed");
    }

    @Test
    void testDeleteAccount_Success() {
        accountManager.registerAccount("userToDelete", "password");
        boolean isDeleted = accountManager.deleteAccount("userToDelete");
        assertTrue(isDeleted, "Account should be deleted successfully");
        assertFalse(accountManager.accounts.containsKey("userToDelete"), "Account should not exist after deletion");
    }

    @Test
    void testDeleteAccount_Failure_UserNotFound() {
        boolean isDeleted = accountManager.deleteAccount("nonexistentuser");
        assertFalse(isDeleted, "Deleting a non-existent account should return false");
    }

    @Test
    void testLogout() {
        accountManager.isLoggedIn = true;
        accountManager.logout();
        assertFalse(accountManager.isLoggedIn, "User should be logged out successfully");
    }
}
