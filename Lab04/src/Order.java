 /**
  * Order
  */

 public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyORDERED;
    private MyDate dateOrdered;
    private static int nbOrders = 0;
    Order(){
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
    
    public void printOrderd() {
        System.out.println("***********************Order***********************");
        System.out.println("date : ");
        dateOrdered.print();
        System.out.println("Ordered Items: ");
        for (int i = 0; i < qtyORDERED; i++) {
            System.out.println((i+1) + ".DVD - " + itemsOrdered[i].getTitle() + "-" + itemsOrdered[i].getCategory() + "-" +  itemsOrdered[i].getDirector() + "-" +  itemsOrdered[i].getLength() + ":"+ itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " +totalCost());
    }
    public void addDigtalVideoDisc(DigitalVideoDisc disc) {
        if (qtyORDERED < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyORDERED++] = disc;
            System.out.println("The disc has been added !!!");
        }
        else 
        {
            System.out.println("The order is almost full !!!");
        }
    }

    public void addDigtalVideoDisc( DigitalVideoDisc[] arr) {
        if (arr != null && qtyORDERED < MAX_NUMBER_ORDERED) {
            if (qtyORDERED + arr.length > MAX_NUMBER_ORDERED) {
                System.out.println("The list of items that cannot be added to the current order !!!");
            }
            else {
                for (int i = 0; i < arr.length; i++) {
                    itemsOrdered[qtyORDERED++] = arr[i];
                    System.out.println("The disc has been added !!!");
                }
            }
        }
        else {
            System.out.println("Error !!!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        if (qtyORDERED < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyORDERED++] = dvd1;
            if (qtyORDERED == MAX_NUMBER_ORDERED) {
                System.out.println("The dvd " + dvd2.getTitle( ) + " could not be added !!!");
            }
            else {
                itemsOrdered[qtyORDERED++] = dvd2;
            }
        }
        else {
            System.out.println("The item quantity has reached its limit !!!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyORDERED; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.out.println("Remove succesfully !!!");
                for (int j = i; j < qtyORDERED - 1; j++) {
                    index = 1;
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyORDERED--;
            }
        }
        if (index == -1) {
			System.out.println("The disc not found !!!");	
		}
    }
     

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < qtyORDERED; i++) {
            
            cost += itemsOrdered[i].getCost();
            
        }
        return cost;
    }

 }


