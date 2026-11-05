package com.example.demo;

public class Weapons {
    private String name;
    private int price;
    private int damage;

    public Weapons(String name, int price, int damage){
        this.name = name;
        this.price = price;
        this.damage = damage;
    }




    public int getDamage() {
        return damage;
    }
    public int getPrice() {return price;}
    public String getName() {return name;}
    public String getallprice(){
        return "name: " + name + " damage: " + damage + " price: " + price;
    }
    public String getall() {
        return "name: " + name + " damage: " + damage;
    }
}
