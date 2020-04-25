package HumanResource;
import application.conn;
import javafx.scene.control.TextField;
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
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Add_Employee_Controller implements Initializable{

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
    
    //-------------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TextField FName;

    @FXML
    private TextField LName;

    @FXML
    private ChoiceBox<String> Gender;

    @FXML
    private DatePicker DOB;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField AddL1;

    @FXML
    private TextField AddL2;

    @FXML
    private TextField City;

    @FXML
    private TextField State;

    @FXML
    private TextField Pin;

    @FXML
    private ChoiceBox<String> BG;

    @FXML
    private TextField Eid;

    @FXML
    private ChoiceBox<String> ELevel;

    @FXML
    private TextField DeptName;

    @FXML
    private DatePicker DOJ;

    @FXML
    private TextField ProName;

    @FXML
    private TextField Password;

    @FXML
    private TextField phone1;

    @FXML
    private Button Submit;

    
    ObservableList<String> Gender_list = FXCollections.observableArrayList();
    ObservableList<String> ELevel_list = FXCollections.observableArrayList();
    ObservableList<String> BG_list = FXCollections.observableArrayList();
    
    private void loadData() {
    	Gender_list.removeAll(Gender_list);
    	String a = "Male";
    	String b = "Female";
    	String c = "Rather Not Say";
    	Gender_list.addAll(a,b,c);
    	Gender.getItems().addAll(Gender_list);
    	
    	BG_list.removeAll(BG_list);
     	BG_list.addAll("A+","B+","O+","AB+","A-","B-","O-","AB-");
    	BG.getItems().addAll(BG_list);
    	
     	ELevel_list.removeAll(ELevel_list);
     	ELevel_list.addAll("Executive (L1)", "Assistant Manager (L2)", "Manager (L3)", "Senior Manager (L4)", "Department Head (L5)","Human Resource");
     	ELevel.getItems().addAll(ELevel_list);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}   
    //------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    void onClick_Submit(ActionEvent event) {
    	
    	int flag=0;    	
    	String FName1 = FName.getText().toString();
    	if(FName1 == null) {
    		FName.setPromptText("*Enter First Name");
    		flag=1;
    	}
    	
    	String LName1 = LName.getText().toString();
    	if(LName1 == null) {
    		LName.setPromptText("*Enter Last Name");
    		flag=1;
    	}
    	
    	String Gender1 = (String) Gender.getValue().toString();
    	if(Gender1 == "null") {
     		JOptionPane.showMessageDialog(null,"Enter Gender");
    		flag=1;
    	}
    	
      	//Date DOB1 = new Date(DOB.getValue().toEpochDay());
    	String DOB1 = DOB.getValue().toString();
    	
    	String email1 = email.getText().toString();
    	if(email == null) {
    		email.setPromptText("*Enter Email ID");
    		flag=1;
    	}
    	
    	String phoneNo = phone.getText().toString();
    	if(phoneNo == null) {
    		phone.setPromptText("*Enter Contact Number");
    		flag=1;
    	}
    	
    	String AddL11 = AddL1.getText().toString();
    	if(AddL11 == null) {
    		AddL1.setPromptText("*Enter Address Line 1");
    		flag=1;
    	}
    	
    	String AddL21 = AddL2.getText().toString();
    	if(AddL21 == null) {
    		AddL2.setPromptText("*Enter Address Line 2");
    		flag=1;
    	}
    	
    	String City1 = City.getText().toString();
    	if(City1 == null) {
    		City.setPromptText("*Enter City Name");
    		flag=1;
    	}
    	
    	String State1 = State.getText().toString();
    	if(State1 == null) {
    		State.setPromptText("*Enter State Name");
    		flag=1;
    	}
    	
    	String Pincode1 = Pin.getText().toString();
    	if(Pincode1 == null) {
    		Pin.setPromptText("*Enter Pincode");
    		flag=1;
    	}
    	String BG1 = (String) BG.getValue().toString();
    	if(BG1 == null) {
     		JOptionPane.showMessageDialog(null,"Enter Blood Group");
    		flag=1;
    	}
    	
    	String Eid1 = Eid.getText().toString();
    	if(Eid1 == null) {
    		Eid.setPromptText("*Enter Employee ID");
    		flag=1;
    	}
    	String ELevel1 = (String) ELevel.getValue().toString();
     	if(ELevel1 == null) {
     		JOptionPane.showMessageDialog(null,"Enter Employee Level");
    		flag=1;
    	}
    	String DeptName1 = DeptName.getText().toString();
     	if(DeptName1 == null) {
    		DeptName.setPromptText("*Enter Department Name");
    		flag=1;
    	}
    	
     	//Date DOJ1 = new Date(DOJ.getValue().toEpochDay());
     	String DOJ1 = DOJ.getValue().toString();
     	
     	String ProjectName1 = ProName.getText().toString();
    	if(ProjectName1 == null) {
    		ProName.setPromptText("*Enter Current Project Name");
    		flag=1;
    	}
    	
    	String phoneNo1 = phone1.getText().toString();
    	if(phoneNo1 == null) {
    		phone1.setPromptText("*Enter Emergency Contact Number");
    		flag=1;
    	}
    	
    	String password = Password.getText().toString();
    	if(password == null) {
    		Password.setPromptText("*Enter a Strong Password");
    		flag=1;
    	}
    	
    	if(flag ==0)
    	{
    		int another_flag=0;
	    	try
	    	{
	    		//Add Employee Details
	    	    conn cc = new conn();
	    	    String q = "insert into employee_details values('"+FName1+"','"+LName1+"','"+Gender1+"','"+DOB1+"','"+email1+"','"+phoneNo+"','"+AddL11+"','"+AddL21+"','"+City1+"','"+State1+"','"+Pincode1+"','"+BG1+"','"+Eid1+"','"+ELevel1+"','"+DeptName1+"','"+DOJ1+"','"+ProjectName1+"','"+phoneNo1+"')";
	    	    cc.s.executeUpdate(q);
	    	    another_flag=1;
	    	    //JOptionPane.showMessageDialog(null,"Employee Data Successfully Added");
	    	}
	    	catch(Exception ee)
	    	{
	    	    JOptionPane.showMessageDialog(null,ee);
	    	}
	    	
	    	if(another_flag==1) {
	    	
	    			//Add Login Details
			    	try
			    	{
			    	    conn cc = new conn();
			    	    if((String) ELevel.getValue().toString() == "Human Resource" )
			    	    {
			    	    	String q1 = "INSERT INTO hr_login VALUES(NULL,'"+Eid1+"','"+password+"')";
			    	    	cc.s.executeUpdate(q1);
			    	    }
			    	    else
			    	    {
			    	    	String q1 = "INSERT INTO login VALUES(NULL,'"+Eid1+"','"+password+"')";
			    	    	cc.s.executeUpdate(q1);
			    	    }
			    	    
			    	    
			    	    //JOptionPane.showMessageDialog(null,"Employee Data Successfully Added");
			    	    AnchorPane HR_Add_Employee = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Add_Employee.fxml"));
			            Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
			            window1.setTitle("GrowFast | HR | Add Employee");
			            window1.setScene(new Scene(HR_Add_Employee));
			            window1.show();
			    	}
			    	catch(Exception ee)
			    	{
			    	    JOptionPane.showMessageDialog(null,ee);
			    	}
			    	
			    	//Initializing Employee Performance Data
			    	try
			    	{
			    		String a ="Not Assigned Yet";
			    		String b ="-";
			    	    conn cc = new conn();
			    	    String q = "insert into employee_performance values('"+Eid1+"',0,0,0,0,0,0,'"+b+"','"+a+"',0,0,0,0,0,0)";
			    	    cc.s.executeUpdate(q);
			    	    JOptionPane.showMessageDialog(null,"Employee Performance Data Successfully Added");
			    	}
			    	catch(Exception ee)
			    	{
			    	    JOptionPane.showMessageDialog(null,"Employee Performance Not Initialized" + ee);
			    	}
	    	}
    	}
    }
   

}
