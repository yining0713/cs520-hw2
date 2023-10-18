package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ExpenseTrackerModel {

  public List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }
  
  // Answer to Modularity part b
  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList(transactions);
  }

}