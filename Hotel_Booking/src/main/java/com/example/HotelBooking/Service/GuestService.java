package com.example.HotelBooking.Service;

import java.util.List;

import com.example.HotelBooking.entity.Guest;

public interface GuestService { 
	Guest login(String email, String password );


	Guest addGuest(Guest guest);

	Guest updateDb(String email,Guest guest);

	void deleteDb(String email);
	List<Guest> getAllGuest();
	}

