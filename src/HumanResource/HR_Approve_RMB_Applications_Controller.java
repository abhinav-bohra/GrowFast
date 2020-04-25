package HumanResource;
import application.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Approve_RMB_Applications_Controller implements Initializable {
	
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
    private TextField RATextField;

    @FXML
    private ChoiceBox<String> StatusChoiceBox;

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
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Approve_Applications.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Manage Employee Applications");
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
    //---------------------------------------------------------------------------------------------------------------------
    @FXML
    private TableView<RMBApp> RMBAppTable;

    @FXML
    private TableColumn<RMBApp,String> IDCol;

    @FXML
    private TableColumn<RMBApp,String> EIDCol;

    @FXML
    private TableColumn<RMBApp,String> NameCol;

    @FXML
    private TableColumn<RMBApp,String> DOSCol;

    @FXML
    private TableColumn<RMBApp,String> AMTCol;

    @FXML
    private TableColumn<RMBApp,String> ReasonCol;

    @FXML
    private TableColumn<RMBApp,String> StatusCol;

    @FXML
    private TableColumn<RMBApp,String> HRCol;
    
    public class RMBApp{
        private final SimpleStringProperty ID;
        private final SimpleStringProperty EID;
        private final SimpleStringProperty Name;
        private final SimpleStringProperty DOS;  
        private final SimpleStringProperty Amt;
        private final SimpleStringProperty Reason;
        private final SimpleStringProperty Status;
        private final SimpleStringProperty HR;  
    
        public RMBApp(String id,String eid,String name,String dos,String amt,String reason,String status,String hr) {
            this.ID = new SimpleStringProperty(id);
            this.EID = new SimpleStringProperty(eid);
            this.Name = new SimpleStringProperty(name);
            this.DOS = new SimpleStringProperty(dos);     
            this.Amt = new SimpleStringProperty(amt);
            this.Reason = new SimpleStringProperty(reason);
            this.Status = new SimpleStringProperty(status);
            this.HR = new SimpleStringProperty(hr);     
        
        }

        public String getID() {
            return ID.get();
        }

        public String getEID() {
            return EID.get();
        }

        public String getName() {
            return Name.get();
        }

        public String getDOS() {
            return DOS.get();
        }

        public String getAmt() {
            return Amt.get();
        }

        public String getReason() {
            return Reason.get();
        }

        public String getStatus() {
            return Status.get();
        }

        public String getHR() {
            return HR.get();
        }   

    }
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        IDCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("ID"));
        EIDCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("EID"));
        NameCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Name"));
        DOSCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("DOS"));
        AMTCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Amt"));
        ReasonCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Reason"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("Status"));
        HRCol.setCellValueFactory(new PropertyValueFactory<RMBApp,String>("HR"));
                        
        ObservableList<RMBApp> Rdata = FXCollections.observableArrayList();
    
        
        try{
            conn con = new conn();
            String str = "select * FROM reimbursementtable ";
            ResultSet rs = con.s.executeQuery(str);
            
            while(rs.next()){
                String id = rs.getString(1);
                String eid = rs.getString(2);
                String name=rs.getString(3);
                String dos =rs.getString(4);
                String amt = rs.getString(5);
                String reason = rs.getString(6);
                String status=rs.getString(7);
                String hr =rs.getString(8);
                
                Rdata.add(new RMBApp( id, eid, name, dos, amt, reason, status, hr));
             }       
            RMBAppTable.setItems(Rdata);
        }                 
        catch(SQLException ee){
            JOptionPane.showMessageDialog(null,ee);
            ee.printStackTrace();   
        }       
        
    }  
    //---------------------------------------------------------------------------------------------------------------------
    ObservableList<String> RA_list = FXCollections.observableArrayList();
    private void loadData() {
    	StatusChoiceBox.setDisable(false);
    	RA_list.removeAll(RA_list);    
    	RA_list.addAll("Pending","Under review","Rejected","Approved");
    	StatusChoiceBox.getItems().addAll(RA_list);
   }
    @FXML
    void onACtion_RATextField(ActionEvent event) {
    	loadData(); 
    	SubmitButton.setDisable(false);
    }
    
    @FXML
    void onAction_SubmitButton(ActionEvent event) throws IOException {
    	Login_Controller obj = new Login_Controller();
    	
    	try {
    		conn c1 = new conn();
    		String q = "UPDATE reimbursementtable SET RStatus='"+(String) StatusChoiceBox.getValue() +"',RHRID='"+obj.getID()+"'  WHERE RID='"+RATextField.getText().toString()+"' ";
    	    int rs =c1.s.executeUpdate(q);
    	    if(rs !=0)    	JOptionPane.showMessageDialog(null,"Application Status Updated Successfully "); 
    	    else 			JOptionPane.showMessageDialog(null,"Error occurred while processing request : No Application Found");
    	}
    		
    	catch(Exception ex) {
    		JOptionPane.showMessageDialog(null,"Eexception occurred while processing request.");    		
    	}
    	
    	AnchorPane mainPane = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Approve_RMB_Applications.fxml"));
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("GrowFast | HR | Manage Reimbusement Applications");
		primaryStage.show();
    	
    }
}


