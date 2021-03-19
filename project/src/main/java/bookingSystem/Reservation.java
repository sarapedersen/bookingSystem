package bookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
	private String regName;
	private int regAge;
	private int persons;
	private int nights;
	private Room room;
	
	public Reservation(String regName, int regAge, int persons, int nights, Room room, LocalDate checkInDate) {
		validAgeCheck(regAge);
		this.regName = regName;
		this.regAge = regAge;
		this.persons = persons;
		this.nights = nights;
		this.room = room;
		checkIn (checkInDate, nights);
	
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

	
	public void validAgeCheck(int age) {
		if (age < 18 || age > 100) {
			throw new IllegalArgumentException("Ugyldig alder! Du må være minst 18 år for å legge inn en reservasjon");
		}
	}
	
//	@Override
//	public String toString() {
//		return String.format("Navn: %s, Alder: %d, Antall personer: %d, Antall netter: %d, rom: ", regName, regAge, nights, persons);
//	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
