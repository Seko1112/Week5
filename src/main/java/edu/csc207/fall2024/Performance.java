package edu.csc207.fall2024;

/**
 * Represents a performance with a play ID and audience size.
 */
public class Performance {
    // Fields should be private with accessor methods
    private String playID;
    private int audience;

    /**
     * Constructor for Performance.
     *
     * @param playID the ID of the play
     * @param audience the number of people in the audience
     */
    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    // Getter for playID
    public String getPlayID() {
        return playID;
    }

    // Getter for audience
    public int getAudience() {
        return audience;
    }
}
