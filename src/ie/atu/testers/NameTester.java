package ie.atu.testers;

import ie.atu.hotel.*;
import java.util.ArrayList;

public class NameTester {

	public static void main(String[] args) {
		Name name1 = new Name("Mr", "Lova", "Lova");
		Name name2 = new Name();
		System.out.println(name1);
		System.out.println(name2 + "yuppers");
		name2.setTitle("Mrs");
		name2.setFirstName("Homer");
		name2.setSurname("Simpson");
		System.out.println(name2);
		System.out.println(name1.isFemale() + "  " + name2.isFemale());
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(name1);
		names.add(name2);
		
		for(Name n:names) {
			System.out.println(n);
		}
	}
}
