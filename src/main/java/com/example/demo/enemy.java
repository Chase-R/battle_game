package com.example.demo;

import java.util.ArrayList;

public class enemy {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private ArrayList<individualItemsOwned> items = new ArrayList<>();

    public enemy(String name, int attack, int defense, int health){
        this.attack=attack;
        this.defense = defense;
        this.name = name;
        this.health = health;
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

    public ArrayList<individualItemsOwned> getItems() {
        return items;
    }

    public void setItems(ArrayList<individualItemsOwned> items) {
        this.items = items;
    }
}
