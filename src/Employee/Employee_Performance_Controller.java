package Employee;
import application.*;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Employee_Performance_Controller implements Initializable{

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
    
    @FXML
    private Button SubmitButton;

    @FXML
    private Button CheckButton;

    @FXML
    private  ChoiceBox<String> Leadership;

    @FXML
    private  ChoiceBox<String> TeamSpirit;

    @FXML
    private ChoiceBox<String> Sincerity;

    @FXML
    private ChoiceBox<String> Reliability;

    @FXML
    private ChoiceBox<String> Integrity;

    @FXML
    private ChoiceBox<String> SoftSkills;
    
    Login_Controller obj = new Login_Controller();
    
    @FXML
    void onClick_HRButton(ActionEvent event) {
    	 try{		   	
		   		conn con = new conn();
	            String str = "select CommentsHR from employee_performance where EID = '"+obj.getID()+"'";
	            ResultSet rs= con.s.executeQuery(str);
	            String Comments = "No comments";
	            
	            while(rs.next())
	            {
	            	Comments = rs.getString(1);
	            	JOptionPane.showMessageDialog(null,"HR COMMENTS : " + Comments);
	            }
	   	 }
	   	 catch(Exception e){
	   	       	 JOptionPane.showMessageDialog(null,"No Comments");
	   	 }

    }
 
    @FXML
    void onClick_SubmitButton(ActionEvent event) throws IOException {
    	
    	String E1 = Sincerity.getValue().toString();
    	String E2 = Reliability.getValue().toString();
    	String E3 = Leadership.getValue().toString();
    	String E4 = TeamSpirit.getValue().toString();
    	String E5 = Integrity.getValue().toString();
    	String E6 = SoftSkills.getValue().toString();
    	
    	try{
	    	    conn cc = new conn();
	    	    String q = "UPDATE  employee_performance SET SinceritySelf='"+E1+"',ReliablitySelf='"+E2+"',LeadSelf='"+E3+"',TeamSelf='"+E4+"',IntegritySelf='"+E5+"',SoftSkillsSelf='"+E6+"' WHERE Eid='"+obj.getID()+"' ";
	    	    cc.s.executeUpdate(q);
	    	    JOptionPane.showMessageDialog(null,"Self Assessment Data Successfully Added");
	    }
    	catch(Exception ee){
	    	    JOptionPane.showMessageDialog(null,"Some Error occurred" + ee);
	    }
    	
    	AnchorPane Employee_MyHR_Pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee_Performance.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setTitle("GrowFast | Employee | Self Assessment");
        window1.setScene(new Scene(Employee_MyHR_Pane));
        window1.show();
	    	
    }
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			ObservableList<String> Ratings_list = FXCollections.observableArrayList();
	      	Ratings_list.removeAll(Ratings_list);
	    	Ratings_list.addAll("1","2","3","4","5");
	    	Sincerity.getItems().addAll(Ratings_list);
	    	Reliability.getItems().addAll(Ratings_list);
	    	Leadership.getItems().addAll(Ratings_list);
	    	TeamSpirit.getItems().addAll(Ratings_list);
	    	Integrity.getItems().addAll(Ratings_list);
	    	SoftSkills.getItems().addAll(Ratings_list);    	
	}  
	//-------------------------------------------------------------------
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
	   
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@FXML
    void onClick_CheckButton(ActionEvent event) {
    	
    	Login_Controller obj = new Login_Controller();
    	String e_id= obj.getID();
    	int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0,b1=0,b2=0,b3=0,b4=0,b5=0,b6=0;
    	String r,hr_id;    	
	   	 try{		   	
		   		conn con = new conn();
	            String str = "select * from employee_performance where EID = '"+e_id+"'";
	            ResultSet rs= con.s.executeQuery(str);
	            
	            while(rs.next())
	            {
	            	a1 = rs.getInt(2);
	                a2 = rs.getInt(3);
                    a3 = rs.getInt(4);
                    a4 = rs.getInt(5);
                    a5 = rs.getInt(6);
                    a6 = rs.getInt(7);
                    b1 = rs.getInt(10);
                    b2 = rs.getInt(11);
                    b3 = rs.getInt(12);
                    b4 = rs.getInt(13);
                    b5 = rs.getInt(14);
                    b6 = rs.getInt(15);  	 
	                r = rs.getString(8);
	                hr_id = rs.getString(9);
	            }
	   	 }
	   	 catch(Exception e){
	       	 JOptionPane.showMessageDialog(null,e);
	        }  	 
		
    	
    	XYChart.Series set1 = new XYChart.Series<>();
    	set1.getData().add(new XYChart.Data("Sincierity",b1));
    	set1.getData().add(new XYChart.Data("Reliability",b2));
    	set1.getData().add(new XYChart.Data("Leadership",b3));
    	set1.getData().add(new XYChart.Data("Team Spirit",b4));
    	set1.getData().add(new XYChart.Data("Integrity",b5));
    	set1.getData().add(new XYChart.Data("Soft Skills",b6)); 	
    	Chart1.getData().addAll(set1);
    	//Chart1.lookupAll(".default-color0.chart-bar")
        //.forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
    	
    	XYChart.Series set2 = new XYChart.Series<>();
    	set2.getData().add(new XYChart.Data("Sincierity",a1));
    	set2.getData().add(new XYChart.Data("Reliability",a2));
    	set2.getData().add(new XYChart.Data("Leadership",a3));
    	set2.getData().add(new XYChart.Data("Team Spirit",a4));
    	set2.getData().add(new XYChart.Data("Integrity",a5));
    	set2.getData().add(new XYChart.Data("Soft Skills",a6)); 	
    	Chart2.getData().addAll(set2);
    	Chart2.lookupAll(".default-color0.chart-bar")
        .forEach(n -> n.setStyle("-fx-bar-fill: #46c275;"));
    	
    	

    }

}