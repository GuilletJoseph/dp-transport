package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 private int code;
	    private String nom;
		public Ville() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ville(Long id, int code, String nom) {
			super();
			this.id = id;
			this.code = code;
			this.nom = nom;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
}
