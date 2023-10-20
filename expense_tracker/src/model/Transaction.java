package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class Transaction {

  //public double amount;
  //public String category;
  //public String timestamp;
  
  // Answer to Modularity part a
  private final double amount;
  private final String category;
  private final String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }
  /*
  public void setAmount(double amount) {
    this.amount = amount;
  }
  */

  public String getCategory() {
    return category;
  }

  /*
  public void setCategory(String category) {
    this.category = category; 
  }
  */
  
  public String getTimestamp() {
    return timestamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}