package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databases.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextArea amount; 
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToMenu();
			}
		});
		btnMenu.setBounds(195, 288, 165, 38);
		contentPane.add(btnMenu);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				depositAmount();
			}
		});
		deposit.setBounds(454, 288, 165, 38);
		contentPane.add(deposit);
		
		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setBounds(12, 0, 867, 38);
		contentPane.add(lblDeposit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(120, 50, 210, 31);
		contentPane.add(lblAmount);
		
		amount = new JTextArea();
		amount.setBounds(368, 50, 262, 31);
		contentPane.add(amount);
		
		label = new JLabel("");
		label.setBounds(120, 115, 525, 142);
		contentPane.add(label);
	}

	private void goToMenu() {
		this.dispose();
		new Menu().setVisible(true);
	}

	private void depositAmount() {
		String url = "jdbc:mysql://localhost:3306/bank";
		String username = "root";
		String password = "Password!1";
		DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);

		boolean dep;
		try {
			dep = databaseConnection.deposit(Double.parseDouble(amount.getText()), databaseConnection.getName());
			
			if(dep)
				depositSuccess();
			else
				depositNot(); 
		} catch (NumberFormatException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}

	private void depositNot() {
		label.setText("Unsuccessful deposit!");
	}

	private void depositSuccess() {
		label.setText("R" + amount.getText() + " deposit successful.");
	}
}
