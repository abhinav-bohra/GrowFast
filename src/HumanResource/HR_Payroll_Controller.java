package HumanResource;
import application.conn;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Payroll_Controller implements Initializable {

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
    	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Homepage.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | HR | Dashboard");
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
    //----------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button CheckButton;

    @FXML
    private ChoiceBox<String> MonthButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Label T1;

    @FXML
    private Label T3;

    @FXML
    private Label T4;

    @FXML
    private Label T5;
   
    @FXML
    private Label T6;

    @FXML
    private Label T7;

    @FXML
    private Label T8;
    
    @FXML
    private Label T9;

    @FXML
    private Label T10;
    
    @FXML
    private Label T0;
    
    @FXML
    private Label T11;

    @FXML
    private Label T12;

    @FXML
    private Button MakeButton;

    @FXML
    private Label L0;
    
    @FXML
    private Label L1;

    @FXML
    private Label L2;

    @FXML
    private Label L3;

    @FXML
    private Label L4;

    @FXML
    private Label L6;

    @FXML
    private Label L7;

    @FXML
    private Label L8;

    @FXML
    private Label L11;

    
 
    
    public void DisplayDetails(String Eid,String Month) { 
    	 try{
             conn con = new conn();
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
                 
                 L0.setOpacity(1);
                 L1.setOpacity(1);
                 L2.setOpacity(1);
                 L3.setOpacity(1);
                 L4.setOpacity(1);
                 L6.setOpacity(1);
                 L7.setOpacity(1);
                 L8.setOpacity(1);
                 L11.setOpacity(1);
                 
                 T0.setOpacity(1);
                 T11.setOpacity(1);
                 T1.setOpacity(1);
                 T3.setOpacity(1);
                 T4.setOpacity(1);
                 T5.setOpacity(1);
                 T6.setOpacity(1);
                 T7.setOpacity(1);
                 T8.setOpacity(1);
                 T9.setOpacity(1);
                 T10.setOpacity(1);
                                 
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
                 
                   
             }
             if(i==0)
                 JOptionPane.showMessageDialog(null,"Employee Record Not Found");
         }catch(Exception ex){
        	 JOptionPane.showMessageDialog(null,"Error Occurred." );
         }
     }
    	
    static String Eid,Month;
    @FXML
    void onAction_CheckButton(ActionEvent event) {
    	Eid = SearchTextField.getText().toString();
    	Month = MonthButton.getValue().toString();
    	 try
	        {
	        	conn c1 = new conn();	           
	            String q = "select * from payroll where EID='"+Eid+"' and Month='"+Month+"'";
		        ResultSet rs =c1.s.executeQuery(q);
		  	    if(rs.next()) {
		  	    	JOptionPane.showMessageDialog(null, "This Transaction is already completed. Press Ok to check details.");
		  	    	DisplayDetails(Eid, Month);
		  	    }
		  	    else{
		  	    		int n = JOptionPane.showConfirmDialog(null,"Transaction Not Found. Do you want to make payment?" ,"", JOptionPane.YES_NO_OPTION);

		  	    		if(n == JOptionPane.NO_OPTION){
		  	    			AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll.fxml"));
		  	    	        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
		  	    	        window1.setTitle("GrowFast | HR | Manage Payroll");
		  	    	        window1.setScene(new Scene(HR_Homepage));
		  	    	        window1.show();
		  	    		}
		  	            else{
		  	            	AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll_Payment.fxml"));
		  	                Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
		  	                window1.setTitle("GrowFast | HR | Make Transaction");
		  	                window1.setScene(new Scene(HR_Homepage));
		  	                window1.show();
		  	            }
		        }

	   }
    	 
    	 catch(Exception e) {
    		 JOptionPane.showMessageDialog(null, "Employee ID Not Found" + e);
    	 }
}    
  
    //Load page-----------------------------------------------------------------------------------------------------------------------------------
    ObservableList<String> Month_list = FXCollections.observableArrayList();
        private void loadData() {
		    	Month_list.removeAll(Month_list);
		    	Month_list.addAll("JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
		    	MonthButton.getItems().addAll(Month_list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}
	
	public String getEid(){
		return Eid;
	}
	public String getMonth(){
		return Month;
	}

   
}