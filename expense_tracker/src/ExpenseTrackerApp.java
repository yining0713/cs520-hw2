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

    view.getApplyAmountFilterBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountFilterField();
      
      // Call controller to add transaction
      String filtered = controller.applyFilter(amount, null);
      
      if (true) {
        JOptionPane.showMessageDialog(view, "Filter Amount: No transaction found");
        view.toFront();
      }
    });

    view.getApplyCategoryFilterBtn().addActionListener(e -> {
      // Get transaction data from view
      String category = view.getCategoryFilterField();
      
      // Call controller to add transaction
      String filtered = controller.applyFilter(0, category);
      
      if (true) {
        JOptionPane.showMessageDialog(view, "Filter Category: No transaction found");
        view.toFront();
      }
    });

  }

}