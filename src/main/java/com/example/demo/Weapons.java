package com.example.demo;
//,

public class Weapons {
    private String name;
    private int price;
    private int damage;
    private String special;

    public Weapons(String name, int price, int damage){
        this.name = name;
        this.price = price;
        this.damage = damage;
        Specialselect();

    }

    public void Specialselect() {
        int randint = randnum(1,3);
        if (randint == 1){
            special = "fire";
        }else if (randint == 2){
            special = "lightning";
        }else {
            special = "ice";
        }
    }

    public String getSpecial() {
        return special;
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

    public int randnum(int min, int max){
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        return randomInt;
    }

}
