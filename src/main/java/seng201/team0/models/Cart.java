package seng201.team0.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Cart {
    private final String cartName;
    private final int capacity;
    private final String resourceType;
    private final int speed;
    private double distanceTravelled;
    private boolean endReached;
    private double currentFillAmount;
    private boolean full;
    private boolean cartSuccess;
    private int currentFillDisplay;
    private final int trackLength;

    public Cart(String cartName, String resourceType, double difficulty, int trackLength) {
        this.cartName = cartName;
        this.resourceType = resourceType;
        endReached = false;
        full = false;
        cartSuccess = false;
        currentFillDisplay = 0;
        this.trackLength = trackLength;
        Random rng = new Random();
        List<Integer> speedList = Arrays.asList(5, 8, 8, 10, 10, 15);
        int randomSpeed = rng.nextInt(6);
        speed = speedList.get(randomSpeed);
        List<Integer> capacityList = Arrays.asList(50 * (int) difficulty, 60 * (int) difficulty, 50 * (int) difficulty, 60 * (int) difficulty, 75 * (int) difficulty);
        int randomCapacity = rng.nextInt(3);
        if (Objects.equals(cartName, "Bonus")) {
            capacity = 100 + ((int) difficulty * 50);
        } else {
            capacity = capacityList.get(randomCapacity);
        }
    }

    public void resetDistance() {
        distanceTravelled = 0;
        endReached = false;
    }

    public void increaseDistance() {
        double newDistanceTravelled = distanceTravelled + (double) speed / trackLength;
        if (distanceTravelled * 100 >= trackLength) {
            distanceTravelled = trackLength;
            endReached = true;
            if (!full) {
                cartSuccess = false;
            }
        } else {
            distanceTravelled = newDistanceTravelled;
        }
    }

    public String getCartName() {
        return cartName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getCurrentFillAmount() {
        return currentFillAmount;
    }

    public int getCurrentFillDisplay() {
        return currentFillDisplay;
    }

    public void increaseFillAmount(int towerFillAmount) {
        double newFillAmount = currentFillAmount + (double) towerFillAmount / capacity;
        if (newFillAmount >= 1) {
            currentFillAmount = 1;
            currentFillDisplay = capacity;
            full = true;
            if (!endReached) {
                cartSuccess = true;
            }
        } else if (newFillAmount <= 0) {
            currentFillAmount = 0;
            currentFillDisplay = 0;
        } else {
            currentFillAmount = newFillAmount;
            currentFillDisplay += towerFillAmount;
        }
    }

    public boolean isCartSuccess() {
        return cartSuccess;
    }

    public boolean isFull() {
        return full;
    }

    public boolean isEndReached() {
        return endReached;
    }

    public void fillCart() {
        full = true;
    }

    public void setEndReached() {
        endReached = true;
    }

    public void setCartSuccess() {
        cartSuccess = true;
    }
}
