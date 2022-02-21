<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="En-tete.jsp" %>
<title>Sign Up</title>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Sign Up</h2>
              <p class="text-white-50 mb-5">Please enter an login and password</p>
			
			  <form method="post" action="${pageContext.request.contextPath}/SignUp">
	              <div class="form-outline form-white mb-4">
	                <input type="text" id="username" class="form-control form-control-lg" name="username" required/>
	                <label class="form-label" for="username">Login</label>
	              </div>
	
	              <div class="form-outline form-white mb-4">
	                <input type="password" id="password" class="form-control form-control-lg" name="password" required/>
	                <label class="form-label" for="password">Password</label>
	              </div>
	              
	              <div class="form-outline form-white mb-4">
	                <input type="password" id="verifpassword" class="form-control form-control-lg" name="verifpassword" required/>
	                <label class="form-label" for="verifpassword">Repeat your password</label>
	              </div>
	
	              <p class="small mb-5 pb-lg-2">
	              	By signing up you accept our 
	              	<br>
	             	<a class="text-blue-50" href="#!" data-bs-toggle="modal" data-bs-target="#TermsModal">Terms Of Use</a>
	              </p>
	
	              <button class="btn btn-outline-light btn-lg px-5" type="submit">Sign Up</button>
              </form>

              <div class="d-flex justify-content-center text-center mt-4 pt-1">
                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
              </div>
              
              <div>
              	<p class="mb-0">Do have an account? <a href="${pageContext.request.contextPath}/SignIp" class="text-blue-50 fw-bold">Sign In</a></p>
              </div>

            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Modal -->
<div class="modal fade" id="TermsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Terms Of Use</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Now, your soul is mine !
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>