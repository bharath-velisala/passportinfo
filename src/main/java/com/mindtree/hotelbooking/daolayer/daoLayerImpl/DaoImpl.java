package com.mindtree.hotelbooking.daolayer.daoLayerImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mindtree.hotelbooking.Exception.DaoException;
import com.mindtree.hotelbooking.daolayer.daoLayer;
import com.mindtree.hotelbooking.entity.Hotel;
import com.mindtree.hotelbooking.entity.Room;

public class DaoImpl implements daoLayer {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/Hotel";
	private static String username = "root";
	private static String password = "Pixel@6444";
	static Connection con;
	static PreparedStatement st;
	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addhotel_sql(int hotel_Id, String hotelName, String city) throws DaoException {
		String Query = "insert into Hotels VALUES('" + hotel_Id + "','" + hotelName + "','" + city + "')";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			throw new DaoException("error occured");
		}

	}

	public void addRoom_sql(String HotelName, String City, Room room) throws DaoException {

		String Query = "insert into rooms VALUES('" + HotelName + "','" + City + "','" + room.getRoom_Id() + "','"
				+ room.getRoom_type() + "','" + room.getRoomcost() + "')";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			throw new DaoException("Data base Exception occured");
		}
	}

	public List<Hotel> previoushotelsdata(List<Hotel> hotel) {
		String Query = "select *from Hotels";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				Hotel h = new Hotel();
				h.setHotel_Id(rs.getInt("Hotel_Id"));
				h.setHotel_Name(rs.getString("Hotel_Name"));
				h.setCity(rs.getString("City"));
				hotel.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	}

	public List<String> roomdata(String City) throws DaoException {
		List<String> s = new ArrayList<String>();
		
		ResultSet rs;
		try {
			String Query = "select *from rooms where City='" + City + "' ";
			Statement st = con.createStatement();
			rs = st.executeQuery(Query);
			while (rs.next()) {
				String temp = "[Hotelname=" + rs.getString("HotelName") + ",City=" + rs.getString("City") + ",Room_Id="
						+ rs.getInt("Room_Id") + ",RoomType=" + rs.getString("RoomType") + ",Cost=" + rs.getInt("Cost")
						+ "]";
				s.add(temp);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		if(s.isEmpty()) {
			throw new DaoException("city not found");
		}
		return s;
	}
}
