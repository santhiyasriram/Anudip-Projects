package com.example.HotelBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelBooking.Service.RoomService;
import com.example.HotelBooking.entity.Room;

@RestController
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/room/{Id}")
	public Room getRoomById(@PathVariable int roomId) {
		return roomService.getRoomById(roomId); 
	}
	
	@PostMapping("/postroom")
	public Room addRoom(@RequestBody Room room) {
		
		return roomService.addRoom(room);
	}
	
	@PutMapping("/updateroom")
	public Room update(@RequestHeader int roomId ,@RequestBody Room room) {
		
		return roomService.updateDb(roomId ,room); 
	}
	@DeleteMapping("/deleteroom")
	public String delete(@RequestHeader int roomId ) {
		roomService.deleteDb(roomId );
		return "data deleted";
	}
	
	
}

