import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JLabel lblpassword;
	private JPasswordField password;
	private JButton submitBtn;
	private JLabel lblExit;
	private JLabel lblBack;

	private Image img_back = new ImageIcon(ProjectMain.class.getResource("res/back.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	int xMouse;
	int yMouse;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
				
		JLabel adminLabel = new JLabel("ADMIN PANEL ");
		adminLabel.setForeground(new Color(255, 255, 255));
		adminLabel.setBackground(new Color(255, 255, 255));
		adminLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		adminLabel.setBounds(420, 51, 160, 117);
		contentPane.add(adminLabel);
		
		username = new JTextField();
		username.setBounds(379, 178, 286, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblusername = new JLabel("Username: ");
		lblusername.setForeground(new Color(255, 255, 255));
		lblusername.setBackground(new Color(255, 255, 255));
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusername.setBounds(281, 185, 88, 13);
		contentPane.add(lblusername);
		
		lblpassword = new JLabel("Password:");
		lblpassword.setForeground(new Color(255, 255, 255));
		lblpassword.setBackground(new Color(255, 255, 255));
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpassword.setBounds(281, 260, 88, 13);
		contentPane.add(lblpassword);
		
		password = new JPasswordField();
		password.setBounds(379, 253, 286, 32);
		contentPane.add(password);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setBackground(new Color(255, 255, 255));
		submitBtn.setFocusPainted(false);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = username.getText();
				String pword = password.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/streamingservicesproject", "root", "Asawanikenshin12");
					
					Statement stmnt = cn.createStatement();
					ResultSet rs = stmnt.executeQuery("select username, password from adminlogin");
					
					while (rs.next()) {
						String dusername = rs.getString(1);	
						String dpassword = rs.getString(2);
						
						if (uname.equals(dusername) & pword.equals(dpassword)) {
							Monitoring monitor = new Monitoring();
							monitor.setVisible(true);
							dispose(); 
						}else {
							Admin adframe = new Admin();
							JOptionPane.showMessageDialog(adframe, "Wrong username or password!");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Something is wrong");
				}
				}
		});
		submitBtn.setBounds(460, 326, 120, 37);
		contentPane.add(submitBtn);
		

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
					setLocation(getX() + evt.getX() - xMouse, getY() + evt.getY() - yMouse );
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				 xMouse  = evt.getX();
				 yMouse = evt.getY();
			}
		});
		panel.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panel.setBounds(0, 0, 967, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(940, 0, 17, 35);
		panel.add(lblExit);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 29));
		
		lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ProjectMain adminBackbtn = new ProjectMain();
				adminBackbtn.show() ;
				dispose();	
			}
		});
		lblBack.setBounds(21, 51, 40, 69);
		contentPane.add(lblBack);
		lblBack.setIcon(new ImageIcon(img_back));
		
		
	}
}
