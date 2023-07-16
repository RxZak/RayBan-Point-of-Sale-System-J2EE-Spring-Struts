<%@ taglib uri="/struts-tags" prefix="s"%>
<%    	String username = session.getAttribute("loggedInUser").toString();
 %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title>Rayban - Product Page</title>


    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/owl-carousel.css">
    <link rel="stylesheet" href="css/lightbox.css">
    <link rel="stylesheet" href="css/store2.css">

    </head>
    
    <body>


<br>
<br>
    <!-- ***** Products Area Starts ***** -->
    <section class="section" id="products">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-heading">
                    
					<s:set var="message" value="%{#parameters['message'][0]}" />
					
					<s:if test="%{#message == 'removed'}">
					    <h3 style="color: red;">Product Removed From Cart Successfully</h3>
					</s:if>
					
					<s:if test="%{#message == 'added'}">
					    <h3 style="color: green;">Product Added to Cart Successfully</h3>
					</s:if>
					<s:if test="%{#message == 'outofstock'}">
					    <h3 style="color: red;">Product Out of stock</h3>
					</s:if>

                    <h2>Our Latest Products</h2>
                    <span>SUNGLASSES</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                
                       <s:iterator value="produits" var="produit" status="prodStatus">
		<div class="item">
                        <div class="thumb">
                            <div class="hover-content">
                                <ul>
                                 <s:url var="addToCartURL" action="addToCart">
								    <s:param name="login"><s:property value="#session.loggedInUser" /></s:param>
								    <s:param name="codePdt"><s:property value="codePdt" /></s:param>
									</s:url>
                                    <li><s:a href="%{addToCartURL}"><i class="fa fa-shopping-cart"></i></s:a></li>
                                </ul>
                            </div>
                            <img src="assets/<s:property value="image"/>"/>
                        </div>
                        <div class="down-content">
							<span>Code: <s:property value="codePdt"/></span>
                            <h4><s:property value="produitsP[#prodStatus.index].nomPdt"/></h4>
                             <span><s:property value="produitsP[#prodStatus.index].PrixPdt"/> MAD </span>
                            <span>Quantity: <s:property value="qtePdt"/></span>
                        </div>
                    </div>

                	</s:iterator>
                               
                
                
                
                
            </div>
        </div>
    </section>
    <!-- ***** Products Area Ends ***** -->
    
    <!-- ***** Footer Start ***** -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="first-item">
                        <div class="logo">
                            <img src="assets/Ray-Ban-Logo.jpg">
                        </div>
                        <ul>
                            <li><a href="#">16501 Collins Ave, Sunny Isles Beach, FL 33160, United States</a></li>
                            <li><a href="#">contact@rayban.com</a></li>
                            <li><a href="#">010-020-0340</a></li>
                        </ul>
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <div class="under-footer">
                        <p>Copyright 2022 RayBan Co., Ltd. All Rights Reserved. 
                        
                       
                    </div>
                </div>
            </div>
        </div>
    </footer>
    

    <!-- jQuery -->
    <script src="js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="js/owl-carousel.js"></script>
    <script src="js/accordions.js"></script>
    <script src="js/datepicker.js"></script>
    <script src="js/scrollreveal.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imgfix.min.js"></script> 
    <script src="js/slick.js"></script> 
    <script src="js/lightbox.js"></script> 
    <script src="js/isotope.js"></script> 
    
    <!-- Global Init -->
    <script src="js/custom.js"></script>

    <script>

        $(function() {
            var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
                $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
                
            });
        });

    </script>

  </body>

</html>
