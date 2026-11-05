//github
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

    @FXML
    public void initialize() {
    updatecharecterscreen();
    addlocation();

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
        }else if(selectedIndex == 8){
            tabPane.getSelectionModel().select(2);
            updateShopScreen();
        }

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
        locationsListView.getItems().add("fight 1");
        locationsListView.getItems().add("fight 2");
        locationsListView.getItems().add("fight 3");
        locationsListView.getItems().add("fight 4");
        locationsListView.getItems().add("fight 5");
        locationsListView.getItems().add("shop");


    }

    public void handleAttack(ActionEvent actionEvent) {
        Manager.attack(selectedEnemy);
        iswon(Manager.checkifwon(selectedEnemy));
        Manager.enemyattack(selectedEnemy);
        iswon(Manager.checkifwon(selectedEnemy));


    }
    public void iswon(int won){
        if (won==2){
            enemyHealthLabel.setText(Manager.getPlayer().getName() + " won");

            playerHealthLabel.setText(Manager.getPlayer().getName() + " won");
            playerDescriptionLabel.setText(Manager.getPlayer().getName() + " won");

            enemyname.setText(Manager.getPlayer().getName() + " won");
            enemyDescriptionLabel.setText(Manager.getPlayer().getName() + " won");
            int reward = 10
                    + (selectedEnemy.getHealth() * 2)
                    + (selectedEnemy.getAttack() * 2)
                    + selectedEnemy.getDefense()
                    + randnum(0, 10);

            Manager.getPlayer().addtuber(reward);

            System.out.println("You earned " + reward + " tubers!");
            System.out.println("Total tubers: " + Manager.getPlayer().getTubers());            System.out.println(Manager.getPlayer().getTubers());
            BTMbtn.setVisible(true);
        }else if(won==1){
            enemyHealthLabel.setText(selectedEnemy.getName() + " won");

            playerHealthLabel.setText(selectedEnemy.getName() + " won");
            playerDescriptionLabel.setText(selectedEnemy.getName() + " won");

            enemyname.setText(selectedEnemy.getName() + " won");
            enemyDescriptionLabel.setText(selectedEnemy.getName() + " won");
        }else if (won == 3){
            updateAttackscreen();
        }
    }


    public void updateAttackscreen(){
        enemyHealthLabel.setText(String.valueOf(selectedEnemy.getHealth()));

        playerHealthLabel.setText(String.valueOf(Manager.getPlayer().getHealth()));
        playerDescriptionLabel.setText("Attack: "+Manager.getPlayer().getAttack()+" Defense: "+Manager.getPlayer().getDefense());

        enemyname.setText(selectedEnemy.getName());
        enemyDescriptionLabel.setText("Attack: "+selectedEnemy.getAttack()+" Defense: "+selectedEnemy.getDefense());

        battleItemsListView.getItems().clear();
        for (IndividualItemsOwned items: Manager.getPlayer().getItems()){
            battleItemsListView.getItems().add(items.getall());
        }
        if (beenshop) {
            weaponslst.setText(Manager.getPlayer().getWeapon().getall());

        }
    }

    public void backToMap(ActionEvent actionEvent) {
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
    }

    public int randnum(int min, int max){
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        return randomInt;
    }




}




