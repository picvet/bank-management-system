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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Transfer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer();
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
	public Transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransfer = new JLabel("RECEPIENTS DETAILS");
		lblTransfer.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setBounds(12, 0, 827, 35);
		contentPane.add(lblTransfer);
		
		JLabel afdasfafasdfasf = new JLabel("Account number");
		afdasfafasdfasf.setBounds(109, 40, 246, 35);
		contentPane.add(afdasfafasdfasf);
		
		JLabel adfasfa = new JLabel("Type");
		adfasfa.setBounds(109, 133, 246, 35);
		contentPane.add(adfasfa);
		
		JLabel sdfadf = new JLabel("Amount");
		sdfadf.setBounds(109, 222, 246, 35);
		contentPane.add(sdfadf);
		
		JTextArea number = new JTextArea();
		number.setBounds(358, 40, 406, 35);
		contentPane.add(number);
		
		JTextArea type = new JTextArea();
		type.setBounds(358, 133, 406, 35);
		contentPane.add(type);
		
		JTextArea amount = new JTextArea();
		amount.setBounds(358, 222, 406, 35);
		contentPane.add(amount);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToMenu();
			}
		});
		btnMenu.setBounds(193, 289, 188, 35);
		contentPane.add(btnMenu);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				transferMoney();
			}

			private void transferMoney() {
				String url = "jdbc:mysql://localhost:3306/bank";
				String username = "root";
				String password = "Password!1";
		
				DatabaseConnection databaseConnection = new DatabaseConnection(url, username, password);

				Boolean trans;
				try {
					trans = databaseConnection.transfer(number.getText(), databaseConnection.getName(), Double.parseDouble(amount.getText()));

					if(trans.equals(true))
						JOptionPane.showMessageDialog(null, "Transfered!");
					else
						JOptionPane.showMessageDialog(null, "Couldn't transfer!");
				} catch (NumberFormatException e) { 
					e.printStackTrace();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
				
				
			}
		});
		btnSend.setBounds(482, 289, 188, 35);
		contentPane.add(btnSend);
	}

	private void goToMenu() {
		this.dispose();
		new Menu().setVisible(true);
	}
}
