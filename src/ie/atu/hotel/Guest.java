package ie.atu.hotel;

import java.util.Scanner;

public class Guest extends Person {
	private String emailAddress;
	private CreditCard card;
	
	public Guest() {
		super();
		this.emailAddress = "";
		this.card = null;
	}
	
	public Guest(Name name, String phoneNumber, String emailAddress, CreditCard card) {
		super(name, phoneNumber);
		this.emailAddress = emailAddress;
		this.card = card;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public CreditCard getCard() {
		return card;
	}
	
	public void setCard(CreditCard newCard) {
		this.card = newCard;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + emailAddress; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Guest)) {
			return false;
		}
		Guest guestToCompare = (Guest) obj;
		return super.equals(guestToCompare) &&
				guestToCompare.emailAddress.equals(this.emailAddress) &&
				guestToCompare.card.equals(this.card);
			   
	}
	
	@Override
	public void read() {
		Scanner scanner = new Scanner(System.in);
		super.read();
		System.out.print("Enter Email Address: ");
		this.emailAddress = scanner.nextLine();
		card.read();
		
		scanner.close();
		
	}
	
	
	
	//dadedadeda its the motherfucking d,o double g
}
