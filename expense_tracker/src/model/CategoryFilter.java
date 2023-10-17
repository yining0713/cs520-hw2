package model;

import java.util.List;
import java.util.ArrayList;

public class CategoryFilter implements TransactionFilter{
    private String category;

    public CategoryFilter(String category) {
        this.category = category;
    }

    public List<Transaction> filter(List<Transaction> transactions){
        List<Transaction> transactionsFiltered = new ArrayList<Transaction>();
        for (int i = 0; i < transactions.size(); i++) {
            for (Transaction t: transactions) {
                if (t.getCategory().trim().equals(category.trim())) {
                    transactionsFiltered.add(t);
                }
            }
        }
        return transactionsFiltered;
    }
}
