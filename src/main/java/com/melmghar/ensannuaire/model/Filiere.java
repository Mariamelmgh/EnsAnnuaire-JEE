package com.melmghar.ensannuaire.model;

public class Filiere {
	
	private Long id;
	
	private String nom;
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Filiere(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	
	
	
	

	
}
