package HumanResource;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HR_Payroll_Payment_Controller implements Initializable {

    @FXML
    private Label T10;

    @FXML
    private Label T1;

    @FXML
    private Label T2;

    @FXML
    private Label T3;

    @FXML
    private Label T4;

    @FXML
    private Label T9;

    @FXML
    private Label T6;

    @FXML
    private Label T7;

    @FXML
    private Label T8;

    @FXML
    private Label T5;

    @FXML
    private Button MakeButton;

    @FXML
    private TextField EIDTF;

    @FXML
    private TextField BasicPayTF;

    @FXML
    private TextField BonusTF;

    @FXML
    private TextField PenaltiesTF;

    @FXML
    private TextField RMBTF;

    @FXML
    private TextField TaxTF;

    @FXML
    private Button CancelButton;
    
    @FXML
    private TextField MonthTF;
    //----------------------------------------------------------------------------------------------------------------------
    
    @FXML
    void onAction_CancelButton(ActionEvent event) throws IOException {
    	    AnchorPane HR_Homepage = (AnchorPane) FXMLLoader.load(getClass().getResource("HR_Payroll.fxml"));
	        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window1.setTitle("GrowFast | HR | Manage Payroll");
	        window1.setScene(new Scene(HR_Homepage));
	        window1.show();
    }

    @FXML
    void onAction_MakeButton(ActionEvent event) throws IOException {
    	
    	//String Eid = EIDTF.getText().toString();
    	String BasicPay = BasicPayTF.getText().toString();
    	String Bonus = BonusTF.getText().toString();
    	String Penalty = PenaltiesTF.getText().toString();
    	//String Month = MonthChoice.getValue().toString();
    	String RMB = RMBTF.getText().toString();
    	String Tax = TaxTF.getText().toString();
    	
    	FinalPay = DoPaymentCalculations(BasicPay,Bonus,Penalty,RMB,Tax);    	
    	int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to make payment of "+FinalPay +"?" ,"", JOptionPane.YES_NO_OPTION);
	  	
    	    if(n == JOptionPane.YES_OPTION){
	  			try
		    	{
		    	    conn cc = new conn();
		    	    String q = "insert into payroll values('"+Eid+"','"+BasicPay+"','"+Bonus+"','"+RMB+"','"+Penalty+"','"+Tax+"','"+Float.toString(FinalPay)+"','"+Month+"')";
		    	    cc.s.executeUpdate(q);
		    	    JOptionPane.showMessageDialog(null,"Transaction Successfullt Completed");
		    	}
		    	catch(Exception ee)
		    	{
		    	    JOptionPane.showMessageDialog(null,"Transaction Failed"+ ee);
		    	    
		    	}
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
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------
     * USER Defined Functions for easy calculations and clean code
     */
    static String Eid,Month;
    float FinalPay;
    
    //Function1 - Payment Calculations
    public float DoPaymentCalculations(String BasicPay,String Bonus,String Penalty,String RMB,String Tax) {
    	float FinalPay =0;
    	float x=Float.valueOf(BasicPay);
    	float y=Float.valueOf(Bonus);
    	float z=Float.valueOf(Penalty);
       	float t=Float.valueOf(Tax);
       	float rmb=Float.valueOf(RMB);
    	
       	if(x<0)	x=0;
       	if(y<0) y=0;
       	if(z<0) z=0;
       	if(t<0) t=0;
       	if(rmb<0 ) rmb=0;
       	
    	FinalPay = x +  y + rmb - z ;
    	FinalPay = FinalPay - (FinalPay*t)/100;   
    	if(FinalPay <0)FinalPay=0;
    	
    	return FinalPay;
    }
    
    //Function2 - Get Basic Pay of Employee depending on his designation
    public int getBasicPay(String ELevel)
	{
    	if(ELevel.compareTo("Executive (L1)")         == 0) return 80000;
		if(ELevel.compareTo("Assistant Manager (L2)") == 0) return 125000;
		if(ELevel.compareTo("Manager (L3)")           == 0) return 175000;
		if(ELevel.compareTo("Senior Manager (L4)")    == 0) return 220000;
		if(ELevel.compareTo("Department Head (L5)")   == 0) return 300000;
		if(ELevel.compareTo("Human Resource")         == 0) return 100000;
		else return 0;
	}
    
    //Function3 - Get Employee Level to get Basic Pay 
    public String getELevel() {
    	String Elevel = null;
    	try
    	{
    	    conn cc = new conn();
    	    String q = "SELECT EmployeeLevel FROM employee_details WHERE EmployeeID = '"+Eid+"'";
    	    ResultSet rs =cc.s.executeQuery(q);
    	    if(rs.next()) {
    	    	Elevel = rs.getString(1);
    	    }
    	}
    	catch(Exception ee)
    	{
    	    JOptionPane.showMessageDialog(null,"ELevel Not Found"+ ee);
    	    
    	}
    	return Elevel;
    }
    
    //Function4 - Check whether entered month is same as that on bill
    public boolean checkRightMonth(LocalDate rdos,String Month) {
    	int mon = rdos.getMonthValue();
    	LocalDate today = LocalDate.now();
    	
    	if(today.getYear()==rdos.getYear()) {
    		if(mon ==1 && Month =="JAN") return true;
	    	else if(mon ==2 && Month =="FEB") return true;
	    	else if(mon ==3 && Month =="MAR") return true;
	    	else if(mon ==4 && Month =="APR") return true;
	    	else if(mon ==5 && Month =="MAY") return true;
	    	else if(mon ==6 && Month =="JUN") return true;
	    	else if(mon ==7 && Month =="JUL") return true;
	    	else if(mon ==8 && Month =="AUG") return true;
	    	else if(mon ==9 && Month =="SEP") return true;
	      	else if(mon ==10 && Month =="OCT") return true;
	    	else if(mon ==11 && Month =="NOV") return true;
	    	else if(mon ==12 && Month =="DEC") return true;
	    	else return false;
    	}
    	else return false;
    }
    
    //Function5 - Get RMB after checking its approved existence and right month of bill
    public void setRMB() {
    	String a ="Approved";
    	String RAmount="0";
    	String RDOS="null";
    	RMBTF.setText("0");
    	try
    	{
    	    conn cc = new conn();
    	    String q = "SELECT RAmount,RDOS FROM reimbursementtable WHERE EID = '"+Eid+"' and RStatus='"+a+"' ";
    	    ResultSet rs =cc.s.executeQuery(q);
    	    if(rs.next()) {
    	    	 RAmount = rs.getString(1);
    	    	 RDOS = rs.getString(2);
    	    	 
    	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Converts String to Date
    	         Date rdos = new Date(sdf.parse(RDOS).getTime());
    	         LocalDate d1=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(rdos));
    	        
    	         if( checkRightMonth(d1,Month) == true) {
    	        		RMBTF.setText(RAmount);
    	         }
    	         else RMBTF.setText("0");
    	    }
        }
    	catch(Exception ee){
    	    JOptionPane.showMessageDialog(null,"Some Error Occuured");
    	}
    }
    /*-------------------------------------------------------------------------------------------------------------------------
     * Initializing Page 
     */
    ObservableList<String> Month_list = FXCollections.observableArrayList();
    private void loadData() {
		    	//Get ID and Month
		        HR_Payroll_Controller obj = new HR_Payroll_Controller();
		        Eid   = obj.getEid();
		        Month = obj.getMonth();
    	    	EIDTF.setText(Eid);
		    	MonthTF.setText(Month);
		    	BasicPayTF.setText(Integer.toString(getBasicPay(getELevel())));
		    	setRMB();
   }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
	}
//------------------------------------------------------------------------------------------------------------------------------	
	

}
