package HumanResource;
import application.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_View_Employee_Controller implements Initializable{
	
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
    private Button AddEmployee_Button;

    @FXML
    private Button SubmitButton;
	
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
    //-----------------------------------------------------------------------------------------------------
    
    public class User{
    	
    	 private final SimpleStringProperty EmployeeID;    
         private final SimpleStringProperty Name;
         private final SimpleStringProperty ELevel;
         private final SimpleStringProperty Age;
         private final SimpleStringProperty Dept;
         private final SimpleStringProperty ProName;
         private final SimpleStringProperty Email;
         private final SimpleStringProperty Phone;
         private final SimpleStringProperty Exp;
        
        public User(String eid, String nam, String ele, String age, String dep, String pro, String ema, String pho, String exp){
        	this.EmployeeID = new SimpleStringProperty(eid);    
        	this.Name = new SimpleStringProperty(nam);
        	this.ELevel = new SimpleStringProperty(ele);
        	this.Age = new SimpleStringProperty(age);
        	this.Dept = new SimpleStringProperty(dep);
        	this.ProName = new SimpleStringProperty(pro);
        	this.Email = new SimpleStringProperty(ema);
        	this.Phone = new SimpleStringProperty(pho);
        	this.Exp = new SimpleStringProperty(exp);        	        
        	        
          }

        public String getEmployeeID() {
            return EmployeeID.get();
        }

        public String getName() {
            return Name.get();
        }

        public String getELevel() {
            return ELevel.get();
        }

        public String getProName() {
            return ProName.get();
        }

        public String getDept() {
            return Dept.get();
        }

        public String getAge() {
            return Age.get();
        }

        public String getEmail() {
            return Email.get();
        }

        public String getPhone() {
            return Phone.get();
        }

        public String getExp() {
            return Exp.get();
        }  
   	
    	
    }
          
    @FXML
    private TableView<User> EmployeeDataTable;

    @FXML
    private TableColumn<User, String> EmployeeIDColoumn;
    
    @FXML
    private TableColumn<User, String> NameColoumn;

    @FXML
    private TableColumn<User, String> ELevelColoumn;

    @FXML
    private TableColumn<User, String> AgeColoumn;

    @FXML
    private TableColumn<User, String> DeptColoumn;

    @FXML
    private TableColumn<User, String> ProNameColoumn;

    @FXML
    private TableColumn<User, String> EmailColoumn;

    @FXML
    private TableColumn<User, String> PhoneColoumn;

    @FXML
    private TableColumn<User, String> ExpColoumn;
    
    //---------------------------------------------------------------------
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		EmployeeIDColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("EmployeeID"));   
		NameColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
		ELevelColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("ELevel"));
		AgeColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Age"));
		DeptColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Dept"));
		ProNameColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("ProName"));
		EmailColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
		PhoneColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Phone"));
		ExpColoumn.setCellValueFactory(new PropertyValueFactory<User,String>("Exp"));
		
		ObservableList<User> data = FXCollections.observableArrayList();
		
		try{
            conn con = new conn();
            String str = "select FName,LName,DOB,EmployeeID,EmployeeLevel,DeptName,ProjectName,Email,PhoneNo,DOJ FROM employee_details ";
            ResultSet rs = con.s.executeQuery(str);
            
            while(rs.next()){
            	String FName = rs.getString(1);
                String LName = rs.getString(2);
                String dob = rs.getString(3);
                String eid=rs.getString(4);
                String ele =rs.getString(5);
                String dep= rs.getString(6);
                String pro=rs.getString(7);
                String ema=rs.getString(8);
                String pho=rs.getString(9);
                String doj =rs.getString(10);
                String nam = FName +" "+ LName;
                                          	
            	String age =getDiff(dob) + " years";
            	String exp =getDiff(doj) + " years";
                data.add(new  User(eid,nam,ele,age,dep,pro,ema,pho,exp));
             }       
            
            
            EmployeeDataTable.setItems(data);
        }           	  
	    catch(SQLException ee){
	    	JOptionPane.showMessageDialog(null,ee);
    	    ee.printStackTrace();
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
	    	JOptionPane.showMessageDialog(null,"Parse Exception" + e);
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------------------------------
	public String getDiff(String date1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
    	Date date1_new = new Date(sdf.parse(date1).getTime());
    	
		/*Instant instant = date1_new.toInstant();					//Converts Date to LocalDate
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate d1 = instant.atZone(defaultZoneId).toLocalDate();
		*/
    	LocalDate d1=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1_new));
		LocalDate d2 = LocalDate.now();								//Gets Current Date
		
		int d3 = Period.between(d1, d2).getYears();
		String D3 = Integer.toString(d3);       	
		return  D3;
	}

}


