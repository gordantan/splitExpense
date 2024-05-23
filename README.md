# splitExpense

Split Expense Assignment

This code is created to tackle the assignment to solve a problem where a group of friends had a set of spent expenses, and the program will
determine who should pay whom in order to get the expenses split equally among the group of friends. 

Tech used: Java

How It Works:
spiltExpense.java

This class contains the method spiltExpenses where the code takes in a set of spent expenses into a hashmap, with the name of the friend
as the key and the total expense spent as the value as an input.
The code will first calculate the average expenses from the input, and derive 2 hashmap structure receiveMoney and payMoney, where 
receiveMoney contains a list of friends who should receive money and payMoney contains a list of friends who should pay money.
Next, the code will seek to sort the expenses under each from the hashmap receiveMoney and payMoney, from the highest amount to the lowest,
to ensure that we use the lowest amount of transactions to settle the expenses. 
Finally, the code will go through the hashmap receiveMoney and settle the amount using hashmap receiveMoney.

There are 3 scenarios.
1st Scenario - Receive Money's amount is more than Pay Money's amount. 
This scenario reflects that the person from the Pay Money Map is not sufficient to fully pay the person from Receive Money Map.
The program will pay the full amount of person from the Pay Money to person from Receive Money, 
compute the remaining Money for the person from ReceiveMoney that is unpaid, and move to the next 
person from the Pay Money Map. 

2nd Scenario - Receive Money's amount is equal Pay Money's amount. 
This scenario reflects that the person from the Pay Money Map can just nicely fully pay the person from Receive Money Map.
The program will pay the full amount of person from the Pay Money to person from Receive Money,
The code will then move to the next person from Receive Money Map to clear the amount, and by using the next 
person from the Pay Money Map. 

3rd Scenario - Receive Money's amount is less than Pay Money's amount. 
This scenario reflects that the person from the Pay Money Map can fully pay person from Receive Money Map. with excess debt to roll over 
next person from Receive Money.
The program will erase the debt from person of Receive Money using the amount from the person of Pay Money.
The code will then compute the remaining Money for the person from PayMoney and move to the next
 person from Receive Money Map.
 
testSpiltExpense.java

This class is the junit test scenarios created based on requirement.
Assertion is done to check if the input from method matches the one given by the requirement. 
