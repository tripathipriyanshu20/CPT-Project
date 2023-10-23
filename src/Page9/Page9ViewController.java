package Page9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Page9ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField time;

    @FXML
    private Label label;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pay(ActionEvent event) {
        int fixedrate=5;
        int inputtime=Integer.parseInt(time.getText());
        int netcost= fixedrate*inputtime;
        label.setText("Net Cost To pay Rs. "+netcost);
    }

    @FXML
    void initialize() {
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'Page9View.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Page9View.fxml'.";

    }
}

//CONNECTORS--**
/*javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Home/HomeView.fxml")); 
	//OR
	//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
	javafx.scene.Scene scene = new javafx.scene.Scene(root);
	javafx.stage.Stage stage=new javafx.stage.Stage();
	stage.setScene(scene);
	stage.show();
}*/