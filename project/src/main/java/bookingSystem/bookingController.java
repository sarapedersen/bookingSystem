package bookingSystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class bookingController {
	@FXML
    private AnchorPane checkInPane;
	
	@FXML
    private Button btnFindRooms;

    @FXML
    private AnchorPane roomPane;

    @FXML
    private Pane paneRoom1;

    @FXML
    private TextArea descRoom1;

    @FXML
    private Label titleRoom1;

    @FXML
    private Button btnRoom1;
    
    public void checkInPaneShow() {
    	checkInPane.setVisible(true);
    	roomPane.setVisible(false);
    }
    
    public void roomPaneShow() {
    	checkInPane.setVisible(false);
    	roomPane.setVisible(true);
    }
}
