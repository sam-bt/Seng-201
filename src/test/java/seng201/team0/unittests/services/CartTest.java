package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Cart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    Cart cart;
    @BeforeEach
    void setupTest(){
        cart = new Cart("TestCart", "Gold", 1.2, 100);
    }
    @Test
    void increaseDistanceTest(){
        for (int i = 0; i <= 20; i++) {
            cart.increaseDistance();
        }
        assertEquals(cart.getDistanceTravelled(), 100);
        assertEquals(cart.isCartSuccess(), false);
        assertEquals(cart.isEndReached(), true);
    }
    @Test
    void distanceResetTest(){
        for (int i = 0; i <= 20; i++) {
            cart.increaseDistance();
        }
        assertEquals(cart.getDistanceTravelled(), 100);
        assertEquals(cart.isCartSuccess(), false);
        assertEquals(cart.isEndReached(), true);
        cart.resetDistance();
        assertEquals(cart.getDistanceTravelled(), 0);
        assertEquals(cart.isEndReached(), false);
    }
    @Test
    void increaseFillAmountTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
    }
    @Test
    void decreaseFillAmountTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
        cart.increaseFillAmount(-20);
        assertEquals(cart.getCurrentFillDisplay(), 5);
    }
    @Test
    void fullCartTest(){
        cart.increaseFillAmount(1000);
        assertEquals(cart.getCurrentFillDisplay(), cart.getCapacity());
        assertEquals(cart.isFull(),true);
    }
    @Test
    void emptyCartTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
        cart.increaseFillAmount(-30);
        assertEquals(cart.getCurrentFillDisplay(), 0);
        assertEquals(cart.getCurrentFillAmount(), 0.0);
    }
}
