package AimsProject.hust.soict.hedspi.aims;



import java.util.Scanner;

import AimsProject.hust.soict.hedspi.aims.order.Order;

/**
 * Aims
 */

public class Aims {

    public static void showMenu() {

        System.out.println("Order Management Application: ");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("Enter your choose:");
        
    }

    public static void showMenuMedia() {

        System.out.println("Select add Book or DVD: ");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Exit");
        System.out.println("Enter your choose:");
        
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
                    int key;
                    do {
                        showMenuMedia();
                        System.out.println("Enter your choose : ");
                        key = input.nextInt();
                        switch (key) {
                            case 1:
                                input.nextLine();
                                Order.addBookToOrder(anOrder);    
                                break;
                            case 2:
                                input.nextLine();
                                Order.addBookToOrder(anOrder);    
                                break;
                            case 3:
                                input.nextLine();
                                Order.addBookToOrder(anOrder);    
                                break;
                            case 0:
                                System.out.println("You choose exit !!!");
                                break;
                            default:
                                System.out.println("Invalid selection !!!");
                                break;
                        }
                    } while (key != 0);
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
