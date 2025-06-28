package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel homepage;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 517);
		homepage = new JPanel();
		homepage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homepage);
		homepage.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(110, 53, 205, 42);
		homepage.add(lblNewLabel);
		
		JButton addStudentBtn = new JButton("Add New Student");
		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentPage addStudentPage = new AddStudentPage();
				addStudentPage.show();
				dispose();
			}
		});
		addStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		addStudentBtn.setBounds(127, 123, 163, 32);
		homepage.add(addStudentBtn);
		
		JButton deleteStudentBtn = new JButton("Delete New Student");
		deleteStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudentPage deleteStudentPage = new DeleteStudentPage();
				deleteStudentPage.show();
				dispose();
			}
		});
		deleteStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteStudentBtn.setBounds(127, 185, 163, 32);
		homepage.add(deleteStudentBtn);
		
		JButton updateStudentBtn = new JButton("Update New Student");
		updateStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudentPage updateStudentPage = new UpdateStudentPage();
				updateStudentPage.show();
				dispose();
			}
		});
		updateStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateStudentBtn.setBounds(127, 251, 163, 32);
		homepage.add(updateStudentBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
				loginPage.show();
				dispose();
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		logoutBtn.setBounds(320, 431, 89, 23);
		homepage.add(logoutBtn);
		
		JButton viewAll = new JButton("View All Students");
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllStudents viewAllStudents = new ViewAllStudents();
				viewAllStudents.show();
				dispose();
			}
		});
		viewAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		viewAll.setBounds(127, 314, 163, 32);
		homepage.add(viewAll);

	}
}
