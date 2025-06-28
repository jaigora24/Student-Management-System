package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ViewAllStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableStudents;
	
	DefaultTableModel model = new DefaultTableModel(
		    new Object[]{"ID", "Name", "Contact", "City"}, 0
	);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStudents frame = new ViewAllStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewAllStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost/studentmanagementsystem", "root", "");

		            String query = "SELECT * FROM student";
		            PreparedStatement pst = con.prepareStatement(query);
		            ResultSet rs = pst.executeQuery();

		            // Clear existing rows
		            model.setRowCount(0);

		            // Add rows to table
		            while (rs.next()) {
		                int id = rs.getInt("StudentId");
		                String name = rs.getString("StudentName");
		                String contact = rs.getString("StudentContact");
		                String city = rs.getString("StudentCity");

		                model.addRow(new Object[]{id, name, contact, city});
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
		refreshBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		refreshBtn.setBounds(404, 11, 89, 23);
		contentPane.add(refreshBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 59, 443, 421);
		contentPane.add(scrollPane);
		
		tableStudents = new JTable();
		scrollPane.setViewportView(tableStudents);
		
		tableStudents.setModel(model);
		
		JButton goBackBtn = new JButton("Go Back");
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage homePage = new HomePage();
				homePage.show();
				dispose();
			}
		});
		goBackBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		goBackBtn.setBounds(31, 12, 89, 23);
		contentPane.add(goBackBtn);
		refreshBtn.doClick();

	}
}
