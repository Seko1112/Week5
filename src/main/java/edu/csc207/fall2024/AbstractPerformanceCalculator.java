package edu.csc207.fall2024;

/**
 * This is a abstract class for all the calculator types.
 */
public abstract class AbstractPerformanceCalculator {
    private Performance performance;
    private Play play;

    public AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }

    /**
     * The abstarct method.
     * @return nothing
     */
    public abstract int amountFor();

    /**
     * The abstarct method.
     * @return nothing
     */
    public int volumeCredits() {
        return Math.max(getPerformance().getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
    }

    /**
     * This method creates a Calculator based on its identity.
     * @param performance is the performance
     * @param play is the play
     * @return the calculator based on the type
     * @throws IllegalArgumentException if type is not found
     */
    public static AbstractPerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            case "history":
                return new HistoryCalculator(performance, play);
            case "pastoral":
                return new PastoralCalculator(performance, play);
            default:
                throw new IllegalArgumentException("Unknown play type: " + play.getType());
        }
    }
}
