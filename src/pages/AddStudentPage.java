package pages;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddStudentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentName;
	private JTextField studentContact;
	private JTextField studentCity;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentPage frame = new AddStudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddStudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(154, 53, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(108, 128, 49, 20);
		contentPane.add(lblNewLabel_1);
		
		studentName = new JTextField();
		studentName.setBounds(182, 128, 96, 20);
		contentPane.add(studentName);
		studentName.setColumns(10);
		
		studentContact = new JTextField();
		studentContact.setColumns(10);
		studentContact.setBounds(182, 186, 96, 20);
		contentPane.add(studentContact);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(108, 185, 49, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "INSERT INTO student (StudentName,StudentContact,StudentCity) VALUES (?,?,?)";
					Connection con = null;
					PreparedStatement pst = null;
					ResultSet rs;
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
//					pst=con.prepareStatement(query);
//					Now I want to return the auto increment id which is allocated to newly added user also prints
					
					pst=con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
					
					if(studentName.getText().equals("") || studentContact.getText().equals("") || studentCity.getText().equals("")) {
						JOptionPane.showMessageDialog(null,  "Fill all the details of the student");
					}
					else {
						pst.setString(1,  studentName.getText());
						pst.setString(2,  studentContact.getText());
						pst.setString(3,  studentCity.getText ());
//						pst.executeUpdate();
						int affectedRows = pst.executeUpdate();
						if(affectedRows>0) {
							rs=pst.getGeneratedKeys();
							if(rs.next()) {
								int generatedId = rs.getInt(1);
								JOptionPane.showMessageDialog(null,  "Added successfully!! Student Id : " + generatedId);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Student NOT added");
						}
						dispose();
						HomePage homePage = new HomePage();
						homePage.show();
					}
					
				}
				catch(Exception exception) {
					JOptionPane.showMessageDialog(null,  "Exception occured during 'Student addition' >> "+exception + ", Please contact the dev team");
				}
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		addBtn.setBounds(143, 308, 89, 23);
		contentPane.add(addBtn);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("City");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(108, 242, 49, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		studentCity = new JTextField();
		studentCity.setColumns(10);
		studentCity.setBounds(182, 243, 96, 20);
		contentPane.add(studentCity);

	}
}
