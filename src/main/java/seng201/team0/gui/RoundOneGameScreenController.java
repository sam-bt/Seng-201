package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

public class RoundOneGameScreenController {
    @FXML private Button nextRoundButton;
    @FXML private ProgressBar cartOneProgressBar;
    @FXML private ProgressBar cartTwoProgressBar;
    @FXML private ProgressBar cartThreeProgressBar;
    @FXML private Label nameAndRoundLabel;
    @FXML private Label moneyLabel;
    @FXML private Label pointsLabel;
    @FXML private Label difficultyLabel;
    @FXML private Label trackLengthLabel;
    @FXML private Label cartOneName;
    @FXML private Label cartTwoName;
    @FXML private Label cartThreeName;
    @FXML private Label cartOneSpeed;
    @FXML private Label cartTwoSpeed;
    @FXML private Label cartThreeSpeed;
    @FXML private Label cartOneSize;
    @FXML private Label cartTwoSize;
    @FXML private Label cartThreeSize;
    @FXML private Label eventFrameLabel;
    @FXML private Label fillAmountLabel;
    @FXML private Label reloadSpeedLabel;
    @FXML private Label actionsLeftLabel;
    @FXML private Label fillCartWithTowerLabel;
    @FXML private Button towerOneButton;
    @FXML private Button towerTwoButton;
    @FXML private Button towerThreeButton;
    @FXML private Button confirmActionButton;
    @FXML private Button nextFrameButton;



    GameManager roundOneGameScreenManager;

    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    public void initialize() {
        cartOneProgressBar. setStyle("-fx-accent: black");
        cartTwoProgressBar. setStyle("-fx-accent: silver");
        cartThreeProgressBar. setStyle("-fx-accent: gold");
        cartOneProgressBar.setProgress(0.8);
    }
    @FXML
    private void onConfirmAction() {}
    @FXML
    private void onConfirmNext() {}
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.closeGameScreen();
    }
}
