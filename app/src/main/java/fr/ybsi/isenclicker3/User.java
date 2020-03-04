package fr.ybsi.isenclicker3;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private int points;
    private Map<String, Boolean> map ;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money;

    public int getLastShop() {
        return lastShop;
    }

    public void setLastShop(int lastShop) {
        this.lastShop = lastShop;
    }

    private int lastShop;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
        this.lastShop = 0;
        this.money = 0;

    }

    // --- GETTERS ---
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getPoints() { return points; }
    public Map<String, Boolean> getMap() {
        return map;
    }

    // --- SETTERS ---
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setPoints(int points) { this.points = points; }
    public void setMap(Map<String, Boolean> map1) {
        this.map = map1;
    }
}
