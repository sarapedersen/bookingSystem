package bookingSystem;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.time.LocalDate;
//import java.time.Month;

//Klasse for å holde styr på tilstanden til de forskjellige rommene og lagring av data. 
//(Når det gjøres en reservasjon vil dataene havne her?) 


public class Hotel extends Application{
	public static Room standard;
	public static Room superior;
	public static Room premium;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hotell Eclipse");
		primaryStage.setScene(new Scene(FXMLLoader.load(Hotel.class.getResource("bookingSystemGUI.fxml"))));
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		Hotel.launch(args);
		
		standard = new Room("Standardrom", 2, 1049);
		superior = new Room("Superior-rom", 4, 1495);
		premium = new Room("Premium-rom", 4, 1749);
		

		
		List<Room> romtyper = new ArrayList<>();
		romtyper.add(standard);
		romtyper.add(superior);
		romtyper.add(premium);
		
//		List<Room> filtrert =												Bare testing av streams?
//				romtyper.stream()
//				.filter(Room -> Room.getPricePerNight() < 1500)
//				.collect(Collectors.toList());
//		System.out.println(filtrert);
				
		
//		Reservation r1 = new Reservation("Sara", 22, 2, 4, standard, LocalDate.of(2021, Month.MARCH, 20));    //Test av konstruktør
		
		
		
	}



	
	
	
	
	
	
	
}
