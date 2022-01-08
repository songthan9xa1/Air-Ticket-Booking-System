package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RegisterView extends JFrame {
	
	private static JPanel contentPane;
	private static JTextField textFieldEmail;
	private static JTextField textFieldFirstName;
	private static JTextField textFieldLastName;
	private static JPasswordField passwordField;
	private static JPasswordField passwordRetypeField;
	private static JButton btnLogin;
	private static JButton btnRegister;
	private static JLabel emailMessage;
	private static JLabel retypePasswordMessage;
	private static JLabel warningMessage;
	private JPanel panel;
	private static JLabel passwordMessage;
	private static JLabel lastNameTextWarningMsg;
	private static JLabel firstNameTextWarningMsg;
	
	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -28, 539, 513);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(71, 27, 400, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(60, 384, 117, 29);
		panel.add(btnRegister);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(222, 384, 117, 29);
		panel.add(btnLogin);
		
		passwordRetypeField = new JPasswordField();
		passwordRetypeField.setBounds(169, 310, 193, 36);
		panel.add(passwordRetypeField);
		
		JLabel lblRetypePassword = new JLabel("Retype Password*");
		lblRetypePassword.setBounds(35, 319, 140, 16);
		lblRetypePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(lblRetypePassword);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setBounds(35, 257, 117, 16);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 248, 193, 36);
		panel.add(passwordField);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(35, 196, 82, 16);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(169, 187, 193, 36);
		panel.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		lblLastName.setLabelFor(textFieldLastName);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(35, 136, 82, 16);
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(169, 127, 193, 36);
		panel.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		lblFirstName.setLabelFor(textFieldFirstName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(169, 66, 193, 36);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(35, 75, 61, 16);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(lblEmail);
		lblEmail.setLabelFor(textFieldEmail);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(150, 22, 117, 16);
		panel.add(lblRegistration);
		lblRegistration.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		warningMessage = new JLabel("");
		warningMessage.setVerticalAlignment(SwingConstants.BOTTOM);
		warningMessage.setBounds(169, 358, 182, 16);
		panel.add(warningMessage);
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMessage.setForeground(Color.RED);
		
		emailMessage = new JLabel("");
		emailMessage.setBounds(169, 99, 193, 16);
		panel.add(emailMessage);
		emailMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		emailMessage.setForeground(Color.RED);
		
		retypePasswordMessage = new JLabel("");
		retypePasswordMessage.setBounds(169, 345, 193, 16);
		panel.add(retypePasswordMessage);
		retypePasswordMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		retypePasswordMessage.setForeground(Color.RED);
		
		passwordMessage = new JLabel("");
		passwordMessage.setForeground(Color.RED);
		passwordMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		passwordMessage.setBounds(169, 282, 193, 16);
		panel.add(passwordMessage);
		
		lastNameTextWarningMsg = new JLabel("");
		lastNameTextWarningMsg.setForeground(Color.RED);
		lastNameTextWarningMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lastNameTextWarningMsg.setBounds(169, 219, 193, 16);
		panel.add(lastNameTextWarningMsg);
		
		firstNameTextWarningMsg = new JLabel("");
		firstNameTextWarningMsg.setForeground(Color.RED);
		firstNameTextWarningMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		firstNameTextWarningMsg.setBounds(169, 159, 193, 16);
		panel.add(firstNameTextWarningMsg);
	}
	public String getFirstName() {
		return textFieldFirstName.getText();
	}
	public String getLastName() {
		return textFieldLastName.getText();
	}
	public String getEmail() {
		return textFieldEmail.getText();
	}
	public String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
	public String getRetypePW() {
		return String.copyValueOf(passwordRetypeField.getPassword());
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JLabel getEmailMessage() {
		return emailMessage;
	}
	public JLabel getFirstNameTextWarningMsg() {
		return firstNameTextWarningMsg;
	}
	public JLabel getLastNameTextWarningMsg() {
		return lastNameTextWarningMsg;
	}
	public JLabel getReTypePasswordMessage() {
		return retypePasswordMessage;
	}
	public JLabel getPasswordMessage() {
		return passwordMessage;
	}
	
	public JLabel getWarningMessage() {
		return warningMessage;
	}
	public JButton getBtnLogin(){
		return btnLogin;
	}
	
	public JButton getBtnRegister(){
		return btnRegister;
	}
}
