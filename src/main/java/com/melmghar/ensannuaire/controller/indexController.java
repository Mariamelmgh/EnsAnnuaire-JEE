package com.melmghar.ensannuaire.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/")
public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		switch (action) {
		case "/etudiant":
			response.sendRedirect("/EnsAnnuaire/insererEtudiant");

			break;
		case "/departement":
			response.sendRedirect("/EnsAnnuaire/insererDepartement");
			break;
		case "/filiere":
			response.sendRedirect("/EnsAnnuaire/insererFiliere");
			break;
		default:
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);

			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
