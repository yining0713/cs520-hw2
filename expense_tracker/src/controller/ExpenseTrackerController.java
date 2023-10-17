package controller;

import view.ExpenseTrackerView;
import model.AmountFilter;
import model.CategoryFilter;

import java.util.ArrayList;
import java.util.List;



import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }

  public Boolean applyFilter(double amount, String category, String filterField) {

    List<Transaction> transactionFiltered = new ArrayList<Transaction>();

    if (filterField == "amount") {
      if (!InputValidation.isValidAmount(amount)) {
      return false;
      }
      transactionFiltered = new AmountFilter(amount).filter(model.getTransactions());
    }

    if (filterField == "category") {
      if (!InputValidation.isValidCategory(category)) {
      return false;
      }
      transactionFiltered = new CategoryFilter(category).filter(model.getTransactions());
    }

    // Get the index 
    // Getting the index here instead of at the filter in case multiple rounds of filters need to be done in the future
    int[] rowsFiltered = getMatchingIndices(model.getTransactions(), transactionFiltered);
    view.highlightTable(rowsFiltered);

    return true;
    }
  
  /**
   * 
   * @param base the entire list of transactions
   * @param match the filtered list of transactions
   * @return the array of indice of all transactions that matched the filtered ones
   */
  public int[] getMatchingIndices(List<Transaction> base, List<Transaction> match){
    int indexBase = 0;
    int indexMatch = 0;
    int[] matchedIndice = new int[match.size()];
    
    while(indexBase != base.size() && indexMatch != match.size()) {
      Transaction currBase = base.get(indexBase);
      Transaction currMatch = match.get(indexMatch);

      if (currBase == currMatch) {
        matchedIndice[indexMatch] = indexBase;
        indexMatch++;
      }
      indexBase++;
    }
    return matchedIndice;
  }

  public Boolean clearFilter() {
    int[] emptyArray = {};
    view.highlightTable(emptyArray);
    return true;
  }
  // Other controller methods
}