package ie.atu.testers;

import java.util.Scanner;

import ie.atu.hotel.Date;

public class DateTester {

	public static void main(String[] args) {
		Date myDate1 = new Date();
		boolean valid = false;
		do {
			try {
				Scanner scan = new Scanner(System.in);
				myDate1.read();
				System.out.print(myDate1);
				valid=true;
			}catch(IllegalArgumentException e) {
				System.out.println("Invalid Date Entered, Try Again");
			}
		}while(!valid);

	}

}
