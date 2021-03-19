package bookingSystem;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class bookingController implements Initializable{
	
	@FXML
    private AnchorPane checkInPane;

    @FXML
    private Button btnFindRooms;

    @FXML
    private AnchorPane roomPane;

    @FXML
    private Button btnRoom1;

    @FXML
    private Button btnRoom2;
    
    @FXML
    private Button btnRoom3;


    
    public void checkInPaneShow() {
    	checkInPane.setVisible(true);
    	roomPane.setVisible(false);
    }
    
    public void roomPaneShow() {
    	checkInPane.setVisible(false);
    	roomPane.setVisible(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
