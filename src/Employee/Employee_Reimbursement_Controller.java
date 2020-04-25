package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import javax.swing.JOptionPane;
import application.Login_Controller;
import application.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Reimbursement_Controller {

	 @FXML
	 private DatePicker DateButton;

	 @FXML
	 private TextArea ReasonTextArea;

	 @FXML
	 private Button Submit;

	 @FXML
	 private TextField AmountButton;
	 
	 @FXML
	 private Button CancelButton;
	 
	 @FXML
	 void onClick_DateButton(ActionEvent event) throws IOException, ParseException {
	    	if(checkDate(DateButton.getValue().toString()) < 0) JOptionPane.showMessageDialog(null, "Invalid Date.");
	  }

	 @FXML
	 void onClick_CancelButton(ActionEvent event) throws IOException {
	    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
	        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window1.setTitle("GrowFast | Employee | Leave Application");
	        window1.setScene(new Scene(Employee_MyHR_Pane));
	        window1.show();
	    }

    @FXML
    void onClick_Submit(ActionEvent event) throws IOException, HeadlessException, ParseException {
    	String Date = DateButton.getValue().toString();
    	String Reason = ReasonTextArea.getText().toString();
    	String Amount = AmountButton.getText().toString();
    	String hr_name="Not Assigned";
    	String Status="Pending";
    	
    	Login_Controller obj = new Login_Controller();
        String user_id = obj.getID();
    	String user_name="Name";
    	
    	if(checkDate(Date)>=0) 
    	{
		    	try {
		    		conn c1 = new conn();
		    		String str = "select FName,LName FROM employee_details WHERE EmployeeID ='"+user_id+"' ";
		    		ResultSet rs = c1.s.executeQuery(str); 
		    		if(rs.next()){
		           
		                 String FName = rs.getString(1);
		                 String LName = rs.getString(2);
		                 user_name = FName +" " + LName;
		    		}
		    		else {
		    			JOptionPane.showMessageDialog(null, "Some error occurred");            	
		    		}   	    			
		    	}
		    	catch(Exception ee) {
		    		JOptionPane.showMessageDialog(null, "Some error occurred" + ee);    		
		    	} 		   		
		    		
		
		    	try {
		    		conn c2 = new conn();
		    	    String q = "INSERT INTO reimbursementtable VALUES(NULL,'"+user_id+"','"+user_name+"','"+Date+"','"+Amount+"','"+Reason+"','"+Status+"','"+hr_name+"')";
			        c2.s.executeUpdate(q);
			  	    JOptionPane.showMessageDialog(null, "Your Application was submitted successfully. Our HR Team will contact you soon.");  
			  	    
		    	}
		    	catch(Exception e){
			  	         JOptionPane.showMessageDialog(null, e);
			    }
		    	
		    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
		        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
		        window1.setTitle("GrowFast | Employee | Reimbursement Application");
		        window1.setScene(new Scene(Employee_MyHR_Pane));
		        window1.show();
		
    	}
        else {
	    	JOptionPane.showMessageDialog(null, "Invalid Date.");
	    }
    }
    //-------------------------------------------------------------------------------------------------
        public int checkDate(String date1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
    	Date date1_new = new Date(sdf.parse(date1).getTime());
    	
    	LocalDate d1=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1_new));
		LocalDate d2 = LocalDate.now();								//Gets Current Date
		
		int d3 = Period.between(d1, d2).getDays();
		return d3;
	}

}
