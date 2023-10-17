package model;

import java.util.List;
import java.util.ArrayList;

public class AmountFilter implements TransactionFilter{
    private double amount;

    public AmountFilter(double amount) {
        this.amount = amount;
    }

    public List<Transaction> filter(List<Transaction> transactions){
        List<Transaction> transactionsFiltered = new ArrayList<Transaction>();
        for (int i = 0; i < transactions.size(); i++) {
            for (Transaction t: transactions) {
                if (t.getAmount() == amount) {
                    transactionsFiltered.add(t);
                }
            }
        }
        return transactionsFiltered;
    }
}
