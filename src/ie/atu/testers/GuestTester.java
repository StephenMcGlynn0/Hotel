package ie.atu.testers;

import java.util.ArrayList;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class GuestTester {

	public static void main(String[] args) {
		//Guest test = new Guest("Steve", "0838522618", "s@gmail.com", new CreditCard(1111222233334444L, new Date(8,1,2002), 111));
		Guest homie = new Guest(new Name("Mr", "cтепан", "бренданович"), "087 1234567", "homer.simpson@atu.ie", new CreditCard(1111222233334444L, new Date(31,12,2027), 111));
		Guest marge = new Guest(new Name("Dr", "Данило", "Поребняк"), "086 1234567", "marge.simpson@atu.ie", new CreditCard(5555666677778888L, new Date(31,12,2024), 222));
		Guest lisa = new Guest(new Name("Miss", "Lisa", "Simpson"), "087 9876543", "lisa.simpson@atu.ie", new CreditCard(5555666677778888L, new Date(31,3,2024), 333));
		//lisa.read();
		
		ArrayList<Guest> guests = new ArrayList<Guest>();
		guests.add(homie);
		guests.add(marge);
		guests.add(lisa);
		
		int mCount=0;
		int fCount=0;
		
		System.out.println("LIST OF GUESTS");
		
		for(Guest g:guests) {
			System.out.println(g);
			if (g.getName().isFemale()) {
				fCount++;
			}else {
				mCount++;
			}
		}
		
		System.out.println("\nMALE/FEMALE GUEST COUNT\n" + mCount + " MALE(S), " + fCount + " FEMALE(S).");
		
		System.out.println("\nGUEST CREDIT CARD DETAILS");
		for(Guest g:guests) {
			System.out.println(g.getName() + " " + g.getCard());
		}
		
		 

	}

}
