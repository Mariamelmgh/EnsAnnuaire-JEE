<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Etudiant</title>


</head>


<body>
<%@include  file="../index.jsp" %>


<h1>List des étudiant</h1>
		<table class="container">
		
		  <thead>
		  <tr>
		  <td>CNE</td>
		   <td>Nom</td>
		   <td>Prénom</td>
		   <td>Filiere</td>
		  <td>Département</td>
		  <td>Action</td>
		  </tr>
		  <tr>
		    <td  colspan="4"> <%@include  file="RechercheEtudiant.html" %></td>
		    <td  colspan="2"> <%@include  file="./etudiant-form.html" %></td>
		  </tr>
		  </thead>
		
	  <tbody>
	 
	  
	  	   		<c:if test="${etudiant != null}">
	  	   		 <form action="editEtudiant" method="GET">
	    		<tr>
	    		
				  	<td><c:out value="${etudiant.getCNE()}" />
				  
				  		<input type="hidden" name="cne" value="<c:out value="${etudiant.getCNE()}" />" />
				  
				  	</td>
				<td>
					
						<input type="text"  name="nom" value="<c:out value='${etudiant.getNom()}' />" />
					
				</td>
				<td>
					<input type="text" name="prenom"  value="<c:out value='${etudiant.getPrenom()}' />" />
				</td>
				<td>
					<select class="form-select form-select-sm"  name="filiere" required>
						 <c:forEach var="filiere" items= "${listFiliere}">
						 
						  <option value=<c:out value="${filiere.id}"/> > 
						  	 <c:out value="${filiere.nom}"/>
						  </option>
						 
						 </c:forEach>
						</select>
				</td>
				<td>
					<input type="text" disabled  name="departement" value="<c:out value='${etudiant.getDepartement()}' />" />
				</td>
			    <td>	
			    	<input type="submit" >
			    	<a href="insererEtudiant">Cancel</a>
				    
			    </td>
	    		</tr>
	    		</form>    	
	    		
		</c:if>	
	   <c:forEach var="e" items= "${listEtudiant}">
	   	
	
	     
	   <c:if test="${etudiant.getCNE() != e.getCNE()}">
	     <tr>
	     	<td><c:out value="${e.getCNE()}" /></td>
	    	<td><c:out value="${e.getNom()}" /></td>
	    	<td><c:out value="${e.getPrenom()}" /></td>
	    	<td><c:out value="${e.getFiliere()}" /></td>
	    	<td><c:out value="${e.getDepartement()}" /></td>
	    	     	
	    	<td>
	    	
	    	 	<a href="showeditEtudiant?cne=<c:out value='${e.getCNE()}' />">Edit</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
		    	<a href="deleteEtudiant?cne=<c:out value='${e.getCNE()}' />">Delete</a> 
	    	</td>
	    	
	      </tr>
	   
	   </c:if>
	  </c:forEach>
	  
	  
  
	  </tbody>
	</table>


</body>
 
</html>