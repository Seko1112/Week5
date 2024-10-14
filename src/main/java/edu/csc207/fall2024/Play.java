package edu.csc207.fall2024;

/**
 * Represents a play with a name and type.
 */
public class Play {
    // Fields should be private with accessor methods
    private String name;
    private String type;

    /**
     * Constructor for Play.
     *
     * @param name the name of the play
     * @param type the type of the play (e.g., tragedy or comedy)
     */
    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
