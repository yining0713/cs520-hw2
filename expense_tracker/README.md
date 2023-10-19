# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.

## Filter Feature
The user can use the amount filter field and button and the category filter field and button to apply filters. The rows with the specified amount or category will be highlighted. The user can filter by either amount and category at a time. The user can click the 'clear filter' button to remove highlighting. <br>
The previous requirement for amount and category input applies here: the amount has to be numbers between 0 and 1000, and the category needs to be one of 'food, travel, entertainment, bills, other'.

## Design Pattern
The strategy pattern is used here. <br>
AmountFilter and CategoryFilter extend TransactionFilter Interface. <br>
ExpenseTrackerController.java has a method applyFilter uses TransactionFilter Interface to call the filter method.<br>
ExpenseTrackerView.java chooses whether to use AmountFilter or CategoryFilter depending on the user's action.

## Reference
The class for highlighting MyColorRenderer references the code here https://stackoverflow.com/questions/25093985/highlight-the-cell-in-jtable