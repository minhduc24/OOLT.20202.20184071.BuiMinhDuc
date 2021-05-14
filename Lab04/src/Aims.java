/**
 * Aims
 */

public class Aims {
    public static void main(String[] args) {
        
        Order anOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        anOrder.addDigtalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);
        anOrder.addDigtalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        anOrder.addDigtalVideoDisc(dvd3);


        //anOrder.addDigtalVideoDisc(dvd2);
        //anOrder.addDigtalVideoDisc(dvd2);
        //anOrder.removeDigitalVideoDisc(dvd2);
        //anOrder.addDigtalVideoDisc(dvd2);


        //System.out.println("Total Cost is: ");
        //System.out.println(anOrder.totalCost());
        Order Order1 = Order.getOrder();
        Order Order2 = Order.getOrder();
        Order Order3 = Order.getOrder();
        Order Order4 = Order.getOrder();
        Order Order5 = Order.getOrder();
        Order Order6 = Order.getOrder();

        Order1.addDigtalVideoDisc(dvd1);
        if (Order1 != null) Order1.printOrderd();
        if (Order2 != null) Order2.printOrderd();
        if (Order3 != null) Order3.printOrderd();
        if (Order4 != null) Order4.printOrderd();
        if (Order5 != null) Order5.printOrderd();
        if (Order6 != null) Order6.printOrderd();

    }
}
