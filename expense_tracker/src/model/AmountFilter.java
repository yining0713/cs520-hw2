package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Get the transactions that match the filter for amount
 */
public class AmountFilter implements TransactionFilter{
    private double amount;

    public AmountFilter(double amount) {
        this.amount = amount;
    }

    /**
     * Return the list of transactions where the amount matches the filter
     * @param transactions the list of all transactions to be filtered
     */
    public List<Transaction> filter(List<Transaction> transactions){
        List<Transaction> transactionsFiltered = new ArrayList<Transaction>();
        for (Transaction t: transactions) {
            if (t.getAmount() == amount) {
                transactionsFiltered.add(t);
            }
        }
        return transactionsFiltered;
    }
}
