package model;

import java.util.List;

/**
 * Provide in interface for filtering different values
 */
public interface TransactionFilter {
    public List<Transaction> filter(List<Transaction> transactions);
}
