package ie.atu.hotel;

import java.util.Scanner;

public abstract class Person {
	protected Name name;
	protected String phoneNumber;
	
	public Person() {
		this.name=null;
		this.phoneNumber="";
	}
	
	public Person(Name name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return name + "\t" + phoneNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person compare = (Person) obj;
		return compare.name.equals(this.name) &&
			   compare.phoneNumber.equals(this.phoneNumber);
	}
	
	public void read() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter First Name: ");
		String fName = scanner.nextLine();
		System.out.print("Enter Surname: ");
		String sName = scanner.nextLine();
		name = new Name(title, fName, sName);
		System.out.print("Enter Phone Number: ");
		this.phoneNumber = scanner.next();
	
	}
	
	
}
