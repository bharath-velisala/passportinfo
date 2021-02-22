package com.mindtree.hotelbooking.bookingSite;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.hotelbooking.Exception.ServiceException;
import com.mindtree.hotelbooking.entity.Hotel;
import com.mindtree.hotelbooking.entity.Room;
import com.mindtree.hotelbooking.services.serviceImpl.ServiceImpl;

public class App extends ServiceImpl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		List<Hotel> hotel = new ArrayList<Hotel>();
		List<Room> room = new ArrayList<Room>();
		App app = new App();
		hotel = app.previoushotelsdata(hotel);
		do {
			System.out.println("press 1 to add hotel");
			System.out.println("press 2 to add room");
			System.out.println("press 3 to display hotels");
			System.out.println("press 4 to exit");
			int a = sc.nextInt();
			sc.nextLine();
			switch (a) {
			case 1:
				try {
					app.addHotel(hotel, room);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					app.addroom(hotel);
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					app.displayHotels();
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				flag = false;
				break;
			}
		} while (flag != false);
	}
}
