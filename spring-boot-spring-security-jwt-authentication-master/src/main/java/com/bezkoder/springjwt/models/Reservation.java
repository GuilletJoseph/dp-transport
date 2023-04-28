package com.bezkoder.springjwt.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	
	
	@Entity
	public class Reservation implements Serializable {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id; 
	    @ManyToOne
		@JoinColumn(name = "idReservant")
	    @JsonIgnoreProperties(value = {"anonces", "reservations"}, allowSetters = true)
		private User  idReservant; 
	    @ManyToOne
		@JoinColumn(name = "idAnonce")
	  @JsonIgnoreProperties(value = {"reservations","idUser"}, allowSetters = true)
		private Anonce  idAnonce;
		public Reservation() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Reservation(Long id, User idReservant, Anonce idAnonce) {
			super();
			this.id = id;
			this.idReservant = idReservant;
			this.idAnonce = idAnonce;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getIdReservant() {
		return idReservant;
	}
		public void setIdReservant(User idReservant) {
			this.idReservant = idReservant;
		}
		public Anonce getIdAnonce() {
			return idAnonce;
		}
		public void setIdAnonce(Anonce idAnonce) {
			this.idAnonce = idAnonce;
		} 
	    
}
