package com.bezkoder.springjwt.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.exceptions.TypeVNotFoundException;
import com.bezkoder.springjwt.models.TypeV;
import com.bezkoder.springjwt.repository.TypeVRepository;


@Service
public class TypeVService {

    @Autowired
    private TypeVRepository typeVRepo;  
    
    
    
	public TypeVService(TypeVRepository typeVRepo) {
		super();
		this.typeVRepo = typeVRepo;
	}

	 public TypeV addTypeV(TypeV typeV) {
	        return typeVRepo.save(typeV);
	    }

	    public List<TypeV> findAllTypeVs() {
	        return (List<TypeV>) typeVRepo.findAll();
	    }

	    public TypeV updateTypeV(TypeV typeV) {
	        return typeVRepo.save(typeV);
	    }

	    public TypeV findTypeVById(Long id) throws TypeVNotFoundException {
	        return typeVRepo.findTypeVById(id)
	                .orElseThrow(() -> new TypeVNotFoundException("TypeV de id " + id + " ete pas trouve"));
	    }

	    public void deleteTypeV(Long id){
	        typeVRepo.deleteById(id);
	    }
	}


