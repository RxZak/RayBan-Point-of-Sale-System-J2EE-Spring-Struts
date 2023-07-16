<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
   <head>
      <title>Inscrire</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   </head>
   
   <body>
      <section class="vh-100" style="background-image: url('assets/rayban.png');">
         <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
               <div class="col-lg-12 col-xl-11">
                  <div class="card text-black" style="border-radius: 25px;">
                     <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                           <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                              <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>
                              <s:form class="mx-1 mx-md-4" name="signupForm" action="addUser" method="post">
                                 <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
										<label class="form-label" for="form3Example1c">Username</label>
                                       <s:textfield id="form3Example1c" name="login" class="form-control" theme="simple" minlength="8" maxlength="20"/>
                                    </div>
                                 </div>
                                 <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                       <label class="form-label" for="form3Example4c">Password</label>
                                       <s:password class="form-control" name="pass" id="form3Example1c" theme="simple" minlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$"/>
                                    </div>
                                 </div>
                                 <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                    <label class="form-label" for="form3Example4cd">Repeat your password</label>
                                       <s:password class="form-control" name="confirmPass" id="form3Example1c" theme="simple" minlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$"/>
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <label class="form-label" for="form3Example3c">Security Question</label>
                                    <s:select id="form3Example3c" class="form-control"
                                       list="secQuestions" headerKey="" headerValue="Select Security question"
                                       name="securityQuestion" theme="simple" required="true"/>
                                 </div>
                                 <div class="d-flex flex-row align-items-center mb-4">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <div class="form-outline flex-fill mb-0">
                                    	<label class="form-label" for="form3Example3c">Answer</label>
                                    	<s:textfield id="form3Example1c" name="answer" class="form-control" theme="simple" />
                                    </div>
                                 </div>
                                 <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <s:submit value="Register" class="btn btn-primary btn-lg"/>
                                    <p class="text-danger"><s:property value="message" /></p>
                                 </div>
                              </s:form>
                              <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <form action = "index" method = "post">
      									<div class="bottom text-center mb-5">
      									<p class="sm-text mx-auto mb-3">Already have an account?
      									<input type = "submit" value = "Login" class="btn btn-outline-dark" /></p>
      									</div>
      								</form>
                                 </div>
                           </div>
                           <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                              <img src="assets/register.png"
                                 class="img-fluid" alt="Sample image">
                           </div>
                           
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>

      <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
   </body>
</html>
