package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databases.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statement frame = new Statement();
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
	public Statement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatement = new JLabel("STATEMENT");
		lblStatement.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatement.setBounds(12, 0, 949, 37);
		contentPane.add(lblStatement);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(65, 49, 848, 400);
		contentPane.add(textArea);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToMenu();
			}
		});
		btnMenu.setBounds(672, 475, 180, 37);
		contentPane.add(btnMenu);
		
		JButton btnStatement = new JButton("Statement");
		btnStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/bank";
				String username = "root";
				String password = "Password!1";
				DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);
				
				databaseConnection.showStatement(textArea);
			}
		});
		btnStatement.setBounds(421, 475, 193, 37);
		contentPane.add(btnStatement);
	}
	
	private void goToMenu() {
		this.dispose();
		new Menu().setVisible(true);
		
	}
}
