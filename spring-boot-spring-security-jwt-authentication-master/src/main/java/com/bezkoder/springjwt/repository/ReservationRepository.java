package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.Reservation;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	 Optional<Reservation> findReservationById(Long id);
    
}
