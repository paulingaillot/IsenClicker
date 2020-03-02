package fr.ybsi.isenclicker3;

import java.util.HashMap;

public class User {

    private String username;
    private String password;
    private int points;
    private HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    // --- GETTERS ---
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getPoints() { return points; }
    public HashMap<String, Boolean> getMap() {
        return map;
    }

    // --- SETTERS ---
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setPoints(int points) { this.points = points; }
    public void setMap(HashMap<String, Boolean> map1) {
        this.map = map1;
    }
}
