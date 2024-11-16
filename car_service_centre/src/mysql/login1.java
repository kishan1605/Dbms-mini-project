package mysql;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class login1 extends JFrame {

	private JPanel contentPane;
	public JTextField Admin_id;
	private JTextField A_Password;
	private JPasswordField AA_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 frame = new login1();
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
	public login1() {
		setTitle("Admin mode");
		setFont(new Font("Berlin Sans FB", Font.BOLD, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(194, 122, 985, 525);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton loginbutton = new JButton("login");
		loginbutton.setForeground(new Color(255, 250, 250));
		loginbutton.setBackground(new Color(95, 158, 160));
		loginbutton.setBounds(642, 418, 131, 39);
		panel.add(loginbutton);
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setBounds(533, 320, 206, 45);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		
		
		JLabel lblNewLabel = new JLabel("Admin Id");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(533, 248, 114, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		Admin_id = new JTextField();
		Admin_id.setBackground(SystemColor.inactiveCaptionBorder);
		Admin_id.setBounds(674, 243, 214, 45);
		panel.add(Admin_id);
		Admin_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Admin_id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-268, -136, 703, 732);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("images/adminlogin.jpeg"));
		lblNewLabel_3.setOpaque(false);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images/adminlogin2.png"));
		lblNewLabel_4.setBounds(454, -12, 506, 284);
		panel.add(lblNewLabel_4);
		
		AA_Password = new JPasswordField();
		AA_Password.setFont(new Font("Tahoma", Font.BOLD, 20));
		AA_Password.setBounds(674, 320, 214, 45);
		panel.add(AA_Password);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN PAGE");
		lblNewLabel_2.setBounds(512, 10, 423, 112);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 50));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage frame1=new mainpage();
				frame1.show();
				dispose();
			}
		});
		btnNewButton.setBounds(194, 675, 105, 34);
		contentPane.add(btnNewButton);
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					Statement smt=con.createStatement();
					String sql="Select * from admin where Admin_id='"+Admin_id.getText()+"' and A_Password='"+AA_Password.getText().toString()+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next()) {
						
						sample sm=new sample();
						String in1=Admin_id.getText();
						String in5=AA_Password.getText();
						
						
						sm.a1.setText(in1);
						sm.a5.setText(in5);
						
						sm.adminframe.show();
						dispose();
						
					}
						
					else
						JOptionPane.showMessageDialog(null, "Incorrect credentials");
					con.close();
					
					
				 }catch(Exception e) {System.out.print(e);
				 }
			}
		});
	}
}

