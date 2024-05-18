package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import seng201.team0.GameManager;
import seng201.team0.services.TowerService;

import java.text.DecimalFormat;

/**
 *
 * This class is the controller for the between rounds screen
 *
 */

public class BetweenRoundsScreenController {
    public final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @FXML
    private Label betweenRoundsTitleLabel;
    @FXML
    private Label betweenRoundMoneyLabel;
    @FXML
    private Label betweenRoundDifficultyLabel;
    @FXML
    private Button startRoundButton;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label roundsLeftLabel;
    @FXML
    private Label cantAccessShopLabel;
    @FXML
    private Label cantStartRoundLabel;
    @FXML
    private TextFlow cantStartRoundTextFlow;
    @FXML
    private Button goToShopButton;
    @FXML
    private Button goToInventoryButton;
    @FXML
    private Button skipRoundButton;

    private GameManager roundGameManager;

    /**
     * Sole constructor that sets the GameManager instance
     */

    public BetweenRoundsScreenController(GameManager tempRoundGameManager) {
        roundGameManager = tempRoundGameManager;
    }

    /**
     * Initializer method that sets the Title Label
     */


    public void initialize() {
        betweenRoundsTitleLabel.setText("Weclome " + roundGameManager.getName() + ", Here are your Stats for Round " + roundGameManager.getCurrRound() + " of " + roundGameManager.getRounds() + "!");
        roundsLeftLabel.setText("Rounds Left: " + (roundGameManager.getRounds() - roundGameManager.getCurrRound() + 1));
        betweenRoundMoneyLabel.setText("Current Money: " + roundGameManager.getMoneyAmount());
        betweenRoundDifficultyLabel.setText("Current Difficulty: " + decimalFormat.format(roundGameManager.getDifficulty()));
        startRoundButton.setText("Start Round " + roundGameManager.getCurrRound() + "!");
        pointsLabel.setText("Current Points: " + decimalFormat.format(roundGameManager.getPoints()));
    }

    /**
     * Method that TODO
     */

    @FXML
    private void onConfirm() { // TODO wrap text
        if (roundGameManager.getRoundOneSelectedTowerList() == null) {
            cantStartRoundLabel.setText("Cannot start the round without any towers selected! Please go to the inventory and select your towers!"); }
        else {
        roundGameManager.incrementRound();
        roundGameManager.closeBetweenRoundScreen();
        }
    }

    @FXML
    private void onShop() { // TODO wrap text
        if (roundGameManager.getCurrRound() == 1) {
            cantAccessShopLabel.setText("Cannot access shop on round 1!");
        } else {
            roundGameManager.openShopScreen();
            // go to shop screen
        }

    }
    @FXML
    private void onInventory() {
        if (roundGameManager.getCurrRound() == 1) {
            roundGameManager.openRoundOneInventoryScreen();
        }
            else {
            roundGameManager.openInventoryScreen();
        }
    }
    @FXML
    private void onSkipRound() {
        roundGameManager.incrementRound();
        roundGameManager.closeGameScreen();
    }
}
