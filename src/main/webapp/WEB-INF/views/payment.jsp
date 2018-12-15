<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>${titel}</title>
<link rel="icon" href="${titelImage}" />


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/uploadfile.css" />">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
<%-- <script src="<c:url value="/resources/javaScript/jquery.uploadfile.min.js" />"></script> --%>
<script src="<c:url value="/resources/javaScript/jquery.uploadfile.js" />"></script>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<style>

<style>
* {
    box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
    float: left;
    width: 50%;
    padding: 10px;
    height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

#mydiv {
    top: 45%;
    left: 35%;
    width:60em;
    height:22em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
     border: 0px solid #ccc;
    background-color: #f3f3f3; 
    position:fixed;
}


</style>

</head>
<body>


<div class="row"  id="mydiv">
  <div class="column" style="background-color:#aaa;">
    <h3 align="center">PAYMENT DETAILS</h3>
     <p> </p>
     <p align="center"><c:out value="${uid}"/></p>
     <p align="center"><c:out value="${uname}"/></p>
     <p align="center"><c:out value="${acscc}"/></p>
     <p align="center"><c:out value="${actualamount}"/></p>
     <p align="center"><c:out value="${dcc}"/></p>
     <p align="center"><c:out value="${dp}"/></p>
     <p align="center"><c:out value="${payableamount}"/></p>
  </div>
  <div class="column" style="background-color:#bbb;">
  <div id="paypal-button-container"></div>
	<div id="confirm">
	    <div>Ship to Prosenjit:</div>
	    <div><span id="recipient"></span>, <span id="line1"></span>, <span id="city"></span></div>
	    <div><span id="state"></span>, <span id="zip"></span>, <span id="country"></span></div>
	
	    <button id="confirmButton">Complete Payment</button>
	</div>

	<div id="thanks">
	    Thanks, <span id="thanksname"></span>!
	</div>

  </div>
</div>

<script>

$().ready(function() {
	 $('#confirm').hide();
     $('#thanks').hide();
     paypal.Button.render({

         env: 'sandbox', // sandbox | production

         client: {
             sandbox:    'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
             production: '<insert production client id>'
         },

         payment: function(data, actions) {
             return actions.payment.create({
                 payment: {
                     transactions: [
                         {
                             amount: { total: '<c:out value="${amount}"/>', currency: '<c:out value="${courency}"/>' }
                         }
                     ]
                 }
             });
         },

         // Wait for the payment to be authorized by the customer

         onAuthorize: function(data, actions) {
         	console.log('Authorize1');
         	console.log(data);
         	console.log(actions);
             // Get the payment details

             return actions.payment.get().then(function(data) {

                 // Display the payment details and a confirmation button

                 var shipping = data.payer.payer_info.shipping_address;
                 console.log('Authorize2');
                 console.log(data);

                 $('#recipient').text(shipping.recipient_name);
                 $('#line1').text(shipping.line1);
                 $('#city').text(shipping.city);
                 $('#state').text(shipping.state);
                 $('#zip').text(shipping.postal_code);
                 $('#country').text(shipping.country_code);

                 $('#paypal-button-container').hide();
                 $('#confirm').show();

                 // Listen for click on confirm button

                 $('#confirmButton').click(function() {

                     // Disable the button and show a loading message
 				console.log('Authorize3');
                     $('#confirm').text('Loading...');
                   //  $('#confirm').disabled = true;

                     // Execute the payment

                     return actions.payment.execute().then(function() {

                         // Show a thank-you note

                         $('#thanksname').text(shipping.recipient_name);

                         $('#confirm').hide();
                         $('#thanks').show();
                         //
                     });
                 });
             });
         }

     }, '#paypal-button-container');

	
	
});


</script>
</body>
</html>