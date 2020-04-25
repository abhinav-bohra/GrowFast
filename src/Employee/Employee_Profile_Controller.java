package Employee;
import application.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Profile_Controller implements Initializable {

    @FXML
    private Button DashboardButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button ApplicationButton;

    @FXML
    private Button SalaryButton;

    @FXML
    private Button PerformanceButton;

    @FXML
    private Button WebButton;

    @FXML
    private Button HRButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button LogoutButton;
    
    @FXML
    private Label t1;

    @FXML
    private Label t2;

    @FXML
    private Label t7;

    @FXML
    private Label t8;

    @FXML
    private Label t5;

    @FXML
    private Label t6;

    @FXML
    private Label t3;

    @FXML
    private Label t4;

    @FXML
    private Label t9;

    @FXML
    private Label t10;

    @FXML
    private Label t11;

    @FXML
    private Label t12;

    @FXML
    private Label t13;

    @FXML
    private Label t14;

    @FXML
    private Label t15;

    @FXML
    private Label t16;
   
    @FXML
    private Button ViewButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button ResetPassword;

    @FXML
    void onAction_ResetPassword(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Reset_Password.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Reset Password");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }
    @FXML
    void onAction_ApplicationButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Manage Applications");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

    @FXML
    void onAction_BackButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Dashboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Dashboard");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_DashboardButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Dashboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Dashboard");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_HRButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_MyHR.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My HR");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

    @FXML
    void onAction_PerformanceButton(ActionEvent event) throws IOException {
    	 AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Performance.fxml"));
         Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window1.setTitle("GrowFast | Employee | Self Assessment");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
    }

    @FXML
    void onAction_ProfileButton(ActionEvent event) throws IOException {
    	 AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
         Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window1.setTitle("GrowFast | Employee | Profile");
         window1.setScene(new Scene(Employee_MyHR_Pane));
         window1.show();
    }

    @FXML
    void onAction_SalaryButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Salary.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Salary Status");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
    }

    @FXML
    void onAction_WebButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_WebBasedLearning.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Web Based Learning");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
    }

    @FXML
    void onAction_LogoutButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | Login");
		primaryStage.show();

    }
    
	@SuppressWarnings("unused")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Login_Controller obj = new Login_Controller();
    	String e_id= obj.getID();
    	
	   	 try{
		   		String FName="Full Name",LName="Last Name",Gender="Gender",DOB="Date of Birth",Email="Email ID",PhoneNo="Phone No.",AddL1="Address Line 1",AddL2="Address Line 2",City="City",State="State",Pincode="Pincode",BloodGroup="BloodGroup",EmployeeID="EmployeeID",EmployeeLevel="EmployeeLevel",DeptName="Department Name",DOJ,ProjectName="Project Name",PhoneNo1;
		    	conn con = new conn();
	            String str = "select * from employee_details where EmployeeID = '"+e_id+"'";
	            ResultSet rs= con.s.executeQuery(str);
	            
	            while(rs.next())
	            {
	
	                FName = rs.getString("FName");
	                LName = rs.getString("LName");
	                Gender = rs.getString("Gender");
	                DOB = rs.getString("DOB");
	                Email = rs.getString("Email");
	                PhoneNo = rs.getString("PhoneNo");
	                AddL1 = rs.getString("AddL1");
	                AddL2 = rs.getString("AddL2");
	                City = rs.getString("City");
	                State= rs.getString("State");
	                Pincode= rs.getString("Pincode");
	                BloodGroup= rs.getString("BloodGroup");
	                EmployeeID= rs.getString("EmployeeID");
	                EmployeeLevel= rs.getString("EmployeeLevel");
	                DeptName= rs.getString("DeptName");
	                DOJ= rs.getString("DOJ");
	                ProjectName= rs.getString("ProjectName");
	                PhoneNo1= rs.getString("PhoneNo1");
	
	             }
	            //Update Label names to display profile details
	            t1.setText(FName);  
	            t2.setText(LName);  
	            t3.setText(Gender); 
	            t5.setText(DOB); 
	            t4.setText(Email);  
	            t6.setText(PhoneNo); 
	            t7.setText(AddL1);
	            t8.setText(AddL2);  
	            t9.setText(City);
	            t10.setText(State);
	            t11.setText(Pincode);
	            t12.setText(BloodGroup);
	            t13.setText(EmployeeID);
	            t14.setText(EmployeeLevel);
	            t16.setText(DeptName);
	            t15.setText(ProjectName);
	        }
	   	 
	   	 catch(Exception e){
	       	 JOptionPane.showMessageDialog(null,e);
	        }  	 
	}
	
	public String getID() {
		Login_Controller obj = new Login_Controller();
    	return obj.getID();
		
	}
}




