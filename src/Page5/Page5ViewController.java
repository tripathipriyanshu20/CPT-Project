package Page5;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Dependies_Zeline.MySQL_Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Page5ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField password;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {
        java.sql.Connection con;
        con= MySQL_Connector.getConnection();
        java.sql.PreparedStatement pst;

        try {

            pst=con.prepareStatement(" select * from evuserlogin where username=?");
            pst.setString(1,Username.getText());
            ResultSet res=pst.executeQuery();
            boolean count=false;
            while(res.next()) {
                count=true;
                String PASS=res.getString("password");
                System.out.println("user pass: "+password.getText() +" and correct pass is :"+ PASS);
                if(PASS.equals(password.getText())) {
                    showMsg("LOGIN SUCCESSFUL");
                    javafx.scene.Parent root= FXMLLoader.load(getClass().getResource("/Page3/Page3View.fxml"));
                    //OR
                    //Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml"));
                    javafx.scene.Scene scene = new javafx.scene.Scene(root);
                    javafx.stage.Stage stage=new javafx.stage.Stage();
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    System.out.println("Incorrect credientials\n");
                    showMsg("Incorrect details");
                }

                //pst.executeUpdate();
                //showMsg("Saved!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    void showMsg(String msg) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EV Notice:");
        alert.setHeaderText("Your details make:");
        alert.setContentText(msg);
        alert.showAndWait();
    }


    @FXML
    void signup(ActionEvent event) throws IOException {
        javafx.scene.Parent root= FXMLLoader.load(getClass().getResource("/Page6/Page6View.fxml"));
        //OR
        //Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(root);
        javafx.stage.Stage stage=new javafx.stage.Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert Username != null : "fx:id=\"Username\" was not injected: check your FXML file 'Page5View.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Page5View.fxml'.";

    }
}
