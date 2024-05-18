package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundOneInventoryService;
import seng201.team0.services.TowerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundOneInventoryScreenController {
    @FXML Button heavyCoalButton;
    @FXML Button lightCoalButton;
    @FXML Button heavyIronButton;
    @FXML Button lightIronButton;
    @FXML Button heavyGoldButton;
    @FXML Button lightGoldButton;
    @FXML Button selectedTowerButtonOne;
    @FXML Button selectedTowerButtonTwo;
    @FXML Button selectedTowerButtonThree;
    @FXML Label towerNameLabel;
    @FXML Label towerHealthLabel;
    @FXML Label towerTypeLabel;
    @FXML Label towerReloadLabel;
    @FXML Label selectAllTowersLabel;
    private final Tower[] selectedTowers = new Tower[3];
    private int selectedTowerIndex = -1;

    GameManager roundOneInventoryScreenGameManager;
    List<Tower> towers;

    RoundOneInventoryScreenController(GameManager tempRoundOneInventoryScreenGameManager){
        roundOneInventoryScreenGameManager = tempRoundOneInventoryScreenGameManager;
    }
    public void initialize() {
        List<Button> towerButtons = List.of(heavyCoalButton,lightCoalButton,heavyIronButton,lightIronButton,heavyGoldButton,lightGoldButton);
        List<Button> selectedTowerButtons = List.of(selectedTowerButtonOne,selectedTowerButtonTwo,selectedTowerButtonThree);
        RoundOneInventoryService roundOneInventory = new RoundOneInventoryService(roundOneInventoryScreenGameManager);
        towers = roundOneInventory.getTowerList();
        Tower[] savedTowers = roundOneInventoryScreenGameManager.getRoundOneTowerList();

        // Sets the action to display the selected towers information when it is clicked on, and to show that it is selected
        for (int i = 0; i < towerButtons.size(); i++) {
            int finalI = i;
            towerButtons.get(i).setOnAction(event -> {
                updateDisplayedStats(towers.get(finalI));
                selectedTowerIndex = finalI;
                towerButtons.forEach(button -> {
                    if (button == towerButtons.get(finalI)) {
                        button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                    } else {
                        button.setStyle("");
                    }
                });
            });
        }
        // Sets the action to add the selected tower to the selected tower slot (doesn't allow for repeats)
        for (int i = 0; i < selectedTowerButtons.size(); i++) {
            int finalI = i;
            selectedTowerButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex != -1) {
                    if (!TowerService.isTowerAlreadySelected(selectedTowers,savedTowers, towers.get(selectedTowerIndex))) {
                    selectedTowerButtons.get(finalI).setText(towers.get(selectedTowerIndex).getTowerName());
                    selectedTowers[finalI] = towers.get(selectedTowerIndex); }
                }
            });
        }
        List<Integer> towerListIndices = roundOneInventoryScreenGameManager.getRoundOneTowerListIndices();
        if (!towerListIndices.isEmpty()) {
            for (int selectedTowerIndex: towerListIndices) {
            selectedTowerButtons.get(selectedTowerIndex).setText(savedTowers[selectedTowerIndex].getTowerName());
            selectedTowers[selectedTowerIndex] = savedTowers[selectedTowerIndex];
            }
        }

    }
    private void updateDisplayedStats(Tower tower) {
        towerNameLabel.setText("Name: "+tower.getTowerName());
        towerHealthLabel.setText("Health: "+tower.getHealth());
        towerTypeLabel.setText("Resource Fill Type: "+tower.getFillType());
        towerReloadLabel.setText("Reload Speed: "+tower.getReloadSpeed());

    }
    @FXML
    private void onConfirm() {
        if (!(roundOneInventoryScreenGameManager.getRoundOneTowerList() == null) || TowerService.areAllRoundOneTowersTypesSelected(selectedTowers) || TowerService.areAllTowersSelected(selectedTowers)) {
        roundOneInventoryScreenGameManager.setRoundOneTowerList(selectedTowers);
        roundOneInventoryScreenGameManager.closeRoundOneInventoryScreen(); }
        else { selectAllTowersLabel.setStyle("-fx-text-fill: red");}
    }
}