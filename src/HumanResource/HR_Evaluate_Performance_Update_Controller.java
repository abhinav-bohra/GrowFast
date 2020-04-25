package HumanResource;
import application.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Evaluate_Performance_Update_Controller implements Initializable {

    @FXML
    private ChoiceBox<String> Sincerity;

    @FXML
    private ChoiceBox<String> Reliability;

    @FXML
    private ChoiceBox<String> Leadership;

    @FXML
    private ChoiceBox<String> TeamSpirit;

    @FXML
    private ChoiceBox<String> Integrity;

    @FXML
    private ChoiceBox<String> SoftSkills;

    @FXML
    private TextArea CommentsTextField;

    @FXML
    private Button SaveButton;
    
    @FXML
    private Button CancelButton;
   
    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();        
	    	
    }

    @FXML
    void onClick_SaveButton(ActionEvent event) throws IOException {
    	HR_Evaluate_Performance_Controller obj = new HR_Evaluate_Performance_Controller();
    	String E1 = Sincerity.getValue().toString();
    	String E2 = Reliability.getValue().toString();
    	String E3 = Leadership.getValue().toString();
    	String E4 = TeamSpirit.getValue().toString();
    	String E5 = Integrity.getValue().toString();
    	String E6 = SoftSkills.getValue().toString();
    	String E7 = CommentsTextField.getText().toString();
    	//JOptionPane.showMessageDialog(null,"YAYYY" + obj.getEid());
    	
    	try{
	    	    conn cc = new conn();
	    	    String q = "UPDATE  employee_performance SET SinciertyHR='"+E1+"',ReliabilityHR='"+E2+"',LeadHR='"+E3+"',TeamHR='"+E4+"',IntegrityHR='"+E5+"',SoftSkillsHR='"+E6+"',CommentsHR='"+E7+"' WHERE Eid='"+obj.getEid()+"'";
	    	    cc.s.executeUpdate(q);
	    	    JOptionPane.showMessageDialog(null,"Employee Performance Data Successfully Added");
	    }
    	catch(Exception ee){
	    	    JOptionPane.showMessageDialog(null,ee);
	    }
    	
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();        
	    	
    }
    
	
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		    ObservableList<String> Ratings_list = FXCollections.observableArrayList();
	       	Ratings_list.removeAll(Ratings_list);
	    	Ratings_list.addAll("1","2","3","4","5");
	    	Sincerity.getItems().addAll(Ratings_list);
	    	Reliability.getItems().addAll(Ratings_list);
	    	Leadership.getItems().addAll(Ratings_list);
	    	TeamSpirit.getItems().addAll(Ratings_list);
	    	Integrity.getItems().addAll(Ratings_list);
	    	SoftSkills.getItems().addAll(Ratings_list);	    		}  
}
