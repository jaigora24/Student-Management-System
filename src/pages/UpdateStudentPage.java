package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStudentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentIdForUpdate;
	private JTextField txtStudentName;
	private JTextField txtStudentCity;
	private JTextField txtStudentContact;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudentPage frame = new UpdateStudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateStudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		studentIdForUpdate = new JTextField();
		studentIdForUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentIdForUpdate.setText("");
			}
		});
		studentIdForUpdate.setForeground(Color.GRAY);
		studentIdForUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		studentIdForUpdate.setText("Student Id");
		studentIdForUpdate.setBounds(172, 77, 88, 20);
		contentPane.add(studentIdForUpdate);
		studentIdForUpdate.setColumns(10);
		
		JButton searchBtnBeforeUpdate = new JButton("Search");
		searchBtnBeforeUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentIdForUpdate.getText();

		        if (id.equals("")) {
		            JOptionPane.showMessageDialog(null, "Please enter Student ID");
		            return;
		        }

				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
		            String query = "SELECT StudentName, StudentCity, StudentContact FROM student WHERE StudentId = ?";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setInt(1, Integer.parseInt(id));
		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		                String name = rs.getString("StudentName");
		                txtStudentName.setText(name);
		                String contact = rs.getString("StudentContact");
		                txtStudentContact.setText(contact);
		                String city = rs.getString("StudentCity");
		                txtStudentCity.setText(city);
		            } else {
		                JOptionPane.showMessageDialog(null, "No student found with ID: " + id);
		                txtStudentName.setText("");
		                txtStudentContact.setText("");
		                txtStudentCity.setText("");
		            }
		            rs.close();
		            pst.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		        }
			}
		});
		searchBtnBeforeUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchBtnBeforeUpdate.setBounds(172, 109, 89, 23);
		contentPane.add(searchBtnBeforeUpdate);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(222, 193, 96, 20);
		contentPane.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentCity = new JTextField();
		txtStudentCity.setBounds(222, 256, 96, 20);
		contentPane.add(txtStudentCity);
		txtStudentCity.setColumns(10);
		
		txtStudentContact = new JTextField();
		txtStudentContact.setBounds(222, 327, 96, 20);
		contentPane.add(txtStudentContact);
		txtStudentContact.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(113, 196, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("City");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(113, 259, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(113, 330, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentIdForUpdate.getText();
				String name = txtStudentName.getText();
				String contact = txtStudentContact.getText();
				String city = txtStudentCity.getText();

				try {
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");

				    String updateQuery = "UPDATE student SET StudentName = ?, StudentContact = ?, StudentCity = ? WHERE StudentId = ?";
				    PreparedStatement pst = con.prepareStatement(updateQuery);
				    pst.setString(1, name);
				    pst.setString(2, contact);
				    pst.setString(3, city);
				    pst.setInt(4, Integer.parseInt(id));

				    int rowsAffected = pst.executeUpdate();

				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "Student updated successfully.");
				    } else {
				        JOptionPane.showMessageDialog(null, "Update failed. No record found.");
				    }
				    pst.close();
				    con.close();
				    HomePage homePage = new HomePage();
				    homePage.show();
				    dispose();
				} catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}

			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateBtn.setBounds(172, 393, 89, 23);
		contentPane.add(updateBtn);

	}

}
