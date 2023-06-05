package com.melmghar.ensannuaire.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melmghar.ensannuaire.dao.EtudiantDao;
import com.melmghar.ensannuaire.dao.FiliereDao;
import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.model.Filiere;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/")
public class EtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Etudiant Dao object
	EtudiantDao etudiantDao = new EtudiantDao();
	
    /**
     * Default constructor. 
     */
    public EtudiantController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		
		System.out.println(action);
		
		
		switch(action) {
		case "/rechercheEtudiantResult":
			System.out.print("tesst");
			try {
				rechercheEtudiant(request,response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		break;
		case "/RechercherEtudiant":
			
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/RechercherEtudiant.html");
		//	dispatcher.forward(request, response);
			
		break;
		case "/insererEtudiant":
			try {
				rechercheEtudiant(request,response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		break;
		default:
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//System.out.println(action);
		}
		
		//response.sendRedirect("insererEtudiant.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Etudiant properties
		//CNE, nom, prénom, filière,
		//département et téléphone 
		
		String CNE = request.getParameter("CNE");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Long filiere =Long.parseLong(request.getParameter("filiere"));
		
		String departement = request.getParameter("departement");
		String telephone = request.getParameter("telephone");
		
	
		//Create Etudiant object with all properties
		Etudiant etudiant = new Etudiant();
		
		etudiant.setCNE(CNE);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setFiliere(filiere);
		etudiant.setDepartement(departement);
		etudiant.setTelephone(telephone);
		
		try {
			this.etudiantDao.insererEtudiant(etudiant);
			System.out.println("test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Redirect user to another page after saving new Etudiant
		response.sendRedirect("index.jsp");
	
	}
	
	private void rechercheEtudiant(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException, ClassNotFoundException {


	Etudiant etudiant = etudiantDao.rechercherEtudiant(request.getParameter("nom"));
	request.setAttribute("etudiant", etudiant);
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();  
	out.println("<!DOCTYPE html>"
				+"<html>"
					+"<head>"
					+"<meta charset='UTF-8'>"
					+"<title>Recherche Etudiant HTML</title>"
					+"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
					+"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' integrity='sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM' crossorigin='anonymous'></script>"

					+"</head>"

					+"<body>"


						+"<label for='exampleDataList' class='form-label'>Datalist example</label>"
						+"<input class='form-control' id='nom' placeholder='Taper Pour rechercher...'>"
					
						+"<table class='table'>"
						  +"<thead>"
						    +"<tr>"
						     +" <th scope='col'>#</th>"
						      +"<th scope='col'>CNE</th>"
						      +"<th scope='col'>Nom</th>"
						      +"<th scope='col'>Prénom</th>"
						      +"<th scope='col'>Filiere</th>"
						      +"<th scope='col'>Téléphone</th>"
						      +"</tr>"
						  +"</thead>"
						  +"<tbody>"
						    +"<tr>"
						     +" <th scope='row'>1</th>"
						     + "<td >"+etudiant.getCNE()+"</td>"
						     +"<td>"+ etudiant.getNom()+"</td>"
						     +"<td>"+ etudiant.getPrenom()+"</td>"
						     +"<td>"+ etudiant.getFiliereId()+"</td>"
						 +  "</tr>"
						  
						 +" </tbody>"
						+"</table>"
				+"</body>"
			+"</html>");
	
	
	//RequestDispatcher dispatcher = request.getRequestDispatcher("RechercherEtudiant.html");
	//dispatcher.forward(request, response);
}
	
	private void listFiliere(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		
		FiliereDao filiereDao = new FiliereDao();
		List<Filiere> listFiliere = filiereDao.getFilieres();
		request.setAttribute("listFiliere", listFiliere);
		RequestDispatcher dispatcher = request.getRequestDispatcher("insererEtudiant.jsp");
		dispatcher.forward(request, response);
	}

	private void insererEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("insererEtudiant.jsp");
		dispatcher.forward(request, response);
	}

}
