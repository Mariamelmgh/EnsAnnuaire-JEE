package com.melmghar.ensannuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.melmghar.ensannuaire.model.Etudiant;

public class EtudiantDao {
	
	
	public int insererEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		
		String query = "INSERT INTO Etudiant" +
						"(CNE,nom,prenom,filiere,departement, telephone) VALUES" +
						"(?,?,?,?,?,?)";
		
		
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try 
		(Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/EnsAnnuaire","root","");
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				
			preparedStatement.setString(1, etudiant.getCNE());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			preparedStatement.setString(4, etudiant.getDepartement());
			preparedStatement.setString(5, etudiant.getFiliere());
			preparedStatement.setString(6, etudiant.getTelephone());
			
			
			//
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		} catch(SQLException exception) {
			exception.printStackTrace();
			
		}
				
				
				
		
		
		return result;
	}

}
