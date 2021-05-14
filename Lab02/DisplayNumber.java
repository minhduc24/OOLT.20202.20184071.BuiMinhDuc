import java.util.Scanner;
public class DisplayNumber {

    
  public static void main(String[] strings) {
        
        Scanner input = new Scanner(System.in);

        int number_Of_DaysInMonth = 0; 
        String MonthOfName = "Unknown";

        System.out.print("Input a month number: ");
        String month = input.nextLine();

        System.out.print("Input a year: ");
        String year = input.nextLine();

        int i = year.length();
        int k = Integer.parseInt(year);
        while (i < 4 || k <= 0)  {
            System.out.println("Re-Input a year: ");
            year = input.nextLine();
            i = year.length();
            k = Integer.parseInt(year);
        }

        //Thang 1
        if (month.equals("1") || month.equals("Jan") || month.equals("Jan.") || month.equals("January")) {
            MonthOfName = "January";
            number_Of_DaysInMonth = 31;
        }

        //Thang 2
        else if (month.equals("2") || month.equals("Feb") || month.equals("Feb.") || month.equals("February")) {
            MonthOfName = "February";
                if ((Integer.parseInt(year) % 400 == 0) || ((Integer.parseInt(year) % 4 == 0) && (Integer.parseInt(year) % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
        }

        //Thang 3
        else if (month.equals("3") || month.equals("Mar") || month.equals("Mar.") || month.equals("March")) {
            MonthOfName = "March";
            number_Of_DaysInMonth = 31;
        }

        //Thang 4
        else if (month.equals("4") || month.equals("Apr") || month.equals("Apr.") || month.equals("April")) {
            MonthOfName = "April";
            number_Of_DaysInMonth = 30;
        }

        //Thang 5
        else if (month.equals("5") || month.equals("May.") || month.equals("May")) {
            MonthOfName = "May";
            number_Of_DaysInMonth = 31;
        }

        //Thang 6
        else if (month.equals("6") || month.equals("Jun") || month.equals("Jun.") || month.equals("June")) {
            MonthOfName = "June";
            number_Of_DaysInMonth = 30;
        }

        //Thang 7
        else if (month.equals("7") || month.equals("Jul") || month.equals("Jul.") || month.equals("July")) {
            MonthOfName = "July";
            number_Of_DaysInMonth = 31;
        }

        //Thang 8
        else if (month.equals("8") || month.equals("Aug") || month.equals("Aug.") || month.equals("August")) {
            MonthOfName = "August";
            number_Of_DaysInMonth = 31;
        }

        //Thang 9
        else if (month.equals("9") || month.equals("Sep") || month.equals("Sep.") || month.equals("September")) {
            MonthOfName = "September";
            number_Of_DaysInMonth = 30;
        }

        //Thang 10
        else if (month.equals("10") || month.equals("Oct") || month.equals("Oct.") || month.equals("October")) {
            MonthOfName = "October";
            number_Of_DaysInMonth = 31;
        }

        //Thang 11
        else if (month.equals("11") || month.equals("Nov") || month.equals("Nov.") || month.equals("November")) {
            MonthOfName = "November";
            number_Of_DaysInMonth = 30;
        }

        //Thang 12
        else if (month.equals("12") || month.equals("Dec") || month.equals("Dec.") || month.equals("December")) {
            MonthOfName = "December";
            number_Of_DaysInMonth = 31;
        }

        System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");

        input.close();
    }
}