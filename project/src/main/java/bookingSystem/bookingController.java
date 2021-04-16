package bookingSystem;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;

public class bookingController implements Initializable{
	
	private Reservation reservation;
	
	public void setReservation(final Reservation reservation) {				//final? - prøver uten!
		this.reservation = reservation;
	}
	
	 @FXML
	    private AnchorPane checkInPane, roomPane, registrationPane;

	    @FXML
	    private Button btnFindRooms, btnBack, btnBack2, btnRegistration, btnCheckIn;

	    @FXML
	    private DatePicker checkInDate;

	    @FXML
	    private Spinner<Integer> peopleSpinner;

	    @FXML
	    private Spinner<Integer> nightsSpinner;

	    @FXML
	    private RadioButton btnRoom1, btnRoom2, btnRoom3;

	    @FXML
	    private Label txtFull;

	    @FXML
	    private TextArea txtReservation, txtPrice;
	    
	    @FXML
	    private TextField txtFornavn, txtEtternavn, txtAlder;

	

    
    public void checkInPaneShow() {
    	checkInPane.setVisible(true);
    	roomPane.setVisible(false);
    	registrationPane.setVisible(false);
    }
    
    public void roomPaneShow() {
    	checkInPane.setVisible(false);
    	roomPane.setVisible(true);
    	registrationPane.setVisible(false);
    }
    
    public void registrationPaneShow() {
    	reservation.caluculateTotalPrice();
    	roomPane.setVisible(false);
    	registrationPane.setVisible(true);
    	txtReservation.setText("Antall personer: " + reservation.getPeople() + "\nAntall netter: " 
    							+ reservation.getNights() + "\nDato for innsjekk: " + reservation.getDate()
    							+ "\nValgt rom: "+ reservation.getRoom());
    	txtReservation.setEditable(false);
    	txtPrice.setText(String.valueOf(reservation.getTotalPrice()));
    }

    
    /**
     * deaktiverer knappene på opptatte rom
     */
    public void handleUpdateRooms() {
    	
    	if (Hotel.standard.isAvailable(reservation.getDate(), reservation.getNights())) {
    		btnRoom1.disarm();
    	}
    	if (!Hotel.superior.isAvailable(reservation.getDate(), reservation.getNights())) {
    		btnRoom2.disarm();
    	}
    	if (!Hotel.premium.isAvailable(reservation.getDate(), reservation.getNights())) {
    		btnRoom3.disarm();
    	}
    	
    	if (!Hotel.standard.isAvailable(reservation.getDate(), reservation.getNights()) && 
    			!Hotel.superior.isAvailable(reservation.getDate(), reservation.getNights()) &&		//dersom ingen er ledig
    			!Hotel.premium.isAvailable(reservation.getDate(), reservation.getNights())) {		//vil det komme en melding 
    		txtFull.setVisible(true);
    	}
    	
    	else {
    		btnRoom1.arm();
    		btnRoom2.arm();
    		btnRoom3.arm();
    		txtFull.setVisible(false);
    	}
    	
    	final int people = peopleSpinner.getValue();
    	final int nights = nightsSpinner.getValue();
    	final LocalDate date = checkInDate.getValue();		//usikker på om det burde stå final her?
    	reservation.setPeople(people);
    	reservation.setNights(nights);
    	reservation.setCheckInDate(date);
    }
    
    public void handleChooseRoom() {
    	final ToggleGroup group = new ToggleGroup(); 
    	btnRoom1.setToggleGroup(group);
    	btnRoom1.setSelected(true);
    	btnRoom2.setToggleGroup(group);
    	btnRoom3.setToggleGroup(group);
    
    	if (btnRoom1.isSelected()) {
    		reservation.setRoom(Hotel.standard);} 
    	else if (btnRoom2.isSelected()) {
    		reservation.setRoom(Hotel.superior);}				
    	else if (btnRoom3.isSelected()) {
    		reservation.setRoom(Hotel.premium);
    	}
    	
//    	final int people = peopleSpinner.getValue();
//    	final int nights = nightsSpinner.getValue();
//    	final LocalDate date = checkInDate.getValue();		//usikker på om det burde stå final her?
//    	reservation.setPeople(people);
//    	reservation.setNights(nights);
//    	reservation.setCheckInDate(date);
//    	reservation.caluculateTotalPrice();
   
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkInPaneShow();
		reservation = new Reservation();
		setReservation(reservation);
		
		//Configure the Spinners with values 
		SpinnerValueFactory<Integer> peopleValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10, 1);
		SpinnerValueFactory<Integer> nightValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10, 1);
		this.peopleSpinner.setValueFactory(peopleValues);
		this.nightsSpinner.setValueFactory(nightValues);
		peopleSpinner.setEditable(true);
		nightsSpinner.setEditable(true);			//litt usikker på den her??
	}
	
	
}

