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
        new GameManager(this::launchSetupScreen, this::launchBetweenRoundsScreen, this::launchGameScreen,this::launchInventoryScreen,this::launchShopScreen,this::launchRoundOneInventoryScreen,this::launchRoundOneGameScreen,this::launchErrorScreen,this::launchFinishedScreen,this::launchLoseScreen,this::clearPane);
    }

    public void clearPane() { // TODO - change/delete as now not needed
        borderpane.getChildren().removeAll(borderpane.getChildren());
    }

    public void launchSetupScreen(GameManager setupGameManager) { //TODO change the name of these managers
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
            stage.setTitle("Between Rounds Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchGameScreen(GameManager setupGameManager) {
        try {
            FXMLLoader gameScreenLoader = new FXMLLoader(getClass().getResource("/fxml/game_screen.fxml"));
            gameScreenLoader.setControllerFactory(param -> new GameScreenController(setupGameManager));
            Parent setupParent  = gameScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Game Screen"); // TODO make match the round number
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchRoundOneInventoryScreen(GameManager setupGameManager) {
        try {
            FXMLLoader roundOneInventoryScreenLoader = new FXMLLoader(getClass().getResource("/fxml/round_one_inventory_screen.fxml"));
            roundOneInventoryScreenLoader.setControllerFactory(param -> new RoundOneInventoryScreenController(setupGameManager));
            Parent setupParent  = roundOneInventoryScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round 1 Inventory Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchShopScreen(GameManager setupGameManager) {
        try {
            FXMLLoader shopScreenLoader = new FXMLLoader(getClass().getResource("/fxml/shop_screen.fxml"));
            shopScreenLoader.setControllerFactory(param -> new ShopScreenController(setupGameManager));
            Parent setupParent  = shopScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Shop Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchInventoryScreen(GameManager setupGameManager) {
        try {
            FXMLLoader inventoryScreenLoader = new FXMLLoader(getClass().getResource("/fxml/inventory_screen.fxml"));
            inventoryScreenLoader.setControllerFactory(param -> new InventoryScreenController(setupGameManager));
            Parent setupParent  = inventoryScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round Inventory Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchRoundOneGameScreen(GameManager setupGameManager) {
        try {
            FXMLLoader roundOneGameScreenLoader = new FXMLLoader(getClass().getResource("/fxml/round_one_game_screen.fxml"));
            roundOneGameScreenLoader.setControllerFactory(param -> new RoundOneGameScreenController(setupGameManager));
            Parent setupParent  = roundOneGameScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round 1 Game Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchErrorScreen(GameManager setupGameManager) {
        try {
            FXMLLoader errorScreenLoader = new FXMLLoader(getClass().getResource("/fxml/error_screen.fxml"));
            errorScreenLoader.setControllerFactory(param -> new InvalidNameScreenController(setupGameManager));
            Parent setupParent  = errorScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Error Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchFinishedScreen(GameManager setupGameManager) {
        try {
            FXMLLoader finishedScreenLoader = new FXMLLoader(getClass().getResource("/fxml/winning_screen.fxml"));
            finishedScreenLoader.setControllerFactory(param -> new WinningScreenController(setupGameManager));
            Parent setupParent  = finishedScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Winning Screen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchLoseScreen(GameManager setupGameManager) {
        try {
            FXMLLoader losingScreenLoader = new FXMLLoader(getClass().getResource("/fxml/losing_screen.fxml"));
            losingScreenLoader.setControllerFactory(param -> new LosingScreenController(setupGameManager));
            Parent setupParent  = losingScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Losing Screen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
