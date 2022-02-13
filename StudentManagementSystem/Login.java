package StudentManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel loginUsername = new JLabel("Username");
		loginUsername.setForeground(Color.BLACK);
		loginUsername.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel loginPassword = new JLabel("Password");
		loginPassword.setForeground(Color.BLACK);
		loginPassword.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		username = new JTextField();
		username.setColumns(10);    
		
		password = new JPasswordField();
		
		JButton login = new JButton("Login");
		login.setForeground(Color.BLACK);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(username.getText().equals("admin") && password.getText().equals("admin123")) {
					Menu menuPage = new Menu();
					menuPage.show();
					dispose();
				}
				else if(username.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the Username or Password :(");
				}

				else{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password :(");
				}

				
			}
		});
		login.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(65, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(loginPassword)
									.addGap(18)
									.addComponent(password))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(loginUsername)
									.addGap(18)
									.addComponent(username, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginUsername)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginPassword)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel loginpage = new JLabel("Login");
		loginpage.setForeground(Color.BLACK);
		loginpage.setBounds(160, 47, 75, 27);
		desktopPane.add(loginpage);
		loginpage.setFont(new Font("Perpetua Titling MT", Font.BOLD, 22));
		contentPane.setLayout(gl_contentPane);
	}
}
