package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.Vehicule;


public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
	 Optional<Vehicule> findVehiculeById(Long id);
    
}