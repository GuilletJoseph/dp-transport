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

import com.bezkoder.springjwt.models.Vehicule;
import com.bezkoder.springjwt.services.VehiculeService;

@RestController
@RequestMapping("/api/vehicule")
@CrossOrigin(origins = "*")
public class VehiculeController {
    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Vehicule>> getAllVehicules () {
        List<Vehicule> vehicules = vehiculeService.findAllVehicules();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehicule> getVehiculeById (@PathVariable("id") Long id) {
        Vehicule vehicule = vehiculeService.findVehiculeById(id);
        return new ResponseEntity<>(vehicule, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(newVehicule, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Vehicule> updateVehicule(@RequestBody Vehicule vehicule) {
        Vehicule updateVehicule = vehiculeService.updateVehicule(vehicule);
        return new ResponseEntity<>(updateVehicule, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteVehicule(@PathVariable("id") Long id) {
        vehiculeService.deleteVehicule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}