
package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private manager Manager =new manager();

    @FXML
    public void initialize() {
        addchoice();

        // Initialize character choices here
        // Initialize attacks, weapons, and items here
        // Initialize shop inventory and map locations here

    }

    public void handleClick(ActionEvent actionEvent) {

        // Handle button clicks here

    }

    @FXML
    public void onConfirmCharacter(ActionEvent actionEvent) {
        int selectedIndex= characterImage.getSelectionModel().getSelectedIndex();

        Manager.setPlayer(Manager.getChoice().get(selectedIndex));



    }

    @FXML
    public void onConfirmAction(ActionEvent actionEvent) {

    }

    @FXML
    public void onConfirmPurchase(ActionEvent actionEvent) {

    }

    @FXML
    public void onConfirmDestination(ActionEvent actionEvent) {

    }

    public void addchoice(){
        characterImage.getItems().clear();
        for (charecter charecter : Manager.getChoice()){

            characterImage.getItems().add(charecter.getName() +" attack "+charecter.getAttack()+" defense "+ charecter.getDefense());

        }
    }
}
