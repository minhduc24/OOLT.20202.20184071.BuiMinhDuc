package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

/**
  * Order
  */

 public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private ArrayList <Media> itemsOrdered = new ArrayList<Media>();
    //private int qtyORDERED;
    private MyDate dateOrdered;
    private static int nbOrders = 0;
    public Order(){
        dateOrdered = new MyDate();
    }

    public static Order getOrder() {
        if (nbOrders < MAX_LIMITTED_ORDERS) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost full !!!");
            return null;
        }
        
    }
    
    //  public void printOrderd() {
    //      System.out.println("***********************Order***********************");
    //      System.out.println("date : ");
    //      dateOrdered.print();
    //      System.out.println("Ordered Items: ");
    //     for (int i = 0; i < qtyORDERED; i++) {
    //          System.out.println((i+1) + ".DVD - " + itemsOrdered[i].getTitle() + "-" + itemsOrdered[i].getCategory() + "-" +  itemsOrdered[i].getDirector() + "-" +  itemsOrdered[i].getLength() + ":"+ itemsOrdered[i].getCost());
    //     }
    //      System.out.println("Total cost: " +totalCost());
    // }

    public void addMedia(Media disc) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            int k = 0;
            for (int i = 0; i < itemsOrdered.size(); i++) {
                if(itemsOrdered.get(i).getId() == disc.getId()) {
                    System.out.println("already exist !!!");
                    k = 1;
                }
            }
            if (k == 0) {
                itemsOrdered.add(disc);
                System.out.println("The disc has been added !!!");    
            }
                        
        }
        else 
        {
            System.out.println("The order is almost full !!!");
        }
    }

    public void addMedia( Media[] arr) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            if (itemsOrdered.size() + arr.length > MAX_NUMBER_ORDERED) {
                System.out.println("The list of items that cannot be added to the current order !!!");
            }
            else {
                for (int i = 0; i < arr.length; i++) {
                    itemsOrdered.add(arr[i]);
                    System.out.println("The disc has been added !!!");
                }
            }
        }
        else {
            System.out.println("Error !!!");
        }
    }

    public void addMedia(Media dvd1,Media dvd2) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(dvd1);
            if (itemsOrdered.size() == MAX_NUMBER_ORDERED) {
                System.out.println("The dvd " + dvd2.getTitle( ) + " could not be added !!!");
            }
            else {
                itemsOrdered.add(dvd2);
            }
        }
        else {
            System.out.println("The item quantity has reached its limit !!!");
        }
    }

    public void removeMedia(int id) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getId() == id) {
                itemsOrdered.remove(i);
            }
        }
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            
            cost += itemsOrdered.get(i).getcost();
            
        }
        return cost;
    }

    public void display(){
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println("Id : "+itemsOrdered.get(i).getId()+" Title : "+itemsOrdered.get(i).getTitle()+" Category : "+itemsOrdered.get(i).getCategory() +" Cost : "+itemsOrdered.get(i).getcost());
            System.out.println("Total cost : " +totalCost());       
        }
    }

    public static void addBookToOrder(Order anOrder) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("\tEnter id: ");
        int id = nhap.nextInt();
        nhap.nextLine();
        System.out.print("\tEnter title: ");
        String title = nhap.nextLine();
        System.out.print("\tEnter category: ");
        String category = nhap.nextLine();
        System.out.print("\tEnter cost: ");
        float cost = nhap.nextFloat();
        Book book = new Book(id, title, category, cost);
        nhap.nextLine();
        System.out.print("\tEnter authors: ");
        nhap.nextLine();
        anOrder.addMedia(book);
        nhap.close();
    }

    public void removeMediaInOrder(Order anOrder) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = nhap.nextInt();
        anOrder.removeMedia(id);
        nhap.close();
    }
}
 


