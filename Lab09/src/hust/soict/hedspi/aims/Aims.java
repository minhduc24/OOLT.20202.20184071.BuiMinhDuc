package hust.soict.hedspi.aims;
import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;

public class Aims {
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	
	public static void showMenuMedia() {
		 System.out.println("Select add Book or DVD ");
	        System.out.println("--------------------------------");
	        System.out.println("1. Book");
	        System.out.println("2. DVD");
	        System.out.println("3. CD");	        
	        System.out.println("0. Exit");
	        System.out.println("--------------------------------");
	        System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choose;
		Order anOrder = null;
		do {
			showMenu();
			System.out.println("Enter your choose: ");
			choose = input.nextInt();
			switch (choose) {
			case 0:
				System.out.println("You choose exit.");
				break;
			case 1:
				anOrder = new Order();
				System.out.println("Done");
				break;
			case 2:
				if (anOrder == null) 
					System.out.println("Please choose case 1 first");
				else {
					showMenuMedia();
					int choose1;
					System.out.println("Enter your choose: ");
					choose1 = input.nextInt();
					switch (choose1) {
					case 0:
						break;
					case 1:
						anOrder.addBookToOrder(anOrder);
						break;
					case 2:
						anOrder.addDVDToOrder(anOrder);
					case 3:
						anOrder.addCDToOrder(anOrder);
					default:
						System.out.println("Invalid selection");
						break;
					}
					System.out.println("Done");
				}
				break;
			case 3:
				if (anOrder == null) {
					System.out.println("Please choose case 1 first");
				} else {
				anOrder.DeleteItemById(anOrder);
				System.out.println("Done");
				}
				break;
			case 4:
				if (anOrder == null) {
					System.out.println("Please choose case 1 first");
				} else {
				anOrder.printListOfOrdered();
				}
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}
		} while (choose != 0);
		
		input.close();
	}
}
