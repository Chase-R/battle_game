package com.example.demo;
//github

import java.util.ArrayList;

public class Manager {

    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Weapons weapons;
    private Charecter player;
    private ArrayList<Weapons> storeweapons = new ArrayList<>();
    private ArrayList<Items> storeitems = new ArrayList<>();



    public Manager(){
        enemies.add(new Enemy("Tunnel Scout", randnum(3,4), 2, randnum(10,14)));
        enemies.add(new Enemy("Tuber Thief", randnum(4,5), 3, randnum(14,18)));
        enemies.add(new Enemy("Colony Defender", randnum(5,6), 4, randnum(19,25)));
        enemies.add(new Enemy("Incisor Warrior", randnum(7,8), 5, randnum(25,31)));
        enemies.add(new Enemy("Tunnel Brute", randnum(9,10), 7, randnum(34,42)));
        enemies.add(new Enemy("Royal Guard", randnum(12,13), 9, randnum(45,55)));
        enemies.add(new Enemy("Queen's Champion", randnum(15,16), 12, randnum(58,72)));
        enemies.add(new Enemy("The Queen", randnum(20,22), 16, randnum(90,110)));
        storeitems.add(new Items("Small Tuber", 0, 0, randnum(13,17), randnum(4,6)));
        storeitems.add(new Items("Sharpened Incisors", randnum(4,6), 0, randnum(23,27), 0));
        storeitems.add(new Items("Thick Hide", 0, randnum(4,6), randnum(23,27), 0));
        storeitems.add(new Items("Juicy Root", 0, 0, randnum(37,43), randnum(9,11)));
        storeitems.add(new Items("Battle Tuber", randnum(4,6), randnum(4,6), randnum(60,70), 0));
        storeitems.add(new Items("Golden Tuber", 0, 0, randnum(70,80), randnum(18,22)));
        storeitems.add(new Items("Royal Warpaint", randnum(9,11), randnum(4,6), randnum(95,105), 0));
        storeitems.add(new Items("Queen's Nectar", 0, 0, randnum(120,130), randnum(32,38)));
        storeweapons.add(new Weapons("Pebble", randnum(13,17), randnum(2,4)));
        storeweapons.add(new Weapons("Sharp Incisor", randnum(27,33), randnum(4,6)));
        storeweapons.add(new Weapons("Bone Dagger", randnum(45,55), randnum(6,8)));
        storeweapons.add(new Weapons("Tuber Club", randnum(70,80), randnum(9,11)));
        storeweapons.add(new Weapons("Crystal Spear", randnum(105,115), randnum(12,14)));
        storeweapons.add(new Weapons("Royal Fang", randnum(150,170), randnum(16,18)));
        storeweapons.add(new Weapons("Queen's Scepter", randnum(240,260), randnum(21,23)));

    }

    public void enemyattack(Enemy opponent){
        System.out.println(opponent.getAttack());
        System.out.println(player.getDefense());
        if(opponent.getAttack()- player.getDefense()>0){
            player.takedamage(opponent.getAttack()- player.getDefense());
        }

    }
    public void attack(Enemy opponent){

        if (weapons== null){
            if(player.getAttack()-opponent.getDefense()>0){
                opponent.takeDamage(player.getAttack()-opponent.getDefense());

            }

        }else{
            if(player.getAttack()+ weapons.getDamage()-opponent.getDefense()>0){
                opponent.takeDamage(player.getAttack()+ weapons.getDamage()-opponent.getDefense());
            }

        }


    }



//yes
    public Charecter getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setPlayer(Charecter player) {
        this.player = player;
        System.out.println(player.getName());

    }

    public int randnum(int min, int max){
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        return randomInt;
    }

    public int checkifwon(Enemy opponent){
        if(player.getHealth() <= 0){
            return 1;
        }

        if (opponent.getHealth() <= 0){
            return 2;
        }

        return 3;
    }

    public ArrayList<Items> getStoreitems() {
        return storeitems;
    }

    public void setStoreitems(ArrayList<Items> storeitems) {
        this.storeitems = storeitems;
    }

    public ArrayList<Weapons> getStoreweapons() {
        return storeweapons;
    }

    public void setStoreweapons(ArrayList<Weapons> storeweapons) {
        this.storeweapons = storeweapons;
    }

    public void itembuy(Items slectedpurchse) {

        System.out.println(player.itembuy(slectedpurchse));
    }

    public void itembuyw(Weapons slectedpurchsew) {

        System.out.println(player.itembuyw(slectedpurchsew));
    }


}
