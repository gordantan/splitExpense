import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class testSpiltExpense {

	@Test
	void testCase1() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Ali", 40.105); 
		expenseMapping.put("Bob", 40.105);
		expenseMapping.put("Charlie", 10.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Charlie pays Ali $10.03."));
		assertTrue(result.contains("Charlie pays Bob $10.04."));
		assertTrue(result.contains("Number of transactions: 2"));
		
	}
	
	@Test
	void testCase2() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Ali", 40.0); 
		expenseMapping.put("Bob", 40.0);
		expenseMapping.put("Charlie", 10.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Charlie pays Ali $10.00."));
		assertTrue(result.contains("Charlie pays Bob $10.00."));
		assertTrue(result.contains("Number of transactions: 2"));
		
	}
	
	@Test
	void testCase3() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Ali", 10.0); 
		expenseMapping.put("Bob", 20.0);
		expenseMapping.put("Charlie", 0.0); 
		expenseMapping.put("Don", 10.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Charlie pays Bob $10.00."));
		assertTrue(result.contains("Number of transactions: 1"));
		
	}
	
	@Test
	void testCase4() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Alice", 40.0); 
		expenseMapping.put("Bob", 40.0);
		expenseMapping.put("Charlie", 10.0); 
		expenseMapping.put("Don", 10.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Charlie pays Alice $15.00."));
		assertTrue(result.contains("Don pays Bob $15.00."));
		assertTrue(result.contains("Number of transactions: 2"));
		
	}
	
	@Test
	void testCase5() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Alice", 200.0); 
		expenseMapping.put("Bob", 80.0);
		expenseMapping.put("Charlie", 50.0); 
		expenseMapping.put("Don", 20.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Bob pays Alice $7.50."));
		assertTrue(result.contains("Charlie pays Alice $37.50."));
		assertTrue(result.contains("Don pays Alice $67.50."));
		assertTrue(result.contains("Number of transactions: 3"));
		
	}
	
	@Test
	void testCase6() {
		
		TreeMap<String, Double> expenseMapping = new TreeMap<>();
		
		expenseMapping.put("Alice", 160.0); 
		expenseMapping.put("Bob", 120.0);
		expenseMapping.put("Charlie", 50.0); 
		expenseMapping.put("Don", 20.0);
		
		spiltExpense se = new spiltExpense();
		ArrayList<String> result = se.spiltExpenses(expenseMapping);
		System.out.println(result);
		assertTrue(result.contains("Don pays Alice $67.50."));
		assertTrue(result.contains("Charlie pays Alice $5.00."));
		assertTrue(result.contains("Charlie pays Bob $32.50."));
		assertTrue(result.contains("Number of transactions: 3"));
		
	}


}
