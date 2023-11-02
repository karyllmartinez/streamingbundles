import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;


public class CustomerService extends JFrame {

	private JPanel contentPane;

	/*
	 * Launch the application.
	 */
	int xMouse;
	int yMouse;
	private Image img_back = new ImageIcon(ProjectMain.class.getResource("res/back.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerService frame = new CustomerService();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerService() {
		
		setBackground(new Color(0, 128, 128));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel1 = new JLabel("CUSTOMER SERVICE");
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setBackground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel1.setBounds(88, 45, 292, 66);
			contentPane.add(lblNewLabel1);
		
		// We're here to help
			JLabel lblNewLabel2 = new JLabel("We're here to help");
			lblNewLabel2.setForeground(new Color(255, 255, 255));
			lblNewLabel2.setBackground(new Color(30, 144, 255));
			lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel2.setBounds(26, 121, 292, 54);
				contentPane.add(lblNewLabel2);
			
			JLabel lblNewLabel3 = new JLabel("<html>We love hearing from our customers and we value your feedback. Send us your questions,\r\n"
					+ "comments or feedback so we can serve you better.</html>");
			lblNewLabel3.setForeground(new Color(255, 255, 255));
			lblNewLabel3.setBackground(new Color(30, 144, 255));
			lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel3.setBounds(26, 177, 570, 80);
				contentPane.add(lblNewLabel3);
			
			JLabel lblNewLabel4 = new JLabel("<html>Just fill in the contact form, and we will answer you shortly.\r\n"
					+ "If you are living nearby, come visit <b>GeeSix+</b> at our comfortable offices.</html>");
			lblNewLabel4.setForeground(new Color(255, 255, 255));
			lblNewLabel4.setBackground(new Color(30, 144, 255));
			lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel4.setBounds(26, 197, 570, 200);
				contentPane.add(lblNewLabel4);
		
		// Connect With Us
			JLabel lblNewLabel5 = new JLabel("Connect With Us");
			lblNewLabel5.setForeground(new Color(255, 255, 255));
			lblNewLabel5.setBackground(new Color(30, 144, 255));
			lblNewLabel5.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel5.setBounds(658, 80, 292, 54);
				contentPane.add(lblNewLabel5);
				
			JLabel lblNewLabel6 = new JLabel("<html>For support or any questions:<br>Email us at <b><u>geesixplus@gmail.com</u></b></html>");
			lblNewLabel6.setForeground(new Color(255, 255, 255));
			lblNewLabel6.setBackground(new Color(30, 144, 255));
			lblNewLabel6.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel6.setBounds(658, 129, 292, 54);
				contentPane.add(lblNewLabel6);
				
			JLabel lblSocMed = new JLabel("<html><b>Facebook:</b> facebook.com/ GeeSixPlus<br>"
					+ "<b>Instagram:</b> instagram.com/ geesixplus<br>"
					+ "<b>Twitter:</b> twitter.com/ geesixplus<<br></html>");
			lblSocMed.setForeground(new Color(255, 255, 255));
			lblSocMed.setBackground(new Color(30, 144, 255));
			lblSocMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSocMed.setBounds(658, 197, 292, 60);
					contentPane.add(lblSocMed);
			
			JLabel lblNewLabel7 = new JLabel("Phone:");
			lblNewLabel7.setForeground(new Color(255, 255, 255));
			lblNewLabel7.setBackground(new Color(30, 144, 255));
			lblNewLabel7.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel7.setBounds(658, 270, 292, 54);
				contentPane.add(lblNewLabel7);
			

			JLabel lblNewLabel8 = new JLabel("<html>+639359084452<br>\r\n"
					+ "Monday - Saturday<br>\r\n"
					+ "9:00 AM - 9:00 PM<br><html>");
			lblNewLabel8.setForeground(new Color(255, 255, 255));
			lblNewLabel8.setBackground(new Color(30, 144, 255));
			lblNewLabel8.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel8.setBounds(658, 327, 292, 54);
				contentPane.add(lblNewLabel8);
		
		JLabel lblBack = new JLabel("");
		
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ProjectMain adminBackbtn = new ProjectMain();
				adminBackbtn.show() ;
				dispose();	
			}
		});
		lblBack.setBounds(26, 42, 71, 72);
		contentPane.add(lblBack);
		lblBack.setIcon(new ImageIcon(img_back));
		
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
		
		JLabel lblExit = new JLabel("X");
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
		
		
	}

}