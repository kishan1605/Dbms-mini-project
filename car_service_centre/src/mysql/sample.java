package mysql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.util.Date;
public class sample {

	public JFrame adminframe;
	private JPanel contentPane;
	private JTextField mechanic_id;
	private JTextField mechanic_name;
	private JTextField mechanic_phone;
	private JTextField salary;
	public JTextField doj;
	private JTextField skills;
	private JTable table;
	public JPanel panel;
	public JPanel panel_1;
	public JPanel panel_8;
	public JPanel panel_2;
	public JPanel panel_4;
	public JTabbedPane tabbedPane;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	private JTable table_1;
	private JTextField mechanic_id1;
	public JTextField a1;
	public JTextField a2;
	public JTextField a3;
	public JTextField a4;
	public JTextField a5;
	private JTable table_2;
	private JTable table_3;
	private JTextField m2;
	private JTextField m3;
	private JTextField m1;
	public JLabel error1;
	public JLabel error2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample window = new sample();
					window.adminframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sample() {
		
		initialize();
		showtable_1();
		clear();
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
			Statement smt=con.createStatement();
			String sql="Select * from admin";
			ResultSet rs=smt.executeQuery(sql);
			if(rs.next()) {
			
				String in2=rs.getString("Admin_Name");
				String in3=rs.getString("Admin_email");
				String in4=rs.getString("Admin_Ph");
				a2.setText(in2);
				a3.setText(in3);
				a4.setText(in4);
			}
		}catch(Exception er) {
			System.out.print(er);
		}
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
			String query2="SELECT customer_id, customer_name, customer_email, customer_phone FROM customer";
			PreparedStatement pssst=con.prepareStatement(query2);
			ResultSet rs2=pssst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs2));
		}catch(Exception eo) {
			
		}
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
			String query="SELECT mechanic_id, mechanic_name, mechanic_phone, salary, doj, skills  FROM mechanic;";
			PreparedStatement psst=con.prepareStatement(query);
			ResultSet rs=psst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			JPanel menupanel = new JPanel();
			menupanel.setBounds(41, 50, 1840, 74);
			adminframe.getContentPane().add(menupanel);
			menupanel.setLayout(null);
			
			JPanel menu = new JPanel();
			menu.addMouseListener(new PanelButtonMouseAdapter2(menu) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					tabbedPane.setSelectedIndex(0);
				}
			});
			menu.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			menu.setBackground(new Color(0, 128, 128));
			menu.setBounds(0, 0, 350, 74);
			menupanel.add(menu);
			menu.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("CUSTOMERs ");
			lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 29));
			lblNewLabel_8.setForeground(new Color(0, 0, 0));
			lblNewLabel_8.setBounds(29, 12, 230, 50);
			menu.add(lblNewLabel_8);
			
			JPanel menu_1 = new JPanel();
			menu_1.addMouseListener(new PanelButtonMouseAdapter2(menu_1) {
				@Override
				public void mouseClicked(MouseEvent e) {
					tabbedPane.setSelectedIndex(1);
					

					try {
						Class.forName("com.mysql.jdbc.Driver") ;
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
						String query2="SELECT service_id, customer_id, car_make, car_model, car_no, date, prob_des FROM booking";
						PreparedStatement pssst=con.prepareStatement(query2);
						ResultSet rs2=pssst.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs2));
					}catch(Exception eo) {
						JOptionPane.showMessageDialog(null, eo);
					}
				}
			});
			menu_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			menu_1.setBackground(new Color(0, 128, 128));
			menu_1.setBounds(349, 0, 350, 74);
			menupanel.add(menu_1);
			menu_1.setLayout(null);
			
			JLabel lblNewLabel_8_1 = new JLabel("BOOKINGs");
			lblNewLabel_8_1.setForeground(Color.BLACK);
			lblNewLabel_8_1.setFont(new Font("Dialog", Font.BOLD, 29));
			lblNewLabel_8_1.setBounds(35, 12, 230, 50);
			menu_1.add(lblNewLabel_8_1);
			
			JPanel menu_2 = new JPanel();
			menu_2.addMouseListener(new PanelButtonMouseAdapter2(menu_2) {
				@Override
				public void mouseClicked(MouseEvent e) {
					tabbedPane.setSelectedIndex(2);
					

					try {
						Class.forName("com.mysql.jdbc.Driver") ;
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
						String query2="SELECT A.service_id,prob_des, mechanic_id, Bill_amount, Status FROM booking2 A ,booking B where A.service_id=B.service_id";
						PreparedStatement pssst=con.prepareStatement(query2);
						ResultSet rs2=pssst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs2));
					}catch(Exception eo) {
						JOptionPane.showMessageDialog(null, eo);
					}
				}
			});
			menu_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			menu_2.setBackground(new Color(0, 128, 128));
			menu_2.setBounds(699, 0, 379, 74);
			menupanel.add(menu_2);
			menu_2.setLayout(null);
			
			JLabel lblNewLabel_8_2 = new JLabel("ALLOCATION");
			lblNewLabel_8_2.setForeground(Color.BLACK);
			lblNewLabel_8_2.setFont(new Font("Dialog", Font.BOLD, 29));
			lblNewLabel_8_2.setBounds(39, 12, 230, 50);
			menu_2.add(lblNewLabel_8_2);
			
			JPanel menu_5 = new JPanel();
			menu_5.addMouseListener(new PanelButtonMouseAdapter2(menu_5) {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					tabbedPane.setSelectedIndex(4);
				}
			});
			menu_5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			menu_5.setBackground(new Color(0, 128, 128));
			menu_5.setBounds(1443, 0, 397, 74);
			menupanel.add(menu_5);
			menu_5.setLayout(null);
			
			JLabel lblNewLabel_8_4 = new JLabel("PROFILE");
			lblNewLabel_8_4.setForeground(Color.BLACK);
			lblNewLabel_8_4.setFont(new Font("Dialog", Font.BOLD, 29));
			lblNewLabel_8_4.setBounds(33, 12, 230, 50);
			menu_5.add(lblNewLabel_8_4);
			
			JPanel menu_4 = new JPanel();
			menu_4.addMouseListener(new PanelButtonMouseAdapter2(menu_4) {
				@Override
				public void mouseClicked(MouseEvent e) {
					tabbedPane.setSelectedIndex(3);
				}
			});
			menu_4.setBackground(new Color(0, 128, 128));
			menu_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			menu_4.setBounds(1078, 0, 365, 74);
			menupanel.add(menu_4);
			menu_4.setLayout(null);
			
			JLabel lblNewLabel_8_3 = new JLabel("MECHANICs");
			lblNewLabel_8_3.setForeground(Color.BLACK);
			lblNewLabel_8_3.setFont(new Font("Dialog", Font.BOLD, 29));
			lblNewLabel_8_3.setBounds(35, 12, 230, 50);
			menu_4.add(lblNewLabel_8_3);
		}
		catch(Exception er) {
			System.out.print(er);
		}
	
	}
	public void showtable_1() {
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
			String query="SELECT mechanic_id, mechanic_name, mechanic_phone, salary, doj, skills  FROM mechanic;";
			PreparedStatement psst=con.prepareStatement(query);
			ResultSet rs=psst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception er) {
			System.out.print(er);
		}
	}
	
	public void clear() {
		mechanic_id.setText(null);
		mechanic_id1.setText(null);
		mechanic_name.setText(null);
		mechanic_id.setText(null);
		mechanic_phone.setText(null);
		salary.setText(null);
		doj.setText(null);
		skills.setText(null);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminframe = new JFrame("Display mode");
		adminframe.setTitle("Admin mode");
		adminframe.getContentPane().setBackground(new Color(95, 158, 160));
		adminframe.setBounds(100,100,1800,1080);
		adminframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		adminframe.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(41, 122, 1840,885);
		adminframe.getContentPane().add(tabbedPane);
		/*table.setSelectionForeground(Color.white);*/
		
		panel = new JPanel();
		panel.setBackground(new Color(206, 239, 255));
		tabbedPane.addTab("CUSTOMERs", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(46, 32, 1749, 798);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 152, 1725, 627);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 170));
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setRowHeight(40);
		table.setGridColor(SystemColor.textText);
		
		JLabel lblNewLabel = new JLabel("CUSTOMERS LIST");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 60));
		lblNewLabel.setBounds(557, 0, 601, 145);
		panel_3.add(lblNewLabel);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 21));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		
		tabbedPane.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, -26 ) );
		tabbedPane.setBackground(Color.PINK);
		tabbedPane.setForeground(new Color(0, 0, 96));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(206, 239, 255));
		tabbedPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("BOOKINGS");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_9.setBounds(718, 12, 507, 134);
		panel_1_1.add(lblNewLabel_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(35, 158, 1775, 694);
		panel_1_1.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setBackground(new Color(255, 170, 170));
		table_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		table_2.setSelectionBackground(new Color(255,255,170));
		table_2.setRowHeight(40);
		table_2.setGridColor(SystemColor.textText);
		table_2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table_2.getTableHeader().setForeground(Color.white);
		table_2.getTableHeader().setBackground(new Color(0,64,128));
		table_2.setDefaultEditor(Object.class, null);
		
		
		
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(206, 239, 255));
		tabbedPane.addTab("New tab", null, panel_8_1, null);
		panel_8_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(59, 346, 1700, 313);
		panel_8_1.add(scrollPane_3);
		
		
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(72, 61, 139));
		panel_12.setBounds(59, 160, 1700, 169);
		panel_8_1.add(panel_12);
		panel_12.setLayout(null);
		
		m2 = new JTextField();
		m2.setFont(new Font("Dialog", Font.PLAIN, 19));
		m2.setBounds(573, 48, 230, 32);
		panel_12.add(m2);
		m2.setColumns(10);
		
		m3 = new JTextField();
		m3.setFont(new Font("Dialog", Font.PLAIN, 19));
		m3.setColumns(10);
		m3.setBounds(996, 48, 230, 32);
		panel_12.add(m3);
		
		String[] boo= {"","Accepted","In progress","Done"};
		JComboBox m4 = new JComboBox(boo);
		m4.setBounds(1372, 48, 220, 31);
		panel_12.add(m4);
		
		table_3 = new JTable();
		table_3.setDefaultEditor(Object.class, null);
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row=table_3.getSelectedRow();
				m1.setText(table_3.getModel().getValueAt(row, 0).toString());
				m2.setText(table_3.getModel().getValueAt(row, 2).toString());
				m3.setText(table_3.getModel().getValueAt(row, 3).toString());
				TableModel model=table_3.getModel();
				String op=model.getValueAt(row, 4).toString();
				switch(op) {
				  case "":
					  m4.setSelectedIndex(0);
					  break;
				  case "Accepted":
					  m4.setSelectedIndex(1);
					  break;
				  case "In progress":
					  m4.setSelectedIndex(2);
					  break;
				  case "Done":
					  m4.setSelectedIndex(3);
					  break;
				}
				
			}
		});
		scrollPane_3.setViewportView(table_3);
		table_3.setBackground(new Color(255, 170, 170));
		table_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		table_3.setSelectionBackground(new Color(255,255,170));
		table_3.setRowHeight(40);
		table_3.setGridColor(SystemColor.textText);
		
		
		
		table_3.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table_3.getTableHeader().setForeground(Color.white);
		table_3.getTableHeader().setBackground(new Color(0,64,128));
		
		JLabel lblNewLabel_11 = new JLabel("Mechanic ID");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11.setForeground(new Color(248, 248, 255));
		lblNewLabel_11.setBounds(453, 55, 161, 16);
		panel_12.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Bill Amount");
		lblNewLabel_11_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_11_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(877, 55, 161, 16);
		panel_12.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Status");
		lblNewLabel_11_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_11_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11_2.setBounds(1297, 55, 161, 16);
		panel_12.add(lblNewLabel_11_2);
		
		JButton btnNewButton_2 = new JButton("ALLOCATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql1 = "UPDATE booking2 SET mechanic_id=?,Bill_amount=?,Status=? WHERE service_id=?";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					
					pst= con.prepareStatement(sql1);
					pst.setString(4, m1.getText());
					pst.setString(1, m2.getText());
					pst.setString(2, m3.getText());
					pst.setString(3, m4.getSelectedItem().toString());
					
					pst.executeUpdate();

					try {
						Class.forName("com.mysql.jdbc.Driver") ;
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
						String query2="SELECT A.service_id,prob_des, mechanic_id, Bill_amount, Status FROM booking2 A ,booking B where A.service_id=B.service_id";
						PreparedStatement pssst=con.prepareStatement(query2);
						ResultSet rs2=pssst.executeQuery();
						table_3.setModel(DbUtils.resultSetToTableModel(rs2));
					}catch(Exception eo) {
						JOptionPane.showMessageDialog(null, eo);
					}
					
				}
				catch(Exception eu) {
					JOptionPane.showMessageDialog(null, "Mechanic no longer working/ Invalid");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(587, 110, 129, 26);
		panel_12.add(btnNewButton_2);
		
		m1 = new JTextField();
		m1.setEditable(false);
		m1.setFont(new Font("Dialog", Font.PLAIN, 19));
		m1.setColumns(10);
		m1.setBounds(143, 48, 230, 32);
		panel_12.add(m1);
		
		JLabel lblNewLabel_11_3 = new JLabel("Service ID");
		lblNewLabel_11_3.setForeground(new Color(248, 248, 255));
		lblNewLabel_11_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_11_3.setBounds(33, 58, 161, 16);
		panel_12.add(lblNewLabel_11_3);
		
		JButton deleteserv = new JButton("DELETE");
		deleteserv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql2 = "DELETE FROM booking WHERE service_id=?";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					pst= con.prepareStatement(sql2);
					pst.setString(1, m1.getText());
					pst.executeUpdate();
					showtable_1();
					clear();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
		        } 
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					String query2="SELECT A.service_id,prob_des, mechanic_id, Bill_amount, Status FROM booking2 A ,booking B where A.service_id=B.service_id";
					PreparedStatement pssst=con.prepareStatement(query2);
					ResultSet rs2=pssst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception eo) {
					JOptionPane.showMessageDialog(null, eo);
				}
			}
		});
		deleteserv.setForeground(Color.BLACK);
		deleteserv.setFont(new Font("Dialog", Font.BOLD, 15));
		deleteserv.setBackground(Color.RED);
		deleteserv.setBounds(862, 110, 129, 26);
		panel_12.add(deleteserv);
		
		JLabel lblNewLabel_10 = new JLabel("ALLOCATION AND BILLING");
		lblNewLabel_10.setBounds(370, 26, 1134, 103);
		lblNewLabel_10.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 72));
		panel_8_1.add(lblNewLabel_10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(206, 239, 255));
		tabbedPane.addTab("MECHANICs", null, panel_2_1, null);
		panel_2_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 100, 0)));
		panel_5.setBackground(new Color(202, 247, 193));
		panel_5.setBounds(29, 45, 498, 516);
		panel_2_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Insertion/Updation:");
		lblNewLabel_2.setForeground(new Color(46, 139, 87));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(98, 0, 321, 67);
		panel_5.add(lblNewLabel_2);
		
		
		
		JButton add = new JButton("Insert");
		add.addActionListener(new ActionListener() {
			  
			public void actionPerformed(ActionEvent e) {
				
					
				if(isValid2(mechanic_phone.getText())) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql = "INSERT INTO mechanic (mechanic_id, mechanic_name, mechanic_phone, salary, doj, skills) VALUES(?,?,?,?,?,?)";
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					pst= con.prepareStatement(sql);
					pst.setString(1, mechanic_id.getText());
					pst.setString(2, mechanic_name.getText());
					pst.setString(3, mechanic_phone.getText());
					pst.setString(4, salary.getText());
					pst.setString(5, doj.getText());
					pst.setString(6, skills.getText());
					pst.executeUpdate();
					showtable_1();
					clear();
					error1.setVisible(false);
					error2.setVisible(false);
					
				}
				catch(Exception ei) {
					JOptionPane.showMessageDialog(null, "Please check the details");
					
				}
				}
				else if(!isValid2(mechanic_phone.getText())){
					error1.setVisible(true);
					
				}
				
			}
				
			
		});
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setBounds(12, 448, 95, 38);
		panel_5.add(add);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isValid2(mechanic_phone.getText())) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql1 = "UPDATE mechanic SET mechanic_name=?,mechanic_phone=?,salary=?,doj=?,skills=? WHERE mechanic_id=?";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					
					pst= con.prepareStatement(sql1);
					pst.setString(6, mechanic_id.getText());
					pst.setString(1, mechanic_name.getText());
					pst.setString(2, mechanic_phone.getText());
					pst.setString(3, salary.getText());
					pst.setString(4, doj.getText());
					pst.setString(5, skills.getText());
					pst.executeUpdate();
					showtable_1();
					clear();
					error1.setVisible(false);
				}
				catch(Exception eu) {
					JOptionPane.showMessageDialog(null, "failed to update");
				}
				}
				else if(!isValid2(mechanic_phone.getText())){
					error1.setVisible(true);
					
				}
			}
		});
		update.setForeground(Color.WHITE);
		update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		update.setBackground(Color.BLACK);
		update.setBounds(119, 448, 95, 38);
		panel_5.add(update);
		
		JLabel lblNewLabel_4 = new JLabel("Mechanic ID");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(21, 95, 128, 23);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mechanic Name");
		lblNewLabel_4_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(21, 153, 169, 23);
		panel_5.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Phone number");
		lblNewLabel_4_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(21, 215, 157, 23);
		panel_5.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Salary\r\n");
		lblNewLabel_4_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(21, 269, 128, 23);
		panel_5.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("DOJ");
		lblNewLabel_4_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_4.setBounds(21, 331, 128, 23);
		panel_5.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Skills");
		lblNewLabel_4_5.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_5.setBounds(21, 389, 128, 23);
		panel_5.add(lblNewLabel_4_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		panel_6.setBackground(new Color(255, 187, 187));
		panel_6.setBounds(29, 573, 498, 157);
		panel_2_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Deletion:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(170, 23, 155, 31);
		panel_6.add(lblNewLabel_3);
		
		mechanic_id1 = new JTextField();
		mechanic_id1.setFont(new Font("Tahoma", Font.BOLD, 17));
		mechanic_id1.setColumns(10);
		mechanic_id1.setBounds(170, 87, 255, 31);
		panel_6.add(mechanic_id1);
		
		JLabel lblNewLabel_4_6 = new JLabel("Mechanic ID");
		lblNewLabel_4_6.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4_6.setBounds(24, 90, 128, 23);
		panel_6.add(lblNewLabel_4_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Class.forName("com.mysql.jdbc.Driver") ;
						String sql2 = "DELETE FROM mechanic WHERE mechanic_id=?";
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
						pst= con.prepareStatement(sql2);
						pst.setString(1, mechanic_id1.getText());
						pst.executeUpdate();
						showtable_1();
						clear();
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Please assign this mechanic's work to others and then try again");
			        }    
			  }
		});
		btnNewButton.setIcon(new ImageIcon("images/deletebtn.jpeg"));
		btnNewButton.setBounds(440, 87, 35, 31);
		panel_6.add(btnNewButton);
		
		skills = new JTextField();
		skills.setBounds(208, 387, 255, 30);
		panel_5.add(skills);
		skills.setFont(new Font("Tahoma", Font.BOLD, 17));
		skills.setColumns(10);
		
		doj = new JTextField();
		doj.setBounds(208, 329, 255, 30);
		panel_5.add(doj);
		doj.setFont(new Font("Tahoma", Font.BOLD, 17));
		doj.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(208, 267, 255, 30);
		panel_5.add(salary);
		salary.setFont(new Font("Tahoma", Font.BOLD, 17));
		salary.setColumns(10);
		
		mechanic_phone = new JTextField();
		mechanic_phone.setBounds(208, 213, 255, 29);
		panel_5.add(mechanic_phone);
		mechanic_phone.setFont(new Font("Tahoma", Font.BOLD, 17));
		mechanic_phone.setColumns(10);
		
		mechanic_name = new JTextField();
		mechanic_name.setBounds(208, 151, 255, 29);
		panel_5.add(mechanic_name);
		mechanic_name.setBackground(new Color(255, 255, 255));
		mechanic_name.setFont(new Font("Tahoma", Font.BOLD, 17));
		mechanic_name.setColumns(10);
		
		
		mechanic_id = new JTextField();
		mechanic_id.setBounds(208, 93, 255, 29);
		panel_5.add(mechanic_id);
		mechanic_id.setFont(new Font("Tahoma", Font.BOLD, 17));
		mechanic_id.setColumns(10);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mechanic_id.setText(null);
				mechanic_name.setText(null);
				mechanic_phone.setText(null);
				salary.setText(null);
				doj.setText(null);
				skills.setText(null);
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clear.setBackground(Color.BLACK);
		clear.setBounds(226, 448, 95, 38);
		panel_5.add(clear);
		
		JButton hike = new JButton("SALARY UP(500)");
		hike.setHorizontalAlignment(SwingConstants.LEADING);
		hike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					String sql_string = "CALL `sal_hike`();";
					CallableStatement cs = con.prepareCall(sql_string);
					cs.execute();
					showtable_1();
					JOptionPane.showMessageDialog(null, "DONE");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				
			}
		});
		hike.setBounds(333, 440, 152, 30);
		panel_5.add(hike);
		hike.setForeground(Color.WHITE);
		hike.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hike.setBackground(Color.BLACK);
		
		JButton btnSalaryDown = new JButton("DOWN(by 500)");
		btnSalaryDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					String sql_string = "CALL `salary_down`();";
					CallableStatement cs = con.prepareCall(sql_string);
					cs.execute();
					showtable_1();
					JOptionPane.showMessageDialog(null, "DONE");
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					
				}
			}
		});
		btnSalaryDown.setForeground(Color.WHITE);
		btnSalaryDown.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalaryDown.setBackground(Color.BLACK);
		btnSalaryDown.setBounds(333, 473, 152, 30);
		panel_5.add(btnSalaryDown);
		
		error1 = new JLabel("INVALID PHONE NUMBER");
		error1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		error1.setForeground(new Color(128, 0, 0));
		error1.setBounds(311, 239, 174, 16);
		panel_5.add(error1);
		
		error2 = new JLabel("INVALID DATE");
		error2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		error2.setForeground(new Color(128, 0, 0));
		error2.setBounds(367, 359, 118, 16);
		panel_5.add(error2);
		error1.setVisible(false);
		error2.setVisible(false);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.infoText);
		panel_7.setBounds(580, 45, 1226, 685);
		panel_2_1.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 57, 1204, 616);
		panel_7.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				mechanic_id.setText(table_1.getModel().getValueAt(row, 0).toString());
				mechanic_name.setText(table_1.getModel().getValueAt(row, 1).toString());
				mechanic_phone.setText(table_1.getModel().getValueAt(row, 2).toString());
				salary.setText(table_1.getModel().getValueAt(row, 3).toString());
				doj.setText(table_1.getModel().getValueAt(row, 4).toString());
				skills.setText(table_1.getModel().getValueAt(row, 5).toString());
			}
		});
		scrollPane_1.setViewportView(table_1);
		

		table_1.setBackground(Color.white);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		table_1.setSelectionBackground(Color.LIGHT_GRAY);
		table_1.setRowHeight(38);
		table_1.setGridColor(Color.RED);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table_1.getTableHeader().setForeground(Color.white);
		table_1.getTableHeader().setBackground(Color.red);
		table_1.setDefaultEditor(Object.class, null);
		
		JLabel lblNewLabel_1 = new JLabel("MECHANIC LIST\r\n");
		lblNewLabel_1.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(480, 12, 284, 37);
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(206, 239, 255));
		tabbedPane.addTab("PROFILE", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.activeCaptionBorder);
		panel_9.setBounds(328, 126, 1190, 562);
		panel_4.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(75, 0, 130));
		panel_10.setBounds(0, 0, 1190, 95);
		panel_9.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ADMIN PROFILE");
		lblNewLabel_7.setBounds(399, 12, 435, 61);
		panel_10.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(255, 128, 128));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.window);
		panel_11.setBounds(0, 94, 1190, 515);
		panel_9.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(141, 93, 219, 230);
		panel_11.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon("images/adminlogo-removebg-preview.png"));
		
		JLabel lblNewLabel_5 = new JLabel("ADMIN ID");
		lblNewLabel_5.setBounds(488, 41, 168, 89);
		panel_11.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel_5_1 = new JLabel("ADMIN NAME");
		lblNewLabel_5_1.setBounds(488, 93, 168, 89);
		panel_11.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel_5_2 = new JLabel("ADMIN EMAIL");
		lblNewLabel_5_2.setBounds(488, 152, 168, 89);
		panel_11.add(lblNewLabel_5_2);
		lblNewLabel_5_2.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel_5_3 = new JLabel("ADMIN PHONE");
		lblNewLabel_5_3.setBounds(488, 208, 168, 89);
		panel_11.add(lblNewLabel_5_3);
		lblNewLabel_5_3.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNewLabel_5_4 = new JLabel("PASSWORD");
		lblNewLabel_5_4.setBounds(488, 263, 168, 89);
		panel_11.add(lblNewLabel_5_4);
		lblNewLabel_5_4.setFont(new Font("Verdana", Font.BOLD, 20));
		
		a1 = new JTextField();
		a1.setEditable(false);
		a1.setBounds(752, 67, 236, 36);
		panel_11.add(a1);
		a1.setFont(new Font("Verdana", Font.PLAIN, 20));
		a1.setColumns(10);
		
		
		a2 = new JTextField();
		a2.setBounds(752, 119, 236, 36);
		panel_11.add(a2);
		a2.setFont(new Font("Verdana", Font.PLAIN, 20));
		a2.setColumns(10);
		
		
		a3 = new JTextField();
		a3.setEditable(false);
		a3.setBounds(752, 178, 236, 36);
		panel_11.add(a3);
		a3.setFont(new Font("Verdana", Font.PLAIN, 20));
		a3.setColumns(10);
		
		a4 = new JTextField();
		a4.setEditable(false);
		a4.setBounds(752, 234, 236, 36);
		panel_11.add(a4);
		a4.setFont(new Font("Verdana", Font.PLAIN, 20));
		a4.setColumns(10);
		
		a5 = new JTextField();
		a5.setBounds(752, 289, 236, 36);
		panel_11.add(a5);
		a5.setFont(new Font("Verdana", Font.PLAIN, 20));
		a5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save Changes");
		btnNewButton_1.setBounds(622, 365, 168, 36);
		panel_11.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 17));
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		
		JButton btnNewButton_3 = new JButton("LOG OUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "YOU SURE...?DO YOU WANT TO SIGNOUT..??")==0) {
					login1 frame1=new login1();
					frame1.show();
					adminframe.dispose();
				}
			}
		});
		btnNewButton_3.setBounds(165, 345, 180, 56);
		panel_11.add(btnNewButton_3);
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setForeground(new Color(240, 255, 240));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "DO YOU WANT TO SAVE CHANGES..???")==0) {
					
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					String sql1 = "UPDATE admin SET Admin_id=?,Admin_Name=?,Admin_email=?,Admin_Ph=?,A_Password=? WHERE Admin_id=?";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
					
					pst= con.prepareStatement(sql1);
					pst.setString(6, a1.getText());
					pst.setString(1, a1.getText());
					pst.setString(2, a2.getText());
					pst.setString(3, a3.getText());
					pst.setString(4, a4.getText());
					pst.setString(5, a5.getText());
					pst.executeUpdate();
					showtable_1();
					clear();
					JOptionPane.showMessageDialog(null, "UPDATE SUCCESFULL");
					
				}
				catch(Exception eu) {
					JOptionPane.showMessageDialog(null, "failed to update");
				}
			   }
			}
		});
		/*table.setSelectionForeground(Color.white);*/
		
		
		
	}
	private void menuclicked(JPanel pan) {
		panel.setVisible(false);
		panel_1.setVisible(false);
		panel_8.setVisible(false);
		panel_2.setVisible(false);
		panel_4.setVisible(false);
		
		pan.setVisible(true);
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
	
	public static boolean compareDates(LocalDate date1)
    {
        LocalDate date2;
        date2=LocalDate.now();
		
		

        //date object is having 3 methods namely after,before and equals for comparing
        //after() will return true if and only if date1 is after date 2
        if(date1.isAfter(date2)){
            return false;
        }

        //before() will return true if and only if date1 is before date2
        else if(date1.isBefore(date2)){
        	 return true;
        }

        //equals() returns true if both the dates are equal
        else if(date1.isEqual(date2)){
        	 return true;
        }
        else 
        	return true;

        
    }
}
