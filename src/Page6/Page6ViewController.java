package Page6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Dependies_Zeline.MySQL_Connector;
import javafx.scene.control.Alert;
public class Page6ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void signup(ActionEvent event) {
        java.sql.Connection con;
        con=MySQL_Connector.getConnection();
        java.sql.PreparedStatement pst;
        String val1=username.getText();
        String val2=password.getText();
        String val3=email.getText();
        String val4=address.getText();
        try {

            pst=con.prepareStatement(" insert into evuserlogin values(?,?,?,?)");
            pst.setString(1,val1);
            pst.setString(2,val2);
            pst.setString(3,val3);
            pst.setString(4,val4);
            //ResultSet res=pst.executeQuery();

            pst.executeUpdate();
            showMsg("Registered User!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    void showMsg(String msg) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fruit Market:");
        alert.setHeaderText("Registration Status:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Page6View.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Page6View.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'Page6View.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'Page6View.fxml'.";

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