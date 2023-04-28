package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.Ville;


public interface VilleRepository extends CrudRepository<Ville, Long> {
	 Optional<Ville> findVilleById(Long id);
    
}
