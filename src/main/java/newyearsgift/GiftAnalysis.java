package newyearsgift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GiftAnalysis {
	
	static Scanner input = new Scanner(System.in);
	
	static ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets = new ArrayList<Sweet>();
	
	static HashMap<String, Integer> nameToRs = new HashMap<String, Integer>();
	static HashMap<String, Integer> nameToWt = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		inputChocolates();
		inputSweets();
		calcRange();
	}
	
	public static void inputChocolates() {
		System.out.print("Enter number of chocloates: ");
		int chocoCount = input.nextInt();
		for(int i = 0; i < chocoCount; i++) {
			System.out.print("Enter the chocolate type (Enter number) 1. Candy 2. Wafer: ");
			int chocoType = input.nextInt();
			System.out.print("Enter name of chocloate: ");
			String name = input.next();
			System.out.print("Enter price of chocolate: ");
			int price = input.nextInt();
			System.out.print("Enter weight of chocolate: ");
			int weight = input.nextInt();
			Chocolate  choco;
			if(chocoType == 1) choco = new Candy(rs, wt);
			else choco = new Wafer(rs, wt);
			chocolates.add(choco);
			
			if(nameToPrice.containsKey(name)) {
				nameToRs.put(name, (int)nameToRs.get(name) + rs);
			} else {
				nameToRs.put(name, rs);
			}
			
			if(nameToWt.containsKey(name)) {
				nameToWt.put(name, (int)nameToWt.get(name) + wt);
			} else {
				nameToWt.put(name, wt);
			}
		}
	}
	
	public static void inputSweets() {
		System.out.print("Enter number of sweets: ");
		int sweetCount = input.nextInt();
		for(int i = 0; i < sweetCount; i++) {
			System.out.print("Enter the sweet type (Enter number) 1. GulabJamun 2. KajuKatli: ");
			int sweetType = input.nextInt();
			System.out.print("Enter price of sweet: ");
			int price = input.nextInt();
			System.out.print("Enter weight of sweet: ");
			int weight = input.nextInt();
			Sweet sweet;
			String name;
			if(sweetType == 1) {
				sweet = new GulabJamun(rs, wt);
				name = "GulabJamun";
			} else {
				sweet = new KajuKatli(rs, wt);
				name = "KajuKatli";
			}
			sweets.add(sweet);
			
			if(nameToRs.containsKey(name)) {
				nameToRs.put(name, (int)nameToRs.get(name) + rs);
			} else {
				nameToRs.put(name, rs);
			}
			
			if(nameToWt.containsKey(name)) {
				nameToWt.put(name, (int)nameToWt.get(name) + wt);
			} else {
				nameToWt.put(name, wt);
			}
		}
	}
	
	public static int calcTotalWt() {
		int totalWt = 0;
		for(Sweet sweet : sweets) totalWt += sweet.getWt();
		for(Chocolate choco : chocolates) totalWt += choco.getWt();
		return totalWt;
	}
	
	public static int calcTotalRs() {
		int totalRs = 0;
		for(Sweet sweet : sweets) totalPrice += sweet.getRs();
		for(Chocolate choco : chocolates) totalRs += choco.getRs();
		return totalRs;
	}
	
	public static void calcRange() {
		System.out.print("Choose the way to calculte range 1. Price, 2. Weight: ");
		int type = input.nextInt();
		System.out.print("Enter lower limit: ");
		int lowerLimit = input.nextInt();
		System.out.print("Enter higher limit: ");
		int higherLimit = input.nextInt();
		if(type == 1) {
			for(Map.Entry<String, Integer> gift : nameToRs.entrySet()) {
				int rs = gift.getValue();
				if(rs >= lowerLimit && rs <= higherLimit) {
					System.out.println(gift.getKey());
				}
			}
		} else {
			for(Map.Entry<String, Integer> gift : nameToWt.entrySet()) {
				int rs = gift.getValue();
				if(rs>= lowerLimit && rs <= higherLimit) {
					System.out.println(gift.getKey());
				}
			}
		}
	}
}
