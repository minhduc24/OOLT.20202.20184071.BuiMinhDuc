package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        DigitalVideoDisc d1 = new DigitalVideoDisc("bnehiennha","cochuchim","danhkhac",35,18.75f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("xinchao","cacban","lamsao",100,50.45f);
        swap(jungleDVD, cinderellaDVD);
        //System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        //System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        //changeTitle(jungleDVD, cinderellaDVD.getTitle());
        //System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        mySwap(d1, d2);
        System.out.println("dvd 1: "+d1.getTitle() +" "+d1.getCategory()+" "+d1.getDirector()+" "+d1.getLength()+":"+d1.getCost());
        System.out.println("dvd 2: "+d2.getTitle() +" "+d2.getCategory()+" "+d2.getDirector()+" "+d2.getLength()+":"+d2.getCost());

    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void mySwap(Object o1, Object o2) {
        DigitalVideoDisc d1 = (DigitalVideoDisc) o1;
        if (d1 != null) {
            DigitalVideoDisc d2 = (DigitalVideoDisc) o2;
        String tmp = d1.getTitle();
        d1.setTitle(d2.getTitle());
        d2.setTitle(tmp);
        tmp = d1.getCategory();
        d1.setCategory(d2.getCategory());
        d2.setCategory(tmp);
        tmp = d1.getDirector();
        d1.setDirector(d2.getDirector());
        d2.setDirector(tmp);
        int tmp1 = d1.getLength();
        d1.setLength(d2.getLength());
        d2.setLength(tmp1);
        float tmp2 = d1.getCost();
        d1.setCost(d2.getCost());
        d2.setCost(tmp2);
        }
    }
}
