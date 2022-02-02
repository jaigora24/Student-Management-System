package StudentManagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField sentry;
	private JTextField semail;
	private JTextField scontact;
	private JTextField shome;
	
	
	Connection con = null;
	PreparedStatement pst = null;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel studentDetails = new JLabel("Student Details");
		studentDetails.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		
		JLabel studentName = new JLabel("Student Name");
		studentName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel entryNumber = new JLabel("Entry Number");
		entryNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel emailAddress = new JLabel("Email Address");
		emailAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel contactNumber = new JLabel("Contact Number");
		contactNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		sname = new JTextField();
		sname.setColumns(10);
		
		sentry = new JTextField();
		sentry.setColumns(10);
		
		semail = new JTextField();
		semail.setColumns(10);
		
		scontact = new JTextField();
		scontact.setColumns(10);
		
		JLabel homeCity = new JLabel("Home City");
		homeCity.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "INSERT INTO `student`(`name`, `entrynumber`, `email`, `contactnumber`, `homecity`) VALUES (?, ?, ?, ?, ?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
					pst=con.prepareStatement(query);
					pst.setString(1, sname.getText());
					pst.setString(2, sentry.getText());
					pst.setString(3, semail.getText());
					pst.setString(4, scontact.getText());
					pst.setString(5, shome.getText());
					if(sname.getText().equals("") || sentry.getText().equals("") || semail.getText().equals("") || scontact.getText().equals("") || shome.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all the details :(");
					}
					else {
						pst.executeUpdate();
						dispose();
						JOptionPane.showMessageDialog(null, "Submit Successfully :)");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		submit.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		
		shome = new JTextField();
		shome.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(116)
								.addComponent(studentDetails))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(27)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(studentName)
									.addComponent(entryNumber)
									.addComponent(emailAddress)
									.addComponent(contactNumber)
									.addComponent(homeCity))
								.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(shome)
									.addComponent(scontact)
									.addComponent(semail)
									.addComponent(sentry)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(sname, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addComponent(submit)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentDetails)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentName)
						.addComponent(sname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(entryNumber)
						.addComponent(sentry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailAddress)
						.addComponent(semail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(contactNumber)
						.addComponent(scontact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(homeCity)
						.addComponent(shome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(submit)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
