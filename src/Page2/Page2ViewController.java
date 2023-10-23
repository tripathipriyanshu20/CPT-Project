package Page2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class Page2ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void CLOSE(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void ADMIN(ActionEvent event) throws IOException {
        javafx.scene.Parent root= FXMLLoader.load(getClass().getResource("/Page7/Page7View.fxml"));
        //OR
        //Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(root);
        javafx.stage.Stage stage=new javafx.stage.Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void USER(ActionEvent event) throws IOException {
        javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Page5/Page5View.fxml"));
        //OR
        //Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(root);
        javafx.stage.Stage stage=new javafx.stage.Stage();
        stage.setScene(scene);
        stage.show();
    }

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