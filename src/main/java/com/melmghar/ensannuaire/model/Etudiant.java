package com.melmghar.ensannuaire.model;

public class Etudiant {
	//CNE, nom, prénom, filière,
	//département et téléphone 
	
	private String CNE;
	private String nom;
	private String prenom;
	private String filiere;
	private String departement;
	private String telephone;
	
	
	//Getter & Setters
	
	public String getCNE() {
		return CNE;
	}
	
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getFiliere() {
		return filiere;
	}
	
	public void setFiliere(String feilere) {
		this.filiere = feilere;
	}
	
	public String getDepartement() {
		return departement;
	}
	
	public void setDepartement(String departement) {
	
		this.departement = departement;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	

}
