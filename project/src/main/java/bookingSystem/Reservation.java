package bookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
	private String regName;
	private int regAge;
	private int adults; 
	private int children;
	private int nights;
	private Room room;
	
//	public Reservation(String regName, int regAge, int adults, int children, int nights, Room room) {
//		this.regName = regName;
//		this.regAge = regAge;
//		this.adults = adults;
//		this.children = children;
//		this.nights = nights;
//		this.room = room;
//	
//	}
	
	public void checkIn(LocalDate date, int days) {
		if (!date.isBefore(LocalDate.now()) && this.room.isAvailable(date, days)) {					//ved gyldig dato:
			for (int i= 0; i < days; i++) {
				this.room.calendar.add(date.plusDays(i));		//legg inn datoene i rommets kalender
			}
		} else {
			throw new IllegalArgumentException("Rommet er ikke ledig eller ugyldig dato!");
		}
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public int getRegAge() {
		return regAge;
	}

	public void setRegAge(int regAge) {
		isValidAge(regAge);
		this.regAge = regAge;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	
	public boolean isValidAge(int age) {
		return age >= 18 && age <= 100;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
