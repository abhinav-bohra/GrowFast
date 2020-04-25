package HumanResource;
import application.conn;

import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Delete_Employee_Controller {

    @FXML
    private Button DashboardButton;

    @FXML
    private Button AddEmployee;

    @FXML
    private Button ApproveApplicationButton;

    @FXML
    private Button ManageSalaryButton;

    @FXML
    private Button UpdatePerformanceButton;

    @FXML
    private Button NewButton;

    @FXML
    private Button Manage_GrievancesButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField SearchButton;

    @FXML
    private Button GoButton;
    
    @FXML
    private Label BackLabel;

    @FXML
    private Label Label0;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Name_Label;

    @FXML
    private Label ID_Label;

    @FXML
    private Label Level_Label;

    @FXML
    private Label Dep_Label;
    
    @FXML
    private Button DeleteButton;
    
    @FXML
    void onAction_AddEmployee(ActionEvent event) throws IOException {
    	AnchorPane HR_Add_Employee = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Manage_Employee.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Manage Employee");
        window1.setScene(new Scene(HR_Add_Employee));
        window1.show();   
   }

    @FXML
    void onAction_ApproveApplicationButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Approve_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Manage Employee Applications");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_BackButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Manage_Employee.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Manage Employee");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_DashboardButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Homepage.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Dashboard");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_LogoutButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | Login");
		primaryStage.show();
    }

    @FXML
    void onAction_ManageSalaryButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Manage Payroll");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();
    }

    @FXML
    void onAction_Manage_GrievancesButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Grievances.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | HR | Grievance Portal");
		primaryStage.show();
    }

    @FXML
    void onAction_NewButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Company_Reports.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | HR | Company Reports");
		primaryStage.show();
    }

    @FXML
    void onAction_UpdatePerformanceButton(ActionEvent event) throws IOException {
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Evaluate_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Employee Performance");
        window1.setScene(new Scene(HR_Homepage));
        window1.show();   
    }

    @FXML
    void onClick_Go(ActionEvent event) {
    	
      	 
      	 try{
             conn con = new conn();
             String str = "select FName,LName,EmployeeID,EmployeeLevel,DeptName FROM employee_details WHERE EmployeeID ='"+ SearchButton.getText()+"' ";
             ResultSet rs = con.s.executeQuery(str);

             int i=0;
             if(rs.next()){
            	  
                 i=1;
                 String FName = rs.getString(1);
                 String LName = rs.getString(2);
                 String EmployeeID=rs.getString(3);
                 String EmployeeLevel=rs.getString(4);
                 String DeptName=rs.getString(5);
                 
                 Label0.setOpacity(1);
                 Label1.setOpacity(1);
                 Label2.setOpacity(1);
                 Label3.setOpacity(1);
                 Label4.setOpacity(1);
                 DeleteButton.setOpacity(1);
                 DeleteButton.setDisable(false);
                 BackLabel.setOpacity(1); 
                 Name_Label.setOpacity(1);                 
                 ID_Label.setOpacity(1);;
                 Level_Label.setOpacity(1);
                 Dep_Label.setOpacity(1);
                 
                 Name_Label.setText(FName + " " + LName);                 
                 ID_Label.setText(EmployeeID);
                 Level_Label.setText(EmployeeLevel);
                 Dep_Label.setText(DeptName);
                
             }
             if(i==0)
                 JOptionPane.showMessageDialog(null,"Employee Record Not Found");
         }catch(Exception ex){
        	 JOptionPane.showMessageDialog(null,"Error Occurred.  " + ex);
         }
     }
    
    @FXML
    void onClick_DeleteButton(ActionEvent event) {
    	int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to proceed? " ,"", JOptionPane.YES_NO_OPTION);
  		if(n == JOptionPane.YES_OPTION){
    	    	try{    		
		            conn con = new conn();
		            String str = "delete from employee_details where EmployeeID = '"+SearchButton.getText()+"'";
		            String str1 = "delete from login where username = '"+SearchButton.getText()+"'";
		            String str2 = "delete from hr_login where HR_Username = '"+SearchButton.getText()+"'";
		            String str3 = "delete from employee_performance where Eid = '"+SearchButton.getText()+"'";
		            String str4 = "delete from reimbursementtable where EID = '"+SearchButton.getText()+"'";
		            String str5 = "delete from payroll where EID = '"+SearchButton.getText()+"'";
		            String str6 = "delete from leaveapplication where EID = '"+SearchButton.getText()+"'";
		            String str7 = "delete from grievancestable where EID = '"+SearchButton.getText()+"'";
		            
			        con.s.executeUpdate(str);
		            con.s.executeUpdate(str1);
		            con.s.executeUpdate(str2);
		            con.s.executeUpdate(str3);
		            con.s.executeUpdate(str4);
		            con.s.executeUpdate(str5);
		            con.s.executeUpdate(str6);
		            con.s.executeUpdate(str7);
		            
		            JOptionPane.showMessageDialog(null,"Employee Record Deleted successfully");
		            
		            Label0.setOpacity(0);
		            Label1.setOpacity(0);
		            Label2.setOpacity(0);
		            Label3.setOpacity(0);
		            Label4.setOpacity(0);
		            DeleteButton.setOpacity(0);
		            DeleteButton.setDisable(true);
		            BackLabel.setOpacity(0); 
		            Name_Label.setOpacity(0);                 
		            ID_Label.setOpacity(0);;
		            Level_Label.setOpacity(0);
		            Dep_Label.setOpacity(0);
		
		        }catch(Exception ex){
		            JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
		        }
  		}
  		
    }

 }
