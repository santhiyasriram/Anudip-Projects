package com.example.HotelBooking.Service;

import com.example.HotelBooking.entity.Room;

public interface RoomService {
	Room getRoomById(int roomId );
	Room addRoom(Room room);
	Room updateDb(int roomId,Room room);
	void deleteDb(int roomId);
}