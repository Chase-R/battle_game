package com.example.demo;
//,

public class Items {

    private String name;
    private int attack;
    private int price;
    private int heal;
    private int maxmp;

    private int uses = 1;

    public Items(String name, int attack, int price, int heal, int magic) {
        this.name = name;
        this.attack = attack;
        this.price = price;
        this.heal = heal;
        this.maxmp = magic;
    }

    public String getall(){
        return name + " attack: "+attack+" heal: "+heal+" Max magic inc: "+maxmp;
    }
    public String getwithpiceall(){
        return name + " attack: "+attack+" price: "+price+" heal: "+heal+" Max magic inc: "+maxmp;
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

    public int getMagic() {
        return maxmp;
    }
}
