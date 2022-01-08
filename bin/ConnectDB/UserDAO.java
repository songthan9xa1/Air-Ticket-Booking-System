package ConnectDB;

/**
 * @author Thanh Tung Trinh 1320718
 * tung.tt133@gmail.com
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Models.User;


/**
 * Class ConnectDB is responsible for all functions/methods that need to be connected to the database.
 */
public class UserDAO {
	
	//private static ConnectDB connectDB = null;
	Connection conn = null;
	PreparedStatement preparedStmt;
	/**
	 * @return Connection 
	 */
//	public static ConnectDB getInstance(){
//		if(connectDB == null){
//			connectDB = new ConnectDB();
//		}
//		return connectDB;
//	}

	public boolean checkLogin(String email, String password) {
		conn = DBConnection.getConnection(); 
		boolean isUser = false;
		try {
			preparedStmt = conn.prepareStatement("SELECT * FROM users WHERE user_email = ? AND user_password = ?");
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				isUser = true;
			}  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUser;
	}
	
	public int getUserID(String email,String password) {
		conn = DBConnection.getConnection();
		try {
			preparedStmt = conn.prepareStatement("SELECT user_id FROM users WHERE user_email = ? AND user_password = ?");
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			return rs.getInt("user_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public boolean checkEmailExisted(String email) {
		boolean emailExisted = false;
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("SELECT * FROM users WHERE user_email = ?");
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				emailExisted = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return emailExisted;
	}
	
	public int insertUserRegistration(User user) {
		int status = 0;
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("INSERT INTO users (user_email, user_firstName, user_lastName, user_password) VALUES(?,?,?,?)");
			preparedStmt.setString(1, user.getEmail());
			preparedStmt.setString(2, user.getFirstName());
			preparedStmt.setString(3, user.getLastName());
			preparedStmt.setString(4, user.getPassword());
			status = preparedStmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	/**
	 * @param email is email input from Login Frame
	 * We add this Email to online Users in database.
	 */
	public void addToOnlineUsers(String email) {
		try {
			conn = DBConnection.getConnection(); 
			String query = "INSERT INTO online values ( ? )";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1,email);
		    preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param email is email from logged in admin/customer/worker
	 * if he logs out, database will delete him from online users.
	 */
	public void removeFromOnlineUsers(String email)
	{
		try {
			conn = DBConnection.getConnection(); 
			String query = "delete from online where onlineuser = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1,email);
		      // execute the java preparedstatement
		    preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param email is the email input from login frame
	 * @return 1 if he/she is already logged in
	 */
	public int checkOnlineUser(String email)
	{
		try {
			conn = DBConnection.getConnection(); 
			String query = "select exists(select * from online where onlineuser = ? )";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1,email);
		    // execute the java preparedstatement
		    ResultSet rs = preparedStmt.executeQuery();
		    rs.next();
		    return (rs.getInt(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void displayUserTickets(DefaultTableModel tb1Model, int user_id,List<String[]> tableData)
	{
		try {
			conn = DBConnection.getConnection(); 
			//TableUlti.RemoveAllRows(tb1Model);
			String sql = "SELECT seat_id,id_flights,seat_num,seat_price,seat_type,flight_day,flight_dep,flight_arr from flights natural join seats natural join users where user_id = ? ;";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1,user_id);
			
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next())
			{
				String id_seat = String.valueOf(rs.getInt("seat_id"));
				String id_flight = String.valueOf(rs.getInt("id_flights"));
				String seat_num = rs.getString("seat_num");
				String date = String.valueOf(rs.getInt("flight_day"));
				String dep = String.valueOf(rs.getFloat("flight_dep"));
				String arr = String.valueOf(rs.getFloat("flight_arr"));
				String seat_price = String.valueOf(rs.getFloat("seat_price"));
				String seat_type = rs.getString("seat_type");

				String tbData[] = {id_seat,id_flight,seat_num,date,dep,arr};
				String data[] = {id_seat,id_flight,seat_num,seat_price,seat_type};
				tableData.add(data);
				tb1Model.addRow(tbData);		
			}			
     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
