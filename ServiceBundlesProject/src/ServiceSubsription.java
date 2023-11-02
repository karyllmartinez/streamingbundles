import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class ServiceSubsription extends JFrame {
	
	int xMouse;
	int yMouse;
	
	private JPanel contentPane;
	
	private Image img_netflix = new ImageIcon(ProjectMain.class.getResource("res/netflix.png")).getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
	private Image img_hbo = new ImageIcon(ProjectMain.class.getResource("res/hbo.png")).getImage().getScaledInstance(60, 70, Image.SCALE_SMOOTH);
	private Image img_disney = new ImageIcon(ProjectMain.class.getResource("res/disney.png")).getImage().getScaledInstance(80, 90, Image.SCALE_SMOOTH);
	private Image img_crunch = new ImageIcon(ProjectMain.class.getResource("res/crunchyroll.png")).getImage().getScaledInstance(60, 70, Image.SCALE_SMOOTH);
	private Image img_back = new ImageIcon(ProjectMain.class.getResource("res/back.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceSubsription frame = new ServiceSubsription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ServiceSubsription() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		
		JPanel bundle1 = new JPanel();
		bundle1.setBackground(new Color(192, 192, 192));
		bundle1.setBounds(107, 58, 244, 391);
		contentPane.add(bundle1);
		bundle1.setLayout(null);
		
		JLabel lblBundle1 = new JLabel("BUNDLE #1");
		lblBundle1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBundle1.setBounds(73, 10, 98, 42);
		bundle1.add(lblBundle1);
		
		JLabel lblNetflixlogo = new JLabel("");
		lblNetflixlogo.setAutoscrolls(true);
		lblNetflixlogo.setBounds(31, 45, 86, 101);
		bundle1.add(lblNetflixlogo);
		lblNetflixlogo.setIcon(new ImageIcon(img_netflix));
		
		JLabel lblHBO = new JLabel("");
		lblHBO.setBounds(127, 34, 107, 124);
		bundle1.add(lblHBO);
		lblHBO.setIcon(new ImageIcon(img_hbo));
		
		JLabel lbldisney = new JLabel("");
		lbldisney.setBounds(69, 111, 102, 101);
		bundle1.add(lbldisney);
		lbldisney.setIcon(new ImageIcon(img_disney));
		
		JLabel lbllist = new JLabel(" ");
		lbllist.setText("<html><center>NETFLIX + HBO GO +<br> DISNEY+<center></html>");
		lbllist.setHorizontalAlignment(SwingConstants.CENTER);
		lbllist.setBorder(new LineBorder(new Color(0, 128, 128)));
		lbllist.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllist.setBounds(10, 208, 224, 59);
		bundle1.add(lbllist);
		
		JLabel lblmprice = new JLabel("MONTHLY:  P999");
		lblmprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmprice.setBounds(59, 277, 126, 27);
		bundle1.add(lblmprice);
		
		JLabel lblaprice = new JLabel("ANNUAL: P11,000");
		lblaprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaprice.setBounds(58, 300, 127, 27);
		bundle1.add(lblaprice);
		
		JLabel lblall = new JLabel("(ALL PREMIUM ACCOUNTS)");
		lblall.setHorizontalAlignment(SwingConstants.CENTER);
		lblall.setForeground(new Color(178, 34, 34));
		lblall.setBounds(0, 317, 234, 64);
		bundle1.add(lblall);
		
		JPanel bundle2 = new JPanel();
		bundle2.setBackground(new Color(192, 192, 192));
		bundle2.setBounds(396, 58, 244, 391);
		contentPane.add(bundle2);
		bundle2.setLayout(null);
				
		JLabel lblBundle2 = new JLabel("BUNDLE #2");
		lblBundle2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBundle2.setBounds(79, 10, 98, 42);
		bundle2.add(lblBundle2);
		
		JLabel lblcrunch = new JLabel("");
		lblcrunch.setBounds(46, 48, 89, 84);
		bundle2.add(lblcrunch);
		lblcrunch.setIcon(new ImageIcon(img_crunch));
		
		JLabel lbldisney2 = new JLabel("");
		lbldisney2.setBounds(130, 25, 148, 119);
		bundle2.add(lbldisney2);
		lbldisney2.setIcon(new ImageIcon(img_disney));
		
		JLabel lblNetflix2 = new JLabel("");
		lblNetflix2.setBounds(90, 122, 87, 84);
		bundle2.add(lblNetflix2);
		lblNetflix2.setIcon(new ImageIcon(img_netflix));
		
		JLabel lbllist_1 = new JLabel(" ");
		lbllist_1.setText("<html><center>CRUNCHYROLL + DISNEY+ <br>+ NETFLIX <center></html>");
		lbllist_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbllist_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllist_1.setBorder(new LineBorder(new Color(0, 128, 128)));
		lbllist_1.setBounds(10, 206, 224, 59);
		bundle2.add(lbllist_1);
		
		JLabel lblmprice_1 = new JLabel("MONTHLY:  P800");
		lblmprice_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmprice_1.setBounds(67, 284, 126, 27);
		bundle2.add(lblmprice_1);
		
		JLabel lblaprice_1 = new JLabel("ANNUAL: P9,000");
		lblaprice_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaprice_1.setBounds(66, 301, 127, 27);
		bundle2.add(lblaprice_1);
		
		JLabel lblall_1 = new JLabel("(ALL PREMIUM ACCOUNTS)");
		lblall_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblall_1.setForeground(new Color(178, 34, 34));
		lblall_1.setBounds(0, 317, 234, 64);
		bundle2.add(lblall_1);
		
		JPanel bundle3 = new JPanel();
		bundle3.setBackground(new Color(192, 192, 192));
		bundle3.setBounds(681, 58, 244, 391);
		contentPane.add(bundle3);
		bundle3.setLayout(null);
			
		JLabel lblBundle = new JLabel("BUNDLE #3");
		lblBundle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBundle.setBounds(81, 24, 90, 19);
		bundle3.add(lblBundle);
		
		JLabel lblhbo3 = new JLabel("");
		lblhbo3.setBounds(46, 53, 59, 88);
		bundle3.add(lblhbo3);
		lblhbo3.setIcon(new ImageIcon(img_hbo));
		
		JLabel lbldisney3 = new JLabel("");
		lbldisney3.setBounds(130, 53, 124, 69);
		bundle3.add(lbldisney3);
		lbldisney3.setIcon(new ImageIcon(img_disney));
		
		JLabel lblcrunch3 = new JLabel("");
		lblcrunch3.setBounds(96, 130, 89, 78);
		bundle3.add(lblcrunch3);
		lblcrunch3.setIcon(new ImageIcon(img_crunch));
		
		JLabel lbllist_1_1 = new JLabel("");
		lbllist_1_1.setText("<html><center>HBO GO + DISNEY+ <br>+ CRUNCHYROLL <center></html>");
		lbllist_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbllist_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllist_1_1.setBorder(new LineBorder(new Color(0, 128, 128)));
		lbllist_1_1.setBounds(10, 205, 224, 59);
		bundle3.add(lbllist_1_1);
		
		JLabel lblmprice_2 = new JLabel("MONTHLY:  P859");
		lblmprice_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmprice_2.setBounds(74, 284, 126, 27);
		bundle3.add(lblmprice_2);
		
		JLabel lblaprice_2 = new JLabel("ANNUAL: P9,500");
		lblaprice_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaprice_2.setBounds(74, 303, 127, 27);
		bundle3.add(lblaprice_2);
		
		JLabel lblall_1_1 = new JLabel("(ALL PREMIUM ACCOUNTS)");
		lblall_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblall_1_1.setForeground(new Color(178, 34, 34));
		lblall_1_1.setBounds(0, 321, 234, 64);
		bundle3.add(lblall_1_1);
		
		JLabel lblBack = new JLabel("");
		
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ProjectMain adminBackbtn = new ProjectMain();
				adminBackbtn.show() ;
				dispose();	
			}
		});
		lblBack.setBounds(26, 45, 71, 72);
		contentPane.add(lblBack);
		lblBack.setIcon(new ImageIcon(img_back));
		
	}
}
