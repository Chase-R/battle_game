package com.example.demo;

import java.util.ArrayList;

public class manager {

    private ArrayList<enemy> enemies = new ArrayList<>();

    private charecter player;



    public manager(){

    }


    public charecter getPlayer() {
        return player;
    }

    public ArrayList<enemy> getEnemies() {
        return enemies;
    }


}
