<%@ include file="header.jsp" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Listes Commandes </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
</head>
<body>


<br><br><br><br><br>
<h3 class="text-center">Commandes</h3>
	<section class="container">
		<div class="row">
         	<div class="col-12">
				<table class="table" data-toggle="table" data-search="true" data-show-columns="true" data-pagination="true">
					<thead class="thead-dark">
					<tr>
					<th data-sortable="true" data-field="code Commande">Commande Id </th>
					<th>User</th>
					<th data-sortable="true" data-field="code Produit">Article Id</th>
					<th>Article Name</th>
					<th data-sortable="true" data-field="Article Price">Date</th>
					<th data-sortable="true" data-field="Quantity">Quantity</th>
					</tr>
					</thead>
					<tbody>					
    				<s:iterator value="commandes" var="cartItem" status="cartStatus">
    					<tr>
                                <td><s:property value="codeCmd" /></td>
                                <td><s:property value="client" /></td>
                                <td><s:property value="codePdt" /></td>
								<td><s:property value="articles[#cartStatus.index].nomPdt" /></td>
                                <td><s:property value="dateCmd" /></td>
                                <td><s:property value="qteCmd" /></td>
      					<!-- Add more table cells for other properties as needed -->
    					</tr>
  					</s:iterator>
  					
					</tbody>
				</table>
				<s:if test="sumCart > 0">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Shipping Details</h2>
                   <s:form action="commander" method="POST">
                        <div class="row row-space">
                            <div class="col-5">
                                <div class="input-group">
                                    <label class="label">Address</label>
                                    <s:textfield name="adresse"  class="input--style-4" theme="simple"></s:textfield>
                                </div>
                            </div>
                            <div class="col-5">
                                <div class="input-group">
                                    <label class="label">Mobile Number</label>
                                    <s:textfield name="mobileNumber" class="input--style-4" theme="simple"></s:textfield>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            
                            <div class="col-5">
                                <div class="input-group">
                                    <label class="label">Payement Method</label>
                                    <div class="p-t-10">
                                        <s:radio  name="payementMethod" list="#{'Cash on Delivery':'Cash on Delivery','Online Payement':'Online Payement'}" value="Online Payement" theme="simple"/>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                      
                        				<s:hidden name="login" value="%{#session.loggedInUser}" />
                        
                        <div class="p-t-7">
                        <s:submit class="btn btn--radius-2 btn--dark" value="Order Now" theme="simple"></s:submit>
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