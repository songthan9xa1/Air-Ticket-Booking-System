package ConnectDB;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection conn = null;
	static String username="root";
	static String pwd="Songthan9xa1";
	static String connectionUrl = "jdbc:mysql://localhost:3306/airline?useTimezone=true&serverTimezone=UTC";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl,username,pwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
