package ie.atu.hotel;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        day = 0;
        month = 0;
        year = 0;
    }

    public Date(int d, int m, int y) {
        setDay(d);
        setMonth(m);
        setYear(y);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws IllegalArgumentException  {
        if(day < 1 || day > 31) {
        	throw new IllegalArgumentException("Invalid Day\n");
        }
        this.day=day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws IllegalArgumentException {
    	if(month < 1 || month > 12) {
        	throw new IllegalArgumentException("Invalid month\n");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
    	if(year < 1900) {
        	throw new IllegalArgumentException("Invalid year\n");
        }
 
        this.year = year;
    }

    public String toString() {
        return day + "-" + month + "-" + year;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Date))
            return false;

        Date dateToCompare = (Date) obj;

        return this.day == dateToCompare.day
                && this.month == dateToCompare.month
                && this.year == dateToCompare.year;
    }
    
    public void read() {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter Day:");
    	int day = scan.nextInt();
    	//setDay(scan.nextInt());
    	System.out.print("Enter Month:");
    	int month = scan.nextInt();
    	//setMonth(scan.nextInt());
    	System.out.print("Enter Year:");
    	int year = scan.nextInt();
    	//setYear(scan.nextInt());
    	setDay(day);
    	setMonth(month);
    	setYear(year);
    	
    
    }
}
