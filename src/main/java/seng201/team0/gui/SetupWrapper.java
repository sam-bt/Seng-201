package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import seng201.team0.GameManager;

import java.io.IOException;

public class SetupWrapper {
    @FXML
    private BorderPane borderpane;

    private Stage stage;


    public void init(Stage stage) {
        this.stage = stage;
        new GameManager(this::launchSetupScreen, this::launchBetweenRoundsScreen, this::launchGameScreen,this::launchRoundOneScreen,this::launchErrorScreen,this::launchFinishedScreen,this::clearPane);
    }

    public void clearPane() { // TODO - change/delete as now not needed
        borderpane.getChildren().removeAll(borderpane.getChildren());
    }

    public void launchSetupScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new SetupScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Setup Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchBetweenRoundsScreen(GameManager setupGameManager) {
        try {
            FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/between_rounds_screen.fxml"));
            mainScreenLoader.setControllerFactory(param -> new BetweenRoundsScreenController(setupGameManager));
            Parent setupParent  = mainScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round Setup Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchGameScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/game_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new GameScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Game Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchRoundOneScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/round_one_setup_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new SetupScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round 1 Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchErrorScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/error_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new InvalidNameScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Error Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchFinishedScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/finished_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new FinishedScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Finish Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
