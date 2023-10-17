import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import model.Transaction;
import controller.InputValidation;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

    // Handle Apply Amount Filter clicks
    view.getApplyAmountFilterBtn().addActionListener(e -> {

      // get amount from amountFilterField
      double amount = view.getAmountFilterField();
      
      // Call controller to apply filter
      Boolean filtered = controller.applyFilter(amount, null, "amount");
      
      // Show error message when the input is invalid
      if (!filtered) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      } 
    });

    // Handle Apply Category Filter clicks
    view.getApplyCategoryFilterBtn().addActionListener(e -> {
      // get category from categoryFilterField
      String category = view.getCategoryFilterField();
      
      // Call controller to apply filter
      Boolean filtered = controller.applyFilter(0, category, "category");

      // Show error message when the input is invalid
      if (!filtered) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

    // Handle Clear Filter clicks
    view.getClearFilterBtn().addActionListener(e -> {
      Boolean cleared = controller.clearFilter();
      //This should always be true. Putting this here as a placeholder since we might add error handling here.
      if (!cleared) {
        JOptionPane.showMessageDialog(view, "Unexpected issue");
        view.toFront();
      }
    });

  }

}