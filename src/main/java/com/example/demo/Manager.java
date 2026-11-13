package com.example.demo;
//https://obsproject.com/

import java.util.ArrayList;

public class Manager {

    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Weapons weapons;
    private Charecter player;
    private ArrayList<Weapons> storeweapons = new ArrayList<>();
    private ArrayList<Items> storeitems = new ArrayList<>();
    private boolean specialUsed = false;

//,


    public Manager(){
        //chat creted the itms and enemys
        enemies.add(new Enemy("Tunnel Scout", randnum(3,4), 2, randnum(10,14), randnum(2,5)));
        enemies.add(new Enemy("Tuber Thief", randnum(4,5), 3, randnum(14,18), randnum(3,6)));
        enemies.add(new Enemy("Colony Defender", randnum(5,6), 4, randnum(19,25), randnum(3,7)));
        enemies.add(new Enemy("Incisor Warrior", randnum(7,8), 5, randnum(25,31), randnum(5,8)));
        enemies.add(new Enemy("Tunnel Brute", randnum(9,10), 7, randnum(34,42), randnum(1,4)));
        enemies.add(new Enemy("Royal Guard", randnum(12,13), 9, randnum(45,55), randnum(6,9)));
        enemies.add(new Enemy("Queen's Champion", randnum(15,16), 12, randnum(58,72), randnum(7,10)));
        enemies.add(new Enemy("The Queen", randnum(20,22), 16, randnum(90,110), randnum(8,10)));
        storeitems.add(new Items("Small Tuber", 0,  randnum(13,17), randnum(4,6),0));
        storeitems.add(new Items("Sharpened Incisors", randnum(4,6), randnum(23,27), 0,0));
        storeitems.add(new Items("Thick Hide", 0,  randnum(23,27), 0,0));
        storeitems.add(new Items("Juicy Root", 0,  randnum(37,43), randnum(9,11),0));
        storeitems.add(new Items("Battle Tuber", randnum(4,6),  randnum(60,70), 0,0));
        storeitems.add(new Items("Golden Tuber", 0, randnum(70,80), randnum(18,22),0));
        storeitems.add(new Items("Royal Warpaint", randnum(9,11),  randnum(95,105), 0,0));
        storeitems.add(new Items("Queen's Nectar", 0,  randnum(120,130), randnum(32,38),0));
        storeitems.add(new Items("Small Magic Crystal", 0, randnum(8,12), 0, 3));
        storeitems.add(new Items("Charged Crystal", 0, randnum(18,22), 0, 5));
        storeitems.add(new Items("Ancient Crystal", 0, randnum(30,40), 0, 8));
        storeitems.add(new Items("Royal Magic Core", 0, randnum(50,60), 0, 12));
        storeitems.add(new Items("Queen's Heartstone", 0, randnum(75,85), 0, 15));
        storeweapons.add(new Weapons("Pebble", randnum(13,17), randnum(2,4)));
        storeweapons.add(new Weapons("Sharp Incisor", randnum(27,33), randnum(4,6)));
        storeweapons.add(new Weapons("Bone Dagger", randnum(45,55), randnum(6,8)));
        storeweapons.add(new Weapons("Tuber Club", randnum(70,80), randnum(9,11)));
        storeweapons.add(new Weapons("Crystal Spear", randnum(105,115), randnum(12,14)));
        storeweapons.add(new Weapons("Royal Fang", randnum(150,170), randnum(16,18)));
        storeweapons.add(new Weapons("Queen's Scepter", randnum(240,260), randnum(21,23)));
        storeitems.add(new Items("Arrow", 5,  randnum(5,10), 0,0));
        for (Enemy e : enemies) {
            enemyShop(e);
        }

    }
    public void resetSpecial() {
        specialUsed = false;
    }
    public String useWeaponSpecial(Enemy opponent) {

        if (specialUsed) {
            return "You already used your weapon special this battle!";
        }

        if (player.getWeapon() == null) {
            return "You need a weapon to use a special!";
        }

        specialUsed = true;

        String special = player.getWeapon().getSpecial();

        int damage = 0;

        if (special.equals("fire")) {
            damage = 15;
            opponent.takeDamage(Math.min(damage, opponent.getHealth()));
            return "🔥 FIRE SPECIAL! You dealt 15 bonus damage!";

        } else if (special.equals("lightning")) {
            damage = 25;
            opponent.takeDamage(Math.min(damage, opponent.getHealth()));
            return "⚡ LIGHTNING SPECIAL! You dealt 25 bonus damage!";

        } else if (special.equals("ice")) {
            damage = 10;
            opponent.takeDamage(Math.min(damage, opponent.getHealth()));
            return "❄️ ICE SPECIAL! You dealt 10 damage!";
        }

        return "No special available!";
    }
    //the attack and enemy attack functins equation came from chat with prompting from what i wanted

    public String magicAttack(Enemy opponent, int mp){
        player.usemp(mp);
        int damage = Math.min(mp*4, opponent.getHealth());
        opponent.takeDamage(damage);
        return "Magic blast! You spent " + mp + " MP and dealt " + damage + " damage!";
    }

    public String magicHeal(int mp){
        player.usemp(mp);
        player.heal(mp*4);
        return "You spent " + mp + " MP and healed " + (mp * 4) + " health!";
    }

    public String magicShield(int mp){
        player.usemp(mp);
        player.usesheils(mp*2);
        return "You spent " + mp + " MP and gained a " + (mp * 2) + " point shield!";
    }

    public int attack(Enemy opponent) {
        int weaponDamage = 0;

        if (player.getWeapon() != null) {
            weaponDamage = player.getWeapon().getDamage();
        }

        double attackMultiplier = 1 + (0.03 * player.getSpeed());
        double defenseMultiplier = 1 + (0.05 * opponent.getDefense());

        int damage = (int) ((player.getAttack() + weaponDamage)
                * attackMultiplier / defenseMultiplier);

        double chance = Math.min(0.60,
                player.getCriticalchance() + (0.02 * player.getSpeed()));

        boolean critical = Math.random() < chance;

        if (critical) {
            damage = (int) (damage * 1.75);
        }

        damage = Math.max(1, Math.min(damage, opponent.getHealth()));

        opponent.takeDamage(damage);

        System.out.println(critical ? "CRITICAL HIT!" : "Normal hit!");
        System.out.println("Damage: " + damage);
        return damage;
    }
    public String enemyattack(Enemy opponent) {
        opponent.gainmp(2);
        int mp = opponent.getMagicp();
        if(mp>=2 && mp*3>=player.getHealth()+player.getSheild()){
            opponent.useMp(mp);
            player.takedamage(mp*2);
            return opponent.getName() + " unleashed a magic blast for " + (mp * 3) + " damage!";



        }
        if (opponent.getHealth() < opponent.getMaxHealth() * 0.4 && mp >= 3) {

            opponent.useMp(mp);
            opponent.heal(mp * 3);
            return opponent.getName() + " used magic heal and recovered " + (mp*3) + " health!";
        }
        if(mp>=6){
            opponent.useMp(mp);
            player.takedamage(mp*3);
            return opponent.getName() + " cast a magic blast for " + (mp * 3) + " damage!";

        }
        String itemMsg = enemyUseItem(opponent);
        String prefix = null;
        if(itemMsg != null){
            prefix = itemMsg + " " ;
        }



        double attackMultiplier = 1 + (0.03 * opponent.getSpeed());
        double defenseMultiplier = 1 + (0.05 * player.getDefense());

        int damage = (int) (opponent.getAttack()
                * attackMultiplier / defenseMultiplier);

        double chance = Math.min(0.60,
                opponent.getCriticalchance() + (0.02 * opponent.getSpeed()));

        boolean critical = Math.random() < chance;

        if (critical) {
            damage = (int) (damage * 1.75);
        }

        damage = Math.max(1, Math.min(damage, player.getHealth()));

        player.takedamage(damage);

        return prefix + opponent.getName() + " attacked you for " + damage + " damage!";
    }


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
    public boolean useArrow(Enemy selectedenemy) {

        for (Items item : storeitems) {
            if (item.getName().equals("Arrow")) {

                if (player.arrowUse(item)) {
                    int damage = Math.min(5, selectedenemy.getHealth());

                    selectedenemy.takeDamage(damage);

                    return true;
                }
            }
        }

        return false;
    }

    public boolean useItem(Items selectedItem, Enemy selectedEnemy){

        if (selectedItem.getHeal() > 0 || selectedItem.getMagic() > 0) {
            return player.itemUse(selectedItem);
        }

        IndividualItemsOwned temp = player.ownItem(selectedItem);

        if (temp != null && temp.getUses() > 0) {

            selectedEnemy.takeDamage(
                    Math.min(selectedItem.getAttack(), selectedEnemy.getHealth())
            );

            temp.Use();

            return true;
        }

        return false;
    }
    public String unlockItems(int enemyIndex) {
        if (enemyIndex == 1) {
            storeitems.add(new Items("Spiced Tuber", 0, randnum(30, 35), randnum(14, 16), 0));

            player.levelup();
            return "You leveled up! stats increased are: health + 10 " + "attack + 1 " + "defense + 1 " + "Magic points + 5 " + "Max Magic points +=5 ";
        }
        if (enemyIndex == 3) {
            storeitems.add(new Items("Rat Tonic", 0, randnum(55, 65), randnum(25, 30), 4));
            return "You leveled up! stats increased are: health + 10 " + "attack + 1 " + "defense + 1 " + "Magic points + 5 " + "Max Magic points +=5 ";
        }
        if (enemyIndex == 5){
            storeitems.add(new Items("Grand Feast", 0, randnum(100,110), randnum(50,60), 8));
            return "You leveled up! stats increased are: health + 10 " + "attack + 1 " + "defense + 1 " + "Magic points + 5 " + "Max Magic points +=5 ";
        }
        if (enemyIndex == 6){
            storeweapons.add(new Weapons("Champion's Claw", randnum(200,220), randnum(18,20)));
            return "You leveled up! stats increased are: health + 10 " + "attack + 1 " + "defense + 1 " + "Magic points + 5 " + "Max Magic points +=5 ";
        }
        return null;

    }
    private void enemyShop(Enemy enemy) {
        int budget = enemy.getHealth() * 2;
        int bought = 0;
        for (int i = storeitems.size() - 1; i >= 0 && bought < 3; i--) {
            Items item = storeitems.get(i);
            boolean useful = item.getHeal() > 0 || item.getAttack() > 0;
            if (useful && !item.getName().equals("Arrow") && item.getPrice() <= budget) {
                enemy.getItems().add(new IndividualItemsOwned(item, 1));
                budget -= item.getPrice();
                bought++;
            }
        }
    }

    private String enemyUseItem(Enemy enemy) {
        for (IndividualItemsOwned owned : enemy.getItems()) {
            Items item = owned.getItem();

            if (item.getHeal() > 0 && enemy.getHealth() < enemy.getMaxHealth() * 0.5) {

                enemy.heal(item.getHeal());
                owned.Use();
                return enemy.getName() + " used " + item.getName() + " and now has" + (enemy.getHealth()) + " health!";
            }
            if (item.getHeal() == 0 && item.getAttack() > 0 && Math.random() < 0.3) {
                player.takedamage(item.getAttack());
                owned.Use();
                return enemy.getName() + " threw " + item.getName() + " for " + item.getAttack() + " damage!";
            }
        }
        return null;
    }


}
