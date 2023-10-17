package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JButton applyAmountFilterBtn;
  private JButton applyCategoryFilterBtn;
  private JButton clearFilterBtn;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private JFormattedTextField amountFilterField;
  private JTextField categoryFilterField;
  private DefaultTableModel model;
  

  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");
    applyAmountFilterBtn = new JButton("Apply Amount Filter");
    applyCategoryFilterBtn = new JButton("Apply Category Filter");
    clearFilterBtn = new JButton("Clear Filter");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);


    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);


    JLabel amountFilterLabel = new JLabel("Amount Filter:");

    amountFilterField = new JFormattedTextField(format);
    amountFilterField.setColumns(10);
    amountFilterField.setMaximumSize(new Dimension(Integer.MAX_VALUE, amountFilterField.getPreferredSize().height));


    JLabel categoryFilterLabel = new JLabel("Category Filter:");
    categoryFilterField = new JTextField(10);
    categoryFilterField.setMaximumSize(new Dimension(Integer.MAX_VALUE, categoryFilterField.getPreferredSize().height));

    // Create table
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);

    JPanel filterPanel = new JPanel();
    filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
    filterPanel.add(amountFilterLabel);
    filterPanel.add(amountFilterField);
    filterPanel.add(applyAmountFilterBtn);
    filterPanel.add(categoryFilterLabel);
    filterPanel.add(categoryFilterField);
    filterPanel.add(applyCategoryFilterBtn);
    filterPanel.add(clearFilterBtn);
    
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
    add(filterPanel, BorderLayout.EAST);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) {
      // Clear existing rows
      model.setRowCount(0);
      // Get row count
      int rowNum = model.getRowCount();
      double totalCost=0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()}); 
      }
        // Add total row
        Object[] totalRow = {"Total", null, null, totalCost};
        model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  
  

  
  
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  public JButton getApplyAmountFilterBtn() {
    return applyAmountFilterBtn;
  }

  public JButton getApplyCategoryFilterBtn() {
    return applyCategoryFilterBtn;
  }


  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
    public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public double getAmountFilterField() {
    if(amountFilterField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountFilterField.getText());
    return amount;
    }
  }

  public void setAmountFilterField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  public String getCategoryFilterField() {
    return categoryFilterField.getText();
  }

  public void setCategoryFilterField(JTextField categoryFilterField) {
    this.categoryFilterField = categoryFilterField;
  }

}
