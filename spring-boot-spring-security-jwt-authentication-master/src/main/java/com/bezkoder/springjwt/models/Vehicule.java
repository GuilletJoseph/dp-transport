package com.bezkoder.springjwt.models;


import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Vehicule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
   	@JoinColumn(name = "idTypeV", referencedColumnName = "id")
    private TypeV idTypeV;
    private int nbPlace;
    @OneToOne
   	@JoinColumn(name = "idBoite", referencedColumnName = "id")
    private Boite idBoite;
    private String imageUrl;
    private String immatriculation;
   @ManyToOne
   @JoinColumn(name = "idUtilisateur")
   @JsonIgnoreProperties(value = {"vehicules"}, allowSetters = true)
  
    private User idUser;
    
    
    public Vehicule() {}
	public Vehicule(Long id, String name, TypeV idTypeV, int nbPlace, Boite idBoite, String imageUrl,
			String immatriculation, User idUser) {
		super();
		this.id = id;
		this.name = name;
		this.idTypeV = idTypeV;
		this.nbPlace = nbPlace;
		this.idBoite = idBoite;
		this.imageUrl = imageUrl;
		this.immatriculation = immatriculation;
		this.idUser = idUser;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeV getIdTypeV() {
		return idTypeV;
	}
	public void setIdTypeV(TypeV idTypeV) {
		this.idTypeV = idTypeV;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Boite getIdBoite() {
		return idBoite;
	}
	public void setIdBoite(Boite idBoite) {
		this.idBoite = idBoite;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	
    
    
}