<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Filére</title>

</head>
<body>
<%@include  file="../index.jsp" %>
<h1>List des filiéres</h1>

		<div class="container">
			<label for="departement" class="form-label">Département</label>
				<form action="<%= request.getContextPath() %>/insererFiliere" method="get">
				 <select class="form-select" name="departement" required onchange="this.form.submit()">
				
					 <c:forEach var="departement" items= "${listDepartements}">
					 		<c:if test="${departement.id == selectedDep}"> 
					 			<option value=<c:out value="${departement.id}"/> selected >
									<c:out value="${departement.nom}"/>
								</option>
					 		</c:if>
					 		<c:if test="${departement.id != selectedDep}">
					 			<option value=<c:out value="${departement.id}"/> >
									<c:out value="${departement.nom}"/>
								</option>
					 		</c:if>
					 	 
						</c:forEach>
				</select>
			</form>
		</div>

		<table class="container">
		
		  <thead>
		  <tr>
		  <td>Id</td>
		   <td>Nom</td>
		   <td></td>
		  <td>Action</td>
		  </tr>
		  <tr>
		    <td  colspan="2"> <%@include  file="RechercheFiliere.html" %></td>
		    <td></td>
		    <td  > <%@include  file="./filiere-form.html" %></td>
		  </tr>
		  </thead>
		
	  <tbody>
	 
	 
	  
	  	   		<c:if test="${filiere != null}">
	  	   		 <form action="editFiliere" method="GET">
	    		<tr>
	    		
				  	<td><c:out value="${filiere.getId()}" />
				  
				  	<input type="hidden" name="id" value="<c:out value="${filiere.getId()}" />" />
				  
				  	</td>
				<td>
					
						<input type="text"  name="nom" value="<c:out value='${filiere.getNom()}' />" />
					
				</td>
				
				<td>
				<select class="form-select" name="departement_id" >
				
					 <c:forEach var="departement" items= "${listDepartements}">
					 		<c:if test="${departement.id == selectedDep}"> 
					 			<option value=<c:out value="${departement.id}"/> selected >
									<c:out value="${departement.nom}"/>
								</option>
					 		</c:if>
					 		<c:if test="${departement.id != selectedDep}">
					 			<option value=<c:out value="${departement.id}"/> >
									<c:out value="${departement.nom}"/>
								</option>
					 		</c:if>
					 	 
						</c:forEach>
				</select>
				
				</td>
			    <td>	
			    	<input type="submit" >
			    	<a href="insererFiliere">Cancel</a>
				    
			    </td>
	    		</tr>
	    		</form>    	
	    		
		</c:if>	
	   <c:forEach var="fil" items= "${listFiliere}">
	   	

	     
	   <c:if test="${fil.getId() != filere.getId()}">
	     <tr>
	     	<td><c:out value="${fil.getId()}" /></td>
	    	<td><c:out value="${fil.getNom()}" /></td>
			<td></td>
	    	<td>
	    	
	    	 	<a href="showeditFiliere?id=<c:out value='${fil.getId()}' />">Edit</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
		    	<a href="deleteFiliere?id=<c:out value='${fil.getId()}' />">Delete</a> 
	    	</td>
	    	
	    	
	      </tr>
	   
	   </c:if>
	  </c:forEach>
	  
	  
  
	  </tbody>
	</table>
	<c:if test="${result != null}">
		<c:if test="${result == 1}">
			<div class="alert alert-success" role="alert">
		  		La filiére à été ajoutée avec succées
			</div>
		</c:if>
		<c:if test="${result == 0}">
			<div class="alert alert-danger" role="alert">
		  		échec
			</div>
		</c:if>
	</c:if>


</body>
 
</html>