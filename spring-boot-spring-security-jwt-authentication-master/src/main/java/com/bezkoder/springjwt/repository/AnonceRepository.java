package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.Anonce;


public interface AnonceRepository extends CrudRepository<Anonce, Long> {
	Optional<Anonce> findAnonceById(Long id);
}
