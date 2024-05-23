import java.util.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class spiltExpense {

	public ArrayList<String> spiltExpenses(Map<String, Double> expensesMapping) {
		double totalExpenses = 0;
		int numberOfPpl = expensesMapping.size();

		TreeMap<String, Double> payMoney = new TreeMap<>();
		TreeMap<String, Double> receiveMoney = new TreeMap<>();
		ArrayList<Double> sortedPayMoney = new ArrayList<Double>();
		ArrayList<Double> sortedReceiveMoney = new ArrayList<Double>();
		ArrayList<String> result = new ArrayList<String>();
		DecimalFormat df = new DecimalFormat("#.00");

		for (Map.Entry<String, Double> expenses : expensesMapping.entrySet()) {
			totalExpenses += expenses.getValue();
		}

		double averageExpenses = round(totalExpenses / numberOfPpl);
		// System.out.println("Average Expenses " +averageExpenses);

		for (Map.Entry<String, Double> expenseItem : expensesMapping.entrySet()) {
			if (expenseItem.getValue() > averageExpenses) {
				/*
				 * System.out.println(expenseItem.getKey() + " having balance " +
				 * round((expenseItem.getValue() - averageExpenses)));
				 */
				receiveMoney.put(expenseItem.getKey(), round(expenseItem.getValue() - averageExpenses));
			} else if (expenseItem.getValue() < averageExpenses) {
				/*
				 * System.out.println(expenseItem.getKey() + " having balance " +
				 * round((expenseItem.getValue() - averageExpenses)));
				 */
				payMoney.put(expenseItem.getKey(), round(averageExpenses - expenseItem.getValue()));
			}
		}

		sortedReceiveMoney = sortArrayList(receiveMoney);
		sortedPayMoney = sortArrayList(payMoney);

		int receiveMoneyIndex = 0;
		int payMoneyIndex = 0;
		int numOfTrans = 0;
		double remainingSum = 0;

		do {
			 //System.out.println("receiveMoneyIndex = "+receiveMoneyIndex);
			 //System.out.println("payMoneyIndex = "+payMoneyIndex);
			 

			if (remainingSum == 0)
				remainingSum = round(sortedReceiveMoney.get(receiveMoneyIndex));

			// System.out.println("remainingSum = " +remainingSum);

			if (remainingSum > sortedPayMoney.get(payMoneyIndex)) {
				remainingSum = round(remainingSum - sortedPayMoney.get(payMoneyIndex));
				result.add(getName(sortedPayMoney.get(payMoneyIndex), payMoney) + " pays "
						+ getName(sortedReceiveMoney.get(receiveMoneyIndex), receiveMoney) + " $"
						+ df.format(sortedPayMoney.get(payMoneyIndex)) + ".");
				payMoneyIndex++;
				payMoney.remove(getName(sortedPayMoney.get(payMoneyIndex - 1), payMoney));
				numOfTrans++;
			}
			else {
				result.add(getName(sortedPayMoney.get(payMoneyIndex), payMoney) + " pays "
						+ getName(sortedReceiveMoney.get(receiveMoneyIndex), receiveMoney) + " $"
						+ df.format(remainingSum) + ".");
				receiveMoneyIndex++;
				numOfTrans++;
				receiveMoney.remove(getName(sortedReceiveMoney.get(receiveMoneyIndex - 1), receiveMoney));
				remainingSum = round(sortedPayMoney.get(payMoneyIndex) - remainingSum);
				if(remainingSum == 0) {
					payMoneyIndex++;	
					payMoney.remove(getName(sortedPayMoney.get(payMoneyIndex - 1), payMoney));
				}
			}
		} while (receiveMoney.size() != 0);

		result.add("Number of transactions: " + numOfTrans);
		return result;
	}

	private ArrayList<Double> sortArrayList(TreeMap<String, Double> unsortedHashMap) {
		ArrayList<Double> sortArrayList = new ArrayList<Double>();

		for (Map.Entry<String, Double> unsortedItem : unsortedHashMap.entrySet()) {
			sortArrayList.add(unsortedItem.getValue());
		}
		Collections.sort(sortArrayList, Collections.reverseOrder());

		return sortArrayList;
	}

	private String getName(Double amount, TreeMap<String, Double> hashMap) {
		for (Map.Entry<String, Double> mapItem : hashMap.entrySet()) {
			if (mapItem.getValue() == amount)
				return mapItem.getKey();
		}
		return null;
	}

	private double round(double value) {
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}