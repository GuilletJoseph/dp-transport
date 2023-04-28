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

import com.bezkoder.springjwt.models.Ville;
import com.bezkoder.springjwt.services.VilleService;

@RestController
@RequestMapping("/api/ville")
@CrossOrigin(origins = "*")
public class VilleController {
    private final VilleService villeService;

    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping("/all")
  // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Ville>> getAllVilles () {
        List<Ville> villes = villeService.findAllVilles();
        return new ResponseEntity<>(villes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ville> getVilleById (@PathVariable("id") Long id) {
        Ville ville = villeService.findVilleById(id);
        return new ResponseEntity<>(ville, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ville> addVille(@RequestBody Ville ville) {
        Ville newVille = villeService.addVille(ville);
        return new ResponseEntity<>(newVille, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ville> updateVille(@RequestBody Ville ville) {
        Ville updateVille = villeService.updateVille(ville);
        return new ResponseEntity<>(updateVille, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteVille(@PathVariable("id") Long id) {
        villeService.deleteVille(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
