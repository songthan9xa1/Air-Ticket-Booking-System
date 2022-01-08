package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	private JPanel contentPane;
	private JButton btnLogin;
	private JButton btnRegister;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JCheckBox showPassword;
	private JLabel warningPassword;
	private JLabel warningEmail;
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 429);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(86, 26, 297, 346);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(41, 289, 100, 29);
		panel.add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(164, 289, 100, 29);
		panel.add(btnRegister);
		
		showPassword = new JCheckBox("Show password");
		showPassword.setBounds(103, 222, 146, 26);
		panel.add(showPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 146, 175, 38);
		panel.add(passwordField);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(103, 74, 175, 38);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPassword.setBounds(21, 151, 84, 27);
		panel.add(lblPassword);
		lblPassword.setLabelFor(passwordField);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblUsername.setBounds(21, 80, 70, 26);
		panel.add(lblUsername);
		lblUsername.setBackground(Color.ORANGE);
		lblUsername.setLabelFor(textFieldUsername);
		
		JLabel lblNewLabel = new JLabel("Flight 24h");
		lblNewLabel.setBounds(103, 28, 86, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		warningPassword = new JLabel("");
		warningPassword.setBounds(103, 188, 175, 34);
		panel.add(warningPassword);
		warningPassword.setForeground(Color.RED);
		warningPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		warningEmail = new JLabel("");
		warningEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningEmail.setForeground(new Color(255, 0, 0));
		warningEmail.setBounds(103, 113, 175, 26);
		panel.add(warningEmail);
		warningPassword.setForeground(Color.RED);
		warningPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
	}
	
	public String getEmail() {
		return textFieldUsername.getText();
	}
	
	public String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
	
	public JButton getBtnLogin(){
		return btnLogin;
	}
	
	public JCheckBox getShowPasswordCheckbox(){
		return showPassword;
	}
	
	public JButton getBtnRegister(){
		return btnRegister;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JLabel getWarningEmail() {
		return warningEmail;
	}
	public JLabel getWarningPassword() {
		return warningPassword;
	}
}
