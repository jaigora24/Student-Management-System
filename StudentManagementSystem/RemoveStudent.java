package StudentManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveStudent extends JFrame {

	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs;
	
	private JPanel contentPane;
	private JTextField deleteEntry;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveStudent frame = new RemoveStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RemoveStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 526);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		deleteEntry = new JTextField();
		deleteEntry.setBounds(111, 40, 206, 29);
		desktopPane_1.add(deleteEntry);
		deleteEntry.setColumns(10);
		
		JButton deleteData = new JButton("Delete");
		deleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
					String query = "DELETE FROM `student` WHERE entrynumber=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
					pst=con.prepareStatement(query);
					
					String pid = deleteEntry.getText();

					pst.setString(1, pid);

					int k =	pst.executeUpdate();
					
					if(k==1) {
						JOptionPane.showMessageDialog(null, "Deleted Successfully :)");
						dispose();
						Menu menu = new Menu();
						menu.show();
					}
	
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
				
				
			}
		});
		deleteData.setForeground(Color.BLACK);
		deleteData.setBounds(130, 111, 167, 37);
		desktopPane_1.add(deleteData);
		deleteData.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.show();
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(130, 171, 167, 37);
		desktopPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Enter the \"Entry Number\" of the student");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 90, 408, 25);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.setLayout(gl_contentPane);
	}
}
