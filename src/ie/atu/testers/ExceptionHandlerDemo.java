package ie.atu.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class ExceptionHandlerDemo {
	
	public static void main(String args[]) {
		ArrayList<Guest> hotelGuests = new ArrayList<>();
		Guest homie = new Guest(new Name("Mr", "cтепан", "бренданович"), "087 1234567", "homer.simpson@atu.ie", new CreditCard(1111222233334444L, new Date(31,12,2027), 111));
		Guest marge = new Guest(new Name("Dr", "Данило", "Поребняк"), "086 1234567", "marge.simpson@atu.ie", new CreditCard(5555666677778888L, new Date(31,12,2024), 222));
		Guest lisa = new Guest(new Name("Miss", "Lisa", "Simpson"), "087 9876543", "lisa.simpson@atu.ie", new CreditCard(5555666677778888L, new Date(31,3,2024), 333));
		
		hotelGuests.add(homie);
		hotelGuests.add(marge);
		hotelGuests.add(lisa);
		
		int guestNum=-1;
		boolean valid=false;
		while(!valid) {
			try {
				String guestNumberToViewAsString = JOptionPane.showInputDialog(null,
						"Enter Guest To View (" + 1 + " to " + hotelGuests.size() + ")");
				
				
				if(guestNumberToViewAsString == null || guestNumberToViewAsString.length() == 0) {
					return;
				}
				guestNum = Integer.parseInt(guestNumberToViewAsString)-1;
				System.out.println(hotelGuests.get(guestNum));
				valid=true;

			}catch(NumberFormatException e) {
				System.out.print(e.getMessage());
			}
			catch(IndexOutOfBoundsException e) {
				System.out.print(e.getMessage());
			}
		}
		
		
	}
	
	
}
