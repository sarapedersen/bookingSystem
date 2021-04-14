package bookingSystem;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class bookingController implements Initializable{
	
	private Reservation reservation;
	
	public void setReservation(final Reservation reservation) {				//hvorfor final?
		this.reservation = reservation;
	}
	
	 @FXML
	    private AnchorPane checkInPane;

	    @FXML
	    private Button btnFindRooms;

	    @FXML
	    private DatePicker checkInDate;

	    @FXML
	    private Spinner<Integer> peopleSpinner;

	    @FXML
	    private Spinner<Integer> nightsSpinner;

	    @FXML
	    private AnchorPane roomPane;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private RadioButton btnRoom1;

	    @FXML
	    private RadioButton btnRoom2;

	    @FXML
	    private RadioButton btnRoom3;

	    @FXML
	    private Button btnRegistration;

	    @FXML
	    private Label txtFull;

	    @FXML
	    private AnchorPane registrationPane;

	    @FXML
	    private Button btnBack2;

	    @FXML
	    private TextArea txtReservation;

	    @FXML
	    private TextArea txtPrice;

	    @FXML
	    private Button btnCheckIn;
	    
	    @FXML
	    private TextField txtFornavn, txtEtternavn, txtAlder;


	
//	@FXML
//    private AnchorPane checkInPane;
//	
//    @FXML
//    private DatePicker checkInDate;
//    
//    @FXML
//    private Spinner<Integer> peopleSpinner, nightsSpinner;    
//    
//    @FXML
//    private AnchorPane roomPane;
//
//    @FXML
//    private RadioButton  btnRoom1, btnRoom2, btnRoom3;
//    
//    @FXML
//    private AnchorPane registrationPane;
//    
//    @FXML
//    private TextArea txtReservation, txtPrice;
//
//    @FXML
//    private Button btnFindRooms, btnBack, btnBack2, btnShowSummary,btnRegistration, btnCheckIn;
//
//    @FXML
//    private Label txtFull;
	
	

    
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
    	roomPane.setVisible(false);
    	registrationPane.setVisible(true);
    	txtReservation.setText("Antall personer: " + reservation.getPeople() + "\nAntall netter: " 
    							+ reservation.getNights() + "\nDato for innsjekk: " + reservation.getDate()
    							+ "\nValgt rom: "+ reservation.getRoom());
    	txtReservation.setEditable(false);
    }

    public void handleChooseRoom() {
    	final ToggleGroup group = new ToggleGroup(); 
    	btnRoom1.setToggleGroup(group);
    	btnRoom1.setSelected(true);
    	btnRoom2.setToggleGroup(group);
    	btnRoom3.setToggleGroup(group);
    	if (btnRoom1.isSelected()) {
    		reservation.setRoom(Hotel.standard);
    		System.out.println(Hotel.standard);
    	}
    
    	
    	final int people = peopleSpinner.getValue();
    	final int nights = nightsSpinner.getValue();
    	LocalDate date = checkInDate.getValue();		//usikker på om det burde stå final her?
    	reservation.setPeople(people);
    	reservation.setNights(nights);
    	reservation.setCheckInDate(date);
    	reservation.getDate();
   
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkInPaneShow();
		final var reservation = new Reservation();
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

