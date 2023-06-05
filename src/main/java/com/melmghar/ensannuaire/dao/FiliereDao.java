package com.melmghar.ensannuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.model.Filiere;
import com.melmghar.ensannuaire.utils.Constent;

public class FiliereDao {
	
	//Insérerunenouvellefilière
	public int creerFiliere(Filiere filiere) throws ClassNotFoundException {
		
		String query = "INSERT INTO Filiere"+
						"(nom) VALUES"+
						"(?)";
		
		int result = 0;
		
		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
	
			preparedStatement.setString(1, filiere.getNom());
			
			//
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
		
		
		return result;
	}
	
	public List<Filiere> getFilieres() throws ClassNotFoundException{
	
		
		String query = "SELECT * FROM Filiere";

		List<Filiere> filieres = new ArrayList<Filiere>();

		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
		
			
			//
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			
			while(result.next()) {
				Long id = result.getLong("id");
				String nom = result.getString("nom");
				filieres.add(new Filiere(id,nom));
			}
			
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
						
		
		return filieres;
		
	}
	
	//Afficherlalistecomplètedesfilièrespardépartements
	public List<Filiere> afficherFiliersParDepartement(Long departementId) throws ClassNotFoundException{
	
		
		String query = "SELECT * FROM Filiere WHERE departement_id = "+departementId;

		List<Filiere> filieres = new ArrayList<Filiere>();

		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
		
			
			//
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			
			while(result.next()) {
				Long id = result.getLong("id");
				String nom = result.getString("nom");
				filieres.add(new Filiere(id,nom));
			}
			
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
						
		
		return filieres;
		
	}

}
