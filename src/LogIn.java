package src;

public class LogIn {
    private String username;
    private String password;

    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public String getUsername() {
        return username;
    }
}