<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/insererEtudiant" method= "POST">

		<div class="mb-3">
		  <label for="CNE" class="form-label">CNE</label>
		  <input  class="form-control" id="CNE" name="CNE" placeholder="P XXX -XXX -XXX -XXX">
		</div>
	
	
		<div class="mb-3">
		  <label for="nom" class="form-label">NOM</label>
		  <input  class="form-control" id="nom" name= "nom" placeholder="XXXXXX">
		</div>
		
		<div class="mb-3">
		  <label for="prenom" class="form-label">PRENOM</label>
		  <input  class="form-control" id="prenom" name= "prenom" placeholder="XXXXXX">
		</div>
		
		<div class="mb-3">
		  <label for="filiere" class="form-label">FILERE</label>
		<!--    <input  class="form-control" id="filiere" name= "filiere" placeholder="XXXXXX">-->
		
			<select class="form-select" aria-label="Selectionner votre filiére" name="filiere">
			 <c:forEach var="filiere" items= "${listFiliere}">
			 
			  <option value=<c:out value="${filiere.id}"/> > 
			  	 <c:out value="${filiere.nom}"/>
			  </option>
			 
			 </c:forEach>
			</select>
		</div>
		
		
		<div class="mb-3">
		  <label for="departement" class="form-label">DEPARTEMENT</label>
		  <input  class="form-control" id="departement" name="departement" placeholder="XXXXXX">
		</div>
		
		<div class="mb-3">
		  <label for="telephone" class="form-label">TELEPHONE</label>
		  <input  class="form-control" id="telephone" name="telephone" placeholder="06 XXX XXXX XXX">
		</div>
		
		  <button type="submit" class="btn btn-primary">Enregistrer</button>
		
	</form>
</body>
</html>