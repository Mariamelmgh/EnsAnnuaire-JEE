<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Département</title>
<style>

</style>
</head>
<body>
<%@include  file="../index.jsp" %>

<h1>List des départements</h1>

		<table class="container">
		
		  <thead>
		  <tr>
		  <td>Id</td>
		   <td>Nom</td>
		  <td>Action</td>
		  </tr>
		  <tr>
		    <td  colspan="2"> <%@include  file="RechercheDepartement.html" %></td>
		    <td  > <%@include  file="./departement-form.html" %></td>
		  </tr>
		  </thead>
		
	  <tbody>
	 
	  
	  	   		<c:if test="${departement != null}">
	  	   		 <form action="editDepartement" method="GET">
	    		<tr>
	    		
				  	<td><c:out value="${departement.getId()}" />
				  
				  	<input type="hidden" name="id" value="<c:out value="${departement.getId()}" />" />
				  
				  	</td>
					<td>
					
						<input type="text"  name="nom" value="<c:out value='${departement.getNom()}' />" />
					
					</td>
				
				
			    <td>	
			   
			    	<input type="submit"  >
			   
			    
			    	<a href="insererDepartement">Cancel</a>
				   
			    
	    		</tr>
	    		</form>    	
	    		
		</c:if>	
	   <c:forEach var="dep" items= "${departements}">
	  

	     
	   <c:if test="${dep.getId() != departement.getId()}">
	     <tr>
	     	<td><c:out value="${dep.getId()}" /></td>
	    	<td><c:out value="${dep.getNom()}" /></td>
	
	    	<td>
	    	
	    	 	<a href="showeditDepartement?id=<c:out value='${dep.getId()}' />">Edit</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
		    	<a href="deleteDepartement?id=<c:out value='${dep.getId()}' />">Delete</a> 
	    	</td>
	    	
	      </tr>
	   
	   </c:if>
	  </c:forEach>
	  
	  
  
	  </tbody>
	</table>


</body>
 
</html>