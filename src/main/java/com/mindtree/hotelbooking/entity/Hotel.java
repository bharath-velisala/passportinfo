package com.mindtree.hotelbooking.entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private int hotel_Id;
	private String hotel_Name;
	private String city;
	private List<Room> room =new ArrayList<Room>();
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hotel_Id, String hotel_Name, String city) {
		super();
		this.hotel_Id = hotel_Id;
		this.hotel_Name = hotel_Name;
		this.city = city;
	}
	public Hotel(int hotel_Id, String hotel_Name, String city, List<Room> room) {
		super();
		this.hotel_Id = hotel_Id;
		this.hotel_Name = hotel_Name;
		this.city = city;
		this.room = room;
	}
	public int getHotel_Id() {
		return hotel_Id;
	}
	public void setHotel_Id(int hotel_Id) {
		this.hotel_Id = hotel_Id;
	}
	public String getHotel_Name() {
		return hotel_Name;
	}
	public void setHotel_Name(String hotel_Name) {
		this.hotel_Name = hotel_Name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Hotel [hotel_Id=" + hotel_Id + ", hotel_Name=" + hotel_Name + ", city=" + city + ", room=" + room + "]";
	}
	
	
}
