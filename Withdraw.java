package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databases.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Withdraw extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
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
	public Withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWithdrawal = new JLabel("WITHDRAWAL");
		lblWithdrawal.setFont(new Font("Dialog", Font.BOLD, 15));
		lblWithdrawal.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawal.setBounds(12, 0, 758, 33);
		contentPane.add(lblWithdrawal);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(45, 62, 244, 33);
		contentPane.add(lblAmount);
		
		JTextArea amount = new JTextArea();
		amount.setBounds(310, 48, 348, 47);
		contentPane.add(amount);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToMenu();
			}
		});
		btnMenu.setBounds(172, 161, 202, 47);
		contentPane.add(btnMenu);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/bank";
				String username = "root";
				String password = "Password!1";
				DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);
				
				try {
					boolean with = databaseConnection.withdrawal(Double.parseDouble(amount.getText()), databaseConnection.getName());
					
					if(with)
						JOptionPane.showMessageDialog(null, "R" + amount.getText() + " withdrawn.");
					else
						JOptionPane.showMessageDialog(null, "Withdrawal not successful!");
				} catch (NumberFormatException | SQLException e) { 
					e.printStackTrace();
				}
			}
		});
		btnWithdraw.setBounds(484, 161, 202, 47);
		contentPane.add(btnWithdraw);
	}

	private void goToMenu() {
		this.dispose();
		new Menu().setVisible(true);
		
	}
}
