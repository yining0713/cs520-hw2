package model;

import java.util.List;

public interface TransactionFilter {
    public List<Transaction> filter(List<Transaction> transactions);
}
