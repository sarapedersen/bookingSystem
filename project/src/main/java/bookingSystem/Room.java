package bookingSystem;

public class Room {
	private int beds;
	private double pricePerNight;
	private int roomNumber;
	private int floorNumber;
	private boolean available;
	
	public int getBeds() {
		return beds;
	}
	
	public void setBeds(int beds) {
		if (beds > 0) {
			this.beds = beds;
		} else {
			throw new IllegalArgumentException("There must be at least one bed per room");
		}
	}
	
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		if (pricePerNight >= 0) {
			this.pricePerNight = pricePerNight;
		} else {
			throw new IllegalArgumentException("The price per night can not be negative!");
		}
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
