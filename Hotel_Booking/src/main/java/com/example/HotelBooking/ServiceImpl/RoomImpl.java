package com.example.HotelBooking.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
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
	
	public Room getroomById(int roomId) {
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

	public Room addroom(Room room) {
		return  roomRepo.save(room);
	}

	public Room updateDb(int roomId,Room room) {
		
		
		Room s1 = roomRepo.findById(roomId);
		
		if(s1!=null) {
			s1.setPrice(room.getPrice());

			s1.setRoomType(room.getRoomType()); 
			
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

	



	  
	public List<Room> getAllRoom()   
	{  
	List<Room> room = new ArrayList<Room>();  
	roomRepo.findAll().forEach(room1 -> room.add(room1));  
	return room;  

}}
