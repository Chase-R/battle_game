package com.example.demo;

import java.util.ArrayList;

public class manager {

    private ArrayList<enemy> enemies = new ArrayList<>();
    private weapons weapons;
    private charecter player;
    private ArrayList<charecter> choice = new ArrayList<>();



    public manager(){
        choice.add(new charecter("bob",10,10 ));
        choice.add(new charecter("stuart",15,5 ));
        choice.add(new charecter("kevin",5,15 ));


    }

    public ArrayList<charecter> getChoice() {
        return choice;
    }

    public charecter getPlayer() {
        System.out.println(player.getName());
        return player;
    }

    public ArrayList<enemy> getEnemies() {
        return enemies;
    }

    public weapons getWeapons() {
        return weapons;
    }

    public void setPlayer(charecter player) {
        this.player = player;
        System.out.println(player.getName());

    }
}
