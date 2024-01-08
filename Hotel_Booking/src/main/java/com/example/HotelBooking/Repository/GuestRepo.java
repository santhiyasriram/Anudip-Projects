package com.example.HotelBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HotelBooking.entity.Guest;
@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer> {

	@Query(value =  "select * from Guest where email =?" , nativeQuery = true)
	Guest findByEmail(String email);

	
	
	
}
