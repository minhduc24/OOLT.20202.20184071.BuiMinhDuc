/**
 * Test
 */
public class DateTest {


        public static void main(String[] args) {

            MyDate Date1 = new MyDate("Third","February","twenty twenty");
            MyDate Date2 = new MyDate("First","May","twenty");
            MyDate Date3 = new MyDate("Second","January","twenty hundred");

            Date1.print();
            Date2.print();
            Date3.print();
            Date1.chooseFormat();
            MyDate[] dlist = {Date1,Date2,Date3};
            System.out.println("Before sort: ");
            DataUltils.printDate(dlist);
            DataUltils.sortingDate(dlist);
            System.out.println("after sort: ");
            DataUltils.sortingDate(dlist);


        }
}