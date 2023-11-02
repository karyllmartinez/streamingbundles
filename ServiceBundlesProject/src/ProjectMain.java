import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ProjectMain extends JFrame {
	
	//Images 
	private Image img_tv = new ImageIcon(ProjectMain.class.getResource("res/tv.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_admin = new ImageIcon(ProjectMain.class.getResource("res/admin.png")).getImage().getScaledInstance(50, 50 , Image.SCALE_SMOOTH);
	private Image img_view = new ImageIcon(ProjectMain.class.getResource("res/view.png")).getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
	private Image img_buy = new ImageIcon(ProjectMain.class.getResource("res/buy.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_service = new ImageIcon(ProjectMain.class.getResource("res/customerservice.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;

	//variables that will be used to move undecorated jframe
	int xMouse;
	int yMouse;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectMain frame = new ProjectMain();
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
	public ProjectMain() {
		setBackground(new Color(0, 128, 128));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		setLocationRelativeTo(null);
		getContentPane();
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cService = new JButton();
		cService.setFocusPainted(false);
		cService.setBackground(new Color(255, 255, 255));
		cService.setText("<html><center>CUSTOMER<br />SERVICE<center></html>");
		
		cService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerService cserv = new CustomerService (); 
				cserv.show(); // display Customer Service here
				dispose(); //close current main after cserv
			}
		});
		
		JLabel lblView = new JLabel("");
		lblView.setBounds(214, 176, 90, 54);
		contentPane.add(lblView);
		lblView.setIcon(new ImageIcon(img_view));
		
		JLabel lblCService = new JLabel("");
		lblCService.setBounds(210, 324, 70, 54);
		contentPane.add(lblCService);
		lblCService.setIcon(new ImageIcon(img_service));
		cService.setBounds(275, 328, 434, 50);
		contentPane.add(cService);
		
		JButton viewDeals = new JButton();
		viewDeals.setFocusPainted(false);
		viewDeals.setBackground(new Color(255, 255, 255));
		viewDeals.setText("SERVICE SUBSCRIPTION");
		
		viewDeals.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				//to open view streaming bundles
				ServiceSubsription vdeals = new ServiceSubsription (); 
				vdeals.show(); // display viewDeals here
				dispose(); //close current main after vdeals
			}
		});
		
		viewDeals.setBounds(275, 176, 434, 54);
		contentPane.add(viewDeals);
		
		JLabel lblNewLabel = new JLabel("GEESIX+");
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblNewLabel.setBounds(135, 76, 292, 54);
		contentPane.add(lblNewLabel);
		
		JLabel tvlogo = new JLabel("");
		tvlogo.setBounds(48, 53, 90, 90);
		contentPane.add(tvlogo);
		tvlogo.setIcon(new ImageIcon(img_tv));
		
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setBounds(210, 400, 56, 60);
		contentPane.add(lblAdmin);
		lblAdmin.setIcon(new ImageIcon(img_admin));
		
		JButton btnadmin = new JButton();
		btnadmin.setFocusPainted(false);
		btnadmin.setBackground(new Color(255, 255, 255));
		btnadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin adm = new Admin();
				adm.show();
				dispose();
			}
		});
		btnadmin.setText("<html><center>ADMIN<center></html>");
		btnadmin.setBounds(275, 400, 434, 54);
		contentPane.add(btnadmin);
		
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
		
		JLabel close = new JLabel("X");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setBounds(940, 0, 17, 35);
		panel.add(close);
		close.setForeground(new Color(0, 0, 0));
		close.setFont(new Font("Tahoma", Font.PLAIN, 29));
			
		JLabel lblBuy = new JLabel("New label");
		lblBuy.setBounds(210, 251, 56, 54);
		contentPane.add(lblBuy);
		lblBuy.setIcon(new ImageIcon(img_buy));
		
		JButton buyDeals = new JButton();
		buyDeals.setFocusPainted(false);
		buyDeals.setBackground(new Color(255, 255, 255));
		buyDeals.setText("<html><center>BUY STREAMING<br />BUNDLE DEALS<center></html>");
		buyDeals.setBackground(Color.WHITE);
		buyDeals.addActionListener(new ActionListener() {
			//to open buy streaming bundles
			public void actionPerformed(ActionEvent e) {
				Packages_Programs bdeals = new Packages_Programs (); 
				bdeals.show(); // display buyDeals here
				dispose(); //close current main after bdeals
			}
		});
		buyDeals.setBounds(275, 251, 434, 54);
		contentPane.add(buyDeals);
			
	}
}
