package fr.ybsi.isenclicker3;

public class User {

    private String username;
    private String password;
    private int points;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    // --- GETTERS ---
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getPoints() { return points; }

    // --- SETTERS ---
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setPoints(int points) { this.points = points; }
}
