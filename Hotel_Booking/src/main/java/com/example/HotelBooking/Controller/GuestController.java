package com.example.HotelBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelBooking.Service.GuestService;
import com.example.HotelBooking.entity.Guest;
import com.example.HotelBooking.entity.Room;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class GuestController {

	@Autowired
	GuestService guestService;
	
	@GetMapping("/login")
	public Guest get(@RequestHeader String email ,@RequestHeader String password) {
		return guestService.login(email,password); 
	}
	
	
	@GetMapping("/guest")  
	private List<Guest> getAllGuest()   
	{  
	return guestService.getAllGuest();  
	} 
	
	@PostMapping("/post")
	public Guest addGuest(@RequestBody Guest guest) {
		
		return guestService.addGuest(guest);
	}
	
	@PutMapping("/update")
	public Guest update(@RequestHeader String email ,@RequestBody Guest guest) {
		
		return guestService.updateDb(email,guest); 
	}
	@DeleteMapping("/delete")
	public String delete(@RequestHeader String email) {
		guestService.deleteDb(email);
		return "data deleted";
	}
	
	
}
