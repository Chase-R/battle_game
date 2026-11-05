package com.example.demo;
//github
public class IndividualItemsOwned {

    private Items item;
    private int uses;

    public IndividualItemsOwned(Items item, int quant){
        this.item = item;
        this.uses = quant;
    }

    public Items getItem() {
        return item;
    }

    public int getUses() {
        return uses;
    }

    public void addUses(int i){
        uses += i;
    }

    public String getall(){
        return item.getall() + "uses" + uses;
    }
}
