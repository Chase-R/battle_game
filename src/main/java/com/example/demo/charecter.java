package com.example.demo;

import java.util.ArrayList;

public class charecter {
    private String name;
    private int health=100;
    private int attack;
    private int defense;
    private int Tubers = 100;
    private weapons weapon;
    private ArrayList<individualItemsOwned> items = new ArrayList<>();


    public charecter(String name, int attack, int defense){
        this.attack=attack;
        this.defense = defense;
        this.name = name;

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

    public int getTubers() {
        return Tubers;
    }

    public ArrayList<individualItemsOwned> getItems() {
        return items;
    }

    public weapons getWeapon() {
        return weapon;
    }
}
