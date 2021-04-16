package bookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private String title;
	private int beds;
	private int pricePerNight;
	protected List<LocalDate> calendar = new ArrayList<>();			//Rommets opptatte dager
	
	//teste konstruktør
	public Room(String title, int beds, int pricePerNight) {
		this.title = title;
		this.beds = beds;
		this.pricePerNight = pricePerNight;
	}
	
	public Room() {
	}
	
	/**Lager en liste av dagene i den valgte perioden og sjekker disse opp mot dagene i rommets kalender.
	 * Returnerer true hvis ingen av datoene kolliderer. Rommet er dermed ledig
	**/
	public boolean isAvailable(LocalDate date, int days) {
		List<LocalDate> dates = new ArrayList<>();
		for (int i= 0; i < days; i++) {
			dates.add(date.plusDays(i));					//lager en liste med alle dagene i perioden
		}
		
		List<LocalDate> retainedList = dates;	
		retainedList.retainAll(this.calendar);				//beholder kun dager som finnes i begge listene
		
		if (retainedList.isEmpty()) return true;	
															
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
	
	public int getPricePerNight() {
		return pricePerNight;
	}
	
	public void setPricePerNight(int pricePerNight) {
		if (pricePerNight >= 0) {
			this.pricePerNight = pricePerNight;
		} else {
			throw new IllegalArgumentException("The price per night can not be negative!");
		}
	}
	
	@Override
	public String toString() {
		return title;
	}

	
	
}
