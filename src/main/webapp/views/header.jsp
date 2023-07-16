<%@ taglib uri="/struts-tags" prefix="s"%>


    
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	 <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="css/font-awesome.css">

    <link rel="stylesheet" href="css/store2.css">

    <link rel="stylesheet" href="css/owl-carousel.css">

    <link rel="stylesheet" href="css/lightbox.css">
	
</head>
<body>
	

    
    
    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <s:url namespace="/" action="produits" var="lien"></s:url>
                        <s:a href="%{lien}" class="logo">
                            <img src="assets/Ray-Ban-Logo.jpg">
                        </s:a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"> <s:url namespace="/" action="produits" var="lien1"></s:url>
				  <s:a href="%{lien1}" class="nav-link">Products</s:a></li>
                            <li class="scroll-to-section">			      <s:url namespace="/" action="updatePass" var="lien2"></s:url>
				  <s:a href="%{lien2}" class="nav-link">Edit Password</s:a>
</li>
                            <li class="scroll-to-section">
                            <form id="commandeForm" action="<s:url namespace='/' action='commandes' />" method="post">
  <input type="hidden" name="login" value="<s:property value='#session.loggedInUser' />" />
</form>

<script>
  function goToCommande() {
    document.getElementById("commandeForm").submit();
  }
</script>

<s:a href="javascript:void(0);" class="nav-link" onclick="goToCommande();">Commande</s:a>

                            <li class="scroll-to-section"><form id="cartForm" action="<s:url namespace='/' action='carts' />" method="post">
  <input type="hidden" name="login" value="<s:property value='#session.loggedInUser' />" />
</form>

<script>
  function goToCart() {
    document.getElementById("cartForm").submit();
  }
</script>

<s:a href="javascript:void(0);" class="nav-link" onclick="goToCart();">Cart</s:a>
                            <li class="scroll-to-section">			      <s:url namespace="/" action="users" var="lien3"></s:url>
     			 <s:url namespace="/" action="logout" var="lien10"></s:url>
				  <s:a href="%{lien10}" class="btn btn-outline-danger">
				  Logout
				  </s:a> 
</li>

                            
                        </ul>        
                        
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->
			