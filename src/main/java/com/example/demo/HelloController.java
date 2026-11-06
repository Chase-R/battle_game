
package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class HelloController {

    // Character Selection
    public ListView characterImage;
    public Label characterDescription;
    public Button confirmCharacterButton;
    public Tab ctab;
    public Tab btab;
    public Tab stab;
    public Tab mtab;
    public Tab ltap;
    public Button weaponSpecialButton;
    int reward;
    // Battle: Player
    public ImageView playerImage;
    public Label playerHealthLabel;
    public Label playerDescriptionLabel;

    // Battle: Enemy
    public ImageView enemyImage;
    public Label enemyHealthLabel;
    public Label enemyDescriptionLabel;

    // Battle Lists
    public ListView battleItemsListView;
    public ListView battleLogListView;

    public Button confirmActionButton;

    // Shop
    public ImageView shopItemImage;
    public Label shopGoldLabel;
    public Label shopItemNameLabel;
    public Label shopItemDescriptionLabel;
    public Label shopItemPriceLabel;
    public ListView shopItemsListView;
    public ListView ownedItemsListView;
    public Button confirmPurchaseButton;

    // Map
    public ImageView worldMapImage;
    public ListView locationsListView;
    public ListView visitedLocationsListView;
    public Label locationDetailsLabel;
    public Button confirmDestinationButton;

    // General Status
    public Label gameStatusLabel;
    public Label attacklbl;
    public Label defenselbl;
    public TextField nametxt;
    public TabPane tabPane;
    public Label enemyname;
    public Button BTMbtn;
    public Label weaponslst;
    public ListView shopItemsListView1;
    public Button confirmPurchaseButton1;
    private Manager Manager =new Manager();

    public int setattack=10;
    public int setdefense = 0;
    public Enemy selectedEnemy;
    public boolean beenshop = false;

    public Weapons selectedweapon;

    @FXML
    public void initialize() {
    updatecharecterscreen();
    addlocation();


        tabPane.getTabs().remove(ltap);
        // Initialize character choices here
        // Initialize attacks, weapons, and items here
        // Initialize shop inventory and map locations here

    }

    public void handleClick(ActionEvent actionEvent) {

        // Handle button clicks here

    }

    @FXML
    public void onConfirmCharacter(ActionEvent actionEvent) {
       Manager.setPlayer(new Charecter(nametxt.getText(), setattack, setdefense));

        System.out.println(Manager.getPlayer().getName());
        System.out.println(Manager.getPlayer().getAttack());
        System.out.println(Manager.getPlayer().getDefense());
        tabPane.getSelectionModel().select(3);





    }

    @FXML
    public void onConfirmAction(ActionEvent actionEvent) {

    }

    @FXML
    public void onConfirmPurchase(ActionEvent actionEvent) {
        int selectedIndex= shopItemsListView.getSelectionModel().getSelectedIndex();

        Items slectedpurchse = Manager.getStoreitems().get(selectedIndex);
        Manager.itembuy(slectedpurchse);
        updateShopScreen();

    }

    @FXML
    public void onConfirmDestination(ActionEvent actionEvent) {
        int selectedIndex= locationsListView.getSelectionModel().getSelectedIndex();
        if(selectedIndex < 8){
            tabPane.getSelectionModel().select(1);
            selectedEnemy = Manager.getEnemies().get(selectedIndex);
            updateAttackscreen();
            reward =  selectedEnemy.getHealth()
                    + selectedEnemy.getAttack()
                    + selectedEnemy.getDefense()
                    + randnum(0, 10);
            Manager.resetSpecial();
            battleLogListView.getItems().clear();

            addBattleLog("⚔️ Battle started!");
            addBattleLog("Your opponent is " + selectedEnemy.getName() + ".");
            weaponSpecialButton.setDisable(false);

            Manager.useArrow(selectedEnemy);

        }else if(selectedIndex == 8){
            tabPane.getSelectionModel().select(2);
            updateShopScreen();
        }
        if (Manager.useArrow(selectedEnemy)) {
            addBattleLog("🏹 You used an Arrow!");
            addBattleLog("Your Arrow dealt 5 damage!");
        }

        updateAttackscreen();

        iswon(Manager.checkifwon(selectedEnemy));

    }

//    public void addchoice(){
//        characterImage.getItems().clear();
//        for (Charecter charecter : Manager.getChoice()){
//
//            characterImage.getItems().add(charecter.getName() +" attack "+charecter.getAttack()+" defense "+ charecter.getDefense());
//
//        }
//    }

    public void AddAttack(ActionEvent actionEvent) {
        if(setattack >=5 && setdefense >1){
            setattack+=1;
            setdefense-=1;
        }
//yes

        updatecharecterscreen();
    }

    public void addDefense(ActionEvent actionEvent) {
        if(setattack > 5) {

            setdefense += 1;
            setattack -= 1;
        }

        updatecharecterscreen();

    }

    public void updatecharecterscreen(){
        attacklbl.setText("Attack = " + setattack);
        defenselbl.setText("Defense = " + setdefense);

    }

    public void addlocation(){
        locationsListView.getItems().clear();;
        locationsListView.getItems().add("Tunnel Scout");
        locationsListView.getItems().add("Tuber Thief");
        locationsListView.getItems().add("Colony Defender");
        locationsListView.getItems().add("Incisor Warrior");
        locationsListView.getItems().add("Tunnel Brute");
        locationsListView.getItems().add("Royal Guard");
        locationsListView.getItems().add("Queen's Champion");
        locationsListView.getItems().add("The Queen");
        locationsListView.getItems().add("shop");


    }

    public void handleAttack(ActionEvent actionEvent) {
        int damage = Manager.attack(selectedEnemy);
        addBattleLog("You attacked " + selectedEnemy.getName()
                + " for " + damage + " damage!");
        iswon(Manager.checkifwon(selectedEnemy));
        int result = Manager.checkifwon(selectedEnemy);
        if(result == 3){
            int edamage = Manager.enemyattack(selectedEnemy);

            addBattleLog(selectedEnemy.getName()
                    + " attacked you for " + edamage + " damage!");
            iswon(Manager.checkifwon(selectedEnemy));
        }else {
            iswon(result);
        }



    }
    public void iswon(int won){
        if (won==2){
            enemyHealthLabel.setText(Manager.getPlayer().getName() + " won");

            playerHealthLabel.setText(Manager.getPlayer().getName() + " won");
            playerDescriptionLabel.setText(Manager.getPlayer().getName() + " won");

            enemyname.setText(Manager.getPlayer().getName() + " won");
            enemyDescriptionLabel.setText(Manager.getPlayer().getName() + " won");


            Manager.getPlayer().addtuber(reward);

            System.out.println("You earned " + reward + " tubers!");
            System.out.println("Total tubers: " + Manager.getPlayer().getTubers());
            System.out.println(Manager.getPlayer().getTubers());
            BTMbtn.setVisible(true);
            addBattleLog(" You defeated " + selectedEnemy.getName() + "!");
        }else if(won==1){
            enemyHealthLabel.setText(selectedEnemy.getName() + " won");

            playerHealthLabel.setText(selectedEnemy.getName() + " won");
            playerDescriptionLabel.setText(selectedEnemy.getName() + " won");

            enemyname.setText(selectedEnemy.getName() + " won");
            enemyDescriptionLabel.setText(selectedEnemy.getName() + " won");
            tabPane.getTabs().clear();
            tabPane.getTabs().add(ltap);
            tabPane.getSelectionModel().select(ltap);
        }else if (won == 3){
            updateAttackscreen();
        }
    }


    public void updateAttackscreen(){
        // Health
        enemyHealthLabel.setText(String.valueOf(selectedEnemy.getHealth()));
        playerHealthLabel.setText(String.valueOf(Manager.getPlayer().getHealth()));

        playerDescriptionLabel.setText(
                " Attack: " + Manager.getPlayer().getAttack()
                        + " Defense: " + Manager.getPlayer().getDefense()
                        + " Speed: " + Manager.getPlayer().getSpeed()
                        + " Critical Chance: " + (Manager.getPlayer().getCriticalchance() * 100) + "%"
        );

        enemyname.setText(selectedEnemy.getName());

        enemyDescriptionLabel.setText(
                " Attack: " + selectedEnemy.getAttack()
                        + " Defense: " + selectedEnemy.getDefense()
                        + " Speed: " + selectedEnemy.getSpeed()
                        + " Critical Chance: " + (selectedEnemy.getCriticalchance() * 100) + "%"
        );

        if (Manager.getPlayer().getWeapon() != null) {
            playerDescriptionLabel.setText(
                    playerDescriptionLabel.getText()
                            + " Weapon: " + Manager.getPlayer().getWeapon().getName()
                            + " Weapon Damage: " + Manager.getPlayer().getWeapon().getDamage()
                            + " Weapon Special" + Manager.getPlayer().getWeapon().getSpecial()
            );
        } else {
            playerDescriptionLabel.setText(
                    playerDescriptionLabel.getText() + "Weapon: None"
            );
        }

        battleItemsListView.getItems().clear();

        for (IndividualItemsOwned items : Manager.getPlayer().getItems()) {
            battleItemsListView.getItems().add(items.getall());
        }


    }

    public void backToMap(ActionEvent actionEvent) {
        visitedLocationsListView.getItems().clear();

        for (IndividualItemsOwned items : Manager.getPlayer().getItems()) {
            visitedLocationsListView.getItems().add(items.getall());
        }
        tabPane.getSelectionModel().select(3);
        BTMbtn.setVisible(false);
        updateAttackscreen();

    }

    public void updateShopScreen(){
        beenshop = true;
        shopItemsListView.getItems().clear();
        shopItemsListView1.getItems().clear();
        ownedItemsListView.getItems().clear();

        shopGoldLabel.setText("tubers = "+ Manager.getPlayer().getTubers());
        for (Items items: Manager.getStoreitems()){
            shopItemsListView.getItems().add(items.getwithpiceall());
        }
        for (Weapons weapons : Manager.getStoreweapons()){
            shopItemsListView1.getItems().add(weapons.getallprice());

        }
        for (IndividualItemsOwned items: Manager.getPlayer().getItems()){
            ownedItemsListView.getItems().add(items.getall());
        }


    }

    public void onConfirmPurchasew(ActionEvent actionEvent) {
        int selectedIndex= shopItemsListView1.getSelectionModel().getSelectedIndex();

        Weapons slectedpurchse = Manager.getStoreweapons().get(selectedIndex);
        Manager.itembuyw(slectedpurchse);
        updateShopScreen();
    }

    public int randnum(int min, int max){
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        return randomInt;
    }


    public void special(ActionEvent actionEvent) {
        String result = Manager.useWeaponSpecial(selectedEnemy);

        addBattleLog(result);

        enemyHealthLabel.setText(
                String.valueOf(selectedEnemy.getHealth())
        );

        iswon(Manager.checkifwon(selectedEnemy));
    }

    private void addBattleLog(String message) {
        battleLogListView.getItems().add(message);

        // Automatically scroll to the newest message
        battleLogListView.scrollTo(
                battleLogListView.getItems().size() - 1
        );
    }
}




