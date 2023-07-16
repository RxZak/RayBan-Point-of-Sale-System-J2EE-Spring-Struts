<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/login2.css">

    <title>Login</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('assets/login.png');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Login to <strong>RayBan</strong></h3>
            <p class="mb-4">The best Sunglasses on the market</p>
            
            
            
            
            
       <s:form action="loginaction" method="post" class="login">
              <div class="form-group first">
                <label for="username">Username</label>
               <s:textfield name="login" placeholder="Username" class="form-control" id="username" theme="simple"/>
              </div>
              <div class="form-group last mb-3">
                <label for="password">Password</label>
                <s:password name="pass" placeholder="Password" class="form-control" required="true" id="password" theme="simple" />
              </div>
              
      
			<s:submit value="Log In" class="btn btn-block btn-primary" theme="simple"></s:submit>
  			</s:form>
  			<form action = "New" method = "post">
  			<br>
		      <div class="bottom text-center mb-5">
		      <p class="sm-text mx-auto mb-3">Don't have an account?
		      <input type = "submit" value = "Sign up" class="btn btn-outline-dark" /></p>
		      </div>
		      </form>
		    <form action = "forgot" method = "post">
  			<br>
      <div class="bottom text-center mb-5">
      <p class="sm-text mx-auto mb-3">have you forgotten your password ?
      <input type = "submit" value = "Forgot Password" class="btn btn-outline-warning" /></p>
      </div>
      </form>

      <p align="center" class="text-danger"><s:property value="message"/></p>
  			
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/login2.js"></script>
  </body>
</html>