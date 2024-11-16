package mysql;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class cust_page {

	public JFrame frame;
	public JLabel pname;
	
	public JTabbedPane tabbedPane;
	public JTextField c1;
	public JTextField c2;
	public JTextField c3;
	public JTextField c4;
	public JTextField c5;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	public JTextField cc1;
	public JTextField cc2;
	public JTextField cc3;
	public JTextField cc4;
	public JTextField cc5;
	public JTextField cc6;
	public JTextField email1;
	public JTextField ccc1;
	private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust_page window = new cust_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cust_page() {
		initialize();
			
	}/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("customer mode");
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 1148);
		panel.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel nb = new JPanel();
		
		nb.addMouseListener(new PanelButtonMouseAdapter2(nb) {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
				
				String email=email1.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					Statement smt=con.createStatement();
					String sql="Select customer_id,customer_name, customer_phone from customer where customer_email='"+email+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next()) {
						LocalDate date=LocalDate.now();
						
						String in1=rs.getString("customer_id");
						cc1.setText(in1);
						cc5.setText(date.toString());
					}
				}catch(Exception er) {
					System.out.print(er);
				}
			}
		});
		nb.setBackground(new Color(0, 128, 128));
		nb.setBounds(0, 388, 486, 144);
		panel.add(nb);
		nb.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW BOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(144, 53, 216, 41);
		nb.add(lblNewLabel);
		
		JPanel mb = new JPanel();
		mb.addMouseListener(new PanelButtonMouseAdapter2(mb) {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);

				String email=email1.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					Statement smt=con.createStatement();
					String sql="Select customer_id,customer_name, customer_phone from customer where customer_email='"+email+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next()) {
					
						String in1=rs.getString("customer_id");
						ccc1.setText(in1);
						
					}
				}catch(Exception er) {
					System.out.print(er);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					String query2="SELECT booking.service_id, car_no, date, mechanic_id, Bill_amount, Status FROM booking,booking2 WHERE customer_id='"+ccc1.getText()+"' and booking.service_id=booking2.service_id";
					PreparedStatement pssst=con.prepareStatement(query2);
					ResultSet rs2=pssst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception eo) {
					JOptionPane.showMessageDialog(null, eo);
				}
			}
		});
		mb.setBackground(new Color(0, 128, 128));
		mb.setLayout(null);
		mb.setBounds(0, 533, 486, 144);
		panel.add(mb);
		
		JLabel lblMyBookings = new JLabel("MY BOOKINGS");
		lblMyBookings.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMyBookings.setBounds(144, 45, 216, 41);
		mb.add(lblMyBookings);
		
		JPanel nb_1 = new JPanel();
		nb_1.addMouseListener(new PanelButtonMouseAdapter2(nb_1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		nb_1.setLayout(null);
		nb_1.setBackground(new Color(0, 128, 128));
		nb_1.setBounds(0, 673, 486, 144);
		panel.add(nb_1);
		
		JLabel lblNewLabel_1 = new JLabel("ABOUT US");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(170, 53, 216, 41);
		nb_1.add(lblNewLabel_1);
		
		JPanel nb_1_1 = new JPanel();
		nb_1_1.addMouseListener(new PanelButtonMouseAdapter2(nb_1_1));
		nb_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "YOU SURE...?DO YOU WANT TO SIGNOUT..??")==0) {
					customer_login frame1=new customer_login();
					frame1.show();
					frame.dispose();
				}
			}
		});
		
	
	
		nb_1_1.setBounds(0, 812, 486, 133);
		panel.add(nb_1_1);
		nb_1_1.setLayout(null);
		nb_1_1.setBackground(new Color(0, 128, 128));
		
		JLabel lblNewLabel_1_1 = new JLabel("SIGNOUT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(165, 53, 209, 41);
		nb_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new PanelButtonMouseAdapter2(panel_1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
				
				String email=c3.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					Statement smt=con.createStatement();
					String sql="Select customer_id,customer_name, customer_phone from customer where customer_email='"+email+"'";
					ResultSet rs=smt.executeQuery(sql);
					if(rs.next()) {
					
						String in1=rs.getString("customer_id");
						String in2=rs.getString("customer_name");
						String in4=rs.getString("customer_phone");
						
						c1.setText(in1);
						c2.setText(in2);
						c4.setText(in4);
					}
				}catch(Exception er) {
					System.out.print(er);
				}
			}
		});
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(136, 90, 218, 223);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, 0, 219, 223);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setBackground(new Color(32, 178, 170));
		lblNewLabel_8.setIcon(new ImageIcon("images/adminlogo-removebg-preview.png"));
		
		pname = new JLabel("");
		pname.setBounds(173, 333, 303, 29);
		panel.add(pname);
		pname.setFont(new Font("Tahoma", Font.BOLD, 21));
		pname.setForeground(Color.WHITE);
		
		JLabel lblLoggedInBy = new JLabel("Logged in as");
		lblLoggedInBy.setForeground(Color.WHITE);
		lblLoggedInBy.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLoggedInBy.setBounds(36, 333, 133, 29);
		panel.add(lblLoggedInBy);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(633, 58, 1170, 879);
		tabbedPane.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, -26 ) );
		
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome..!!");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.BOLD, 99));
		lblNewLabel_6.setBounds(271, 176, 786, 408);
		panel_7.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("0", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("BOOK FOR SERVICE");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_3.setBounds(324, 42, 576, 117);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Customer ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(345, 253, 199, 40);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Car Make");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1.setBounds(345, 312, 199, 40);
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Model");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_2.setBounds(345, 371, 199, 40);
		panel_3.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Vehicle NO.");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_3.setBounds(345, 431, 199, 40);
		panel_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Date");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_4.setBounds(345, 513, -103, -32);
		panel_3.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Issue with Car");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_5.setBounds(345, 491, 248, 40);
		panel_3.add(lblNewLabel_4_5);
		
		cc1 = new JTextField();
		cc1.setEditable(false);
		cc1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc1.setBounds(574, 253, 285, 40);
		panel_3.add(cc1);
		cc1.setColumns(10);
		
		cc2 = new JTextField();
		cc2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc2.setColumns(10);
		cc2.setBounds(574, 312, 285, 40);
		panel_3.add(cc2);
		
		cc3 = new JTextField();
		cc3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc3.setColumns(10);
		cc3.setBounds(574, 371, 285, 40);
		panel_3.add(cc3);
		
		cc4 = new JTextField();
		cc4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc4.setColumns(10);
		cc4.setBounds(574, 431, 285, 40);
		panel_3.add(cc4);
		
		cc5 = new JTextField();
		cc5.setEditable(false);
		cc5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc5.setColumns(10);
		cc5.setBounds(574, 491, -46, -42);
		panel_3.add(cc5);
		
		cc6 = new JTextField();
		cc6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cc6.setColumns(10);
		cc6.setBounds(574, 492, 285, 40);
		panel_3.add(cc6);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql = "INSERT INTO booking(customer_id, car_make, car_model, car_no, date, prob_des) VALUES (?,?,?,?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					pst= con.prepareStatement(sql);
					pst.setString(1, cc1.getText());
					pst.setString(2, cc2.getText());
					pst.setString(3, cc3.getText());
					pst.setString(4, cc4.getText());
					pst.setString(5, cc5.getText());
					pst.setString(6, cc6.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "BOOKING SUCCESSFUL..CHECK in MY BOOKINGS");
					clear();
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql = "INSERT INTO booking2(mechanic_id, Bill_Amount, Status) VALUES (?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					
					pst= con.prepareStatement(sql);
					pst.setString(1, null);
					pst.setString(2, null);
					pst.setString(3, null);
					pst.executeUpdate();
					
					clear();
					
				}
				catch(Exception ex) {
					
					
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(255, 165, 0));
		btnNewButton.setBounds(548, 610, 105, 27);
		panel_3.add(btnNewButton);
		
		email1 = new JTextField();
		email1.setEditable(false);
		email1.setBounds(101, 269, -20, -42);
		panel_3.add(email1);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("1", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("MY BOOKINGS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_7.setBounds(388, 0, 495, 125);
		panel_4.add(lblNewLabel_7);
		
		ccc1 = new JTextField();
		ccc1.setEditable(false);
		ccc1.setBounds(74, 99, -20, -42);
		panel_4.add(ccc1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 139, 1062, 604);
		panel_4.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBackground(Color.white);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_1.setSelectionBackground(Color.LIGHT_GRAY);
		table_1.setRowHeight(38);
		table_1.setGridColor(Color.RED);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table_1.getTableHeader().setForeground(Color.white);
		table_1.getTableHeader().setBackground(Color.red);
		table_1.setDefaultEditor(Object.class, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		tabbedPane.addTab("2", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("images/aboutus.png"));
		lblNewLabel_9.setBounds(170, -23, 1853, 941);
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("3", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(75, 0, 130));
		panel_6.setBounds(70, 95, 1012, 635);
		panel_2.add(panel_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.textHighlightText);
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 119, 1012, 542);
		panel_6.add(panel_1_1);
		
		JLabel profile1 = new JLabel("CUSTOMER ID");
		profile1.setFont(new Font("Verdana", Font.BOLD, 20));
		profile1.setBounds(406, 102, 168, 89);
		panel_1_1.add(profile1);
		
		JLabel lblNewLabel_5 = new JLabel("NAME");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5.setBounds(406, 161, 168, 89);
		panel_1_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("EMAIL");
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(406, 221, 168, 89);
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("PHONE NUMBER");
		lblNewLabel_5_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5_2.setBounds(406, 281, 198, 89);
		panel_1_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("PASSWORD");
		lblNewLabel_5_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_5_3.setBounds(406, 338, 168, 89);
		panel_1_1.add(lblNewLabel_5_3);
		
		c1 = new JTextField();
		c1.setFont(new Font("Verdana", Font.PLAIN, 20));
		c1.setEditable(false);
		c1.setColumns(10);
		c1.setBounds(609, 128, 271, 36);
		panel_1_1.add(c1);
		
		c2 = new JTextField();
		c2.setFont(new Font("Verdana", Font.PLAIN, 20));
		c2.setColumns(10);
		c2.setBounds(609, 187, 271, 36);
		panel_1_1.add(c2);
		
		c3 = new JTextField();
		c3.setEditable(false);
		c3.setFont(new Font("Verdana", Font.PLAIN, 20));
		c3.setColumns(10);
		c3.setBounds(609, 247, 271, 36);
		panel_1_1.add(c3);
		
		c4 = new JTextField();
		c4.setEditable(false);
		c4.setFont(new Font("Verdana", Font.PLAIN, 20));
		c4.setColumns(10);
		c4.setBounds(609, 307, 271, 36);
		panel_1_1.add(c4);
		
		c5 = new JTextField();
		c5.setFont(new Font("Verdana", Font.PLAIN, 20));
		c5.setColumns(10);
		c5.setBounds(609, 364, 271, 36);
		panel_1_1.add(c5);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("images/adminlogo-removebg-preview.png"));
		lblNewLabel_1_2.setBounds(109, 157, 239, 213);
		panel_1_1.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1 = new JButton("Save Changes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "DO YOU WANT TO SAVE CHANGES..???")==0) {
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver") ;
						String sql1 = "UPDATE customer SET customer_name=?,customer_email=?,customer_phone=?,c_password=? WHERE customer_id=?";
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
						
						pst= con.prepareStatement(sql1);
						
						pst.setString(1, c2.getText());
						pst.setString(2, c3.getText());
						pst.setString(3, c4.getText());
						pst.setString(4, c5.getText());
						pst.setString(5, c1.getText());
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "UPDATE SUCCESFULL");
						
					}
					catch(Exception eu) {
						JOptionPane.showMessageDialog(null, "failed to update");
					}
				   }
			}
		});
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setBounds(531, 437, 168, 36);
		panel_1_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER PROFILE");
		lblNewLabel_2.setForeground(new Color(255, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_2.setBounds(318, -15, 405, 144);
		panel_6.add(lblNewLabel_2);
		frame.setBounds(100,100,1550,948);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		}
	public void clear() {
		cc2.setText(null);
		cc3.setText(null);
		cc4.setText(null);
		cc5.setText(null);
		cc6.setText(null);
		
	}
	public void menuclicked(JPanel panel) {
	}
	
	private class PanelButtonMouseAdapter2 extends MouseAdapter{
		JPanel mb;
		
		public PanelButtonMouseAdapter2(JPanel mb) {
			this.mb=mb;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			mb.setBackground(new Color(41, 200, 141));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			mb.setBackground(new Color(0, 128, 128));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			mb.setBackground(new Color(0, 75, 75));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			mb.setBackground(new Color(41, 200, 141));
		}
		
		
	}
	public static boolean isValid2(String phone)
    {
        String emailRegex ="^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
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
