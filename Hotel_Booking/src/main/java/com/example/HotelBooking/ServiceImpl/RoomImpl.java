package com.example.HotelBooking.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelBooking.Exception.ResourceNotFoundException;
import com.example.HotelBooking.Repository.RoomRepo;
import com.example.HotelBooking.Service.RoomService;
import com.example.HotelBooking.entity.Room;
@Service
public class RoomImpl implements RoomService {


	@Autowired
	RoomRepo roomRepo;
	
	public Room getRoomById(int roomId) {
		Optional<Room> rm=Optional.ofNullable(roomRepo.findById(roomId));
		Room room;
		if(rm.isPresent())
		{
			 room=rm.get();
		}else {
				throw new ResourceNotFoundException();
			}
		return room;
	  
	}

	public Room addRoom(Room room) {
		return  roomRepo.save(room);
	}

	public Room updateDb(int roomId,Room room) {
		
		
		Room s1 = roomRepo.findById(roomId);
		
		if(s1!=null) {
			s1.setGuestId(room.getGuestId());   
			s1.setHour(room.getHour());
			s1.setPrice(room.getPrice());
		return roomRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	public void deleteDb(int roomId) {
	
		
		Room s2 = roomRepo.findById(roomId);
		
		if(s2!=null) {
			roomRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	
	
}
