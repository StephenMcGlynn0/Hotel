/**
 Stephen McGlynn
 */
package ie.atu.hotel;

import java.text.DecimalFormat;

public class Room implements Reservable{
	private int roomNumber;
	private String roomType;
	private double pricePerNight;
   private boolean allocated;

	public Room(int roomNumber, String roomType, double pricePerNight, boolean allocated)throws IllegalArgumentException{
		if(pricePerNight < 100) {
			throw new IllegalArgumentException("Cannot have a room below 100 a night");
		}
		//check if room type is valid
		boolean validRoomType = false;
		if(roomType.toLowerCase().equals("double") || roomType.toLowerCase().equals("king") || roomType.toLowerCase().equals("family")) {
			validRoomType = true;
		}
		if(!validRoomType) {
			throw new IllegalArgumentException("Invalid room type");
		}
		
		this.roomNumber=roomNumber;
		this.roomType=roomType;
		this.pricePerNight=pricePerNight;
      this.allocated=false;
	}

	@Override
	public String toString() {
		DecimalFormat df=new DecimalFormat("#.00");

		return roomNumber + " " + roomType + " ROOM @ €" + df.format(pricePerNight) + " per night " + (allocated ? "BOOKED" : "FREE");
	}
	
	@Override
	public boolean equals(Object obj){
	   Room rObject;
	   if (obj instanceof Room)
		   rObject = (Room)obj;
	   else
	       return false;
	 
	   return this.roomNumber == (rObject.roomNumber);
	}

	public void setRoomNumber(int roomNumber){
		this.roomNumber=roomNumber;
	}
	public void setRoomType(String roomType){
		this.roomType=roomType;
	}
	public void setPricePerNight(double pricePerNight){
		this.pricePerNight=pricePerNight;
	}
	public void setAllocated(boolean allocated) {
		this.allocated=allocated;
	}
	public int getNumber() {
		return roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public boolean getAllocated() {
		return allocated;
	}

	@Override
	public void reserve() {
		if(!this.allocated) {
			this.allocated = true;
			System.out.print("Room " + this.roomNumber + " is reserved");
		}
		
	}

	@Override
	public void cancel() {
		if(this.allocated) {
			this.allocated = false;
			System.out.print("Room " + this.roomNumber + " is available");
		}
		
	}
}