package com.example.demo;

public class Items {

    private String Name;
    private int attack;
    private int defense;
    private int price;
    private int heal;

    public Items(String name, int health, int attack, int defense, int price, int heal) {
        this.Name = name;
        this.attack = attack;
        this.defense = defense;
        this.price = price;
        this.heal = heal;
    }


    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return Name;
    }

    public int getHeal() {
        return heal;
    }

    public int getPrice() {
        return price;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
