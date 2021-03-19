package bookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private String title;
	private int beds;
	private double pricePerNight;
	private String description;
	protected List<LocalDate> calendar = new ArrayList<>();
	
	public Room(String title, int beds, double pricePerNight, String description) {
		this.title = title;
		this.beds = beds;
		this.pricePerNight = pricePerNight;
		this.description = description;
	}
	
	public Room() {
	}
	
	//Det her må kunne skrives enklere!
	
	public boolean isAvailable(LocalDate date, int days) {
		List<LocalDate> dates = new ArrayList<>();
		for (int i= 0; i < days; i++) {
			dates.add(date.plusDays(i));
		}
		
		List<LocalDate> retainedList = dates;	
		retainedList.retainAll(this.calendar);
		
		if (retainedList.isEmpty()) {
			 return true;
		}
		
		return false;
	}
	
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
	

	
	
}
