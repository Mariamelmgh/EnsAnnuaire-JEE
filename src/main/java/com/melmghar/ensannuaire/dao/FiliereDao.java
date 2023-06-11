package com.melmghar.ensannuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Filiere;
import com.melmghar.ensannuaire.utils.Constent;

public class FiliereDao {
	
	//Insérerunenouvellefilière
	public int creerFiliere(Filiere filiere) throws ClassNotFoundException {
		
		String query = "INSERT INTO Filiere"+
						"(nom,depatement_id) VALUES"+
						"(?,?)";
		
		int result = 0;
		
		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
	
			preparedStatement.setString(1, filiere.getNom());
			preparedStatement.setLong(2, filiere.getDepartementId());
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
				Long departementId = result.getLong("depatement_id");
				filieres.add(new Filiere(id,nom,departementId));
			}
			
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
						
		
		return filieres;
		
	}
	
	//Afficherlalistecomplètedesfilièrespardépartements
	public List<Filiere> afficherFiliersParDepartement(Long departementId) throws ClassNotFoundException{
	
		
		String query = "SELECT * FROM Filiere WHERE depatement_id = "+departementId;

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
				Long departement_id = result.getLong("id");
				filieres.add(new Filiere(id,nom,departement_id));
			}
			
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
						
		
		return filieres;
		
	}

	//Rechercher un filiére dansl’annuaire
	public Filiere rechercherFiliere(String nom) throws ClassNotFoundException{
			
			String query = "SELECT * FROM Filiere WHERE nom like '%"+nom+ "%'";
			
			
			Filiere filiere = new Filiere();
			
			Class.forName(Constent.DRIVER_NAME);
			
			try (Connection connection = DriverManager
			.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
				
				//
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
				filiere.setId(result.getLong("id"));
				filiere.setNom(result.getString("nom"));
				filiere.setDepartementId(result.getLong("depatement_id"));		
				
			}catch(SQLException exception) {
				exception.printStackTrace();
				
			}
			return filiere;
		}
	//Rechercherundépartementdansl’annuaire
	public Filiere rechercherFiliere(Long id) throws ClassNotFoundException{
			
			String query = "SELECT * FROM Filiere WHERE id  =" +id ;
			
			
			Filiere filiere = new Filiere();
			
			Class.forName(Constent.DRIVER_NAME);
			
			try (Connection connection = DriverManager
			.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
				
				//
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
				filiere.setId(result.getLong("id"));
				filiere.setNom(result.getString("nom"));
				filiere.setDepartementId(result.getLong("depatement_id"));		
						
				
			}catch(SQLException exception) {
				exception.printStackTrace();
				
			}
			return filiere;
		}

	public int deleteFiliere(Long id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String query = "DELETE FROM Filiere WHERE id  =" +id ;
		int result = 0;
		Class.forName(Constent.DRIVER_NAME);
		
		try (Connection connection = DriverManager
		.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(query)){
		
			
			//
			System.out.println(preparedStatement);
			
			 result= preparedStatement.executeUpdate();
					
					
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			
		}
		
		
		return result;
		
	}

	public int modifierFiliere(Filiere filiere) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "UPDATE Filiere SET nom = '" + filiere.getNom() +"',depatement_id="+ filiere.getDepartementId()+"  WHERE id = " + filiere.getId();
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
	
}
