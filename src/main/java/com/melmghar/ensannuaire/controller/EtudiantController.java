package com.melmghar.ensannuaire.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melmghar.ensannuaire.dao.EtudiantDao;
import com.melmghar.ensannuaire.model.Etudiant;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/insererEtudiant")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/insererEtudiant.jsp");
		dispatcher.forward(request, response);
		
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
		String filiere = request.getParameter("filiere");
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

}
