package com.example.demo;

import java.util.ArrayList;

public class Enemy {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private ArrayList<IndividualItemsOwned> items = new ArrayList<>();

    public Enemy(String name, int attack, int defense, int health){
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

    public ArrayList<IndividualItemsOwned> getItems() {
        return items;
    }

    public void setItems(ArrayList<IndividualItemsOwned> items) {
        this.items = items;
    }
}
