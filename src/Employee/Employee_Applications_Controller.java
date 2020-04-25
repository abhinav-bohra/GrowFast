package Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import application.Login_Controller;
import application.conn;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Applications_Controller implements Initializable{

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
    private Button LogoutButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button L_Button;
    
    @FXML
    private Button R_Button;

    @FXML
    private Label LeaveButton;  

    @FXML
    private Label ReimbButton;
    
    @FXML
    private Label L1;

    @FXML
    private Label R1;

    @FXML
    void onAction_WebButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_WBLPane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_WebBasedLearning.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Web Based Learning");
        window.setScene(new Scene(Employee_WBLPane));
        window.setResizable(false);
        window.show();
    }
 
    @FXML
    void onAction_LogoutButton(ActionEvent event) throws IOException {
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | Login");
		primaryStage.setResizable(false);
		primaryStage.show();
    }

    @FXML
    void onAction_ProfileButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_Profile_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Profile.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Profile");
        window1.setScene(new Scene(Employee_Profile_Pane));
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
        window.setResizable(false);
        window.show();
    }

    @FXML
    void onAction_DashboardButton(ActionEvent event) throws IOException {
    	AnchorPane EmployeeHomePane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Dashboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("GrowFast | Employee | Dashboard");
        window.setScene(new Scene(EmployeeHomePane));
        window.setResizable(false);
        window.show();
    }

    @FXML
    void onAction_HRButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_MyHR.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My HR");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
     }

      @FXML
    void onAction_PerformanceButton(ActionEvent event) throws IOException {
    	  AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Performance.fxml"));
          Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
          window1.setTitle("GrowFast | Employee | Self Assessment");
          window1.setScene(new Scene(Employee_MyHR_Pane));
          window1.setResizable(false);
          window1.show();
        }


    @FXML
    void onAction_SalaryButton(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Salary.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Salary Status");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
       }
    //--------------------------------------------------------------------------------------------------------------------------

    @FXML
    void onAction_L_Button(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Leave_Application.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My Leave Application");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }

    @FXML
    void onAction_R_Button(ActionEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Reimbursement_Application.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My Reimbursement Application");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }

    @FXML
    void onTouchL1(TouchEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Leave_Application.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My Leave Application");
        window1.centerOnScreen();
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }

    @FXML
    void onTouchR1(TouchEvent event) throws IOException {
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Reimbursement_Application.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | My Reimbursement Application");
        window1.centerOnScreen();
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.setResizable(false);
        window1.show();
    }
    //------------------------------------------------------------------------------------
    
    Login_Controller obj = new Login_Controller();
    String Eid = obj.getID();    		
       
    @FXML
    private TableView <LeaveApp> LAppTable;

    @FXML
    private TableColumn<LeaveApp,String> LAppIDCol;

    @FXML
    private TableColumn<LeaveApp,String> StartCol;

    @FXML
    private TableColumn<LeaveApp,String> EndCol;

    @FXML
    private TableColumn<LeaveApp,String> StatCol;
    
    public class LeaveApp{
    	private final SimpleStringProperty LAppID;
    	private final SimpleStringProperty Start;
    	private final SimpleStringProperty End;
    	private final SimpleStringProperty Stat;    	
    
	    public LeaveApp(String lap,String sta,String end,String stat) {
	    	this.LAppID = new SimpleStringProperty(lap);
	    	this.Start = new SimpleStringProperty(sta);
	    	this.End = new SimpleStringProperty(end);
	    	this.Stat = new SimpleStringProperty(stat);   	
	    	
	    }
	
		public String getLAppID() {
			return LAppID.get();
		}
	
		public String getStart() {
			return Start.get();
		}
	
		public String getEnd() {
			return End.get();
		}
	
		public String getStat() {
			return Stat.get();
		}
    }
	//Next Table - Reimbursement Table

    @FXML
    private TableView<RMBApp> RMBTable;

    @FXML
    private TableColumn<RMBApp, String> AppIDCol;

    @FXML
    private TableColumn<RMBApp, String> DOSCol;

    @FXML
    private TableColumn<RMBApp, String> AmtCol;

    @FXML
    private TableColumn<RMBApp, String> StatusCol;
    
    public class RMBApp{
    	private final SimpleStringProperty AppID;
    	private final SimpleStringProperty DOS;
    	private final SimpleStringProperty Amt;
    	private final SimpleStringProperty Status;    	
    
	    public RMBApp(String app,String dos,String amt,String status) {
	    	this.AppID = new SimpleStringProperty(app);
	    	this.DOS = new SimpleStringProperty(dos);
	    	this.Amt = new SimpleStringProperty(amt);
	    	this.Status = new SimpleStringProperty(status);   	
	    	
	    }
	
		public String getAppID() {
			return AppID.get();
		}
	
		public String getDOS() {
			return DOS.get();
		}
	
		public String getAmt() {
			return Amt.get();
		}
	
		public String getStatus() {
			return Status.get();
		}
    }
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LAppIDCol.setCellValueFactory(new PropertyValueFactory<LeaveApp,String>("LAppID"));
		StartCol.setCellValueFactory(new PropertyValueFactory<LeaveApp,String>("Start"));
		EndCol.setCellValueFactory(new PropertyValueFactory<LeaveApp,String>("End"));
		StatCol.setCellValueFactory(new PropertyValueFactory<LeaveApp,String>("Stat"));
		
		AppIDCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("AppID"));
		DOSCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("DOS"));
		AmtCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Amt"));
		StatusCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Status"));
		
		ObservableList<LeaveApp> Ldata = FXCollections.observableArrayList();
		ObservableList<RMBApp> Rdata = FXCollections.observableArrayList();
		
		try{
            conn con = new conn();
            String str = "select LeaveID,LStartDate,LEndDate,LStatus FROM leaveapplication WHERE EID='"+Eid+"' ";
            ResultSet rs = con.s.executeQuery(str);
            
            while(rs.next()){
            	String lap = rs.getString(1);
                String sta = rs.getString(2);
                String end=rs.getString(3);
                String stat =rs.getString(4);
                Ldata.add(new LeaveApp(lap,sta,end,stat));
             }       
            LAppTable.setItems(Ldata);
        }           	  
	    catch(SQLException ee){
	    	JOptionPane.showMessageDialog(null,ee);
    	    ee.printStackTrace();	
	    }
		
		try{
            conn con1 = new conn();
            String str1 = "select RID,RDOS,RAmount,RStatus FROM reimbursementtable WHERE EID='"+Eid+"' ";
            ResultSet rs = con1.s.executeQuery(str1);
            
            while(rs.next()){
            	String app = rs.getString(1);
                String dos = rs.getString(2);
                String amt=rs.getString(3);
                String status =rs.getString(4);
                Rdata.add(new RMBApp(app,dos,amt,status));
             }       
            RMBTable.setItems(Rdata);
        }           	  
	    catch(SQLException ee){
	    	JOptionPane.showMessageDialog(null,ee);
    	    ee.printStackTrace();	
	    }
    }  
}
    
