package bookingSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookingApp extends Application{

	public void start(Stage stage) throws Exception {
		stage.setTitle("Hotell Eclipse");
		stage.setScene(new Scene(FXMLLoader.load(BookingApp.class.getResource("bookingSystemGUI.fxml"))));
		stage.show();
		
	}
	
	public static void main(String[] args) {
		BookingApp.launch(args);
	}
}
