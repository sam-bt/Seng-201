package seng201.team0.models;

/**
 *
 * This class contains the information for the information input in the menu screen
 *
 */
public class Setup {
    private String playerName;
    private int numRounds;
    private int difficulty;
    /**
     *
     * Constructor method that initialises the input variables
     *
     */
    public Setup(String playerName, int numRounds, int difficulty) {
        this.playerName = playerName;
        this.numRounds = numRounds;
        this.difficulty = difficulty;
    }
    public String getName() {
        return playerName;
    }
    public int getNumRounds() {
        return numRounds;
    }
    public int getDifficulty() {
        return difficulty;
    }
}
