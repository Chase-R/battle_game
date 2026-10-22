package com.example.demo;

public class charecter {
    private String name;
    private int health=100;
    private int attack;
    private int defense;
    private int Tubers = 100;

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
}
