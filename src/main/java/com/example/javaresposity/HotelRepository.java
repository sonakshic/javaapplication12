package com.example.javaresposity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javamodel.Hotelmodel;



public interface HotelRepository extends JpaRepository<Hotelmodel, Long> {

	
	Optional<Hotelmodel> findByEmail(String email);
}
