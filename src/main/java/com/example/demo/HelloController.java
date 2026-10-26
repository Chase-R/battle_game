
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
    public ListView attacksListView;
    public ListView weaponsListView;
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
    private Manager Manager =new Manager();

    public int setattack=10;
    public int setdefense = 10;

    @FXML
    public void initialize() {
    updateADlabel();
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




    }

    @FXML
    public void onConfirmAction(ActionEvent actionEvent) {

    }

    @FXML
    public void onConfirmPurchase(ActionEvent actionEvent) {

    }

    @FXML
    public void onConfirmDestination(ActionEvent actionEvent) {
        int selectedIndex= locationsListView.getSelectionModel().getSelectedIndex();
        tabPane.getSelectionModel().select(1);
        enemyHealthLabel.setText(String.valueOf(Manager.getEnemies().get(selectedIndex).getHealth()));

        playerHealthLabel.setText(String.valueOf(Manager.getPlayer().getHealth()));
        playerDescriptionLabel.setText("Attack: "+Manager.getPlayer().getAttack()+" Defense: "+Manager.getPlayer().getDefense());

        enemyname.setText(Manager.getEnemies().get(selectedIndex).getName());
        enemyDescriptionLabel.setText("Attack: "+Manager.getEnemies().get(selectedIndex).getAttack()+" Defense: "+Manager.getEnemies().get(selectedIndex).getDefense());
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
        if(setdefense > 0){
            setattack+=1;
            setdefense-=1;
        }


        updateADlabel();
    }

    public void addDefense(ActionEvent actionEvent) {
        if(setattack > 0) {

            setdefense += 1;
            setattack -= 1;
        }

        updateADlabel();

    }

    public void updateADlabel(){
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

    }
}
