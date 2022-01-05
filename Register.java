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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextArea fullName;
	private JTextArea idNumber;
	private JComboBox<String> gender;
	private JTextArea username;
	private JTextArea password;
	private JTextArea phone;
	private JTextArea email;
	private JTextArea streetN;
	private JTextArea streetNum;
	private JTextArea zip;
	private JComboBox<String> type;
	private JTextArea desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Register() { 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 0, 906, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full name");
		lblNewLabel_1.setBounds(12, 58, 179, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID number");
		lblNewLabel_1_1.setBounds(12, 114, 179, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setBounds(12, 243, 179, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setBounds(12, 310, 179, 28);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone number");
		lblNewLabel_1_5.setBounds(12, 369, 179, 28);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Email");
		lblNewLabel_1_6.setBounds(12, 435, 179, 28);
		contentPane.add(lblNewLabel_1_6);
		
		gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setBounds(167, 174, 243, 28);
		contentPane.add(gender);
		
		fullName = new JTextArea();
		fullName.setBounds(167, 58, 249, 28);
		contentPane.add(fullName);
		
		idNumber = new JTextArea();
		idNumber.setBounds(167, 114, 249, 28);
		contentPane.add(idNumber);
		
		username = new JTextArea();
		username.setBounds(167, 243, 249, 28);
		contentPane.add(username);
		
		password = new JTextArea();
		password.setBounds(167, 310, 249, 28);
		contentPane.add(password);
		
		phone = new JTextArea();
		phone.setBounds(167, 369, 249, 28);
		contentPane.add(phone);
		
		email = new JTextArea();
		email.setBounds(167, 435, 249, 28);
		contentPane.add(email);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1.setBounds(12, 174, 179, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Street name");
		lblNewLabel_1_2.setBounds(458, 58, 179, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_7 = new JLabel("Street number");
		lblNewLabel_1_7.setBounds(458, 114, 179, 28);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Zip code");
		lblNewLabel_1_8.setBounds(458, 174, 179, 28);
		contentPane.add(lblNewLabel_1_8);
		
		streetN = new JTextArea();
		streetN.setBounds(611, 58, 249, 28);
		contentPane.add(streetN);
		
		streetNum = new JTextArea();
		streetNum.setBounds(611, 114, 249, 28);
		contentPane.add(streetNum);
		
		zip = new JTextArea();
		zip.setBounds(611, 174, 249, 28);
		contentPane.add(zip);
		
		JLabel lblNewLabel_1_8_1 = new JLabel("Account type");
		lblNewLabel_1_8_1.setBounds(458, 303, 179, 28);
		contentPane.add(lblNewLabel_1_8_1);
		
		JLabel lblNewLabel_1_8_2 = new JLabel("Description");
		lblNewLabel_1_8_2.setBounds(458, 369, 179, 28);
		contentPane.add(lblNewLabel_1_8_2);
		
		JLabel lblAccount = new JLabel("ACCOUNT");
		lblAccount.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setBounds(462, 228, 456, 43);
		contentPane.add(lblAccount);
		
		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"savings", "debit"}));
		type.setBounds(611, 305, 243, 28);
		contentPane.add(type);
		
		desc = new JTextArea();
		desc.setBounds(611, 369, 249, 28);
		contentPane.add(desc);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					createAccount();
				} catch (ClassNotFoundException e) { 
					e.printStackTrace();
				}
			}

			private void createAccount() throws ClassNotFoundException {

				String url = "jdbc:mysql://localhost:3306/bank";
				String username = "root";
				String password = "Password!1";

				DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);

				String type1 = type.getItemAt(type.getSelectedIndex());
				String description = desc.getText();

				String username_user = Register.this.username.getText();

				databaseConnection.createAccount(type1, description, username_user);
				databaseConnection.createUser(
					fullName.getText(), gender.getItemAt(gender.getSelectedIndex()), 
					idNumber.getText(), Register.this.password.getText(), Register.this.username.getText(),
					phone.getText(), email.getText(), Integer.parseInt(streetNum.getText()), 
					streetN.getText(), zip.getText());
				JOptionPane.showMessageDialog(null, "Account created!");
			}
		});
		btnCreateAccount.setBounds(458, 465, 179, 28);
		contentPane.add(btnCreateAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newLoginPage();
			}
		});
		btnLogin.setBounds(691, 465, 179, 28);
		contentPane.add(btnLogin);
	}
	
	public void newLoginPage() {
		this.dispose();
		new Login().setVisible(true);
	}
	
	
}
