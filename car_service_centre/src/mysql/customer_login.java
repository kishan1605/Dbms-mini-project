package mysql;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class customer_login extends JFrame {

	private JPanel contentPane;
	public JTextField customer_email;
	private JTextField customer_name;
	private JTextField customer_email1;
	private JTextField customer_phone;
	public JLabel error1;
	public JLabel error2;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JPasswordField c_password;
	private JPasswordField c_password1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_login frame = new customer_login();
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
	public customer_login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(103, 145, 538, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login to your account");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(20, 10, 370, 73);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account? Login here.");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 77, 346, 13);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(0, 115, 538, 375);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(100, 82, 137, 30);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(100, 136, 96, 35);
		panel_2.add(lblNewLabel_5);
		
		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					Statement smt=con.createStatement();
					String sql="Select * from customer where customer_email='"+customer_email.getText()+"' and c_password='"+c_password.getText().toString()+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next()) {
						
						String in3=customer_email.getText();
						String in5=c_password.getText();
						
						cust_page cp=new cust_page();
						cp.pname.setText(in3);
						cp.email1.setText(in3);
						cp.c3.setText(in3);
						cp.c5.setText(in5);
						dispose();
						cp.frame.show();
						
					}
						
					else {
						
					
						JOptionPane.showMessageDialog(null, "Wrong username/password\n or \n Signup Required");
						dispose();
						customer_login frame=new customer_login();
						frame.show();
						
					}
					con.close();
				 }catch(Exception er) {
					 JOptionPane.showMessageDialog(null, er);
				 }
			}
		});
		login.setForeground(new Color(245, 255, 250));
		login.setBackground(new Color(32, 178, 170));
		login.setFont(new Font("Tahoma", Font.BOLD, 17));
		login.setBounds(203, 240, 137, 35);
		panel_2.add(login);
		
		customer_email = new JTextField();
		customer_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		customer_email.setBounds(209, 79, 248, 38);
		panel_2.add(customer_email);
		customer_email.setColumns(10);
		
		c_password = new JPasswordField();
		c_password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		c_password.setBounds(209, 139, 248, 35);
		panel_2.add(c_password);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(205, -71, 530, 258);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("images/signup2.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(732, 145, 538, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRegister = new JLabel("Sign up now");
		lblRegister.setFont(new Font("Verdana", Font.BOLD, 30));
		lblRegister.setBounds(20, 10, 222, 73);
		panel_1.add(lblRegister);
		
		JLabel lblNewLabel_1_1 = new JLabel("Create a Free Account.");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(20, 77, 346, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 125, 538, 365);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if( isValid(customer_email1.getText()) && isValid2(customer_phone.getText())) {
				try {
					error1.setVisible(false);
					error2.setVisible(false);
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql = "INSERT INTO customer(customer_name, customer_email, customer_phone, c_password) VALUES (?,?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					pst= con.prepareStatement(sql);
					pst.setString(1, customer_name.getText());
					pst.setString(2, customer_email1.getText());
					pst.setString(3, customer_phone.getText());
					pst.setString(4, c_password1.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "signup succesfully");
					dispose();
					customer_login frame=new customer_login();
					frame.show();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Already have account.please login");
					dispose();
					customer_login frame=new customer_login();
					frame.show();
				}
			}
			else if( !isValid(customer_email1.getText()) && !isValid2(customer_phone.getText())) {
				error1.setVisible(true);
				error2.setVisible(true);
				
			}
			else if(!isValid(customer_email1.getText())){
				error1.setVisible(true);
				error2.setVisible(false);
			}
			else if(!isValid2(customer_phone.getText())){
				error1.setVisible(false);
				error2.setVisible(true);

			}
			
		  }
		});
		signup.setForeground(new Color(245, 255, 250));
		signup.setFont(new Font("Tahoma", Font.BOLD, 17));
		signup.setBackground(new Color(32, 178, 170));
		signup.setBounds(205, 299, 137, 35);
		panel_3.add(signup);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(79, 101, 137, 30);
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1.setBounds(79, 215, 96, 35);
		panel_3.add(lblNewLabel_5_1);
		
		customer_name = new JTextField();
		customer_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		customer_name.setColumns(10);
		customer_name.setBounds(215, 40, 248, 38);
		panel_3.add(customer_name);
		
		customer_email1 = new JTextField();
		customer_email1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		customer_email1.setColumns(10);
		customer_email1.setBounds(215, 98, 248, 38);
		panel_3.add(customer_email1);
		
		customer_phone = new JTextField();
		customer_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		customer_phone.setColumns(10);
		customer_phone.setBounds(215, 158, 248, 38);
		panel_3.add(customer_phone);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Username");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_1.setBounds(79, 48, 137, 30);
		panel_3.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Phone");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_2.setBounds(79, 161, 137, 30);
		panel_3.add(lblNewLabel_4_1_2);
		
		error1 = new JLabel("invalid email*");
		error1.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		error1.setForeground(new Color(178, 34, 34));
		error1.setBounds(362, 132, 356, 25);
		error1.setVisible(false);
		panel_3.add(error1);
		
		
		error2 = new JLabel("invalid phone*");
		error2.setForeground(new Color(178, 34, 34));
		error2.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		error2.setBounds(362, 191, 356, 25);
		error2.setVisible(false);
		panel_3.add(error2);
		
		c_password1 = new JPasswordField();
		c_password1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		c_password1.setBounds(215, 215, 248, 35);
		panel_3.add(c_password1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(205, -266, 645, 649);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("images/signup3.png"));
		
		JLabel lblNewLabel_6 = new JLabel("CUSTOMER LOGIN");
		lblNewLabel_6.setForeground(SystemColor.textHighlightText);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_6.setBounds(444, 27, 514, 94);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage frame1=new mainpage();
				frame1.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(107, 659, 96, 36);
		contentPane.add(btnNewButton);
	}
	
	public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
 
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
            
        }
        
        if(pat.matcher(email).matches()) {
        	return true;
        }
        else {
        	return false;
        }
    }
	
	public static boolean isValid2(String phone)
    {
        String emailRegex = "(0/91)?[7-9][0-9]{9}";
 
        Pattern pat = Pattern.compile(emailRegex);
        if (phone == null) {
            return false;
            
        }
        
        if(pat.matcher(phone).matches()) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
