/**
 * MyDate
 */
import java.time.LocalDate;
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

        if ( day> 0 && day < 32 && month > 0 && month < 13 && year >= 0){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else if(month <= 0 || month > 12){
                System.out.println("Month Error!!!");
            }
        else if(year < 0){
                System.out.println("Year Error!!!");
            }
        else if(day<=0 || day > getDayOfMonth(month, year)){
                System.out.println("Day Error!!!");
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
        System.out.println("Date: " + this.month + " // " + this.day + " // " + this.year);
    }
}
