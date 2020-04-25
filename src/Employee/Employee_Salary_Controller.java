package Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import application.*;
import application.conn;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Salary_Controller implements Initializable{

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
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Profile");
        window.setScene(new Scene(EmployeeHomePane));
        window.show();
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
    
    //---------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button GoButton;

    @FXML
    private Button GeneratePaySlipButton;

    @FXML
    private Label L1;

    @FXML
    private Label L2;
    @FXML
    
    private Label L0;
    @FXML
    private Label L11;

    @FXML
    private Label L3;

    @FXML
    private Label L4;

    @FXML
    private Label L5;

    @FXML
    private Label L6;

    @FXML
    private Label L7;

    @FXML
    private Label L8;
    
    @FXML
    private ChoiceBox<String> MonthChoice;
    
    //-----------------------------------------------------------------------------------------------------------------------
    public void DisplayDetails(String Eid,String Month) { 
   	 try{
            conn con = new conn();
            String str1 ="SELECT FName,LName from employee_details WHERE EmployeeID='"+Eid+"'";
            ResultSet rs1 = con.s.executeQuery(str1);
            if(rs1.next())
            {
            	String FName = rs1.getString(1);
                String LName = rs1.getString(2);
                L5.setText(FName + " " + LName);
                
            }
            String str = "select BasePay,Bonus,RMB,Deduction,TaxDeduction,NetPayment FROM payroll WHERE EID='"+Eid+"' and Month='"+Month+"' ";
            ResultSet rs = con.s.executeQuery(str);
            
            int i=0;
            if(rs.next()){
           	  
                i=1;
                String BasePay = rs.getString(1);
                String Bonus = rs.getString(2);
                String RMB = rs.getString(3);
                String Deduction=rs.getString(4);
                String Tax =rs.getString(5);
                String NetPayment=rs.getString(6);
                
                L0.setText(Eid);
                L1.setText("Transaction Complete");
                L2.setText("INR " + BasePay+"0");
                L3.setText("INR " + Deduction+"0");
                L4.setText(Tax+ "%");
                L6.setText("INR " + Bonus+"0");
                L7.setText("INR " + RMB+"0");
                L8.setText("INR " + NetPayment+"0");
                Float Pay = Float.valueOf(BasePay) + Float.valueOf(Bonus) + Float.valueOf(RMB) - Float.valueOf(Deduction);
                Float Tax1 = Float.valueOf(Tax);
                Float Tax_Amt1= (Pay*Tax1)/100;
                String TaxAmt=Tax_Amt1.toString();
                L11.setText("INR " + TaxAmt +"0");
                GeneratePaySlipButton.setDisable(false);
                  
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Employee Record Not Found");
        }catch(Exception ex){
       	 JOptionPane.showMessageDialog(null,"Error Occurred.  " + ex);
        }
    }
    
    @FXML
    void onClick_Generate(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "EPayment Slip has been mailed to you. Please Check your inbox.");   	
    	
    }

    @FXML
    void onClick_Go(ActionEvent event) {
    	Login_Controller obj =new Login_Controller();
    	String Eid = obj.getID();
    	String Month = MonthChoice.getValue().toString();
    	 try{
	        	conn c1 = new conn();	           
	            String q = "select * from payroll where EID='"+Eid+"' and Month='"+Month+"'";
		        ResultSet rs =c1.s.executeQuery(q);
		  	    if(rs.next()) {
		  	    	DisplayDetails(Eid, Month);
		  	    }
		  	    else{
		  	    	JOptionPane.showMessageDialog(null, "Salary for this month has not been transfered yet. Contact our HR Team for more detail.");
		  	    	
		  	   }
	     }
    	 catch(Exception ee){
    		 JOptionPane.showMessageDialog(null,"Error Occurred.  " + ee);
    	 }
    }

ObservableList<String> Month_list = FXCollections.observableArrayList();
    
    private void loadData() {
		    	Month_list.removeAll(Month_list);
		    	Month_list.addAll("JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
		    	MonthChoice.getItems().addAll(Month_list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}

}
