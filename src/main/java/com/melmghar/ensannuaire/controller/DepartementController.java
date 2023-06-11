package com.melmghar.ensannuaire.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melmghar.ensannuaire.dao.DepartementDao;
import com.melmghar.ensannuaire.model.Departement;

/**
 * Servlet implementation class DepartementController
 */
@WebServlet({"/rechercheDepartementResult","/insererDepartement","/editDepartement","/deleteDepartement","/showeditDepartement"})
public class DepartementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DepartementDao departementDao = new DepartementDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartementController() {
        super();
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
			case "/rechercheDepartementResult":
				rechercheDepartement(request,response);
			break;
			
			case "/insererDepartement":
				insererDepartement(request,response);
			break;
			case "/showeditDepartement":
				showEditDepartement(request,response);
			break;
			case "/editDepartement":

				
				editDepartement(request,response);
			break;
		
			case "/deleteDepartement":
				deleteDepartement(request,response);
			break;
			default:
				insererDepartement(request,response);
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
	}

	private void deleteDepartement(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		departementDao.deleteDepartement(id);
		response.sendRedirect("insererDepartement");
		
	}

	private void showEditDepartement(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong( request.getParameter("id"));
		Departement departement = departementDao.rechercherDepartement(id);
		request.setAttribute("departement", departement);
		request.setAttribute("departements", departementDao.listDepartement());
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("views/departement/departement.jsp");
		 dispatcher.forward(request, response);
	}

	private void editDepartement(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		String nom = request.getParameter("nom");
		Departement departement = new Departement(id, nom);
		departementDao.modifierDepartement(departement);
		response.sendRedirect("insererDepartement");
		
	}

	private void insererDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Departement> departements = departementDao.listDepartement();
		System.out.print(departements.size());
		request.setAttribute("departements", departements);
		request.getRequestDispatcher("views/departement/departement.jsp").forward(request, response);

		
	}

	private void rechercheDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/departement/RechercheDepartement.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nom =  request.getParameter("nom");
		Departement departement = new Departement();
		departement.setNom(nom);
		
		try {
			departementDao.insererDepartement(departement);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	

}
