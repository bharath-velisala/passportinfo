package com.mindtree.hotelbooking.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.hotelbooking.Exception.DaoException;
import com.mindtree.hotelbooking.Exception.ServiceException;
import com.mindtree.hotelbooking.daolayer.daoLayerImpl.DaoImpl;
import com.mindtree.hotelbooking.entity.Hotel;
import com.mindtree.hotelbooking.entity.Room;

public class ServiceImpl extends DaoImpl {
	DaoImpl dao = new DaoImpl();
	Scanner sc = new Scanner(System.in);

	public List<Hotel> addHotel(List<Hotel> hotel, List<Room> room) throws ServiceException {
		System.out.println("enter hotel id");
		int a = sc.nextInt();
		sc.nextLine();
		for (Hotel h : hotel) {
			while (a == h.getHotel_Id()) {
				System.out.println("Id already exists please enter another id");
				a = sc.nextInt();
				sc.nextLine();
			}
		}
		System.out.println("enter hotelname");
		String b = sc.nextLine();
		System.out.println("enter city");
		String c = sc.nextLine();
		hotel.add(new Hotel(a, b, c));
		try {
			dao.addhotel_sql(a, b, c);
		} catch (DaoException e) {
			throw new ServiceException("Error occured during adding Hotel");
		}
		return hotel;
	}

	public List<Room> addroom(List<Hotel> hotel) throws ServiceException {
		boolean flag = true;
		System.out.println("Enter hotel id");
		int hid = sc.nextInt();
		String HotelName = "";
		String City = "";
		for (Hotel h : hotel) {
			if (hid == (h.getHotel_Id())) {
				HotelName = h.getHotel_Name();
				City = h.getCity();
				System.out.println("Room number");
				int rmnum = sc.nextInt();
				sc.nextLine();
				System.out.println("Room type");
				String type = sc.nextLine();
				System.out.println("Room price");
				int price = sc.nextInt();
				sc.nextLine();
				Room rm = new Room(rmnum, type, price);
				List<Room> r =h.getRoom();
				r.add(rm);
				h.setRoom(r);
				try {
					dao.addRoom_sql(HotelName, City, rm);
				} catch (DaoException e) {
					e.printStackTrace();
				}
				flag = false;
				break;
			}
		}
		if (flag == true) {
			throw new ServiceException("Hotel not found");
		}
		return null;
	}

	public void displayHotels() throws ServiceException {
		System.out.println("enter City");
		String s = sc.nextLine();
		List<String> s1;
			try {
				s1 = dao.roomdata(s);
				for (String temp : s1) {
					System.out.println(temp);
				}
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
	}
}
