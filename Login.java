package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databases.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextArea username; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 788, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(82, 122, 241, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(82, 193, 241, 32);
		contentPane.add(lblPassword);
		
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createAccount();
			}

			
		});
		btnCreateAccount.setBounds(359, 282, 145, 32);
		contentPane.add(btnCreateAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank you for using our banking app.");
				System.exit(0);
			}
		});
		btnExit.setBounds(581, 282, 145, 32);
		contentPane.add(btnExit);
		
		password = new JPasswordField();
		password.setBounds(385, 193, 328, 27);
		contentPane.add(password);
		
		username = new JTextArea();
		username.setBounds(385, 119, 328, 27);
		contentPane.add(username);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				checkAndLogin();
			}

			private void checkAndLogin() {
				String url = "jdbc:mysql://localhost:3306/bank";
				String username = "root";
				String password = "Password!1";
		
				DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);
		
				boolean allowed = databaseConnection.checkLoginDetails(Login.this.username.getText() , Login.this.password.getText());
		
				if(allowed == true)
					openMenu();
				else 
					JOptionPane.showMessageDialog(null, "Your credentials are wrong!"); 
			}

		});
		btnLogin.setBounds(164, 282, 145, 32);
		contentPane.add(btnLogin);
	}

	private void createAccount() {
		this.dispose();
		new Register().setVisible(true);;
	}

	private void openMenu() {
			try (FileWriter writer = new FileWriter("personDetails.txt", false)) {
				writer.write(username.getText());
				writer.close();
				this.dispose();
				new Menu().setVisible(true);
			} catch (IOException e) { 
				e.printStackTrace();
			}
	}

}
