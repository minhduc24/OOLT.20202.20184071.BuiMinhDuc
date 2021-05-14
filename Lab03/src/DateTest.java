/**
 * Test
 */
public class DateTest {


        public static void main(String[] args) {

            MyDate myDate = new MyDate("November 11th 2020");
            myDate.print();
            MyDate myDate1 = new MyDate();
            myDate1.print();
            MyDate myDate2 = new MyDate(5,6,2000);
            myDate2.print();
            MyDate myDate3 = new MyDate();
            myDate3.accept();
            myDate3.print();
        }
}