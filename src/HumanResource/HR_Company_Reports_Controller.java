package HumanResource;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Company_Reports_Controller implements Initializable{
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

    @FXML
    private BarChart<?, ?> Chart1;

    @FXML
    private CategoryAxis X1;

    @FXML
    private NumberAxis Y1;

    @FXML
    private BarChart<?, ?> Chart2;

    @FXML
    private CategoryAxis X2;

    @FXML
    private NumberAxis Y2;

    @FXML
    private Label Sincere;

    @FXML
    private Label Leader;

    @FXML
    private Label Integrity;

    @FXML
    private Label Reliable;

    @FXML
    private Label Team;

    @FXML
    private Label Soft;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0;
    	
	   	 try{		   	
		   		conn con = new conn();
	            String str = "SELECT Avg(SinciertyHR) , AVG(ReliabilityHR), AVG(LeadHR), AVG(TeamHR),AVG(IntegrityHR),AVG(SoftSkillsHR) FROM employee_performance;";
	         
	            ResultSet rs= con.s.executeQuery(str);
	            
	            while(rs.next())
	            {            	
	                a1 = rs.getInt(1);
	                a2 = rs.getInt(2);
                    a3 = rs.getInt(3);
                    a4 = rs.getInt(4);
                    a5 = rs.getInt(5);
                    a6 = rs.getInt(6);
	            }
	   	 }
	   	 catch(Exception e){
	       	 JOptionPane.showMessageDialog(null,e);
	        }  	 
	   	XYChart.Series set1 = new XYChart.Series<>();
    	set1.getData().add(new XYChart.Data("Sincierity",a1));
    	set1.getData().add(new XYChart.Data("Reliability",a2));
    	set1.getData().add(new XYChart.Data("Leadership",a3));
    	set1.getData().add(new XYChart.Data("Team Spirit",a4));
    	set1.getData().add(new XYChart.Data("Integrity",a5));
    	set1.getData().add(new XYChart.Data("Soft Skills",a6)); 	
    	Chart1.getData().addAll(set1);
    	//Chart1.lookupAll(".default-color0.chart-bar")
        //.forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
		
    	String b1="To Be Decided",b2="To Be Decided",b3="To Be Decided",b4="To Be Decided",b5="To Be Decided",b6="To Be Decided";	
    	 try{		   	
		   		conn con1 = new conn();
		   		String str1 = "SELECT Eid FROM employee_performance WHERE SinciertyHR=(select max(SinciertyHR) from employee_performance)";
		   		String str2 = "SELECT Eid FROM employee_performance WHERE ReliabilityHR=(select max(ReliabilityHR) from employee_performance)";
		   		String str3 = "SELECT Eid FROM employee_performance WHERE LeadHR=(select max(LeadHR) from employee_performance)";
		   		String str4 = "SELECT Eid FROM employee_performance WHERE TeamHR=(select max(TeamHR) from employee_performance)";
		   	    String str5 = "SELECT Eid FROM employee_performance WHERE IntegrityHR=(select max(IntegrityHR) from employee_performance) ;";
		   	    String str6 = "SELECT Eid FROM employee_performance WHERE SoftSkillsHR=(select max(SoftSkillsHR) from employee_performance)";
		   	   
		   	    ResultSet rs1= con1.s.executeQuery(str1);
                if(rs1.next())  b1 = rs1.getString(1);
                String str11 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b1+"'";
                ResultSet rs11= con1.s.executeQuery(str11);
                if(rs11.next()) Sincere.setText( rs11.getString(1) +" " + rs11.getString(2));
              
                ResultSet rs2= con1.s.executeQuery(str2);
                if(rs2.next())  b2 = rs2.getString(1);
                String str12 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b2+"'";
                ResultSet rs12= con1.s.executeQuery(str12);
                if(rs12.next()) Reliable.setText( rs12.getString(1) +" " + rs12.getString(2));;
                
                ResultSet rs3= con1.s.executeQuery(str3);
                if(rs3.next())  b3 = rs3.getString(1);
                String str13 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b3+"'";
                ResultSet rs13= con1.s.executeQuery(str13);
                if(rs13.next()) Leader.setText( rs13.getString(1) +" " + rs13.getString(2));
                
                ResultSet rs4= con1.s.executeQuery(str4);
                if(rs4.next())  b4 = rs4.getString(1);
                String str14 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b4+"'";
                ResultSet rs14= con1.s.executeQuery(str14);
                if(rs14.next()) Team.setText( rs14.getString(1) +" " + rs14.getString(2));
                
                ResultSet rs5= con1.s.executeQuery(str5);
                if(rs5.next())  b5 = rs5.getString(1);
                String str15 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b5+"'";
                ResultSet rs15= con1.s.executeQuery(str15);
                if(rs15.next()) Integrity.setText( rs15.getString(1) +" " + rs15.getString(2));
                
                ResultSet rs6= con1.s.executeQuery(str6);
                if(rs6.next())  b6 = rs6.getString(1);
                String str16 = "SELECT FName,LName FROM employee_details WHERE EmployeeID='"+b6+"'";
                ResultSet rs16= con1.s.executeQuery(str16);
                if(rs16.next()) Soft.setText( rs16.getString(1) +" " + rs16.getString(2));      
	   	 }
    	 catch(Exception e){
	       	 JOptionPane.showMessageDialog(null,e);
	        }  	 
    	}
 }
