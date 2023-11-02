import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField Email;
	private JTextField CardNumber;
	private JTextField LastName;
	private JTextField CVC;
	 

	/**
	 * Launch the application.
	 */
	
	String billings;
	int xMouse;
	int yMouse;
	private Image img_back = new ImageIcon(ProjectMain.class.getResource("res/back.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setUndecorated(true);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(464, 150, 112, 33);
		contentPane.add(lblFirstName);
		
		JLabel paymentLabel = new JLabel("PAYMENT");
		paymentLabel.setForeground(new Color(255, 255, 255));
		paymentLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		paymentLabel.setBounds(689, 68, 145, 49);
		contentPane.add(paymentLabel);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(464, 193, 112, 33);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(464, 236, 112, 33);
		contentPane.add(lblEmail);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setForeground(new Color(255, 255, 255));
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCardNumber.setBounds(464, 279, 112, 33);
		contentPane.add(lblCardNumber);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		lblExpirationDate.setForeground(new Color(255, 255, 255));
		lblExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpirationDate.setBounds(464, 319, 124, 33);
		contentPane.add(lblExpirationDate);
		
		JLabel lblCvc = new JLabel("CVC:");
		lblCvc.setForeground(new Color(255, 255, 255));
		lblCvc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCvc.setBounds(464, 362, 124, 33);
		contentPane.add(lblCvc);
		
		JLabel SelectBundle = new JLabel("SUBSCRIPTION");
		SelectBundle.setForeground(new Color(255, 255, 255));
		SelectBundle.setHorizontalAlignment(SwingConstants.LEFT);
		SelectBundle.setFont(new Font("Tahoma", Font.BOLD, 24));
		SelectBundle.setBounds(46, 93, 230, 49);
		contentPane.add(SelectBundle);
		
		JLabel lblselect = new JLabel("Type of Bundle: ");
		lblselect.setForeground(new Color(255, 255, 255));
		lblselect.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblselect.setBounds(46, 139, 206, 42);
		contentPane.add(lblselect);
		
		JLabel lblBilling = new JLabel("Billing:");
		lblBilling.setForeground(new Color(255, 255, 255));
		lblBilling.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBilling.setBounds(46, 243, 206, 42);
		contentPane.add(lblBilling);
		
	
		JRadioButton rdMonthly = new JRadioButton("Monthly");
		rdMonthly.setForeground(new Color(255, 255, 255));
		rdMonthly.setBackground(new Color(0, 128, 128));
		rdMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billings = "Monthly";
			}
		});
		rdMonthly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdMonthly.setBounds(46, 279, 145, 49);
		contentPane.add(rdMonthly);
		
		JRadioButton rdAnnual = new JRadioButton("Annual");
		rdAnnual.setBackground(new Color(0, 128, 128));
		rdAnnual.setForeground(new Color(255, 255, 255));
		rdAnnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billings = "Annual";
			}
		});
		rdAnnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdAnnual.setBounds(46, 319, 145, 49);
		contentPane.add(rdAnnual);
		
		JLabel monthlyPrice = new JLabel("");
		monthlyPrice.setForeground(new Color(255, 255, 255));
		monthlyPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		monthlyPrice.setBounds(197, 287, 112, 33);
		contentPane.add(monthlyPrice);
		
		JLabel annualPrice = new JLabel("");
		annualPrice.setForeground(new Color(255, 255, 255));
		annualPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		annualPrice.setBounds(197, 319, 112, 49);
		contentPane.add(annualPrice);
		
		ButtonGroup btngrp = new ButtonGroup();
		btngrp.add(rdMonthly);
		btngrp.add(rdAnnual);
		

		
		
		FirstName = new JTextField();
		FirstName.setBounds(586, 149, 357, 28);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(586, 232, 357, 28);
		contentPane.add(Email);
		
		CardNumber = new JTextField();
		CardNumber.addKeyListener(new KeyAdapter() {
			//input should be integers only
			public void keyTyped(KeyEvent e) {
				String cnum = CardNumber.getText();
				
				
				char c = e.getKeyChar();
				
				if (!Character.isDigit(c)) {
					e.consume();				
				} else if (cnum.length() == 16 ) {
					e.consume();
				} 
				
			}
		});
		CardNumber.setColumns(10);
		CardNumber.setBounds(586, 279, 357, 28);
		contentPane.add(CardNumber);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		LastName.setBounds(586, 191, 357, 28);
		contentPane.add(LastName);
		
		CVC = new JTextField();
		CVC.addKeyListener(new KeyAdapter() {
			//input should be integers only
			public void keyTyped(KeyEvent e) {
				String cvcnum = CVC.getText();	
				char Charcvc = e.getKeyChar();
				
				if (!Character.isDigit(Charcvc)) {
					e.consume();				
				} else if (cvcnum.length() == 3 ) {
					e.consume();
				}
				
			}
		});
		CVC.setColumns(10);
		CVC.setBounds(586, 360, 357, 28);
		contentPane.add(CVC);
	
		JDateChooser ExpirationDate = new JDateChooser();
		ExpirationDate.getJCalendar().setMinSelectableDate(new Date());
		ExpirationDate.setBounds(586, 319, 357, 28);
		contentPane.add(ExpirationDate);
		
		String bundleschoices [] = {"SELECT", "[1] Netflix, HBO GO, Disney+", "[2] Crunchyroll, Disney+, Netflix", "[3] HBO GO, Disney+, Crunchyroll"};
		JComboBox comboBox = new JComboBox(bundleschoices);
		
		
		comboBox.setSelectedIndex(0);
		getContentPane().add(comboBox);
		getContentPane().add(monthlyPrice);
		getContentPane().add(annualPrice);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox) {
					JComboBox cb = (JComboBox)e.getSource();
					String price = (String) cb.getSelectedItem();
					switch (price) {
					
					case "[1] Netflix, HBO GO, Disney+" : monthlyPrice.setText("P999")  ;
						break;
					case "[2] Crunchyroll, Disney+, Netflix" : monthlyPrice.setText("P800");
						break;
					case "[3] HBO GO, Disney+, Crunchyroll" : monthlyPrice.setText("P850");
						break;
					
					}
				}
				if (e.getSource() == comboBox) {
					JComboBox cb = (JComboBox)e.getSource();
					String price2 = (String) cb.getSelectedItem();
					switch (price2) {
					case "SELECT": JOptionPane.showMessageDialog(null, "PLEASE CHOOSE AN APPROPRIATE BUNDLE");
						break;
					case "[1] Netflix, HBO GO, Disney+" : annualPrice.setText("P11,000")  ;
						break;
					case "[2] Crunchyroll, Disney+, Netflix" : annualPrice.setText("P9,000");
						break;
					case "[3] HBO GO, Disney+, Crunchyroll" : annualPrice.setText("P9,500");
						break;
					
					}
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox.setBounds(46, 191, 341, 42);
		contentPane.add(comboBox);
		

		JLabel txtid = new JLabel("");
		txtid.setHorizontalAlignment(SwingConstants.TRAILING);
		txtid.setBounds(61, 398, 45, 13);
		contentPane.add(txtid);
		
		JButton PayBtn = new JButton("PAY");
		PayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date date = new Date();
				java.sql.Date sql;
				date = new java.sql.Date(date.getTime());
				
				String dFname = FirstName.getText();
				String dLname = LastName.getText();
				String dEmail = Email.getText();
				String dCardNumber = CardNumber.getText();
				String dcvc = CVC.getText();
				int cvcl = dcvc.length();
				
				 
				String value = comboBox.getSelectedItem().toString();
				boolean radio = btngrp.isSelected(null);
				Object type = comboBox.getSelectedItem();
				int cNumLength = dCardNumber.length();	
				 if( !dEmail.contains("@")) {
                	//if email format is not complete
                	 JOptionPane.showMessageDialog(PayBtn, "Please input a correct email ");
                } else if (radio == true) {
                	//if type of billing is not selected
                	 JOptionPane.showMessageDialog(PayBtn, "Please select type of Billing");
                } else if (type == "SELECT") {
                	//if the selected type of bundle is wrong
                	JOptionPane.showMessageDialog(PayBtn, "Please select type of Bundle");
                } else if (cNumLength != 16) {
                	//if user inputs invalid card number
                	JOptionPane.showMessageDialog(PayBtn, "Invalid card number!");
                }else if (cvcl != 3) {
                	JOptionPane.showMessageDialog(PayBtn, "Invalid cvc!");
                }else {	
												
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/streamingservicesproject", "root", "Asawanikenshin12");

					String query = "INSERT INTO payment values('" + dFname + "','" + dLname + "','" + dEmail + "','" + value + "','" + billings + "','" + date + "')";
				
                    Statement sta = connection.createStatement();
                                       
                    int x = sta.executeUpdate(query);
                                                       
                    if (x == 0) {
                    	//if form is not complete
                        JOptionPane.showMessageDialog(PayBtn, "Please complete the form");
                    } 
                    else {
                    	
                    	String msg = "" + dFname;
        				msg += " \n";
        				
                        JOptionPane.showMessageDialog(PayBtn,
                        "Thank you, " + msg + "Please wait for an email for your streaming service bundles account! \n This might take a few seconds.");
                        //return to main page after message dialog
                        ProjectMain adminBackbtn = new ProjectMain();
        				adminBackbtn.show() ;
        				dispose();	
                    }
                    connection.close();
                    
                } catch (Exception e1) {
                	e1.printStackTrace();
                }
                }
			
            }
        });
			
		PayBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		PayBtn.setBounds(679, 409, 152, 42);
		contentPane.add(PayBtn);
		
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
		
		JLabel lblBack = new JLabel("");
		
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Packages_Programs adminBackbtn = new Packages_Programs();
				adminBackbtn.show() ;
				dispose();	
			}
		});
		lblBack.setBounds(26, 42, 71, 72);
		contentPane.add(lblBack);
		lblBack.setIcon(new ImageIcon(img_back));
		
		
		
		
	}
}
