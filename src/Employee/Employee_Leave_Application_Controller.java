package Employee;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Leave_Application_Controller {

    @FXML
    private DatePicker StartDateButton;

    @FXML
    private DatePicker EndDateButton;

    @FXML
    private TextArea ReasonTextArea;

    @FXML
    private Button Submit;
    
    @FXML
    private Button CancelButton;
   
    @FXML
    void onClick_CancelButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Leave Application");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.centerOnScreen();
        window1.setResizable(false);
        window1.show(); 
    }


    @FXML
    void onClick_Submit(ActionEvent event) throws IOException, HeadlessException, ParseException {
    	String StartDate = StartDateButton.getValue().toString();
    	String EndDate = EndDateButton.getValue().toString();
    	//Date EndDate = new Date(EndDateButton.getValue().toEpochDay());
    	String Reason = ReasonTextArea.getText().toString();
    	String Status = "Pending";
    	String hr_name="Not Assigned";
    	
    	Login_Controller obj = new Login_Controller();
        String user_id = obj.getID();
    	String user_name="Name";
    	
	    	if(checkDate(StartDate,EndDate) >0) {
			    		
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
		    	    String q = "INSERT INTO leaveapplication VALUES(NULL,'"+user_id+"','"+user_name+"','"+StartDate+"','"+EndDate+"','"+Reason+"','"+Status+"','"+hr_name+"')";
			        c2.s.executeUpdate(q);
			  	    JOptionPane.showMessageDialog(null, "Your Application was submitted successfully. Our HR Team will contact you soon.");            	
		    	}
		    	catch(Exception e){
			  	         JOptionPane.showMessageDialog(null, e);
			    }
		    	
		    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
		        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
		        window1.setTitle("GrowFast | Employee | Leave Application");
		        window1.setScene(new Scene(Employee_MyHR_Pane));
		        window1.centerOnScreen();
		        window1.setResizable(false);
		        window1.show();
	    	}
	    	else { JOptionPane.showMessageDialog(null, "End Date cannot be before Start Date");
	    	
	    	}
    }
    public int checkDate(String date1,String date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
    	Date date1_new = new Date(sdf.parse(date1).getTime());
    	LocalDate d1=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1_new));
		
    	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
    	Date date2_new = new Date(sdf2.parse(date2).getTime());
    	LocalDate d2=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date2_new));
		
    	int d3 = Period.between(d1, d2).getDays();
		return d3;
	}

}
