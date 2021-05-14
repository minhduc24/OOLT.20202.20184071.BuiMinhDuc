package hust.soict.hedspi.aims.order;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Track;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;
	private int id;
	private static final int numberOfOrder = 4;
    private int thresholdsTotal;
    private float thresholdsSale;
	
    public void setThresholds(int thresholdsTotal, float thresholdsSale) {
        this.thresholdsTotal = thresholdsTotal;
        this.thresholdsSale = thresholdsSale;
    }
    
    public static Order getOrder() throws LimitExceededException {
        if (nbOrders < MAX_LIMITTED_ORDERS) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        else {
        	throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
        }   
    }
    
    
	public void addMedia (Media disc) throws LimitExceededException  {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (itemsOrdered.contains(disc)) {
				System.out.println("The disc already exists");
			} else {
			itemsOrdered.add(disc);
			System.out.println("The disc has been added");
			}
		} else {
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
		}
	}
	
	public void removeMedia (Media disc) {
		if (itemsOrdered.contains(disc)) {
			itemsOrdered.remove(disc);
			System.out.println("Successfully removed disc");
		} else 
			System.out.println("The disc not found");
	}
	
	public boolean removeMedia(int id) {
        boolean temp = false;
        for(Media media: itemsOrdered) {
            if(media.getId() == id) {
                removeMedia(media);
                temp = true;
                break;
            }
        } if(!temp) {
            System.err.println("Can not find id");
        }
        return temp;
    }
	
	public float totalCost() {
		float sum = 0;
		for (Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	public void printListOfOrdered() {
        System.out.println("********************************ORDER******************************");
        int i = 1;
        System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", "STT", "Type", "ID", "Title", "Category", "Cost");
        for(Media media: itemsOrdered) {
            if(media instanceof Book) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", i, "Book", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }else if(media instanceof DigitalVideoDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-10s | %-10s |\n", i, "DVD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }
            i++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*******************************************************************");
    }
	
	public void addBookToOrder (Order anOrder) {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter book id: ");
		id = input.nextInt();
		input.nextLine();
		System.out.println("Enter book title: ");
		String title = input.nextLine();
		System.out.println("Enter book category: ");
		String category = input.nextLine();
		System.out.println("Enter book cost: ");
		float cost = input.nextFloat();
		System.out.println("Enter book author: ");
		String author = input.nextLine();
		Book aBook = new Book(id, title, category,cost);
		aBook.addAuthor(author);
		input.close();
		try {
			anOrder.addMedia(aBook);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
	}
	
	public void addDVDToOrder (Order anOrder) throws PlayerException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter DVD id: ");
		id = input.nextInt();
		input.nextLine();
		System.out.println("Enter DVD title: ");
		String title = input.nextLine();
		System.out.println("Enter DVD category: ");
		String category = input.nextLine();
		System.out.println("Enter DVD cost: ");
		float cost = input.nextFloat();
		input.nextLine();
		System.out.println("Enter DVD director: ");
		String director = input.nextLine();
		System.out.println("Enter DVD length: ");
		int length = input.nextInt();
		DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, director, cost, length);
		try {
			anOrder.addMedia(DVD);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		String ask;
        do {
            System.out.printf("***\tDo you want to play ? (yes or no): ");
            ask = input.nextLine();
            switch (ask) {
                case "yes":
                    System.out.println("===============================");
				    DVD.play();
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Invalid selection");
            }
        } while (ask.equalsIgnoreCase("yes") == false && ask.equalsIgnoreCase("no") == false);
		
		input.close();
	}
	
	public void addCDToOrder (Order anOrder) throws PlayerException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter CD id: ");
		id = input.nextInt();
		input.nextLine();
		System.out.println("Enter CD title: ");
		String title = input.nextLine();
		System.out.println("Enter CD category: ");
		String category = input.nextLine();
		System.out.println("Enter CD cost: ");
		float cost = input.nextFloat();
		input.nextLine();
		System.out.println("Enter CD director: ");
		String director = input.nextLine();
		System.out.println("Enter CD artist: ");
		String artist = input.nextLine();
		CompactDisc CD = new CompactDisc(id, title, category, director, artist, cost);
		try {
			anOrder.addMedia(CD);
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
		int numbersTrack;
		System.out.println("Enter length track: ");
		numbersTrack = input.nextInt();
		String titleTrack;
		int lengthTrack;
		for (int i = 0; i < numbersTrack; i++) {
			System.out.println("Track: " + (i+1));
			System.out.println("Enter track title: ");
			titleTrack = input.nextLine();
			System.out.println("Enter track length: ");
			lengthTrack = input.nextInt();
			input.nextLine();
			Track track = new Track(titleTrack, lengthTrack);
			CD.addTrack(track);
		}
		
		String ask;
        do {
            System.out.printf("***\tDo you want to play ? (yes or no): ");
            ask = input.nextLine();
            switch (ask) {
                case "yes":
                    System.out.println("===============================");
				    	CD.play();
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Invalid selection");
            }
        } while (ask.equalsIgnoreCase("yes") == false && ask.equalsIgnoreCase("no") == false);
		input.close();
	}
	
	public void DeleteItemById (Order anOrder) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter id: ");
		id = input.nextInt();
		anOrder.removeMedia(id);
		input.close();
	}
	
	
	
	private boolean checkOrder(Order order) {
        for(Media media: order.itemsOrdered) {
            if(media.getCost() <= order.totalCost()*thresholdsSale)
                return true;
        }
        return false;
    }
	
	public Media getALuckyItem() throws LuckyItemException{
        if(itemsOrdered.size() >= numberOfOrder && this.totalCost() >= thresholdsTotal) {
            if(checkOrder(this)) {
                int item = 0;
                do {
                    double rand = Math.random();
                    rand *= itemsOrdered.size();
                    item = (int)rand;
                } while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
                return itemsOrdered.get(item);
            } else {
                throw new LuckyItemException("All items are larger than the gift threshold ("+ totalCost()*thresholdsSale+")");
            }
        } else {
            throw new LuckyItemException("Not eligible for lucky products\nProduct number >= " + numberOfOrder + "\nTotal order >= " + thresholdsTotal);
        }
    }
	
	
}

