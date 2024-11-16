package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
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
	public mainpage() {
		setTitle("Mainpage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1356, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCustomerLogin = new JButton("Customer Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer_login frame1=new customer_login();
				frame1.show();
				dispose();
			}
		});
		
		JButton button = new JButton("Admin login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login1 frame1=new login1();
				frame1.show();
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 30));
		button.setForeground(new Color(248, 248, 255));
		button.setBackground(new Color(0, 0, 0));
		button.setBounds(286, 431, 321, 228);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images/logo1.png"));
		lblNewLabel_1.setBounds(-163, 37, 814, 711);
		contentPane.add(lblNewLabel_1);
		btnCustomerLogin.setForeground(new Color(248, 248, 255));
		btnCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCustomerLogin.setBackground(new Color(0, 0, 0));
		btnCustomerLogin.setBounds(765, 431, 321, 228);
		contentPane.add(btnCustomerLogin);
		
		JButton button_1 = new JButton("Admin login");
		button_1.setForeground(new Color(248, 248, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(883, 110, -64, -39);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(("images/main.jpg")));
		lblNewLabel.setBounds(-23, -20, 1509, 887);
		contentPane.add(lblNewLabel);
	}
}
