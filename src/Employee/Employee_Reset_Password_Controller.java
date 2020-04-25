package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import application.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Reset_Password_Controller implements Initializable {

	@FXML
    private Button ResetButton;

    @FXML
    private TextField EIDTF;

    @FXML
    private PasswordField OldPass1;

    @FXML
    private PasswordField NewPass1;

    @FXML
    private PasswordField NewPass2;
    
    @FXML
    private Button CancelButton;

    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	 AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
         Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window1.setTitle("GrowFast | Employee | Profile");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
    }

    @FXML
    void onClick_ResetButton(ActionEvent event) throws IOException {
    	String eid = EIDTF.getText().toString();
    	String oldpass1 = OldPass1.getText().toString();
    	String newpass1 = NewPass1.getText().toString();
    	String newpass2 = NewPass2.getText().toString();
    	
    
    			try 
    			{
    				conn c1 = new conn();
    				String q = "select * from login where username='"+eid+"' and password='"+oldpass1+"'";
	       	 		ResultSet rs =c1.s.executeQuery(q);
		             if(rs.next()){ 
		            		if(newpass1.compareTo(newpass2) !=0) {
		                		JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
		                	    return;
		                	}		                	
		                	else{
			            	 conn cc = new conn();			            	 
			            	 String q1 = "UPDATE login SET password='"+newpass1+"' WHERE username='"+eid+"' ";
			         	     cc.s.executeUpdate(q1);
			         	     JOptionPane.showMessageDialog(null,"Password Updated Successfully ");
			         	     AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
			                 Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
			                 window1.setTitle("GrowFast | Employee | Profile");
			                 window1.setScene(new Scene(Employee_MyHR_Pane));
			                 window1.show();
		                	}
		             }
		             else{
	                 JOptionPane.showMessageDialog(null, "Invalid Username or password. Please try again.");
		             }
	            }
		        catch(HeadlessException | SQLException e1){
		 	             e1.printStackTrace();
		      	}				
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Employee_Profile_Controller obj = new Employee_Profile_Controller();
		EIDTF.setText(obj.getID());
	}

}
