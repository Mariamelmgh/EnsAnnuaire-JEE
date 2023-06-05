package com.melmghar.ensannuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.utils.Constent;

public class DepartementDao {
	
	//Afficherlalistecomplètedesdépartements
	public List<Departement> listDepartement() throws ClassNotFoundException{
		
		String query = "SELECT * FROM Departement";
		
		
		List<Departement> departements = new ArrayList<Departement>();
		
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
				departements.add(new Departement(id,nom));
			}
			
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
						
		
		
		return departements;
	}
	
	//Rechercherundépartementdansl’annuaire
	public Departement rechercherDepartement(String nom) throws ClassNotFoundException{
			
			String query = "SELECT * FROM Departement WHERE nom like '%"+nom+ "'%";
			
			
			Departement departement = new Departement();
			
			Class.forName(Constent.DRIVER_NAME);
			
			try (Connection connection = DriverManager
			.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
				
				//
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				
				
					departement.setId(result.getLong("id"));
					departement.setNom(result.getString("nom"));
						
				
			}catch(SQLException exception) {
				exception.printStackTrace();
				
			}
			return departement;
		}
	
	//Insérerunnouveaudépartement
	public int insererDepartement(Departement departement) throws ClassNotFoundException {
		
		String query = "INSERT INTO Departement (nom) VALUES (?)";
		
		int result = 0;
			
		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
	
			preparedStatement.setString(1, departement.getNom());
			
			//
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
		
		
		
		
		
		
		return result;
		
		
	}
	
	
	
	

}
