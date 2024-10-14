package edu.csc207.fall2024;

import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementPrinter {
    private Invoice invoice;
    private Map<String, Play> plays;
    private StatementData statementData;

    public StatementPrinter(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
        this.statementData = new StatementData(invoice, plays);
    }

    public StatementData getStatementData() {
        return statementData;
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known
     */
    public String statement() {
        return renderPlainText(statementData);
    }

    private String renderPlainText(StatementData statemenData) {
        String result = "Statement for " + statemenData.getCustomer() + System.lineSeparator();

        for (PerformanceData performanceData : statemenData.getPerformances()) {
            result += String.format("  %s: %s (%d seats)%n", performanceData.getPlayName(),
                    usd(performanceData.amountFor()),
                    performanceData.getAudience());
        }

        result += String.format("Amount owed is %s%n", usd(statemenData.totalAmount()));
        result += String.format("You earned %s credits%n", statemenData.volumeCredits());

        return result;
    }

    String usd(int amount) {
        return String.format("$%,.2f", (double) amount / Constants.PERCENT_FACTOR);
    }
}
