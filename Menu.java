package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton statement;
	private JButton deposit;
	private JButton send;
	private JButton balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOptions = new JLabel("OPTIONS");
		lblOptions.setFont(new Font("Dialog", Font.BOLD, 15));
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setBounds(12, 0, 1000, 38);
		contentPane.add(lblOptions);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(633, 335, 220, 38);
		contentPane.add(btnExit);
		
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToDeposit();
			}
		});
		deposit.setBounds(180, 81, 264, 38);
		contentPane.add(deposit);
		
		send = new JButton("Send money");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToTransfer();
			}
		});
		send.setBounds(589, 81, 264, 38);
		contentPane.add(send);
		
		statement = new JButton("Statement");
		statement.setBounds(180, 206, 264, 38);
		contentPane.add(statement);
		
		balance = new JButton("Withdraw");
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		balance.setBounds(589, 206, 264, 38);
		contentPane.add(balance);
	}

	private void goToDeposit() {
		this.dispose();
		new Deposit().setVisible(true);
	}

	private void goToTransfer() {
		this.dispose();
		new Transfer().setVisible(true);
	}
}
