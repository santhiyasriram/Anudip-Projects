package com.example.HotelBooking.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelBooking.Exception.ResourceNotFoundException;
import com.example.HotelBooking.Repository.GuestRepo;
import com.example.HotelBooking.Service.GuestService;
import com.example.HotelBooking.entity.Guest;
import com.example.HotelBooking.entity.Room;

@Service

public class GuestImpl  implements GuestService {

	@Autowired
	GuestRepo guestRepo;
	
	@Override
	public Guest login(String email, String password) {
		 Guest s = guestRepo.findByEmail(email);
		 
		 if(s!=null) {
			 if(s.getPassword().equals(password)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	@Override
	public Guest addGuest(Guest guest) {
		return  guestRepo.save(guest);
	}

	@Override
	public Guest updateDb(String email,Guest guest) {
		
		
		Guest s1 = guestRepo.findByEmail(email);
		
		if(s1!=null) {
			s1.setPassword(guest.getPassword());
			s1.setRoom(guest.getRoom());
		return guestRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	@Override
	public void deleteDb(String email) {
	
		
		Guest s2 = guestRepo.findByEmail(email);
		
		if(s2!=null) {
			guestRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	  
		public List<Guest> getAllGuest()   
		{  
		List<Guest> guest = new ArrayList<Guest>();  
		guestRepo.findAll().forEach(guest1 -> guest.add(guest1));  
		return guest;  

	}
	
}

