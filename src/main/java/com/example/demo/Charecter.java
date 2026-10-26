package com.example.demo;

import java.util.ArrayList;

public class Charecter {
    private String name;
    private int health=100;
    private int attack;
    private int defense;
    private int Tubers = 100;
    private Weapons weapon;
    private ArrayList<IndividualItemsOwned> items = new ArrayList<>();


    public Charecter(String name, int attack, int defense){
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

    public ArrayList<IndividualItemsOwned> getItems() {
        return items;
    }

    public Weapons getWeapon() {
        return weapon;
    }
}
