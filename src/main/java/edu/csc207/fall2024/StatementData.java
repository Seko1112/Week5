package edu.csc207.fall2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementData {
    private String customer;
    private List<PerformanceData> performances;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.getCustomer();
        this.performances = new ArrayList<>();

        for (Performance performance : invoice.getPerformances()) {
            final Play play = plays.get(performance.getPlayID());
            performances.add(new PerformanceData(performance.getAudience(), play.getType(), play.getName()));
        }
    }

    public String getCustomer() {
        return customer;
    }

    public List<PerformanceData> getPerformances() {
        return performances;
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known
     */
    public int totalAmount() {
        int totalAmount = 0;
        for (PerformanceData performance : performances) {
            totalAmount += performance.amountFor();
        }
        return totalAmount;
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known
     */
    public int volumeCredits() {
        int volumeCredits = 0;
        for (PerformanceData performance : performances) {
            if ("history".equals(performance.getType())) {
                volumeCredits += Math.max(performance.getAudience() - Constants.HISTORY_VOLUME_CREDIT_THRESHOLD, 0);
            }
            else if ("pastoral".equals(performance.getType())) {
                volumeCredits += Math.max(performance.getAudience() - Constants.PASTORAL_VOLUME_CREDIT_THRESHOLD, 0)
                        + performance.getAudience() / 2;
            }
            else {
                volumeCredits += Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
                if ("comedy".equals(performance.getType())) {
                    volumeCredits += Math.floor(performance.getAudience() / Constants.COMEDY_EXTRA_VOLUME_FACTOR);
                }
            }

        }
        return volumeCredits;
    }
}
