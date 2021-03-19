package bookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;

//Klasse for å holde styr på tilstanden til de forskjellige rommene og lagring av data. 
//(Når det gjøres en reservasjon vil dataene havne her?) 


public class Hotel {
	private static Room standard;
	private Room juniorSuite;
	private Room suite;
	
	public Hotel () {
		
	}
	
	public void init() {
		standard = new Room("Standardrom", 2, 1000, "maks antall gjester: 3 voksne\r\n"
				+ "sengetype: to enkeltsenger eller én dobbelseng\r\n"
				+ "størrelse: 24 m²");
	}
	
	
	public static void main(String[] args) {
		standard = new Room("Standardrom", 2, 1000, "maks antall gjester: 3 voksne\r\n"
				+ "sengetype: to enkeltsenger eller én dobbelseng\r\n"
				+ "størrelse: 24 m²");
		
		Reservation r1 = new Reservation();
		r1.setRoom(standard);
		r1.checkIn(LocalDate.of(2021, Month.MARCH, 20), 7);
		
		
	}
	
	
	
	
	
	
}
