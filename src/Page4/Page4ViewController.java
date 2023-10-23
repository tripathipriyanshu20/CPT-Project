package Page4;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
public class Page4ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ev_id;

    @FXML
    private ComboBox<String> pickstate;

    @FXML
    private ComboBox<String> pickcity;

    @FXML
    private ComboBox<String> pickaddress;

    @FXML
    private TextField stationname;

    @FXML
    private TextField contactnumber;

    @FXML
    private TextField code;

    @FXML
    private TextField waitingtime;

    @FXML
    private ComboBox<String> destistate;

    @FXML
    private ComboBox<String> desticity;

    @FXML
    private ComboBox<String> destiaddress;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void submit(ActionEvent event) {
        java.sql.Connection con;
        con=Dependies_Zeline.MySQL_Connector.getConnection();
        java.sql.PreparedStatement pst;
        System.out.println("HEY LINE 63");
        try {
            pst=con.prepareStatement("insert into evdata values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, Integer.parseInt(ev_id.getText()));
            pst.setString(2, pickstate.getSelectionModel().getSelectedItem());
            pst.setString(3, pickcity.getSelectionModel().getSelectedItem());
            pst.setString(4, pickaddress.getSelectionModel().getSelectedItem());
            pst.setString(5, destistate.getSelectionModel().getSelectedItem());
            pst.setString(6, desticity.getSelectionModel().getSelectedItem());
            pst.setString(7, destiaddress.getSelectionModel().getSelectedItem());
            pst.setString(8, stationname.getText());
            pst.setString(9, contactnumber.getText());
            pst.setString(10, code.getText());
            pst.setInt(11, Integer.parseInt(waitingtime.getText()));
            pst.execute();
            System.out.println("RESULT SUBMITTED!");
            showMsg("Car Status Updated!");

        }
        catch(Exception e) {
            e.printStackTrace();
            showMsg("Error while saving!");
        }

    }
    void showMsg(String msg) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EV Station application says");
        alert.setHeaderText("Status for your submssion:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert ev_id != null : "fx:id=\"ev_id\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert pickstate != null : "fx:id=\"pickstate\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert pickcity != null : "fx:id=\"pickcity\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert pickaddress != null : "fx:id=\"pickaddress\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert stationname != null : "fx:id=\"stationname\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert contactnumber != null : "fx:id=\"contactnumber\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert code != null : "fx:id=\"code\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert waitingtime != null : "fx:id=\"waitingtime\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert destistate != null : "fx:id=\"destistate\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert desticity != null : "fx:id=\"desticity\" was not injected: check your FXML file 'Page4View.fxml'.";
        assert destiaddress != null : "fx:id=\"destiaddress\" was not injected: check your FXML file 'Page4View.fxml'.";
        ArrayList<String> ary=new ArrayList<String>(Arrays.asList("Andaman and Nicobar Islands",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chhattisgarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Ladakh",
                "Lakshadweep",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Puducherry",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal"
        ));

        ArrayList<String> ary2=new ArrayList<String>(Arrays.asList(    "Dehradun",
                "Hardwar",
                "Haldwani-cum-Kathgodam",
                "Srinagar",
                "Kashipur",
                "Roorkee",
                "Rudrapur",
                "Rishikesh",
                "Saharanpur",
                "Noida",
                "Ludhiana",
                "Patiala",
                "Amritsar",
                "Jalandhar",
                "Bathinda",
                "Pathankot",
                "Hoshiarpur",
                "Batala",
                "Moga",
                "Malerkotla",
                "Khanna",
                "Mohali",
                "Barnala",
                "Firozpur",
                "Phagwara",
                "Kapurthala",
                "Zirakpur",
                "Kot Kapura",
                "Faridkot",
                "Muktsar",
                "Rajpura",
                "Sangrur",
                "Faridabad",
                "Gurgaon",
                "Hisar",
                "Rohtak",
                "Panipat",
                "Karnal",
                "Sonipat",
                "Yamunanagar",
                "Chennai",
                "Coimbatore",
                "Madurai",
                "Tiruchirappalli",
                "Salem",
                "Tirunelveli",
                "Tiruppur",
                "Ranipet",
                "Nagercoil",
                "Thanjavur",
                "Indore",
                "Bhopal",
                "Jabalpur",
                "Gwalior",
                "Ujjain",
                "Sagar",
                "Ratlam",
                "Satna",
                "Murwara (Katni)",
                "Morena",
                "Dhanbad",
                "Ranchi",
                "Jamshedpur",
                "Bokaro Steel City",
                "Deoghar",
                "Phusro",
                "Adityapur",
                "Hazaribag",
                "Shimla",
                "Mandi",
                "Solan",
                "Nahan"));

        ArrayList<String> ary3=new ArrayList<String>(Arrays.asList("colony road","foji chownk","UPES Kandholi","UPES Bidholi","Pondha","Premnagar","ISBT","Ghantaghar","Railway Station","Ballupur"));
        pickaddress.getItems().addAll(ary3);
        pickcity.getItems().addAll(ary2);
        pickstate.getItems().addAll(ary);

        destiaddress.getItems().addAll(ary3);
        desticity.getItems().addAll(ary2);
        destistate.getItems().addAll(ary);
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