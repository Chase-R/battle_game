package com.example.demo;

import java.util.ArrayList;

public class store {
    private ArrayList<items> options = new ArrayList<>();

    public store(){

    }

    public void addItem(items item){
        options.add(item);
    }


    public ArrayList<items> getOptions() {
        return options;
    }


}
