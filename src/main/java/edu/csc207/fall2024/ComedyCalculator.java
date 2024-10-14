package edu.csc207.fall2024;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class ComedyCalculator extends AbstractPerformanceCalculator {
    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amountFor() {
        int result = Constants.COMEDY_BASE_AMOUNT;
        if (getPerformance().getAudience() > Constants.COMEDY_AUDIENCE_THRESHOLD) {
            result += Constants.COMEDY_OVER_BASE_CAPACITY_AMOUNT + Constants.COMEDY_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.COMEDY_AUDIENCE_THRESHOLD);
        }
        result += Constants.COMEDY_AMOUNT_PER_AUDIENCE * getPerformance().getAudience();
        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + getPerformance().getAudience() / Constants.COMEDY_EXTRA_VOLUME_FACTOR;
    }
}

