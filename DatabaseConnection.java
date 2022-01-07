package databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTextArea;

import system.Account;
import system.AccountException;
import system.Address;
import system.Contact;
import system.Customer;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection(String url, String user, String password)  {
        try {
            connection =  DriverManager.getConnection(url, user, password);
        } catch(SQLException io){
            io.printStackTrace();
        }
        
    }

    public ResultSet getResults(String sql) throws SQLException{
        return this.connection.prepareStatement(sql).executeQuery();
    }

    public void createUser(
        String full_name, String gender, String id_number, String password, String username, String phone_number,
        String email, int street_number, String street_name, String zip_code
    ){

        try {
            Address address = new Address(street_name, street_number, zip_code);
            Contact contact = new Contact(phone_number, email);

            Customer customer = new Customer(
                id_number, full_name, contact, password , address, username, gender);


            // String sql = "INSERT INTO  users VALUES('kwazi', 'male', 8989898, 'password89', 'user34', '9090909090', 'email@gmail.com', 56, 'street name', 'TUI89')";
            String sql = "INSERT INTO  users VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getCustomer_name());
            preparedStatement.setString(2, customer.getGender());
            preparedStatement.setString(3, customer.getCustomer_id());
            preparedStatement.setString(4, customer.getCustomer_password());
            preparedStatement.setString(5, customer.getCustomer_username());
            preparedStatement.setString(6, contact.getCustomer_number());
            preparedStatement.setString(7, contact.getEmail());
            preparedStatement.setInt(8, address.getStreet_number());
            preparedStatement.setString(9, address.getStreet_name());
            preparedStatement.setString(10, address.getZip_code());

            preparedStatement.executeUpdate();

        } catch (AccountException e) { 
            e.printStackTrace();
        } catch (SQLException e) { 
            e.printStackTrace();
        }

    }

    public void createAccount(
        String type, String description, String username_user
    ){
        try {

            String gen = generateDetails();

            String token[] = gen.split("#");
            int account_id =Integer.parseInt(token[0]) ;
            String account_number = token[1];

            double balance = 0, interest_rate;

            if(type.equals("savings"))
                interest_rate = 2.4;
            else 
                interest_rate = 3.0;

            Account account = new Account(
                account_id,  type, account_number,  balance, interest_rate, description);

                // String sql = "INSERT INTO account VALUES(7845345, 'savings', 56565, 89, 'this is a description', 2.3, 'kwazi')";
                String sql = "INSERT INTO account VALUES(?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

                preparedStatement.setInt(1, account.getAccount_id());
                preparedStatement.setString(2, account.getAccount_type());
                preparedStatement.setString(3, account_number);
                preparedStatement.setDouble(4, account.getBalance());
                preparedStatement.setString(5, account.getDescription());
                preparedStatement.setDouble(6, interest_rate);
                preparedStatement.setString(7, username_user);

                preparedStatement.executeUpdate();


        } catch (AccountException e) { 
            e.printStackTrace();
        } catch (SQLException e) { 
            e.printStackTrace();
        }

    }

    private String generateDetails() { 
        
                String id = Integer.toString(ThreadLocalRandom.current().nextInt(100, 10000));
                String number = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 99999)); 
            
            return id + "#" + number;
    }

    public boolean checkLoginDetails(
        String username, String password
    ){
        boolean found = true;

        String sql = "SELECT * FROM users WHERE username=? and password = ?";

			PreparedStatement pst;
            try {
                pst = connection.prepareStatement(sql);

                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                if(!rs.next())
                    found = false;
            } catch (SQLException e) {
                e.printStackTrace();
            }

			

        return found;
    }

    public boolean deposit(double amount, String name) throws SQLException{
    	boolean deposited = true;
        
        //getting current balance
        
        double balance = getBalance(name);
         
        double updater = balance + amount;  

        //updating balance

        updateBalance(updater, name);
        
        createStatement(amount, "deposit", getAccountNumber(name));
          
        return deposited;
        
    }
    
    public boolean withdrawal(double amount, String name) throws SQLException{
    	boolean isDone = true;
    	
    	double balance = getBalance(name);
    	
    	double updater = balance - amount;
    	
    	updateBalance(updater, name);
    	
    	createStatement(amount, "withdrawal", getAccountNumber(name));
    	
    	return isDone;
    	
    }
    
    private void updateBalance(double amount, String name) {
        String sql1 = "UPDATE account SET balance=? WHERE username_user=?";
            try {
    			PreparedStatement pst1 = connection.prepareStatement(sql1);

    			pst1.setDouble(1, amount);
    			pst1.setString(2, name);
    			
    			pst1.executeUpdate();
            }catch(SQLException io){
                io.printStackTrace();
            }
    }

    private double getBalance(String name) throws SQLException {
        String sql = "SELECT * FROM account WHERE username_user=?";
        		double amo = 0;
    			PreparedStatement pst;
                    pst = connection.prepareStatement(sql);

                    pst.setString(1, name);
                    
                    ResultSet rs = pst.executeQuery(); 
                    if(rs.next())
                    	amo = rs.getDouble("balance");
                    return amo;
     
    }

    public boolean transfer(String account_number, String name,  double amount) throws SQLException {
    	boolean tran = false;

    	//senders balance
        double senderBalance = getBalance(name); 

        if(senderBalance >= amount){
 
            String nameReceiver = getNameReceiver(account_number);

            Boolean deposited = deposit(amount, nameReceiver);
 

            if(deposited.equals(true)){
            	
                //update the senders amount  
                double newSenderBalance = senderBalance - amount;
                
                withdrawal(newSenderBalance, name); 
                createStatement(amount, "deposit", account_number);
                createStatement(amount, "transfer", getAccountNumber(name));
                
                tran = true;
            }
            
        }
    	return tran;
    } 

    private void createStatement(double amount, String transaction, String account_number) { 
    	String date = createDate(); 
    	
    	//adding to database
    	String sql = "INSERT INTO  statement VALUES(?,?,?,?)";
    	try {
    	PreparedStatement prepare = connection.prepareStatement(sql);
        
        prepare.setString(1, date);
        prepare.setString(2, account_number);
        prepare.setDouble(3, amount);
        prepare.setString(4, transaction);
            
        prepare.executeUpdate();
		
    	} catch(SQLException io) {
    		io.printStackTrace();
    	}
	}

	private String getAccountNumber(String name) { 
		return accountNum(name);
	}

	private String  accountNum(String name) {
		String sqlReceiver = "SELECT * FROM account WHERE username_user=?";
        String accNo = "";
                try {
                PreparedStatement prepare = connection.prepareStatement(sqlReceiver);
        
                prepare.setString(1, name);
                    
                ResultSet res = prepare.executeQuery(); 

                if(res.next())
                    accNo = res.getString("account_number"); 
                
                } catch(SQLException io) {
                	io.printStackTrace();
                }
                return accNo;
	}

	private String createDate() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		return new java.sql.Timestamp(now.getTime()).toString();
	}

	private String getNameReceiver(String account_number) {

        String sqlReceiver = "SELECT * FROM account WHERE account_number=?";
        String name = "";
                try {
                PreparedStatement prepare = connection.prepareStatement(sqlReceiver);
        
                prepare.setString(1, account_number);
                    
                ResultSet res = prepare.executeQuery(); 

                if(res.next())
                    name = res.getString("username_user"); 
                }catch(SQLException io){
                    io.printStackTrace();
                }
                return name;
    }

    public String getName() {
        String name = "";
        try (Scanner sc = new Scanner(new File("personDetails.txt"))) {
        	if(sc.hasNextLine())
        		name = sc.nextLine();
            return name;
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        }
        return null;
    }
    
    public void showStatement(JTextArea area) {
    	String sql = "SELECT date, account_number, amount, transaction FROM statement";
    	try ( 
    	Statement statement = this.connection.createStatement();
    	ResultSet resultSet = this.getResults(sql);
    			){
    		java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
    		
    		int numCol = metaData.getColumnCount();
    		String acc = this.accountNum(this.getName());
    		
    		String appe = "Statement for account number " + acc + "%n%n"; 
    		StringBuilder sb = new StringBuilder(appe);
    		for(int i = 1; i <= numCol; i++)
    			sb.append("%-8s\t" + metaData.getColumnName(i));
    		sb.append("\n");
    		
    		while(resultSet.next()) {
    			for(int i = 1; i <= numCol; i++)
    				sb.append("%-8s\t" + resultSet.getObject(i));
    			sb.append("\n");
    		}
    		
    		area.setText(appe);
    		
    	}catch(SQLException io) {
    		io.printStackTrace();
    	}
    	
    }

}