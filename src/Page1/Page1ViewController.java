package Page1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class Page1ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

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