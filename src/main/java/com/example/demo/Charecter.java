package com.example.demo;

import java.util.ArrayList;

public class Charecter {
    private String name;
    private int health=100;
    private int attack;
    private int defense;
    private int tubers = 0;
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
        return tubers;
    }
    public void addtuber(int num){
        tubers += num;
    }
    public void subtuber(int num){
        tubers -= num;
    }

    public ArrayList<IndividualItemsOwned> getItems() {
        return items;
    }

    public void takedamage(int damage){
        health-=damage;
    }

    public Weapons getWeapon() {
        return weapon;
    }


    public String itembuy(Items selectedItem){
        if (selectedItem.getPrice() <= tubers){
            tubers -= selectedItem.getPrice();
            IndividualItemsOwned temp = ownItem(selectedItem);

            if (temp == null) {
                items.add(new IndividualItemsOwned(selectedItem, 1));
                return "bought a new item" + items.getLast().getItem().getName();

            }else {
                temp.addUses(3);
                return "bought more of a item" + temp.getUses();
            }

        }else {
            return "no money";


        }

    }
    public String itembuyw(Weapons selectedItem){
        if (selectedItem.getPrice() <= tubers){
            tubers -= selectedItem.getPrice();
            weapon = selectedItem;
            return "bought";



        }else {
            return "no money";


        }

    }

    public String weaponbuy(Weapons selectedweapon){
        if (selectedweapon.getPrice() <= tubers){
            weapon = selectedweapon;
            return "sucess";
        }
        return "fail";

    }
    public IndividualItemsOwned ownItem(Items itemsbuy){
        IndividualItemsOwned temp = null;

        for (int i=0; i <items.size(); i++ ) {
            if (items.get(i).getItem().equals(itemsbuy)) {
                temp = items.get(i);
            }
        }
        return temp;
    }
}
