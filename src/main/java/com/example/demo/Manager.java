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
        enemies.add(new Enemy("enemy 1",randnum(1,5),randnum(1,5),randnum(10,20)));
        storeitems.add(new Items("item 1",randnum(1,5),randnum(1,5),randnum(1,5),randnum(1,5)));
        storeitems.add(new Items("item 1",randnum(10,15),randnum(10,15),randnum(10,15),randnum(10,15)));
        storeitems.add(new Items("item 1",randnum(20,25),randnum(20,25),randnum(20,25),randnum(20,25)));
        storeweapons.add(new Weapons("weapon 1",randnum(1,5),randnum(1,5)));
        storeweapons.add(new Weapons("weapon 1",randnum(10,15),randnum(10,15)));
        storeweapons.add(new Weapons("weapon 1",randnum(20,25),randnum(20,25)));



    }

    public void enemyattack(Enemy opponent){
        for (Enemy enemy:enemies){
            if (enemy == opponent){
                if(opponent.getAttack()- player.getDefense()>0){
                    player.takedamage(opponent.getAttack()- player.getDefense());
                }
            }
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
}
