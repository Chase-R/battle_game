package com.example.demo;
//gothub//,
import java.util.ArrayList;

public class Enemy {
    private final int maxHealth;
    private final int maxmp;
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int magicp = 5;
    private double criticalchance = 0.10;
    private ArrayList<IndividualItemsOwned> items = new ArrayList<>();


    public Enemy(String name, int attack, int defense, int health, int speed){
        this.attack=attack;
        this.defense = defense;
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.maxHealth = health;
        this.maxmp = 3 + health / 10; 
        this.magicp = maxmp / 2;
    }
    public void takeDamage(int damage){
        health-=damage;
    }
    public int getSpeed() {
        return speed;
    }

    public double getCriticalchance() {
        return criticalchance;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<IndividualItemsOwned> getItems() {
        return items;
    }


    public int getMagicp() {
        return magicp;
    }

    public void setMagicp(int magicp) {
        this.magicp = magicp;
    }
    public int getMaxHealth() { return maxHealth; }

    public void gainmp(int amount) {
        magicp = Math.min(magicp + amount, maxmp);
    }

    public boolean useMp(int amount) {
        if (amount > 0 && amount <= magicp) {
            magicp -= amount;
            return true;
        }
        return false;
    }

    public void heal(int amount) {
        health = Math.min(health + amount, maxHealth);
    }
}
