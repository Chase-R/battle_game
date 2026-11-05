package com.example.demo;

public class Items {

    private String name;
    private int attack;
    private int defense;
    private int price;
    private int heal;
    private int uses = 3;

    public Items(String name, int attack, int defense, int price, int heal) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.price = price;
        this.heal = heal;
    }

    public String getall(){
        return name + " attack: "+attack+" defense: "+defense+" heal: "+heal;
    }
    public String getwithpiceall(){
        return name + " attack: "+attack+" defense: "+defense+" price: "+price+" heal: "+heal;
    }


    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getHeal() {
        return heal;
    }

    public int getPrice() {
        return price;
    }


    public int getUses() {
        return uses;
    }

    public void Use() {
        uses--;
    }
}
