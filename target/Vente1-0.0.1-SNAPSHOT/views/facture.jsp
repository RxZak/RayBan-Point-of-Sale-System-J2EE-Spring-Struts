
<!------ Include the above in your HEAD tag ---------->
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="j" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Invoice</title>
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
	
</head>
<body>


<div class="container">
<div id="HTMLtoPDF">
    <div class="row">
    
        <div class="col-xs-12">
    		<div class="invoice-title" align="center">
    			<h2>Invoice</h2><h3 class="pull-right">Rayban </h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<strong>Payement Method:</strong><br>
    					<s:property value="payementMethod"/><br>
    					<s:property value="login"/><br>
    					<strong>Phone Number:</strong><br>
    					0<s:property value="mobileNumber"/><br>
    				</address>
    			</div>
    			
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Articles</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Article</strong></td>
        							<td><strong>Price(DH)</strong></td>
        							<td><strong>Quantity</strong></td>
        							<td><strong>Total(DH)</strong></td>
        							<td><strong>Order Date</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    				<s:iterator value="cart" var="cartItem" status="cartStatus">
    					<tr>
        				<td><s:property value="articles[#cartStatus.index].nomPdt" /></td>
     					<td><s:property value="prixCart" /> MAD</td>
     					<td><s:property value="qteCart" /></td>
     					<td><s:property value="total" /> MAD</td>
     					<td><s:property value="orderDate" /></td>
     					
      					<!-- Add more table cells for other properties as needed -->
    					</tr>
  					</s:iterator>

    						</tbody>
    					</table>
    				</div>
    			</div>   			
    		</div>	
    	</div>
   
    </div>
		    		
</div>

<button onclick="hasa()" class="btn btn-info">Download PDF</button>
		  
				<s:url namespace="/" action="indexHome" var="lien8"></s:url>
				  <s:a href="%{lien8}" class="btn btn-success" >Return to Store</s:a>	
	<!-- these js files are used for making PDF -->
	<script src="../js/jspdf.js"></script>
	<script src="../js/jquery-2.1.3.js"></script>
	<script src="../js/pdfFromHTML.js"></script>
	<script>
	function  hasa(){
	var h=document.getElementById("HTMLtoPDF");
	var doc=new jsPDF()
	doc.fromHTML(h,30,30)
	return doc.save("facture.pdf")
	}
	</script>
	
	 	
</div>
</body></html>