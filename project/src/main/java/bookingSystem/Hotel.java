package bookingSystem;

import java.util.ArrayList;
import java.util.List;



//(Når det gjøres en reservasjon vil dataene havne her?) 

/**Klasse for å holde styr på tilstanden til de forskjellige rommene og lagring av data.
 * 
 * For utvidelese av bookingsystemet kunne det vært en tanke å ha et Hotell-interface som implementeres på de forskjellige hotellene
 * Slik at hvert hotell har en egen klasse.
 */
public class Hotel {
	public static Room standard = new Room("Standardrom", 2, 1049);
	public static Room superior = new Room("Superior-rom", 4, 1495);
	public static Room premium = new Room("Premium-rom", 4, 1749);
	public static List<Room> romtyper = new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		romtyper.add(standard);
		romtyper.add(superior);
		romtyper.add(premium);
		
	}



	
	
	
	
	
	
	
}
