package AimsProject.hust.soict.hedspi.aims.utils;

public class DataUtills {
    public static int compare(MyDate d1, MyDate d2) {
		if(d1.getYear() > d2.getYear()) {
			return 1;
		} else if (d1.getYear() < d2.getYear()) {
			return -1;
		} else {
			if (d1.getMonth() > d2.getMonth()) {
				return 1;
			} else if (d1.getMonth() < d2.getMonth()) {
				return -1;
			} else {
				if (d1.getDay() > d2.getDay()) {
					return 1;
				} else if (d1.getDay() < d2.getDay()) {
					return -1;
				} else return 0;
			}
		}
	}

    private static void swap (MyDate date[], int i, int j) {
        MyDate tmp = new MyDate();
        tmp.setDay(date[i].getDay());
		tmp.setMonth(date[i].getMonth());
		tmp.setYear(date[i].getYear());
		date[i].setDay(date[j].getDay());
		date[i].setMonth(date[j].getMonth());
		date[i].setYear(date[j].getYear());
		date[j].setDay(tmp.getDay());
		date[j].setMonth(tmp.getMonth());
		date[j].setYear(tmp.getYear());
    }

    public static void sortingDate(MyDate[] date) {
        for (int i = 0; i < date.length - 1; i++) {
            for (int j = i + 1; j < date.length; j++) {
                if(compare(date[i], date[j]) > 0) 
                    swap(date, i ,j);
            }
        }
    
    }

    public static void printDate(MyDate[] date) {
        for (int i=0; i<date.length; i++) {
			date[i].print();
		}
    }
}
