package Page3;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Page3ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> pickupState;

    @FXML
    private ComboBox<String> pickupCity;

    @FXML
    private ComboBox<String> pickupArea;

    @FXML
    private TextField evno1;

    @FXML
    private TextField evno2;

    @FXML
    private TextField evno3;

    @FXML
    private TextField evno4;

    @FXML
    private TextField wait1;

    @FXML
    private TextField wait2;

    @FXML
    private TextField wait3;

    @FXML
    private TextField wait4;

    @FXML
    private TextField EV1name;

    @FXML
    private TextField EV2name;

    @FXML
    private TextField EV3name;

    @FXML
    private TextField EV4name;

    @FXML
    private TextField evNumber;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<String> destiState;

    @FXML
    private ComboBox<String> destiCity;

    @FXML
    private ComboBox<String> destiArea;

    @FXML
    private TextField Contact1;

    @FXML
    private TextField Contact2;

    @FXML
    private TextField Contact3;

    @FXML
    private TextField Contact4;

    @FXML
    void BookEV(ActionEvent event) {
        java.sql.Connection con;
        con=Dependies_Zeline.MySQL_Connector.getConnection();
        java.sql.PreparedStatement pst,pst2;
        int wait_time_updated=0;
        try {
            pst = con.prepareStatement("SELECT * FROM evdatabase.evdata where Id=?");
            pst.setInt(1, Integer.parseInt(evNumber.getText()));
            ResultSet rset = pst.executeQuery();
            boolean count = false;
            int i = 1;

            while (rset.next()) {
                count = true;
                int wait_time = rset.getInt("waiting");
                wait_time_updated=wait_time+30;
                //UPDATE `evdatabase`.`evdata` SET `waiting` = '20' WHERE (`Id` = '101')
            }
        rset.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            showMsg("Try with another area!");
        }


        try{
            pst2=con.prepareStatement("UPDATE `evdata` SET `waiting` = ? WHERE `Id` = ?");
            pst2.setInt(1, wait_time_updated);
            pst2.setInt(2, Integer.parseInt(evNumber.getText()));
            messageLabel.setText("Please complete your payment:-"+201);
            pst2.executeUpdate();
        }catch (Exception e){
            System.out.println("Error!");
        }

        try {
            javafx.scene.Parent root= FXMLLoader.load(getClass().getResource("/Page9/Page9View.fxml"));
            //OR
            //Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage=new javafx.stage.Stage();
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void ShowRides(ActionEvent event) {
        java.sql.Connection con;
        con=Dependies_Zeline.MySQL_Connector.getConnection();
        java.sql.PreparedStatement pst;

        try {
            pst=con.prepareStatement("SELECT * FROM `evdata` WHERE `cstate` LIKE ? AND `ccity` LIKE ? AND `carea` LIKE ? AND `dstate` LIKE ? AND `dcity` LIKE ?  AND `darea` LIKE ?");
            pst.setString(1,pickupState.getSelectionModel().getSelectedItem());
            pst.setString(2,pickupCity.getSelectionModel().getSelectedItem());
            pst.setString(3,pickupArea.getSelectionModel().getSelectedItem());
            pst.setString(4,destiState.getSelectionModel().getSelectedItem());
            pst.setString(5,destiCity.getSelectionModel().getSelectedItem());
            pst.setString(6,destiArea.getSelectionModel().getSelectedItem());
            ResultSet rset=pst.executeQuery();
            boolean count=false;
            int i=1;
            while(rset.next()|| i<=4) {
                count=true;
                int evno=rset.getInt("ID");
                int waitingtime=rset.getInt("waiting");
                String name=rset.getString("name");
                String contact=rset.getString("contact");
                System.out.println(evno+"  "+waitingtime+"  "+name+"  "+contact);
                if(i==1) {
                    evno1.setText(evno+"");
                    wait1.setText(waitingtime+"");
                    EV1name.setText(name);
                    Contact1.setText(contact);


                }
                if(i==2) {
                    evno2.setText(evno+"");
                    wait2.setText(waitingtime+"");
                    EV2name.setText(name);
                    Contact2.setText(contact);

                }
                if(i==3) {
                    evno3.setText(evno+"");
                    wait3.setText(waitingtime+"");
                    EV3name.setText(name);
                    Contact3.setText(contact);

                }
                if(i==4) {
                    evno4.setText(evno+"");
                    wait4.setText(waitingtime+"");
                    EV4name.setText(name);
                    Contact4.setText(contact);

                }

                i++;
                System.out.println(i);
            }


            if(count==false) {
                System.out.println("INVALID");
                messageLabel.setText("Something went wrong!");

            }
        } catch (Exception e) {
            e.printStackTrace();
            showMsg("Try with another area!");
        }

    }

    void showMsg(String msg) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EV Station Msg:");
        alert.setHeaderText("EV Available on this route!" );
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert pickupState != null : "fx:id=\"pickupState\" was not injected: check your FXML file 'Page3View.fxml'.";
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
        pickupArea.getItems().addAll(ary3);
        pickupCity.getItems().addAll(ary2);
        pickupState.getItems().addAll(ary);
        assert pickupCity != null : "fx:id=\"pickupCity\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert pickupArea != null : "fx:id=\"pickupArea\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert evno1 != null : "fx:id=\"evno1\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert evno2 != null : "fx:id=\"evno2\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert evno3 != null : "fx:id=\"evno3\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert evno4 != null : "fx:id=\"evno4\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert wait1 != null : "fx:id=\"wait1\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert wait2 != null : "fx:id=\"wait2\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert wait3 != null : "fx:id=\"wait3\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert wait4 != null : "fx:id=\"wait4\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert EV1name != null : "fx:id=\"EV1name\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert EV2name != null : "fx:id=\"EV2name\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert EV3name != null : "fx:id=\"EV3name\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert EV4name != null : "fx:id=\"EV4name\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert evNumber != null : "fx:id=\"evNumber\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert destiState != null : "fx:id=\"destiState\" was not injected: check your FXML file 'Page3View.fxml'.";
        destiState.getItems().addAll(ary);
        destiCity.getItems().addAll(ary2);
        destiArea.getItems().addAll(ary3);
        assert destiCity != null : "fx:id=\"destiCity\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert destiArea != null : "fx:id=\"destiArea\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert Contact1 != null : "fx:id=\"Contact1\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert Contact2 != null : "fx:id=\"Contact2\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert Contact3 != null : "fx:id=\"Contact3\" was not injected: check your FXML file 'Page3View.fxml'.";
        assert Contact4 != null : "fx:id=\"Contact4\" was not injected: check your FXML file 'Page3View.fxml'.";

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