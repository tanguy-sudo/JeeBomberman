<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="En-tete.jsp"%>
<title>Store</title>
</head>
<body>
	<%@ include file="Navbar.jsp"%>
	<main role="main">
		<section class="jumbotron text-center">
	        <div class="container">
	          <h1 class="jumbotron-heading">Store</h1>
	          <p class="lead text-muted">Here you can choose a color for your character.</p>
	        </div>
	    </section>    
		<div class="container">
			<form method="post" action="${pageContext.request.contextPath}/Store">
			  <div class="row">
				  <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/RedAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">Red color</h5>
		                  <p class="card-text">
		                  <c:choose>
							<c:when test="${color_agent == 'ROUGE'}">
								   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="ROUGE" checked>
							</c:when>
							<c:otherwise>
								 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="ROUGE"> 
							</c:otherwise>
						  </c:choose>
						  <label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
		          <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/BlueAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">Blue color</h5>
		                  <p class="card-text">
			                  <c:choose>
								<c:when test="${color_agent == 'BLEU'}">
									   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="BLEU" checked>
								</c:when>
								<c:otherwise>
									 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="BLEU"> 
								</c:otherwise>
							  </c:choose>
						  	<label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
		           <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/GreenAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">Green color</h5>
		                  <p class="card-text">
		                  <c:choose>
							<c:when test="${color_agent == 'VERT'}">
								   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="VERT" checked>
							</c:when>
							<c:otherwise>
								 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="VERT"> 
							</c:otherwise>
						  </c:choose>
						  	<label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
		           <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/YellowAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">Yellow color</h5>
		                  <p class="card-text">
		                  <c:choose>
							<c:when test="${color_agent == 'JAUNE'}">
								   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="JAUNE" checked>
							</c:when>
							<c:otherwise>
								 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="JAUNE"> 
							</c:otherwise>
						  </c:choose>
						  	<label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
		           <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/WhiteAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">White color</h5>
		                  <p class="card-text">
		                  <c:choose>
							<c:when test="${color_agent == 'BLANC'}">
								   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="BLANC" checked>
							</c:when>
							<c:otherwise>
								 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="BLANC"> 
							</c:otherwise>
						  </c:choose>
						  	<label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
		           <div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="images/DefaultAgent.png">	                
		                <div class="card-body">
		                	<h5 class="card-title">Default color</h5>
		                  <p class="card-text">
		                  <c:choose>
							<c:when test="${color_agent == 'DEFAULT'}">
								   	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="DEFAULT" checked>
							</c:when>
							<c:otherwise>
								 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="DEFAULT"> 
							</c:otherwise>
						  </c:choose>
						  	<label class="form-check-label" for="flexRadioDefault1">Select</label>
						  </p>
		                  <div class="d-flex justify-content-between align-items-center">
		                  </div>
		                </div>
		              </div>
		            </div>
			  	</div>
		        <button class="btn btn-outline-dark btn-lg px-5" type="submit">Change color</button>
			</form>
		</div>
	</main>
</body>
</html>