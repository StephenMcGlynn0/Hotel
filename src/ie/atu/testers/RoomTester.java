//Stephen McGlynn

package ie.atu.testers;

import java.util.ArrayList;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Employee;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;
import ie.atu.hotel.Person;
import ie.atu.hotel.Room;

public class RoomTester {

	public static void main(String[] args) {

		ArrayList<Room> rooms = new ArrayList<Room>();
		try {
			// for loop to add double rooms
			for (int i = 1; i <= 5; i++) {
				rooms.add(new Room(i, "DOUBLE", 160, false));
			}
			// for loop to add king rooms
			for (int i = 6; i <= 10; i++) {
				rooms.add(new Room(i, "KING", 185, false));
			}
			// for loop to add king rooms
			for (int i = 11; i <= 13; i++) {
				rooms.add(new Room(i, "FAMILY", 210, false));
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Room Price Or Type Entered\n" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong creating the rooms\n" + e.getMessage());
		}

		// display all rooms
		for (Room r : rooms) {
			System.out.println(r);
		}

		// display all family rooms and count them
		System.out.println("\nFAMILY ROOM LIST");
		int familyRoomCount = 0;
		for (Room r : rooms) {
			if (r.getRoomType().toLowerCase().equals("family")) {
				System.out.println(r);
				familyRoomCount++;
			}
		}
		System.out.println(familyRoomCount + " FAMILY ROOM(S)\n");

		// use the reserve method on first available family room
		for (Room r : rooms) {
			if (r.getRoomType().toLowerCase().equals("family")) {
				r.reserve();
				break;
			}
		}

		// display all family rooms and count them
		System.out.println("\n\nFAMILY ROOM LIST");
		for (Room r : rooms) {
			if (r.getRoomType().toLowerCase().equals("family")) {
				System.out.println(r);
			}
		}
		
		//create a polymorphic aray list that can take Employee and Guest
		ArrayList<Person> peopleInHotel = new ArrayList<Person>();
		Guest homer = new Guest(new Name("Mr", "Homer", "Simpson"), "087 1234567", "homer.simpson@atu.ie", new CreditCard(1111222233334444L, new Date(31,12,2027), 111));
		Employee emp1 = new Employee(new Name("Ms", "Faye", "McGuire"),"087 1234567", new Date(12,10,2020), new Date(12,10,2020),24000.0);
		peopleInHotel.add(homer);
		peopleInHotel.add(emp1);
	}

}
