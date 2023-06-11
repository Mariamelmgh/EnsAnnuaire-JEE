package com.melmghar.ensannuaire.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melmghar.ensannuaire.dao.DepartementDao;
import com.melmghar.ensannuaire.dao.FiliereDao;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Filiere;

/**
 * Servlet implementation class FiliereController
 */
@WebServlet({"/insererFiliere","/rechercheFiliereResult","/editFiliere","/deleteFiliere","/showeditFiliere"})
public class FiliereController extends HttpServlet {
	
	FiliereDao filiereDao = new FiliereDao();
	private static final long serialVersionUID = 1L;
	Long result = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiliereController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
	//	System.out.println(action);
		try {
				switch (action){
					case "/insererFiliere":
						insereFiliere(request, response);
					break;
					case "/rechercheFiliereResult":
						rechercheFiliere(request, response);
					break;
					case "/editFiliere":
						editFiliere(request, response);
					break;
					case "/deleteFiliere":
						deleteFiliere(request, response);
					break;
					case "/showeditFiliere":
						showEditFiliere(request, response);
					break;
					
					default:
						insereFiliere(request, response);	
				} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	private void showEditFiliere(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Filiere filiere = filiereDao.rechercherFiliere(id);
		request.setAttribute("filiere", filiere);
		
		DepartementDao departementDao = new DepartementDao();
		List<Departement> departements = new ArrayList<Departement>();
		departements = departementDao.listDepartement();
		request.setAttribute("listDepartements", departements);
		request.setAttribute("listFiliere", filiereDao.getFilieres());
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("views/filiere/insereFiliere.jsp");
		 dispatcher.forward(request, response);
		
	}

	private void deleteFiliere(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		filiereDao.deleteFiliere(id);
		response.sendRedirect("insererFiliere");
	
	}

	private void editFiliere(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		
		String nom = request.getParameter("nom");
		Long depatId = Long.parseLong(request.getParameter("departement_id"));
			
		Filiere filiere = new Filiere(id, nom,depatId);
		filiereDao.modifierFiliere(filiere);
		response.sendRedirect("insererFiliere");
		
		
	}

	private void rechercheFiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/filiere/RechercheFiliere.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//NOM
		String nom = request.getParameter("nom");
		//DEPARTEMENT ID
		Long departementId = Long.parseLong( request.getParameter("departementId"));
		
		Filiere feliere = new Filiere();
		feliere.setNom(nom);
		feliere.setDepartementId(departementId);
		
		try {
			result = (long) this.filiereDao.creerFiliere(feliere);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("insererFiliere");
		
		
		
	}
	
	
	public void listFiliere(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		
		Long departementId = Long.parseLong( request.getParameter("departementId"));
		List<Filiere> listFiliere = filiereDao.afficherFiliersParDepartement(departementId);
		request.setAttribute("listFiliere", listFiliere);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/insererEtudiant.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insereFiliere(HttpServletRequest request,HttpServletResponse response)
	throws SQLException, IOException, ServletException, ClassNotFoundException {
			DepartementDao departementDao = new DepartementDao();
			List<Departement> departements = new ArrayList<Departement>();
			departements = departementDao.listDepartement();
			request.setAttribute("listDepartements", departements);
			List<Filiere> listFiliere = new ArrayList<Filiere>();
			
			if(request.getParameter("departement") != null) {
				
				Long depId = Long.parseLong(request.getParameter("departement"));
				listFiliere = filiereDao.afficherFiliersParDepartement(depId);
				request.setAttribute("selectedDep", depId);
				
			}else {
				listFiliere = filiereDao.getFilieres();
				
			}
			
			request.setAttribute("listFiliere", listFiliere);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/filiere/insereFiliere.jsp");
			dispatcher.forward(request, response);
	}
	
	

}
