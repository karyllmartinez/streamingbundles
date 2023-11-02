import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblchange = new JLabel("CHANGE PASSWORD: ");
		lblchange.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblchange.setBounds(27, 69, 160, 24);
		contentPane.add(lblchange);
			
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 62, 246, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String pstr = passwordField.getText();
				 if(pstr.equals("")) { 	
					 JOptionPane.showMessageDialog(null, "Invalid Input!");
					
				 } else {
					  try {
		                    
						  
		                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/streamingservicesproject", "root", "Asawanikenshin12");

		                    PreparedStatement st = (PreparedStatement) 
		                    con.prepareStatement("UPDATE `streamingservicesproject`.`adminlogin` SET `password` = ? WHERE (`username` = 'Admin') ;"
		                    		+ "");

		                    st.setString(1, pstr);
		                    st.executeUpdate();
		                   
		                	
		                		 JOptionPane.showMessageDialog(btnNewButton, "Password has been successfully changed");		 	                  		 	                    
		 	                     dispose();
						  
		                } catch (SQLException sqlException) {
		                    sqlException.printStackTrace();
		                }
               	
						 }
	              
         	 
	       }
	       
		});
		btnNewButton.setBounds(171, 165, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitoring mon = new Monitoring();
				mon.show() ;
				dispose();
			}
		});
		btnNewButton_1.setBounds(332, 165, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
	}
}
