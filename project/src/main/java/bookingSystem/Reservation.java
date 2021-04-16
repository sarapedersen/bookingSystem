package bookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
	private String regName;
	private int regAge;
	private int people;
	private int nights;
	private Room room;
	private LocalDate checkInDate;
	private int totalPrice;
	
//	public Reservation(String regName, int regAge, int people, int nights, Room room, LocalDate checkInDate) {
//		validAgeCheck(regAge);
//		this.regName = regName;
//		this.regAge = regAge;
//		this.people = people;
//		this.nights = nights;
//		this.room = room;
//		checkIn (checkInDate, nights);
//	}
	
	public Reservation() {}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}

	public int getNights() {
		return nights;
	}
	
	public void setNights(int nights) {
		this.nights = nights;
	}
	
	public void setCheckInDate(LocalDate date) {
		this.checkInDate = date;
	}
	
	public LocalDate getDate() {
		return checkInDate;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void checkIn(LocalDate date, int days) {
		if (!date.isBefore(LocalDate.now()) && this.room.isAvailable(date, days)) {					//ved gyldig dato:
			for (int i= 0; i < days; i++) {
				this.room.calendar.add(date.plusDays(i));		//legg inn datoene i rommets kalender
			}
		} else {
			throw new IllegalArgumentException("Rommet er ikke ledig eller ugyldig dato!");
		}
	}
	
	
	public String getRegName() {
		return regName;
	}


	public int getRegAge() {
		return regAge;
	}
	
	public void caluculateTotalPrice() {
		//hvis tallet går opp blir antall rom lik personer delt på senger
		//hvis ikke (altså % != 0) så skal antall rom bli lik (x%y) + (x/y)
		
		int numberOfRooms;
		int resten = this.getPeople() % this.getRoom().getBeds();
		int div = this.getPeople() / this.getRoom().getBeds();
		
		if (resten == 0) {
			numberOfRooms = this.getPeople() / this.getRoom().getBeds();
		}
		else {
			numberOfRooms = div + 1;
		}
//		System.out.println("Antall rom: " + numberOfRooms + " | resten: " + resten + " | div: " + div);
		this.setTotalPrice(numberOfRooms*this.getRoom().getPricePerNight()*this.getNights());
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setTotalPrice(int price) {
		this.totalPrice = price;
	}
	
	public void validAgeCheck(int age) {
		if (age < 18 || age > 100) {
			throw new IllegalArgumentException("Ugyldig alder! Du må være minst 18 år for å legge inn en reservasjon");
		}
	}
	
//	@Override
//	public String toString() {
//		return String.format("Navn: %s, Alder: %d, Antall personer: %d, Antall netter: %d, rom: ", regName, regAge, nights, people);
//	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	

	

}
