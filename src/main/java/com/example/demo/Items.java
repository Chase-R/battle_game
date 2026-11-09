package com.example.demo;

public class Items {

    private String name;
    private int attack;
    private int price;
    private int heal;
    private int uses = 1;

    public Items(String name, int attack, int price, int heal) {
        this.name = name;
        this.attack = attack;
        this.price = price;
        this.heal = heal;
    }

    public String getall(){
        return name + " attack: "+attack+" heal: "+heal;
    }
    public String getwithpiceall(){
        return name + " attack: "+attack+" price: "+price+" heal: "+heal;
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
