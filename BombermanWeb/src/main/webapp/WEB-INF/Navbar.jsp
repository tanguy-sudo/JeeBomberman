<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
    <ul class="navbar-nav">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Accueil</a>
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/Store">Store <span class="sr-only"></span></a>
      </li>
    </ul>
  </div>
  <div class="navbar-nav ms-auto">
 	 <ul class="navbar-nav">
        <li class="nav-item active my-lg-0">
       		<a class="nav-link" href="#">${ sessionScope.userSession.username }<span class="sr-only"></span></a>
     	</li>
     	<li class="nav-item active my-lg-0">
     		<a href="${ pageContext.request.contextPath }/SignOut" class="nav-item nav-link">Sign Out</a>
     	</li>
     </ul>
  </div>
</nav>