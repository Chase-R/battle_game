package com.example.demo;
//,

import java.util.ArrayList;

public class Charecter {
    private String name;
    private int health=100;
    private int attack;
    private int defense;
    private int tubers = 0;
    private int magicp = 5;
    private int maxmp =10;
    private int speed = 10-randnum(1,10);
    private double criticalchance = (double) (10 - speed) /10;
    private Weapons weapon;
    private ArrayList<IndividualItemsOwned> items = new ArrayList<>();
    private String imagePath;
    private int sheild = 0;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }


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

    public int takedamage(int damage){
        int absorbed = Math.min(sheild, damage);
        sheild -= absorbed;
        health -= (damage - absorbed);
        return absorbed;
    }

    public int gainmp(int amount){
        magicp = Math.min(magicp + amount, maxmp);
        return magicp;
    }

    public Weapons getWeapon() {
        return weapon;
    }
    public boolean arrowUse(Items selectedItem) {
        IndividualItemsOwned temp = ownItem(selectedItem);

        if (temp != null && temp.getUses() > 0) {
            temp.Use();
            return true;
        }

        return false;
    }


    public String itembuy(Items selectedItem){
        if (selectedItem.getPrice() <= tubers){
            tubers -= selectedItem.getPrice();
            IndividualItemsOwned temp = ownItem(selectedItem);

            if (temp == null) {
                items.add(new IndividualItemsOwned(selectedItem, 1));
                return "bought a new item" + items.getLast().getItem().getName();

            }else {
                temp.addUses(1);
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

    public int getMagicp() {
        return magicp;
    }

    public boolean usemp(int use){
        if (use > 0 && use <= magicp){
            magicp -= use;
            return true;
        }
        return false;
    }



    public void setMagicp(int magicp) {
        this.magicp = magicp;
    }

    public int randnum(int min, int max){
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        return randomInt;
    }

    public void heal(int heal){
        health+=heal;
    }

    public double getCriticalchance() {
        return criticalchance;
    }

    public void setCriticalchance(double criticalchance) {
        this.criticalchance = criticalchance;
    }

    public int getSpeed() {
        return speed;
    }
    public boolean itemUse(Items selectedItem){

        IndividualItemsOwned temp = ownItem(selectedItem);

        if (temp != null && temp.getUses() > 0){

            health += selectedItem.getHeal();
            maxmp += selectedItem.getMagic();

            temp.Use();

            return true;
        }

        return false;
    }

    public int getMaxmp() {
        return maxmp;
    }

    public void setMaxmp(int maxmp) {
        this.maxmp = maxmp;
    }

    private boolean compmpmax( int add){
        if(magicp+ add <=maxmp){
            return true;
        }
        return false;
    }

    public int getSheild() {
        return sheild;
    }

    public void resetSheild(){
        sheild=0;
    }
    public void usesheils( int use){
        sheild += use;
    }

    public void setSheild(int sheild) {
        this.sheild = sheild;
    }
}
