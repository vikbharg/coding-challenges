package techgig2021.finals;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfOrders = 0;
		int numberOfMachines = 0;
		if (stdin.hasNext()) {
			numberOfOrders = stdin.nextInt();
			numberOfMachines = stdin.nextInt();
		}
		
		List<Order> orders = new ArrayList<>();
		
		Map<Integer, Integer> missingMachineFrequency = new HashMap<>();
		
		for(int i=0;i<numberOfOrders;i++) {
			Order order = new Order();
			order.setAmount(stdin.nextInt());
			int numberOfMissingMachines = stdin.nextInt();
			Map<Integer, Integer> missingMachines = new HashMap<>();
			int totalRent = 0;
			for(int j=0;j<numberOfMissingMachines;j++) {
				int number = stdin.nextInt();
				int rent = stdin.nextInt();
				totalRent += rent;
				missingMachines.put(number, rent);
				if(missingMachineFrequency.get(number) == null) {
					missingMachineFrequency.put(number, 1);
				}else {
					missingMachineFrequency.put(number, missingMachineFrequency.get(number)+1);
				}
			}
			order.setTotalRent(totalRent);
			order.setMissingMachines(missingMachines);
			orders.add(order);
		}
		
		Map<Integer, Integer> machines = new HashMap<>();
		
		for(int k=0;k<numberOfMachines;k++) {
			machines.put(k+1, stdin.nextInt());
		}
		
		System.out.println(getMaxProfit(orders, machines, missingMachineFrequency));
	}
	
	public static int getMaxProfit(List<Order> orders, Map<Integer, Integer> machines, Map<Integer, Integer> missingMachineFrequency) {
		
		int profit = 0;
		
		int totalOrderSum = 0;
		for(Order order: orders) {
			int amount = order.getAmount();
			int expense = 0;
			for(Map.Entry<Integer,Integer> entry : order.getMissingMachines().entrySet()) {
				if(missingMachineFrequency.get(entry.getKey()) == 1) {
					expense += entry.getValue();
				}
			}
			if(amount - expense > 0) {
				totalOrderSum += amount-expense;
			}
		}
		
		int totalMachineExpense = 0;
		for(Map.Entry<Integer,Integer> entry : machines.entrySet()) {
			if(missingMachineFrequency.get(entry.getKey()) > 1) {
				totalMachineExpense += entry.getValue();
			}
		}
		
		return totalOrderSum-totalMachineExpense;
	}

}

class Order{
	int amount;
	int totalRent;
	Map<Integer, Integer> missingMachines;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(int totalRent) {
		this.totalRent = totalRent;
	}
	public Map<Integer, Integer> getMissingMachines() {
		return missingMachines;
	}
	public void setMissingMachines(Map<Integer, Integer> missingMachines) {
		this.missingMachines = missingMachines;
	}
}

class Machine{
	int number;
	int price;
	int rent;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	
}


