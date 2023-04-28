package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.ArrayList;

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
import com.bezkoder.springjwt.exceptions.AnonceNotFoundException;
import com.bezkoder.springjwt.exceptions.UserNotFoundException;
import com.bezkoder.springjwt.models.Anonce;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.services.UserDetailsServiceImpl;
import com.bezkoder.springjwt.repository.AnonceRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	  private AnonceRepository anonceRepository;

	  @Autowired
	  private UserRepository userRepository;

    private final UserDetailsServiceImpl  userDetailsServiceImpl;

    public UserController(UserDetailsServiceImpl  userDetailsServiceImpl) {
        this.userDetailsServiceImpl  = userDetailsServiceImpl ;
    }
    	  
    	  @GetMapping("/all")
    	   public ResponseEntity<List<User>> getAllUtilisateurs () {
    	        List<User> utilisateurs = userDetailsServiceImpl.findAllUsers();
    	     return  new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    	    }  	  

    	  @GetMapping("/user")
    	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    	  public String userAccess() {
    	    return "User Content.";
    	  }


    	  @GetMapping("/mod")
    	  @PreAuthorize("hasRole('MODERATOR')")
    	  public String moderatorAccess() {
    	    return "Moderator Board.";
    	  }

    	  @GetMapping("/admin")
    	  @PreAuthorize("hasRole('ADMIN')")
    	  public String adminAccess() {
    	    return "Admin Board.";
    	  }  
   

  @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> getUtilisateurById (@PathVariable("id") Long id) {
        User user = userDetailsServiceImpl.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> addUtilisateur(@RequestBody User user) {
       User newUser = userDetailsServiceImpl.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userDetailsServiceImpl.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
   }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {
        userDetailsServiceImpl.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
