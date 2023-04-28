package com.bezkoder.springjwt.models;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Anonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    
    @ManyToOne
	@JoinColumn(name = "idUser")
    @JsonIgnoreProperties(value = {"anonces"}, allowSetters = true)
	private User idUser;  
    
    private LocalDate date;
    private String hDebut;
    private int nbPlace;
    @OneToOne
   	@JoinColumn(name = "idVilleDepart", referencedColumnName = "id")
    private Ville idVilleDepart;
    @OneToOne
   	@JoinColumn(name = "idVilleArrive", referencedColumnName = "id")
    private Ville idVilleArrive;
    
    @OneToOne
   	@JoinColumn(name = "idVehicule", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"idUser"}, allowSetters = true)
    private Vehicule idVehicule;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idAnonce")
	private Collection<Reservation> reservations;



	public Anonce(Long id, User idUser, LocalDate date, String hDebut, int nbPlace, Ville idVilleDepart,
			Ville idVilleArrive, Vehicule idVehicule, Collection<Reservation> reservations) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.date = date;
		this.hDebut = hDebut;
		this.nbPlace = nbPlace;
		this.idVilleDepart = idVilleDepart;
		this.idVilleArrive = idVilleArrive;
		this.idVehicule = idVehicule;
		this.reservations = reservations;
	}

	public Anonce() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public Anonce(Long id, User idUser, LocalDate date, String hDebut, int nbPlace, Ville idVilleDepart,
			Ville idVilleArrive, Vehicule idVehicule) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.date = date;
		this.hDebut = hDebut;
		this.nbPlace = nbPlace;
		this.idVilleDepart = idVilleDepart;
		this.idVilleArrive = idVilleArrive;
		this.idVehicule = idVehicule;
	}





	public Vehicule getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(Vehicule idVehicule) {
		this.idVehicule = idVehicule;
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getIdUser() {
		return idUser;
}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String gethDebut() {
		return hDebut;
	}
	public void sethDebut(String hDebut) {
		this.hDebut = hDebut;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Ville getIdVilleDepart() {
		return idVilleDepart;
	}
	public void setIdVilleDepart(Ville idVilleDepart) {
		this.idVilleDepart = idVilleDepart;
	}
	public Ville getIdVilleArrive() {
		return idVilleArrive;
	}
	public void setIdVilleArrive(Ville idVilleArrive) {
		this.idVilleArrive = idVilleArrive;
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}  
    
	
	
	
	
	
	
    
}
