package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;

/**
 * Aims
 */

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

    public static void main(String[] args) {
        Order order = new Order();
        Scanner input = new Scanner(System.in);
        int choose;
        Order anOrder = null;
        do {
            showMenu();
            System.out.println("Enter your choose : ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    order = new Order();
                    System.out.println("Done !!!");
                    break;
                case 2:
                    Order.addBookToOrder(anOrder);
                    System.out.println("Done !!!");
                    break;
                case 3:
                    order.removeMediaInOrder(anOrder);
                    System.out.println("Done !!!");
                    break;
                case 4:
                    order.display();
                case 0:
                    System.out.println("You choose exit !!!");
                    break;
                default:
                    System.out.println("Invalid selection !!!");
                    break;
            }
        } while (choose != 0);
        input.close();
    }
}
