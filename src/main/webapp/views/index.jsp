<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
	<%@include  file="./css/style.css" %>
</style>

</head>
<body>
<nav class="navbar navbar-dark bg-dark">
<a href ="<%=request.getContextPath()%>">home</a>
<a href = "<%=request.getContextPath()%>/etudiant">Etudiant</a>
<a href ="<%=request.getContextPath()%>/filiere">Filiere</a>
<a href ="<%=request.getContextPath()%>/departement">Departement</a>
</nav>

</body>
</html>