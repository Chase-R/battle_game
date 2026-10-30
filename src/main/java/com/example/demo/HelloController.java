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
    private Manager Manager =new Manager();

    public int setattack=10;
    public int setdefense = 10;
    public Enemy selectedEnemy;

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

    }

    @FXML
    public void onConfirmDestination(ActionEvent actionEvent) {
        int selectedIndex= locationsListView.getSelectionModel().getSelectedIndex();
        tabPane.getSelectionModel().select(1);
        selectedEnemy = Manager.getEnemies().get(selectedIndex);
        updateAttackscreen();
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
//yes

        updatecharecterscreen();
    }

    public void addDefense(ActionEvent actionEvent) {
        if(setattack > 0) {

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

    }

    public void handleAttack(ActionEvent actionEvent) {
        Manager.attack(selectedEnemy);
        updateAttackscreen();
    }


    public void updateAttackscreen(){
        enemyHealthLabel.setText(String.valueOf(selectedEnemy.getHealth()));

        playerHealthLabel.setText(String.valueOf(Manager.getPlayer().getHealth()));
        playerDescriptionLabel.setText("Attack: "+Manager.getPlayer().getAttack()+" Defense: "+Manager.getPlayer().getDefense());

        enemyname.setText(selectedEnemy.getName());
        enemyDescriptionLabel.setText("Attack: "+selectedEnemy.getAttack()+" Defense: "+selectedEnemy.getDefense());
    }
}
