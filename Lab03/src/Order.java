 /**
  * Order
  */

 public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyORDERED;

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


