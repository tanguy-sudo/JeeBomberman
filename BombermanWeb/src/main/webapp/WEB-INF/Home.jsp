<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="En-tete.jsp"%>
<title>Home</title>
</head>
<body>
	<%@ include file="Navbar.jsp"%>
	<main role="main">
		<section class="jumbotron text-center">
	        <div class="container">
	          <h1 class="jumbotron-heading">Store</h1>
	          <p class="lead text-muted">Here you can see your game history.</p>
	        </div>
	    </section>    
		<div class="container">
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">result</th>
			      <th scope="col">id_game</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="i" begin="0" end="${ size + 1 }" step="1">
			  		<c:if test="${ !empty plays[i] }">
				  		<tr>
				      		<th scope="row"><c:out value="${ i + 1 }"/></th>	 
							<td><c:out value="${ plays[i].results }"/></td>
				      		<td><c:out value="${ plays[i].id_game }"/></td>
				    	</tr>			  		
				    </c:if>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</main>      
</body>
</html>