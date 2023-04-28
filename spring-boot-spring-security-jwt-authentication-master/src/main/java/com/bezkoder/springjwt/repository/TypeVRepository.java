package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.TypeV;


public interface TypeVRepository extends CrudRepository<TypeV, Long> {
	 Optional<TypeV> findTypeVById(Long id);
    
}
