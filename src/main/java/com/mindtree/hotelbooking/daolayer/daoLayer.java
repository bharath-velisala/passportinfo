package com.mindtree.hotelbooking.daolayer;

import com.mindtree.hotelbooking.Exception.DaoException;
import com.mindtree.hotelbooking.entity.Room;

public interface daoLayer {

	void addhotel_sql(int hotel_Id,String hotelName,String city)throws DaoException;
	void addRoom_sql(String HotelName,String City,Room room)throws DaoException;
}
