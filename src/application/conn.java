package application;

import java.sql.*;

public class conn {

	public Connection c;
	public Statement s;

	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3308/growfast","root","");
			s = c.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    ResultSet executeQuery(String q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
