package com.mindtree.hotelbooking.services;

import java.util.List;

import com.mindtree.hotelbooking.Exception.ServiceException;
import com.mindtree.hotelbooking.entity.Hotel;
import com.mindtree.hotelbooking.entity.Room;

public interface serviceInterface {
	List<Hotel>addHotel(List<Hotel>hotel)throws ServiceException;
	List<Room>addRoom(List<Room>room)throws ServiceException;
	void display(List<Room>room);
	
}
