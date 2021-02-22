package com.mindtree.hotelbooking.entity;

public class Room {

	private int room_Id;
	private String room_type;
	private int roomcost;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int room_Id, String room_type, int roomcost) {
		super();
		this.room_Id = room_Id;
		this.room_type = room_type;
		this.roomcost = roomcost;
	}
	public int getRoom_Id() {
		return room_Id;
	}
	public void setRoom_Id(int room_Id) {
		this.room_Id = room_Id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(int roomcost) {
		this.roomcost = roomcost;
	}
	@Override
	public String toString() {
		return "Room [room_Id=" + room_Id + ", room_type=" + room_type + ", roomcost=" + roomcost + "]";
	}
	
	
}
