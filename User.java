// User.java - Represents a registered library user.
public class User {

    private int userId;
    private String name;
    private String email;

    // Constructor
    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Display user details in a readable way
    public String toString() {
        return "ID: " + userId
             + "\nName: " + name
             + "\nEmail: " + email;
    }
}