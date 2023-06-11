<%@page import="com.melmghar.ensannuaire.dao.DepartementDao"%>
<%@page import="com.melmghar.ensannuaire.dao.FiliereDao"%>
<%@page import="com.melmghar.ensannuaire.model.Departement"%>
<%@page import="com.melmghar.ensannuaire.model.Filiere"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reherche etudiant</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body class="container-fluid">
<%
	 DepartementDao departementDao = new DepartementDao();
	 Departement departement = departementDao.rechercherDepartement(request.getParameter("nom"));
	 FiliereDao filiereDao = new FiliereDao();
	 List<Filiere> filiers = new ArrayList<Filiere>();
	 filiers= filiereDao.afficherFiliersParDepartement(departement.getId());
	
%>
    <div class="card" style="width: 600px; margin: auto; margin-top: 50px">
        <h2 class="bg-dark text-light card-header">La résultat de rechereche</h2>
       
            <table class="table table-hover table-striped">
                <tr>
                    <td>Id</td>
                    <td><%= departement.getId() %></td>
                </tr>
                <tr>
                    <td>Nom</td>
                    <td><%= departement.getNom() %></td>
               
        
            </table>
           
        
    </div>
</body>
</html>
