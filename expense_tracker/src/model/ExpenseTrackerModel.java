package model;

import java.util.ArrayList;
import java.util.List;

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

  public List<Transaction> getTransactions() {
    //return Collections.unmodifiableList(transactions);
    List<Transaction> copyOfTransactions = new ArrayList<>();
    for (Transaction originalTransaction : transactions) {
      // Create a new Transaction object with the same values as the original
      Transaction copyTransaction = new Transaction(
        originalTransaction.getAmount(),
        originalTransaction.getCategory()
      );
      copyOfTransactions.add(copyTransaction);

      return copyOfTransactions;
    }
  }

}
