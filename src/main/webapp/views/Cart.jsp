<%@ include file="header.jsp" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Listes Commandes </title>
	
		<link rel="stylesheet" href="css/main.css">
</head>
<body>


<br><br><br><br><br>
<h3 class="text-center">Cart</h3>
	<section class="container">
		<div class="row">
         	<div class="col-12">
				<table class="table" data-toggle="table" data-search="true" data-show-columns="true" data-pagination="true">
					<thead class="thead-dark">
					<tr>
					<th data-sortable="true" data-field="code Commande">Cart Id </th>
					<th>User</th>
					<th data-sortable="true" data-field="code Produit">Article Id</th>
					<th>Article Name</th>
					<th data-sortable="true" data-field="Article Price">Article Price</th>
					<th data-sortable="true" data-field="Quantity">Quantity</th>
					<th data-sortable="true" data-field="Total">Total</th>
					<th>Remove</th>
					</tr>
					</thead>
					<tbody>					
					<s:iterator value="carts" var="cartItem" status="cartStatus">
    					<tr>
      					<td><s:property value="IdCart" /></td>
     					<td><s:property value="login" /></td>
     					<td><s:property value="codePdt" /></td>
        				<td><s:property value="articles[#cartStatus.index].nomPdt" /></td>
     					<td><s:property value="prixCart" /> MAD</td>
     					<td><s:property value="qteCart" /></td>
     					<td><s:property value="total" /> MAD</td>
     					<td>
     					<s:url namespace="/" action="removeFromCart" var="rm">
     						<s:param name="login"><s:property value="#session.loggedInUser" /></s:param>
							<s:param name="codePdt"><s:property value="codePdt" /></s:param>
     					</s:url>
				  		<s:a href="%{rm}">Remove</s:a></td>
    					</tr>
  					</s:iterator>
  					<tr>
  					<td></td>
     					<td></td>
     					<td></td>
     					<td></td>
     					<td></td>
     					<td></td>
     					<td><s:property value="sumCart" /> MAD</td>
     				</tr>
					</tbody>
				</table>
				<s:if test="sumCart > 0">
				    <div class="container">
				        <div class="form-container">
				            <h2 class="mb-4">Shipping Details</h2>
				            <s:form action="commander" method="POST">
							    <div class="row mb-3">
							        <label for="address" class="col-sm-4 col-form-label">Address</label>
							        <div class="col-sm-8">
							            <s:textfield name="address" cssClass="form-control" required="true" theme="simple"></s:textfield>
							        </div>
							    </div>
							    <div class="row mb-3">
							        <label for="mobileNumber" class="col-sm-4 col-form-label">Mobile Number</label>
							        <div class="col-sm-8">
							            <s:textfield name="mobileNumber" cssClass="form-control" required="true" theme="simple"></s:textfield>
							        </div>
							    </div>
							    <div class="row mb-3">
							        <label class="col-sm-4 col-form-label">Payment Method</label>
							        <div class="col-sm-8">
									<s:select name="payementMethod" headerKey="" headerValue="Select Payment Method" list="payementMethods" required="true" cssClass="form-control" theme="simple" />
									<s:hidden name="login" value="%{#session.loggedInUser}" />
							        </div>
							    </div>
							    <div class="row mb-3">
							        <div class="col-sm-8 offset-sm-4">
							            <s:submit cssClass="btn btn-primary" value="Order Now" theme="simple"></s:submit>
							        </div>
							    </div>
							</s:form>
				        </div>
				    </div>
				</s:if>
			</div>
		</div>
	</section>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/locale/bootstrap-table-fr-FR.min.js"></script>
</body>
</html>