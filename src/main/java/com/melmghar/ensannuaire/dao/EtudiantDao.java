package com.melmghar.ensannuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.utils.Constent;

public class EtudiantDao {
	
	//Insérerunnouvelétudiant
	public int insererEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		
		String query = "INSERT INTO Etudiant" +
						"(CNE,nom,prenom,filiere_id,departement, telephone) VALUES" +
						"(?,?,?,?,?,?)";
		
		
		
		int result = 0;
		
		Class.forName(Constent.DRIVER_NAME);
		
		try 
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				
			preparedStatement.setString(1, etudiant.getCNE());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			preparedStatement.setLong(4, etudiant.getFiliereId());
			preparedStatement.setString(5, etudiant.getDepartement());
			preparedStatement.setString(6, etudiant.getTelephone());
			
			
			//
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		}
				
				
				
		
		
		return result;
	}
	
	//modifier étudiant
	public int modifierEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		
		String query = "UPDATE  Etudiant SET"
				+ " nom= '" +etudiant.getNom() +
				"', prenom = '" + etudiant.getPrenom()+
				"', filiere_id = " + etudiant.getFiliereId()+
				" WHERE CNE = '" + etudiant.getCNE()+"'";
		
		
		
		int result = 0;
		
		Class.forName(Constent.DRIVER_NAME);
		
		try 
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				
		
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		}
				
				
				
		
		
		return result;
	}
	//supprimer unnouvelétudiant
	public int deleteEtudiant(String CNE) throws ClassNotFoundException {
		
		String query = "delete from etudiant where CNE = '" +CNE + "'";
		
		
		
		int result = 0;
		
		Class.forName(Constent.DRIVER_NAME);
		
		try 
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		}
				
				
				
		
		
		return result;
	}
	
	
	// Rechercherunétudiantdansl’annuaire
	public Etudiant rechercherEtudiant(String nom) throws ClassNotFoundException {
	
		String query = "SELECT * FROM Etudiant where nom like"
				+ " '%" + nom +"%'";
		Etudiant etudiant = new Etudiant();
		
		Class.forName(Constent.DRIVER_NAME);
		
		try
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			 

			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			result.next();
			etudiant.setCNE(result.getString("CNE"));
			etudiant.setNom(result.getString("nom"));
			etudiant.setPrenom(result.getString("prenom"));
			etudiant.setFiliere(result.getLong("filiere_id"));
			etudiant.setTelephone(result.getString("telephone"));
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return etudiant;
		
		
	}
	
	// Rechercherunétudiantdansl’annuaire
	public Etudiant rechercherEtudiantByCNE(String CNE)throws ClassNotFoundException {
	
		String query = "SELECT * FROM Etudiant where CNE = '"+ CNE +"'"; 
		Etudiant etudiant = new Etudiant();
		
		Class.forName(Constent.DRIVER_NAME);
		
		try
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			 

			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			result.next();
			etudiant.setCNE(result.getString("CNE"));
			etudiant.setNom(result.getString("nom"));
			etudiant.setPrenom(result.getString("prenom"));
			etudiant.setFiliere(result.getLong("filiere_id"));
			etudiant.setTelephone(result.getString("telephone"));
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return etudiant;
		
		
	}

	public List<Etudiant> getEtudiants() throws ClassNotFoundException {

		String query = "SELECT * FROM Etudiant";
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		
		Class.forName(Constent.DRIVER_NAME);
		
		try
		(Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			 

			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			while(result.next()) {
			Etudiant etudiant = new Etudiant();
			etudiant.setCNE(result.getString("CNE"));
			etudiant.setNom(result.getString("nom"));
			etudiant.setPrenom(result.getString("prenom"));
			etudiant.setFiliere(result.getLong("filiere_id"));
			etudiant.setTelephone(result.getString("telephone"));
			etudiants.add(etudiant);
			
			}
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return etudiants;
		
		
	}

}
