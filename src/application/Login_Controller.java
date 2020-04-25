package application;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;


public class Login_Controller implements Initializable {
	
		ObservableList<String> list = FXCollections.observableArrayList();
		static String u,v;
	  
		@FXML
	    private TextField UsernameTextfield;

	    @FXML
	    private PasswordField PasswordTextField;
	    
	    @FXML
	    private ChoiceBox<String> LoginTypeChoice;
	       
	    @FXML
	    void onAction_LoginTypeChoice(ActionEvent event) {
	    	String choice = LoginTypeChoice.getValue();
	    	if(choice == null) {
	    		JOptionPane.showMessageDialog(null, "Please Select Login Type");
	    	}

	    }
	    
	    
        @FXML
	    void LoginAction(ActionEvent event) throws IOException {    
        	 
            u = UsernameTextfield.getText().toString();
           // JOptionPane.showMessageDialog(null, "String u is" + u);
	        v = PasswordTextField.getText().toString();
	            
	        try
	        {
	        		conn c1 = new conn();	           
	                if(LoginTypeChoice.getValue() == "Employee" || u=="admin")
	                {
		            	 String q = "select * from login where username='"+u+"' and password='"+v+"'";
		            	 ResultSet rs =c1.s.executeQuery(q);
		  	             if(rs.next()){  	                
		  	            	 AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("/Employee/Employee_Dashboard.fxml"));
		  	                 Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		  	                 window.setTitle("GrowFast | Employee | Dashboard");
		  	                 window.setScene(new Scene(EmployeeHomePane));
		  	                 window.centerOnScreen();
		  			         window.setResizable(false);
		  	                 window.show();
		  	             }
		  	             else{
			                  JOptionPane.showMessageDialog(null, "Invalid Username or password. Please try again.");
			             }
		            }
	            
	                else if(LoginTypeChoice.getValue() == "HR Personnel" || u=="admin")
	                {
		            	 String q = "select * from hr_login where HR_Username='"+u+"' and HR_Password='"+v+"'";
		            	 ResultSet rs =c1.s.executeQuery(q);
		  	             if(rs.next()){
		  	                 AnchorPane HRHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("/HumanResource/HR_Homepage.fxml"));
				             Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				             window.setTitle("GrowFast | HR | Dashboard");
				             window.setScene(new Scene(HRHomePane));
				             window.centerOnScreen();
		  			         window.setResizable(false);
		  			         window.show();	 
		  	            }
		  	            else{
			                  JOptionPane.showMessageDialog(null, "Invalid Username or password. Please try again.");
			            }
		            }     
	                
	           else {
	                	 JOptionPane.showMessageDialog(null, "Please Select Login Type");
	           }
	                 
	        }
	        
	        catch(HeadlessException | SQLException e1){
	             e1.printStackTrace();
	        }	
	        
	           	
	    }
        
        //-------------------------------------------------------------------------------------------------------------
        
        //Important Function to pass UserID to other classes
        public String getID() {
    		return u;
    	}
	    
	    private void loadData() {
	    	list.removeAll(list);
	    	String a = "Employee";
	    	String b = "HR Personnel";
	    	list.addAll(a,b);
	    	LoginTypeChoice.getItems().addAll(list);
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			loadData();
		}   
		
		
	   
}
