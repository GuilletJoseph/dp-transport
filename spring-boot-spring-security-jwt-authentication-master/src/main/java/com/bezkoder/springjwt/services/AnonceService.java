package com.bezkoder.springjwt.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.exceptions.AnonceNotFoundException;
import com.bezkoder.springjwt.models.Anonce;
import com.bezkoder.springjwt.repository.AnonceRepository;


@Service
public class AnonceService {

    @Autowired
    private AnonceRepository anonceRepo;  
    
    
    
	public AnonceService(AnonceRepository anonceRepo) {
		super();
		this.anonceRepo = anonceRepo;
	}

	 public Anonce addAnonce(Anonce anonce) {
	        return anonceRepo.save(anonce);
	    }

	    public List<Anonce> findAllAnonces() {
	        return (List<Anonce>) anonceRepo.findAll();
	    }

	    public Anonce updateAnonce(Anonce anonce) {
	        return anonceRepo.save(anonce);
	    }

	    public Anonce findAnonceById(Long id) throws AnonceNotFoundException {
	        return anonceRepo.findAnonceById(id)
	                .orElseThrow(() -> new AnonceNotFoundException("Anonce de id " + id + " ete pas trouve"));
	    }

	    public void deleteAnonce(Long id){
	        anonceRepo.deleteById(id);
	    }
	}


