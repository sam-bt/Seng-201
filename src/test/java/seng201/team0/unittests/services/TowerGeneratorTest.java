package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.services.TowerGenerator;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TowerGeneratorTest {
    @Test
    void heavyTowerHealthTest(){
        int generated = TowerGenerator.heavyTowerHealthGenerator();
        assertTrue(generated <= 300 && generated >= 200);
    }
    @Test
    void lightTowerHealthTest(){
        int generated = TowerGenerator.lightTowerHealthGenerator();
        assertTrue(generated <= 150 && generated >= 100);
    }
    @Test
    void heavyTowerFillAmountTest(){
        int generated = TowerGenerator.heavyTowerFillAmountGenerator();
        assertTrue(generated <= 60 && generated >= 40);
    }
    @Test
    void lightTowerFillAmountTest(){
        int generated = TowerGenerator.lightTowerFillAmountGenerator();
        assertTrue(generated <= 30 && generated >= 20);
    }
    @Test
    void heavyTowerReloadSpeedTest(){
        int generated = TowerGenerator.heavyTowerReloadSpeedGenerator();
        assertTrue(generated <= 6 && generated >= 4);
    }
    @Test
    void lightTowerReloadSpeedTest(){
        int generated = TowerGenerator.lightTowerReloadSpeedGenerator();
        assertTrue(generated <= 3 && generated >= 1);
    }
    @Test
    void heavyTowerPriceTest(){
        double generatedOne = TowerGenerator.heavyTowerPriceGenerator(1.0);
        assertTrue(generatedOne <= 500.0 && generatedOne >= 200.0);
        double generatedTwo = TowerGenerator.heavyTowerPriceGenerator(2.7);
        assertTrue(generatedTwo <= 1000.0 && generatedTwo >= 400.0);
    }
    @Test
    void lightTowerPriceTest(){
        double generatedOne = TowerGenerator.lightTowerPriceGenerator(1.0);
        assertTrue(generatedOne <= 265.0 && generatedOne >= 100.0);
        double generatedTwo = TowerGenerator.lightTowerPriceGenerator(3.5);
        assertTrue(generatedTwo <= 795.0 && generatedTwo >= 300.0);
    }
}
