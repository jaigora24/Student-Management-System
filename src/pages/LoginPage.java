package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uName;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameText = new JLabel("Username");
		usernameText.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameText.setBackground(UIManager.getColor("Button.foreground"));
		usernameText.setBounds(100, 95, 85, 28);
		contentPane.add(usernameText);
		
		uName = new JTextField();
		uName.setBounds(183, 99, 154, 20);
		contentPane.add(uName);
		uName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(183, 136, 154, 20);
		contentPane.add(password);
		
		JLabel passwordText = new JLabel("Password");
		passwordText.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordText.setBackground(Color.BLACK);
		passwordText.setBounds(100, 134, 85, 28);
		contentPane.add(passwordText);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uName.getText().equals("admin") && password.getText().equals("admin123")){
					HomePage homePage = new HomePage();
					homePage.show();
					dispose();
				}
				else if(uName.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,  "Please enter the both fields username and password!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username & password!!");
				}
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginBtn.setBounds(162, 190, 89, 23);
		contentPane.add(loginBtn);

	}
}
