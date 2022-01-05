package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class AccountApp {

	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String username = "root";
		String password = "Password!1";

		try{
			Connection connection = DriverManager.getConnection(url, username, password);
			
			// String sql = "INSERT INTO account VALUES(7845345, 'savings', 56565, 89, 'this is a description', 2.3, 'kwazi')";
			// String sql = "INSERT INTO  users VALUES('kwazi', 'male', 8989898, 'password89', 'user34', '9090909090', 'email@gmail.com', 56, 'street name', 'TUI89')";
			String sql = "SELECT * FROM account WHERE username_user=?";

			PreparedStatement pst = connection.prepareStatement(sql);
 
			pst.setString(1, "timer");
			
			ResultSet rs = pst.executeQuery();
			double t = 0;
			if(rs.next())
				t = rs.getDouble("balance");
			
			JOptionPane.showMessageDialog(null, "Current balance R" + t);
			
		}catch(SQLException io){
			io.printStackTrace();
		}
		

	}

}
