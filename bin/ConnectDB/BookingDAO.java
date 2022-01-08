package ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class BookingDAO {
	//private static ConnectDB connectDB = null;
	static Connection conn = null;
	PreparedStatement preparedStmt;
		
	public void bookDirectFlight(int id_flights,int id_cus,float price,String type)
	{
		try {
			conn = DBConnection.getConnection(); 
			String sql = "insert into seats(seat_num,id_flights,user_id,seat_price,seat_type,isBooked) values( ? , ? , ? , ? , ? , ? )";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "");
			pst.setInt(2,id_flights);
			pst.setInt(3,id_cus);
			pst.setFloat(4,price);
			pst.setString(5,type);
			pst.setInt(6, 0);
			
			pst.executeUpdate();
			String sql2 = new String();
			if(type.equals("Economy"))
				sql2 = "update flights set avail_seats = avail_seats-1 where id_flights = ? ";
			else
				sql2 = "update flights set avail_premium_seats = avail_premium_seats-1 where id_flights = ? ";
			PreparedStatement pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1,id_flights);
			pst2.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bookTransitFlight(int id_flights1,int id_flights2,int id_cus,float price1,float price2,String type)
	{
		try {
			conn = DBConnection.getConnection(); 
			String sql = "insert into seats(seat_num,id_flights,user_id,seat_price,seat_type,isBooked) values( ? , ? , ? , ? , ? , ? )";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "");
			pst.setInt(2,id_flights1);
			pst.setInt(3,id_cus);
			pst.setFloat(4,price1);
			pst.setString(5,type);
			pst.setInt(6, 0);
			
			pst.executeUpdate();
			String sql2 = new String();
			if(type.equals("Economy"))
				sql2 = "update flights set avail_seats = avail_seats-1 where id_flights = ? ";
			else
				sql2 = "update flights set avail_premium_seats = avail_premium_seats-1 where id_flights = ? ";
			PreparedStatement pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1,id_flights1);
			pst2.executeUpdate();
			
			conn = DBConnection.getConnection(); 
			String sql3 = "insert into seats(seat_num,id_flights,user_id,seat_price,seat_type,isBooked) values( ? , ? , ? , ? , ? , ? )";
			
			PreparedStatement pst3 = conn.prepareStatement(sql3);
			pst3.setString(1, "");
			pst3.setInt(2,id_flights2);
			pst3.setInt(3,id_cus);
			pst3.setFloat(4,price2);
			pst3.setString(5,type);
			pst3.setInt(6, 0);
			
			pst3.executeUpdate();
			String sql4 = new String();
			if(type.equals("Economy"))
				sql4 = "update flights set avail_seats = avail_seats-1 where id_flights = ? ";
			else
				sql4 = "update flights set avail_premium_seats = avail_premium_seats-1 where id_flights = ? ";
			PreparedStatement pst4 = conn.prepareStatement(sql4);
			pst4.setInt(1,id_flights2);
			pst4.executeUpdate();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	public void displayFlightsOneWay(DefaultTableModel tb1Model, List<String[]> tableData,int dateinput,String depinput,String arrinput)
	{
		
		try {
			conn = DBConnection.getConnection(); 
			String sql = "SELECT * FROM airline.flights natural join flights_line where \r\n" + 
					"flight_day = ? and city_dep = ? and city_arr = ? ";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,dateinput);
			pst.setString(2,depinput);
			pst.setString(3,arrinput);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				float faktor=Faktor(rs.getFloat("flight_dep"),rs.getString("carrier"),rs.getInt("flight_day"));
				String c_dep = rs.getString("city_dep");
				String c_arr = rs.getString("city_arr");
				String id =  String.valueOf(rs.getInt("id_flights"));
				String dep = String.valueOf(rs.getFloat("flight_dep"));
				String arr = String.valueOf(rs.getFloat("flight_arr"));
				String dur = String.valueOf(rs.getInt("flight_air_time"));
				
				DecimalFormat df = new DecimalFormat("#.#");
				String price = String.valueOf(df.format(rs.getFloat("basic_price")*faktor));
				String carrier = rs.getString("carrier");
				String premium = String.valueOf(df.format(rs.getFloat("premium_price")*faktor));

				String flightday = String.valueOf(rs.getInt("flight_day"));
				//String seats = String.valueOf(rs.getInt("flight_seats"));
				
				
				String tbData[] = {c_dep,c_arr,dur,price};
				String data[] = {id,c_dep,c_arr,dur,carrier,dep,arr,flightday,price,premium};
				tableData.add(data);
				tb1Model.addRow(tbData);		
			}		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void displayFlightTransit(DefaultTableModel tb1Model, List<String[]> tableData,int dateinput,String depinput,String arrinput)
	{
		List<String[]> a = Transit1(dateinput,depinput,arrinput);
		List<String[]> b = Transit2(dateinput,depinput,arrinput);
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<b.size();j++)
			{
				if(a.get(i)[2].equalsIgnoreCase(b.get(j)[1]))
				{
					if(Float.valueOf(a.get(i)[6])<Float.valueOf(b.get(j)[5]))
					{
						float faktor1=Faktor(Float.valueOf(a.get(i)[5]),a.get(i)[4],Integer.parseInt(a.get(i)[7]));
						float faktor2=Faktor(Float.valueOf(a.get(i)[5]),b.get(j)[4],Integer.parseInt(a.get(i)[7]));
						String id1=a.get(i)[0];
						String id2=b.get(j)[0];
						String c_dep= a.get(i)[1];
						String c_transit= a.get(i)[2];
						String c_arr=b.get(j)[2];
						String dep1=a.get(i)[5];
						String arr1= a.get(i)[6];
						String dep2=b.get(j)[5];
						String arr2=b.get(j)[6];
						float x = Float.valueOf(a.get(i)[3])+Float.valueOf(b.get(j)[3]);
						String dur = String.valueOf(x);
						String flightday = a.get(i)[7];
						float pr = Float.valueOf(a.get(i)[8])*faktor1+Float.valueOf(b.get(j)[8])*faktor2;
						String total_price = String.valueOf(pr);
						DecimalFormat df = new DecimalFormat("#.#");
						String carrier = a.get(i)[4]+"+"+b.get(j)[4];
						float total_premium_price = Float.valueOf(a.get(i)[9])*faktor1+Float.valueOf(b.get(j)[9])*faktor2;
						String total_premium = String.valueOf(df.format(total_premium_price));
						
						String tbData[]= {c_dep,c_arr,c_transit,dur,total_price};
						String data[]= {id1,id2,c_dep,c_transit,c_arr,dur,carrier,dep1,arr1,dep2,arr2,flightday,total_price,total_premium};
						tb1Model.addRow(tbData);
						tableData.add(data);
						System.out.println(tableData.size());
					}
				}
			}
		}
		
	}
	
	public List<String[]> Transit1(int dateinput,String depinput, String arrinput)
	{
		List<String[]> a = new ArrayList();
		try
		{
			conn = DBConnection.getConnection();
			String sql = "Select * from flights natural join flights_line where flight_day = ? and city_dep = ? and city_arr != ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,dateinput);
			pst.setString(2, depinput);
			pst.setString(3, arrinput);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String c_dep = rs.getString("city_dep");
				String c_arr = rs.getString("city_arr");
				String id =  String.valueOf(rs.getInt("id_flights"));
				String dep = String.valueOf(rs.getFloat("flight_dep"));
				String arr = String.valueOf(rs.getFloat("flight_arr"));
				String dur = String.valueOf(rs.getInt("flight_air_time"));
				String price = String.valueOf(rs.getFloat("basic_price"));
				String carrier = rs.getString("carrier");
				String premium_price = String.valueOf(rs.getFloat("premium_price"));

				String flightday = String.valueOf(rs.getInt("flight_day"));
				
				String data[] = {id,c_dep,c_arr,dur,carrier,dep,arr,flightday,price,premium_price};
				a.add(data);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public List<String[]> Transit2(int dateinput,String depinput, String arrinput)
	{
		List<String[]> a = new ArrayList();
		try
		{
			conn = DBConnection.getConnection();
			String sql = "Select * from flights natural join flights_line where flight_day = ? and city_dep != ? and city_arr = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,dateinput);
			pst.setString(2, depinput);
			pst.setString(3, arrinput);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String c_dep = rs.getString("city_dep");
				String c_arr = rs.getString("city_arr");
				String id =  String.valueOf(rs.getInt("id_flights"));
				String dep = String.valueOf(rs.getFloat("flight_dep"));
				String arr = String.valueOf(rs.getFloat("flight_arr"));
				String dur = String.valueOf(rs.getInt("flight_air_time"));
				String price = String.valueOf(rs.getFloat("basic_price"));
				String carrier = rs.getString("carrier");
				String premium_price = String.valueOf(rs.getFloat("premium_price"));

				String flightday = String.valueOf(rs.getInt("flight_day"));
				
				String data[] = {id,c_dep,c_arr,dur,carrier,dep,arr,flightday,price,premium_price};
				a.add(data);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public float Faktor(float flight_dep, String carrier, int flightday)
	{
		float x =1;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat day = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat dayflight = new SimpleDateFormat("dd");
		char[] a =toString().valueOf(flightday).toCharArray();
		System.out.println(flightday);
		StringBuilder Input1 = new StringBuilder().append(a[4]).append(a[5]);
		int InputMonth = Integer.parseInt(String.valueOf(Input1));
		System.out.println(InputMonth);
		StringBuilder Input2 = new StringBuilder().append(a[6]).append(a[7]);
		int InputDay=Integer.parseInt(String.valueOf(Input2));
		System.out.println(InputDay);
		//carrier
		if(carrier.equalsIgnoreCase("Lufthansa"))
		{
			x=(float) (x+0.2);
		}
		//flight in day
		if(Integer.parseInt(day.format(calendar.getTime()))==flightday)
		{
			x=(float) (x-0.3);
			if(Float.valueOf(time.format(calendar.getTime()))==flight_dep-3)
			{
				x=(float) (x-0.5);
			}
			else if (Float.valueOf(time.format(calendar.getTime()))==flight_dep-4)
			{
				x=(float) (x-0.4);
			}
			else
			{
				x=(float) (x-0.2);
			}
		}
		//month
		if (Integer.parseInt(month.format(calendar.getTime()))==InputMonth-1)
		{
			x=(float) (x-0.1);
		}
		else if (Integer.parseInt(month.format(calendar.getTime()))==InputMonth-2)
		{
			x=(float) (x-0.2);
		}
		else if(Integer.parseInt(month.format(calendar.getTime()))<=InputMonth-3)
		{
			x=(float) (x-0.3);
		} 
		//day
		if(Integer.parseInt(day.format(calendar.getTime()))==InputMonth && Integer.parseInt(dayflight.format(calendar.getTime())) == InputDay-1)
		{
			x= (float) (x-0.3);
		}
		else if (Integer.parseInt(day.format(calendar.getTime()))==InputMonth && Integer.parseInt(dayflight.format(calendar.getTime())) <= InputDay-3)
		{
			x= (float) (x-0.2);
		}
		return x;
	}
	
	

}
