import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;


public class Monitoring extends JFrame {

	private JPanel contentPane;
	private JTable tbldata;
	private JScrollPane scrollPane;
	private JButton btnLoadData;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	int xMouse;
	int yMouse;
	private JButton btnchange;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitoring frame = new Monitoring();
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
	public Monitoring() {
		setBackground(new Color(0, 128, 128));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setAutoscrolls(true);
		lblExit.setBounds(940, 0, 17, 35);
		contentPane.add(lblExit);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 29));
		
		scrollPane = new JScrollPane(tbldata);
		scrollPane.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		scrollPane.setBounds(204, 119, 753, 353);
		contentPane.add(scrollPane);
		
		tbldata = new JTable();
		tbldata.setBorder(new EmptyBorder(0, 0, 0, 0));
		tbldata.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tbldata);
		
		btnLoadData = new JButton("VIEW DATA");
		btnLoadData.setBackground(new Color(255, 255, 255));
		btnLoadData.setFocusPainted(false);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/streamingservicesproject", "root", "Asawanikenshin12");
					Statement st = con.createStatement();
					String query = "select * from payment";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tbldata.getModel();
					
					int cols = rsmd.getColumnCount();
					String [] colName = new String[cols];
					for (int i=0; i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
					}
						
					
					String FirstName, LastName, Email, Bundles, Billings, Date;
					//to read all rows one by one and will be add on table
					while (rs.next()) {
						FirstName = rs.getString(1);
						LastName = rs.getString(2);
						Email = rs.getString(3);
						Bundles = rs.getString(4);
						Billings = rs.getString(5);
						Date = rs.getString(6);
						
						String [] row = {FirstName, LastName, Email, Bundles, Billings, Date};
						model.addRow(row);
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(262, 58, 283, 38);
		contentPane.add(btnLoadData);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				 xMouse  = evt.getX();
				 yMouse = evt.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
					setLocation(getX() + evt.getX() - xMouse, getY() + evt.getY() - yMouse );
			}
		});
		panel.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panel.setBounds(0, 0, 967, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Log out");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to log out?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				    	ProjectMain adminBackbtn = new ProjectMain();
						adminBackbtn.show() ;
						dispose();	
				
				    }
			}
		});
		btnNewButton.setBounds(44, 411, 126, 35);
		contentPane.add(btnNewButton);
		
		btnchange = new JButton("Change Password");
		btnchange.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword change = new ChangePassword();
				change.show() ;
				
			}
		});
		btnchange.setBounds(44, 366, 126, 35);
		contentPane.add(btnchange);
		
		JButton btnReset = new JButton("HIDE DATA");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbldata.setModel(new DefaultTableModel());
			}
		});
		btnReset.setFocusPainted(false);
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(614, 58, 283, 38);
		contentPane.add(btnReset);
		
		
	}
}
