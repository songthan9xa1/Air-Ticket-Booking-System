package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import Models.Seat;

/*
 * @author: Thien Huong Le
 */
public class flightSeats {
    private Connection connect = DBConnection.getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public flightSeats() {
    }
    
    
    // check whether or not a seat is in the database (is already booked)
    public boolean isBooked(String seatNum, int flightId) throws Exception {
    	int result = 0;
    	try {
    		String query = "SELECT isBooked FROM seats WHERE seat_num = ? and id_flights = ?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, seatNum);
            preparedStatement.setInt(2, flightId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) result = 1;
            else result = 0;
            
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	if(result == 1) return true;
        else return false;
    }
    
    // get type of a seat (Premium or Economy)
    public String getSeatType(int id) throws Exception {
    	String type = "none";    	
    	try {
    		String query = "SELECT seat_type FROM seats WHERE seat_id = ?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	type = resultSet.getString("seat_type");
            }
            
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return type;
    }
    
    // put a booked seat into the database
    public void putSeat(int seat_id,String seatNum,String type) throws Exception {
    	try {
        	String query = "UPDATE seats SET seat_num = ? , seat_type = ? , isBooked = 1 where seat_id = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, seatNum);
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, seat_id);

            // execute the java preparedstatement
            preparedStatement.executeUpdate();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		}
    }
    
    
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
   


}
