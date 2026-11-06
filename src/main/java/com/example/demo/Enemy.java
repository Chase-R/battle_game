package com.example.demo;
//gothub
import java.util.ArrayList;

public class Enemy {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private double criticalchance = 0.10;
    private ArrayList<IndividualItemsOwned> items = new ArrayList<>();

    public Enemy(String name, int attack, int defense, int health, int speed){
        this.attack=attack;
        this.defense = defense;
        this.name = name;
        this.health = health;
        this.speed = speed;
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


}
