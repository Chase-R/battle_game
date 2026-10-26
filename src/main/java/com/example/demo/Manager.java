package com.example.demo;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Weapons weapons;
    private Charecter player;



    public Manager(){
        enemies.add(new Enemy("enemy 1",randnum(1,5),randnum(1,5),randnum(10,20)));


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
}
