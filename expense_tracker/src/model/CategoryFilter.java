package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Get the transactions that match the filter for category
 */
public class CategoryFilter implements TransactionFilter{
    private String category;

    public CategoryFilter(String category) {
        this.category = category;
    }

    /**
     * Return the list of transactions where the category matches the filter
     * @param transactions the list of all transactions to be filtered
     */
    public List<Transaction> filter(List<Transaction> transactions){
        List<Transaction> transactionsFiltered = new ArrayList<Transaction>();
        for (Transaction t: transactions) {
            if (t.getCategory().trim().equals(category.trim())) {
                transactionsFiltered.add(t);
            }
        }

        return transactionsFiltered;
    }
}
