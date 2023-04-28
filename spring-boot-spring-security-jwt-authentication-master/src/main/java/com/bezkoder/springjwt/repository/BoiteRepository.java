package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.Boite;



public interface BoiteRepository extends CrudRepository<Boite, Long> {
	 Optional<Boite> findBoiteById(Long id);
    
}
