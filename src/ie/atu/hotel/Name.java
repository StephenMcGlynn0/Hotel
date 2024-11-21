package ie.atu.hotel;

import java.io.Serializable;

public class Name implements Serializable{
	private String title;
	private String firstName;
	private String surname;

	public Name() {
		this.title = "";
		this.firstName = "";
		this.surname = "";
	}

	public Name(String t, String fN, String sN) {
		this.title = t;
		this.firstName = fN;
		this.surname = sN;
	}
	
	@Override
	public String toString() {
		return this.title + " " + this.firstName + " " + this.surname;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setTitle(String t) {
		t = t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase();
		boolean valid = false;
		switch(t) {
			case "Mr":
				valid=true;
				break;
			case "Ms":
				valid=true;
				break;
			case "Mrs":
				valid=true;
				break;
			case "Miss":
				valid=true;
				break;
			case "Dr":
				valid=true;
				break;
		}
        if(valid)
        	this.title = t;
        else
        	System.out.print("invalid title entered");
		
	}
	
	public void setFirstName(String fN) {
		this.firstName = fN;
	}
	
	public void setSurname(String sN) {
		this.surname = sN;
	}
	
	public boolean isFemale() {
		if(title.equals("Ms") || title.equals("Mrs") || title.equals("Miss")) {
			return true;
		}
		return false;
	}
	
    @Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Name))
			return false;
		
		Name nameToCompare = (Name) obj;
		if ((title.equals(nameToCompare.title)) && (firstName.equals(nameToCompare.firstName))
				&& (surname.equals(nameToCompare.surname))) {
			return true;
		}
		return false;
	}

}
