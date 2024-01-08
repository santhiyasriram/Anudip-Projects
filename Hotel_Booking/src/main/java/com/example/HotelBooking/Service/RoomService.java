package com.example.HotelBooking.Service;

import java.util.List;

import com.example.HotelBooking.entity.Room;

public interface RoomService {
	Room getroomById(int roomId );
	Room addroom(Room room);
	Room updateDb(int roomId,Room room);
	void deleteDb(int roomId);
	List<Room> getAllRoom();
}