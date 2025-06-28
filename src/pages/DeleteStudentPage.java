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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteStudentPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentIdForDelete;
	private JTextField txtStudentName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudentPage frame = new DeleteStudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteStudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Student Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(150, 145, 135, 14);
		contentPane.add(lblNewLabel);
		
		studentIdForDelete = new JTextField();
		studentIdForDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentIdForDelete.setText("");
			}
		});
		studentIdForDelete.setBounds(160, 170, 96, 20);
		contentPane.add(studentIdForDelete);
		studentIdForDelete.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setEditable(false);
		txtStudentName.setBounds(160, 229, 96, 20);
		contentPane.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameLabel.setBounds(101, 231, 49, 14);
		contentPane.add(nameLabel);
		
		JButton searchBtnBeforeDelete = new JButton("Search");
		searchBtnBeforeDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentIdForDelete.getText();

		        if (id.equals("")) {
		            JOptionPane.showMessageDialog(null, "Please enter Student ID");
		            return;
		        }

				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
		            String query = "SELECT StudentName FROM student WHERE StudentId = ?";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setInt(1, Integer.parseInt(id));
		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		                String name = rs.getString("StudentName");
		                txtStudentName.setText(name);
		            } else {
		                JOptionPane.showMessageDialog(null, "No student found with ID: " + id);
		                txtStudentName.setText("");
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
		searchBtnBeforeDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchBtnBeforeDelete.setBounds(312, 169, 89, 23);
		contentPane.add(searchBtnBeforeDelete);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentIdForDelete.getText();
				String name = txtStudentName.getText();
				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
		            String query = "DELETE FROM student WHERE StudentId = ?";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setInt(1, Integer.parseInt(id));
		            int rowsAffected = pst.executeUpdate();
		            if(rowsAffected>0) {
		            	JOptionPane.showMessageDialog(null,  "Student '"+name+"' Deleted Successfully!!");
		            }
		            else {
		            	JOptionPane.showMessageDialog(null,  "Error in deleting this student :: NO STUDENT FOUND WITH THIS ID '"+id+"'");
		            }
		            HomePage homePage = new HomePage();
		            homePage.show();
		            dispose();
		            pst.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		        }
				
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteBtn.setBounds(312, 212, 89, 23);
		contentPane.add(deleteBtn);

	}
}
