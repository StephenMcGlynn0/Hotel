package ie.atu.hotel;
import java.util.Scanner;

public class CreditCard {
	private long number;
	private Date expiryDate;
	private int securtiyCode;

	public CreditCard(long number, Date expiry, int securityCode) {
		this.number = number;
		this.expiryDate = expiry;
		this.securtiyCode = securityCode;
	}

	@Override
	public String toString() {
		return "Card Number:" + this.number;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CreditCard)) {
			return false;
		}
		CreditCard cardToCompare = (CreditCard) obj;
		return cardToCompare.number == this.number && cardToCompare.expiryDate == this.expiryDate
				&& cardToCompare.securtiyCode == this.securtiyCode;

	}

	public long getNumber() {
		return number;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public int getSecurtiyCode() {
		return securtiyCode;
	}
	
	public void read() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Card Number:");
		long cardNum = scanner.nextLong();
		System.out.print("Enter Expiry Day:");
		int day = scanner.nextInt();
		System.out.print("Enter Expiry Month:");
		int month = scanner.nextInt();
		System.out.print("Enter Expiry Year:");
		int year = scanner.nextInt();
		Date expDate = new Date(day,month,year);
		System.out.print("Enter Security Code:");
		int code = scanner.nextInt();
		scanner.close();
		this.number = cardNum;
		this.expiryDate = expDate;
		this.securtiyCode = code;
	}

}
