<%@page import="com.melmghar.ensannuaire.dao.EtudiantDao"%>
<%@page import="com.melmghar.ensannuaire.model.Etudiant"%>
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

<body >
<%@include  file="../index.jsp" %>
<%
	EtudiantDao etudiantDao = new EtudiantDao();
	Etudiant etudiant = etudiantDao.rechercherEtudiant(request.getParameter("nom"));
	//request.setAttribute("etudiant", etudiant);

%>
    <div class="container" style="width: 600px; margin: auto; margin-top: 50px">
        <h2 class="bg-primary text-light card-header">La résultat de rechereche</h2>
        <form class="form" action="register" method="post">
            <table class=" container">
                <tr>
                    <td>CNE</td>
                    <td><%= etudiant.getCNE() %></td>
                </tr>
                <tr>
                    <td>Nom</td>
                    <td><%= etudiant.getNom() %></td>
                </tr>
                <tr>
                    <td>Prénom</td>
                     <td><%= etudiant.getPrenom() %></td>
                </tr>
                <tr>
                    <td>Filiére</td>
                     <td><%= etudiant.getFiliere() %></td>
                </tr>
                <tr>
                    <td>Département</td>
                     <td><%= etudiant.getDepartement() %></td>
                </tr>
                <tr>
                    <td>TEéléphone</td>
                     <td><%= etudiant.getTelephone() %></td>
                </tr>
        
            </table>
        </form>
    </div>
</body>
</html>
