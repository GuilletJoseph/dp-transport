package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.TypeV;
import com.bezkoder.springjwt.services.TypeVService;

@RestController
@RequestMapping("/api/typev")
@CrossOrigin(origins = "*")
public class TypeVController {
    private final TypeVService typeVService;

    public TypeVController(TypeVService typeVService) {
        this.typeVService = typeVService;
    }

    @GetMapping("/all")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TypeV>> getAllTypeVs () {
        List<TypeV> typeVs = typeVService.findAllTypeVs();
        return new ResponseEntity<>(typeVs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeV> getTypeVById (@PathVariable("id") Long id) {
        TypeV typeV = typeVService.findTypeVById(id);
        return new ResponseEntity<>(typeV, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeV> addTypeV(@RequestBody TypeV typeV) {
        TypeV newTypeV = typeVService.addTypeV(typeV);
        return new ResponseEntity<>(newTypeV, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeV> updateTypeV(@RequestBody TypeV typeV) {
        TypeV updateTypeV = typeVService.updateTypeV(typeV);
        return new ResponseEntity<>(updateTypeV, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteTypeV(@PathVariable("id") Long id) {
        typeVService.deleteTypeV(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
