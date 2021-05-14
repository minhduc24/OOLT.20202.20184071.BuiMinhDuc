package hust.soict.hedspi.aims.utils;
/**
 * MyDate
 */
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate() {
        this.day = LocalDate.now().getDayOfMonth();
        this.month = LocalDate.now().getMonthValue();
        this.year = LocalDate.now().getYear(); 
    }
    public MyDate(int day, int month, int year) {

        if (month >= 1 && month <= 12 && year >= 0 && day>=1 && day <= getDayOfMonth(month,year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            if(month <= 0 || month > 12){
                System.out.println("Error Month!!!");
            }
            if(year < 0){
                System.out.println("Error Year!!!");
            }
            if(day<=0 || day > getDayOfMonth(month, year)){
                System.out.println("Error Day!!!");
            }
        }
    }
 
    public MyDate(String strDate) {
        int[] Date = checkDate(strDate); // format dd-mm-yyyy
        if(Date != null){
            this.month = Date[0];
            this.day = Date[1];
            this.year = Date[2];
        }
    }

    private int[] checkDate(String strDate) {
        int err = 0;
        String[] tmp = strDate.split(" ");
        String month = tmp[0];
        String day = tmp[1];
        String year = tmp[2];
        int m = checkValueMonth(month);
        if(m == 0){
            System.out.println("Month Error !!!");
            err = 1;
        }
        int y = 0;
        if(checkStringIsNumber(year)) {
            y = Integer.parseInt(year);
            if(y < 0) {
                System.out.println("Year Error !!!");
                err = 1;
            }
        }
        else {
            System.out.println("Error Year");
            err = 1;
        }
        int d = valueDay(day);
        if(d == 0) {
            System.out.println("Error Day!");
            err = 1;
        }
        if(err == 0) {
            if(d <= getDayOfMonth(m,y)) {
                int []date = new int[3];
                date[0] = m;
                date[1] = d;
                date[2] = y;
                return date;
            }
            else {
                System.out.println("Error Date");
                return null;
            }
        }
        else {
            return null;
        }
    }
    private int checkValueMonth(String month) {

        String m = month.toLowerCase();
        if (checkStringIsNumber(month) && Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {
            return Integer.parseInt(month);
        }
        if(m.equals("january") || m.equals("jan.") || m.equals("jan")) {
            return 1;
        }       
        else if (m.equals("february") || m.equals("feb.") || m.equals("feb")) {
            return 2;
        }
        else if (m.equals("march") || m.equals("mar.") || m.equals("mar")) {
            return 3;
        }
        else if (m.equals("april") || m.equals("apr.") || m.equals("apr")) {
            return 4;
        }
        else if (m.equals("may")) {
            return 5;
        }
        else if (m.equals("june") || m.equals("jun")) {
            return 6;
        }
        else if (m.equals("july") || m.equals("jul")) {
            return 7;
        }
        else if (m.equals("august") || m.equals("aug.") || m.equals("aug")) {
            return 8;
        }
        else if (m.equals("september") || m.equals("sep.") || m.equals("sep")) {
            return 9;
        }
        else if (m.equals("october") || m.equals("oct.") || m.equals("oct")) {
            return 10;
        }
        else if (m.equals("november") || m.equals("nov.") || m.equals("nov")) {
            return 11;
        }
        else if (m.equals("december") || m.equals("dec.") || m.equals("dec")) {
            return 12;
        }
        else 
            return 0;
    }

    private boolean checkStringIsNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private int valueDay(String day) {

        String dayFormat;
        int date;
        if (checkStringIsNumber(day)) {
            date = Integer.parseInt(day);
        } 
        else {
            dayFormat = day.substring(day.length() - 2).toLowerCase();
            if (dayFormat.equals("st") || dayFormat.equals("nd") || dayFormat.equals("rd") || dayFormat.equals("th")) {
                day = day.substring(0, day.length() - 2);
            }
            if (checkStringIsNumber(day)) {
                date = Integer.parseInt(day);
            } 
            else 
                return 0;    
        }
        if(date >= 1 && date <= 31)
            return date;
        else
            return 0;
    }

    private int getDayOfMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 2 && year % 4 == 0) {
            return 29;
        } else if (month == 2 && year % 4 != 0) {
            return 28;
        }
        else
            return 30;
    }

    public void accept() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the date: ");
        String strDate = input.nextLine();
        int []date = checkDate(strDate);
        if(date != null){
            this.month = date[0];
            this.day = date[1];
            this.year = date[2];
        }
        input.close();
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if(day >= 1 && day <= 31)
            this.day = day;
        else {
            System.out.println("Day Error !!!");
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Month Error !!!");
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if(year >=0 )
            this.year = year;
        else {
            System.out.println("Year Error !!!");
        }
    }

    public void print() {
        System.out.println("Date: " + this.month + " / " + this.day + " / " + this.year);
    }

    static String[][] dayStr = {
        {"first", "1"}, {"second", "2"}, {"third", "3"}, {"fourth", "4"}, {"fifth", "5"},
        {"sixth", "6"}, {"seventh", "7"}, {"eighth", "8"}, {"ninth", "9"}, {"tenth", "10"},
        {"eleventh", "11"}, {"twelfth", "12"}, {"thirteenth", "13"}, {"fouterteenth", "14"},
        {"fifteenth", "15"}, {"sixteenth", "16"}, {"seventeeth", "17"}, {"eighteenth", "18"},
        {"nineteenth", "19"},{"twentieth", "20"}, {"twenty-first", "21"},{"twenty-second", "22"},
        {"twenty-third", "23"}, {"twenty-fourth", "24"}, {"twenty-fifth", "25"}, {"twenty-sixth", "26"},
        {"twenty-seventh", "27"}, {"twenty-eighth", "28"}, {"twenty-ninth", "29"},{"thirtieth", "30"},{"thirty-first", "31"},
    };

    static String[] monthStr = {
        "January", "February", "March", "April", "May", "June","July", "August", "September","October", "November", "December"
    };

    static String[] yearStr = {
        "nineteen ninety one", "nineteen ninety two", "nineteen ninety three", "nineteen ninety four", 
        "nineteen ninety five", "nineteen ninety six", "nineteen ninety seven", "nineteen ninety eight", "nineteen ninety nine",
        "two thousand", "two thousand and one", "two thousand and two", "two thousand and three", "two thousand and four",
        "two thousand and five", "two thousand and six", "two thousand and seven", "two thousand and eight", "two thousand and nine",
        "two thousand and ten", "twenty eleven", "twenty twelse", "twenty thirteen", "twenty fourteen", "twenty fifteen",
        "twenty sixteen", "twenty seventeen", "twenty eighteen", "twenty nineteen", "twenty twenty", "twenty twenty one", 
    };

    private void convertDay (String day) {
        for (int i = 0; i < 31; i++) {
            if (day.equalsIgnoreCase(dayStr[i][0])) {
                this.day = Integer.parseInt(dayStr[i][1]);
            }
        }
    }

    private void convertMonth(String month) {
        for (int i = 0; i < monthStr.length; i++) {
            if (month.equalsIgnoreCase(monthStr[i])) {
                this.month = i + 1;
            }
        }
    }

    private void convertYear(String year) {
		for(int i = 0; i < 22; i++) {
			if(year.equalsIgnoreCase(yearStr[i]))
				this.year = i + 1991;
		}
	}


    public MyDate(String day, String month, String year) {
        convertDay(day);
        convertMonth(month);
        convertYear(year);
    }

    public void printCurrentDate() {
        MyDate date = new MyDate();
        String month = new String(); 
        date.getMonth();
            if (date.getMonth() == 1) {
                month = "January";
            }
            else if (date.getMonth() == 2) {
                month = "February";
            }
            else if (date.getMonth() == 3) {
                month = "March";
            }
            else if (date.getMonth() == 4) {
                month = "April";
            }
            else if (date.getMonth() == 5) {
                month = "May";
            }
            else if (date.getMonth() == 6) {
                month = "June";
            }
            else if (date.getMonth() == 7) {
                month = "July";
            }
            else if (date.getMonth() == 8) {
                month = "August";
            }
            else if (date.getMonth() == 9) {
                month = "September";
            }
            else if (date.getMonth() == 10) {
                month = "October";
            }
            else if (date.getMonth() == 11) {
                month = "November";
            }
            else if (date.getMonth() == 12) {
                month = "December";
            }
        
        if(date.getDay() == 1 || date.getDay() == 21 || date.getDay() == 31)
            System.out.println("Today is: " + month + " " + date.day + "st " + date.year);
        else if(date.getDay() == 2 || date.getDay() == 22)
            System.out.println("Today is " + month + " " + date.day + "nd " + date.year);
        else if(date.getDay() == 3 || date.getDay() == 23)
            System.out.println("Today is: " + month + " " + date.day + "rd " + date.year);
        else
            System.out.println("Today is: " + month + " " + date.day + "th " + date.year);
    }

    public void chooseFormat() {
        Calendar date = Calendar.getInstance();
        String dateFormat;
        int choose;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter choose:  ");
        System.out.printf("1. yyyy-MM-dd\n2. d/M/yyyy\n3. dd-MMM-yyyy\n4. MMM d yyyy\n 5. mm-dd-yyyy");
        choose = input.nextInt();
        dateFormat = switch (choose) {
            case 1 -> "yyyy-MM-dd";
            case 2 -> "d/M/yyyy";
            case 3 -> "dd-MMM-yyyy";
            case 4 -> "MMM d yyyy";
            case 5 -> "MM-dd-yyyy";
            default -> "MMMM dd yyyy";
        };

        SimpleDateFormat spf = new SimpleDateFormat(dateFormat);
        System.out.println(spf.format(date.getTime()));
        input.close();
    }
}
