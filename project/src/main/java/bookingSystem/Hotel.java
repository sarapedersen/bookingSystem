package bookingSystem;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import minegenkode.button;

import java.time.LocalDate;
import java.time.Month;

//Klasse for å holde styr på tilstanden til de forskjellige rommene og lagring av data. 
//(Når det gjøres en reservasjon vil dataene havne her?) 


public class Hotel extends Application{
	private static Room standard;
	private Room juniorSuite;
	private Room suite;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hotell Eclipse");
		primaryStage.setScene(new Scene(FXMLLoader.load(Hotel.class.getResource("bookingSystemGUI.fxml"))));
		primaryStage.show();
//		titleRoom1.setText();
		
		
	}
	
	public static void main(String[] args) {
		standard = new Room("Standardrom", 2, 1000, "maks antall gjester: 3 voksne\r\n"
				+ "sengetype: to enkeltsenger eller én dobbelseng\r\n"
				+ "størrelse: 24 m²");
		
		Hotel.launch(args);
		
//		Reservation r1 = new Reservation("Sara", 22, 2, 4, standard, LocalDate.of(2021, Month.MARCH, 20));
//		System.out.println(r1.toString());
		
		
	}



	
	
	
	
	
	
	
}
