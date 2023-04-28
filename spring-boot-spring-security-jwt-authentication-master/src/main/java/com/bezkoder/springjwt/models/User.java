package com.bezkoder.springjwt.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  
  
  
  
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idReservant")
	private Collection<Reservation> reservations;
  
  

private String tel;
  @OneToOne
	@JoinColumn(name = "idVille", referencedColumnName = "id")
  private Ville idVille;
 private String adresse;
  private String imageUrl;
  
  @OneToMany(mappedBy = "idUser", cascade = { CascadeType.ALL })
  @JsonIgnoreProperties(value = {"idUser"}, allowSetters = true)
	private Set<Vehicule> vehicules = new HashSet<>();  
  
  
  @OneToMany(mappedBy = "idUser", cascade = { CascadeType.ALL })
  @JsonIgnoreProperties(value = {"idUser"}, allowSetters = true)
	private Set<Anonce> anonces = new HashSet<>();
  
 
  
  
  
  
  
  
  
  
  public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
		@NotBlank @Size(max = 120) String password, Set<Role> roles, Collection<Reservation> reservations, String tel,
		Ville idVille, String adresse, String imageUrl, Set<Vehicule> vehicules, Set<Anonce> anonces) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
	this.roles = roles;
	this.reservations = reservations;
	this.tel = tel;
	this.idVille = idVille;
	this.adresse = adresse;
	this.imageUrl = imageUrl;
	this.vehicules = vehicules;
	this.anonces = anonces;
}

public Collection<Reservation> getReservations() {
	return reservations;
}

public void setReservations(Collection<Reservation> reservations) {
	this.reservations = reservations;
}

public String getTel() {
	return tel;
}

public Ville getIdVille() {
	return idVille;
}

public void setIdVille(Ville idVille) {
	this.idVille = idVille;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public User() {
  }

public User(String username) {
    this.username = username;
}





  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

public Set<Vehicule> getVehicules() {
	return vehicules;
}

public void setVehicules(Set<Vehicule> vehicules) {
	this.vehicules = vehicules;
}

public Set<Anonce> getAnonces() {
	return anonces;
}

public void setAnonces(Set<Anonce> anonces) {
	this.anonces = anonces;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
