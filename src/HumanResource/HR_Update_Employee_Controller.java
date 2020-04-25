package HumanResource;

import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import application.conn;
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

public class HR_Update_Employee_Controller {

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
	    private Label L1;

	    @FXML
	    private TextField FName;

	    @FXML
	    private Label L2;

	    @FXML
	    private TextField LName;

	    @FXML
	    private Label L3;

	    @FXML
	    private Label L4;

	    @FXML
	    private Label L5;

	    @FXML
	    private TextField email;

	    @FXML
	    private Label L6;

	    @FXML
	    private TextField phone;

	    @FXML
	    private Label L7;

	    @FXML
	    private TextField AddL1;

	    @FXML
	    private Label L8;

	    @FXML
	    private TextField AddL2;

	    @FXML
	    private Label L9;

	    @FXML
	    private TextField City;

	    @FXML
	    private Label L10;

	    @FXML
	    private TextField State;

	    @FXML
	    private Label L11;

	    @FXML
	    private TextField Pin;

	    @FXML
	    private Label L12;

	    @FXML
	    private Label L14;

	    @FXML
	    private TextField Eid;

	    @FXML
	    private Label L15;

	    @FXML
	    private Label L16;

	    @FXML
	    private Label L17;

	    @FXML
	    private TextField DeptName;

	    @FXML
	    private Label L18;

	    @FXML
	    private TextField ProName;
   
	    @FXML
	    private Label L20;
	    
	    @FXML
	    private Label L21;

	    @FXML
	    private TextField Password;

	    @FXML
	    private Button Save_Update;

	    @FXML
	    private Label L13;

	    @FXML
	    private TextField phone1;

	    @FXML
	    private TextField SearchButton;

	    @FXML
	    private Button GoButton;

	    @FXML
	    private TextField DOB;

	    @FXML
	    private TextField Gender;

	    @FXML
	    private TextField BG;

	    @FXML
	    private TextField ELevel;

	    @FXML
	    private TextField DOJ;
   
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
    void onClick_GoButton(ActionEvent event) {
    	 
    	try{   		
	   		String FName1="Full Name",LName1="Last Name",Gender1="Gender",DOB1="Date of Birth",Email1="Email ID",PhoneNo="Phone No.",AddL11="Address Line 1",AddL21="Address Line 2",City1="City",State1="State",Pincode1="Pincode",BloodGroup1="BloodGroup",EmployeeID1="EmployeeID",EmployeeLevel1="EmployeeLevel",DeptName1="Department Name",DOJ1="Date of Joining",ProjectName1="Project Name",PhoneNo1="Phone";
	    	//String e_id= SearchButton.getText().toString();
	    	
	        conn con = new conn();
            String str = "select * from employee_details where EmployeeID = '"+SearchButton.getText().toString()+"'";
            ResultSet rs= con.s.executeQuery(str);
            
            int i=0;
	            if(rs.next())
	            {
	            	i=1;
	                FName1 = rs.getString("FName");
	                LName1 = rs.getString("LName");
	                Gender1 = rs.getString("Gender");
	                DOB1 = rs.getString("DOB");
	                Email1 = rs.getString("Email");
	                PhoneNo = rs.getString("PhoneNo");
	                AddL11 = rs.getString("AddL1");
	                AddL21 = rs.getString("AddL2");
	                City1 = rs.getString("City");
	                State1= rs.getString("State");
	                Pincode1= rs.getString("Pincode");
	                BloodGroup1= rs.getString("BloodGroup");
	                EmployeeID1= rs.getString("EmployeeID");
	                EmployeeLevel1= rs.getString("EmployeeLevel");
	                DeptName1= rs.getString("DeptName");
	                DOJ1= rs.getString("DOJ");
	                ProjectName1= rs.getString("ProjectName");
	                PhoneNo1= rs.getString("PhoneNo1");	
	             }
	            else JOptionPane.showMessageDialog(null,"Employee Record Not Found.");
            
	        if(i!=0)
	        {
	        	
	            //Add Text to fields
	            FName.setText(FName1);  
	            LName.setText(LName1);  
	            Gender.setText(Gender1); 
	            DOB.setText(DOB1); 
	            email.setText(Email1);  
	            phone.setText(PhoneNo);
	            phone1.setText(PhoneNo1);
	            AddL1.setText(AddL11);
	            AddL2.setText(AddL21);  
	            City.setText(City1);
	            State.setText(State1);
	            Pin.setText(Pincode1);
	            BG.setText(BloodGroup1);
	            Eid.setText(EmployeeID1);
	            ELevel.setText(EmployeeLevel1);
	            DeptName.setText(DeptName1);
	            ProName.setText(ProjectName1);
	            DOJ.setText(DOJ1);
	            
	            //Set all labels and fields and visible
	        	 
	            L20.setOpacity(1);
	            L21.setOpacity(1);
	            L1.setOpacity(1);
	            L2.setOpacity(1);
	            L3.setOpacity(1);
	            L4.setOpacity(1);
	            L5.setOpacity(1);
	            L6.setOpacity(1);
	            L7.setOpacity(1);
	            L8.setOpacity(1);
	            L9.setOpacity(1);
	            L10.setOpacity(1);
	            L11.setOpacity(1);
	            L12.setOpacity(1);
	            L13.setOpacity(1);
	            L14.setOpacity(1);
	            L15.setOpacity(1);
	            L16.setOpacity(1);
	            L17.setOpacity(1);
	            L18.setOpacity(1);
	            
	            FName.setOpacity(1);  
	            LName.setOpacity(1);  
	            Gender.setOpacity(1); 
	            DOB.setOpacity(1);
	            email.setOpacity(1);  
	            phone.setOpacity(1); 
	            phone1.setOpacity(1); 
	            AddL1.setOpacity(1);
	            AddL2.setOpacity(1); 
	            City.setOpacity(1);
	            State.setOpacity(1);
	            Pin.setOpacity(1);
	            BG.setOpacity(1);
	            Eid.setOpacity(1);
	            ELevel.setOpacity(1);
	            DeptName.setOpacity(1);
	            ProName.setOpacity(1);
	            DOJ.setOpacity(1);
	            Save_Update.setOpacity(1);
	            
	            //Editable Fields        
	            email.setEditable(true); 
	            phone.setEditable(true);
	            phone1.setEditable(true); 
	            AddL1.setEditable(true);
	            AddL2.setEditable(true); 
	            City.setEditable(true);
	            State.setEditable(true);
	            Pin.setEditable(true);        
	        }
        }
   	 
   	 catch(Exception e){ JOptionPane.showMessageDialog(null,e);
   	 e.printStackTrace();
   	 }  	 
}   
    @FXML
    void onClick_Save_Update(ActionEvent event) {
    	  	
    	/*
    	 * Get Current Text (Updated)
    	 */
    	
    	String FName1 = FName.getText().toString();    	  	
    	String LName1 = LName.getText().toString();    	
    	String Gender1 = (String) Gender.getText().toString();
    	String DOB1 = DOB.getText().toString();    	
    	String email1 = email.getText().toString();
    	String phoneNo = phone.getText().toString();
    	String AddL11 = AddL1.getText().toString();
    	String AddL21 = AddL2.getText().toString();
    	String City1 = City.getText().toString();
    	String State1 = State.getText().toString();
    	String Pincode1 = Pin.getText().toString();
    	String BG1 = (String) BG.getText().toString();
    	String Eid1 = Eid.getText().toString();
    	String ELevel1 = (String) ELevel.getText().toString();
     	String DeptName1 = DeptName.getText().toString();
     	String DOJ1 = DOJ.getText().toString();
    	String ProjectName1 = ProName.getText().toString();
    	String phoneNo1 = phone1.getText().toString();
    	//String password = Password.getText().toString();
    	
    	try
    	{
    	    conn cc = new conn();
    	    String q = "UPDATE employee_details SET FName='"+FName1+"',LName='"+LName1+"',Gender='"+Gender1+"',DOB='"+DOB1+"',Email='"+email1+"',PhoneNo='"+phoneNo+"',AddL1='"+AddL11+"',AddL2='"+AddL21+"',City='"+City1+"',State='"+State1+"',Pincode='"+Pincode1+"',BloodGroup='"+BG1+"',EmployeeID='"+Eid1+"',EmployeeLevel='"+ELevel1+"',DeptName='"+DeptName1+"',DOJ='"+DOJ1+"',ProjectName='"+ProjectName1+"',PhoneNo1='"+phoneNo1+"' WHERE EmployeeID='"+Eid1+"' ";
    	    cc.s.executeUpdate(q);
    	    JOptionPane.showMessageDialog(null,"Employee Data Updated Successfully ");
    	}
    	catch(Exception ee)
    	{
    	    JOptionPane.showMessageDialog(null,ee);
    	    ee.printStackTrace();
    	}

    }
}

