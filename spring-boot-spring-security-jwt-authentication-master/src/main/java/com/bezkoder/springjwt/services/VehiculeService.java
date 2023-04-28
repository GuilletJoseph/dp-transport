package com.bezkoder.springjwt.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.exceptions.VehiculeNotFoundException;
import com.bezkoder.springjwt.models.Vehicule;
import com.bezkoder.springjwt.repository.VehiculeRepository;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepo;  
    
    
    
	public VehiculeService(VehiculeRepository vehiculeRepo) {
		super();
		this.vehiculeRepo = vehiculeRepo;
	}

	 public Vehicule addVehicule(Vehicule vehicule) {
	        return vehiculeRepo.save(vehicule);
	    }

	    public List<Vehicule> findAllVehicules() {
	        return (List<Vehicule>) vehiculeRepo.findAll();
	    }

	    public Vehicule updateVehicule(Vehicule vehicule) {
	        return vehiculeRepo.save(vehicule);
	    }

	    public Vehicule findVehiculeById(Long id) throws VehiculeNotFoundException {
	        return vehiculeRepo.findVehiculeById(id)
	                .orElseThrow(() -> new VehiculeNotFoundException("Vehicule de id " + id + " ete pas trouve"));
	    }

	    public void deleteVehicule(Long id){
	        vehiculeRepo.deleteById(id);
	    }
	}

