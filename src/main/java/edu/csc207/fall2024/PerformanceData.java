package edu.csc207.fall2024;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class PerformanceData {
    private int audience;
    private String type;
    private String playName;

    public PerformanceData(int audience, String type, String playName) {
        this.audience = audience;
        this.type = type;
        this.playName = playName;
    }

    public int getAudience() {
        return audience;
    }

    public String getType() {
        return type;
    }

    public String getPlayName() {
        return playName;
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws IllegalArgumentException if one of the play types is not known
     */
    public int amountFor() {
        int amount = 0;
        switch (type) {
            case "tragedy":
                amount = Constants.TRAGEDY_BASE_AMOUNT;
                if (audience > Constants.TRAGEDY_AUDIENCE_THRESHOLD) {
                    amount += Constants.TRAGEDY_OVER_BASE_CAPACITY_PER_PERSON
                            * (audience - Constants.TRAGEDY_AUDIENCE_THRESHOLD);
                }
                break;
            case "comedy":
                amount = Constants.COMEDY_BASE_AMOUNT;
                if (audience > Constants.COMEDY_AUDIENCE_THRESHOLD) {
                    amount += Constants.COMEDY_OVER_BASE_CAPACITY_AMOUNT
                            + Constants.COMEDY_OVER_BASE_CAPACITY_PER_PERSON
                            * (audience - Constants.COMEDY_AUDIENCE_THRESHOLD);
                }
                amount += Constants.COMEDY_AMOUNT_PER_AUDIENCE * audience;
                break;
            case "history":
                amount = Constants.HISTORY_BASE_AMOUNT;
                if (audience > Constants.HISTORY_AUDIENCE_THRESHOLD) {
                    amount += Constants.HISTORY_OVER_BASE_CAPACITY_PER_PERSON
                            * (audience - Constants.HISTORY_AUDIENCE_THRESHOLD);
                }
                break;
            case "pastoral":
                amount = Constants.PASTORAL_BASE_AMOUNT;
                if (audience > Constants.PASTORAL_AUDIENCE_THRESHOLD) {
                    amount += Constants.PASTORAL_OVER_BASE_CAPACITY_PER_PERSON
                            * (audience - Constants.PASTORAL_AUDIENCE_THRESHOLD);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        return amount;
    }
}
