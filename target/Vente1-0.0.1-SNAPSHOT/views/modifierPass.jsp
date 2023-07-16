<%@ include file="header.jsp" %>

<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%    	String username = session.getAttribute("loggedInUser").toString();
 %>
<html>
   <head>
      <title>New Password</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
	
   </head>
 	
   
   <body>
   
   <br><br>
			
   <div class="container px-4 py-5 mx-auto" style="width: 500px; height: 300px;   margin: 25px 50px 75px 100px;" align="center">
    <div class="card card0" align="center" style="padding: 25px ;">
       <s:form action="savePass" method="post">   
             <center>
          
		 	<h3 class="mb-5 text-center heading"> New Password</h3>
				<s:hidden name="login" value="%{#session.loggedInUser}" />
				<div class="m-2">
					<s:password class="form-control" name="oldPass" placeholder="Enter your old Password "  theme="simple"/>
				</div>
				<div class="m-2">
					<s:password class="form-control" name="pass" placeholder="Enter your new Password "  theme="simple" minlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$"/>
				</div>
				<div class="m-2">
					<s:password class="form-control" name="confirmPass" placeholder="Confirm Password "  theme="simple" minlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$"/>
				</div>
				    
            	
		 	    <s:submit value="Save" class="btn btn-success btn" theme="simple"></s:submit>
		 	    		</center>
		 	    
		</s:form>
		</div>
     </div>
      <p align="center" class="text-danger"><s:property value="message"/></p>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>    
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/locale/bootstrap-table-fr-FR.min.js"></script>
   </body>
</html>