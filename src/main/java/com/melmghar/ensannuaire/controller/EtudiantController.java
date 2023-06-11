package com.melmghar.ensannuaire.controller;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melmghar.ensannuaire.dao.DepartementDao;
import com.melmghar.ensannuaire.dao.EtudiantDao;
import com.melmghar.ensannuaire.dao.FiliereDao;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.model.Filiere;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet({"/rechercheEtudiantResult","/RechercherEtudiant","/insererEtudiant","/editEtudiant","/deleteEtudiant","/showeditEtudiant"})
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
		
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch(action) {
			case "/rechercheEtudiantResult":
				rechercheEtudiant(request,response);
			break;
			case "/insererEtudiant":
				insererEtudiant(request,response);
			break;
			case "/editEtudiant":
				editEtudiant(request,response);
			break;
			case "/showeditEtudiant":
			
				showEditEtudiant(request,response);
			break;
		
			case "/deleteEtudiant":
				deleteEtudiant(request,response);
			break;
			default:
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
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
		response.sendRedirect("insererEtudiant");
	
	}

	private void rechercheEtudiant(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException, ClassNotFoundException {

		request.getRequestDispatcher("views/Etudiant/RechercheEtudiant.jsp").forward(request, response);
	//	response.sendRedirect("views/RechercheEtudiant.jsp");
	

		
	}
	
	

	private void insererEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		FiliereDao filiereDao = new FiliereDao();
		List<Filiere> listFiliere = filiereDao.getFilieres();
		
		//DepartementDao departementDao = new DepartementDao();
	//	Departement departement = departementDao.rechercherDepartement(1);
		List<Etudiant> listEtudiant = etudiantDao.getEtudiants();
		request.setAttribute("listFiliere", listFiliere);
		request.setAttribute("listEtudiant", listEtudiant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/Etudiant/insererEtudiant.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditEtudiant(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
		
		
		
		String CNE = request.getParameter("cne");
	
		
		Etudiant etudiant = etudiantDao.rechercherEtudiantByCNE(CNE);
				
		request.setAttribute("etudiant", etudiant);
		request.setAttribute("listEtudiant", etudiantDao.getEtudiants());
		FiliereDao filiereDao = new FiliereDao();
		List<Filiere> listFiliere = filiereDao.getFilieres();
		request.setAttribute("listFiliere", listFiliere);
		
		

		 RequestDispatcher dispatcher = request.getRequestDispatcher("views/Etudiant/insererEtudiant.jsp");
		 dispatcher.forward(request, response);
		
	
	}
	
private void editEtudiant(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
		
		
		
		String CNE = request.getParameter("cne");
	
		
		String nom = request.getParameter("nom");

		String prenom = request.getParameter("prenom");
	
		Long filiere =Long.parseLong(request.getParameter("filiere"));

		String departement = request.getParameter("departement");
		
		String telephone = request.getParameter("telephone");
	
		Etudiant etudiant = new Etudiant(CNE,nom,prenom,filiere,departement,telephone);
				
		 etudiantDao.modifierEtudiant(etudiant);
		 response.sendRedirect("insererEtudiant");
		
		
		}
	
	private void deleteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
		
		String CNE = request.getParameter("cne");
		 etudiantDao.deleteEtudiant(CNE);
		 response.sendRedirect("insererEtudiant");
	}

}
