<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sec:csrfMetaTags/>


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

div.ex1 {
    padding: 50px 100px 0px 100px;
}

div.ex2 {
    padding: 0px 100px 10px 100px;
}

div.ex3 {
    padding: 50px 0px 0px 0px;
}

.header img {
  float: left;
  width: 400px;
  height: 80px;
  background: #555;
}
.headerr img {
  float: right;
  width: 280px;
  height: 78px;
  background: #555;
}
.headerm img {
  float: left;
  width: 460px;
  height: 80px;
  
}

 {
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

div.ex10 {
    padding: 120px 0px 200px 130px;
}

</style>

</head>
<body>

<div class="container">
  <div class="page-header">
  <div class="header">  <img src="<c:url value="${headerLeft}" />" alt="logo" /> </div>
  <div class="headerm">  <img src="<c:url value="${headerMiddle}" />" alt="logo" />   </div>
  <div class="headerr">  <img src="<c:url value="${headerRight}" />" alt="logo" />   </div>    
  </div>      
</div> 

<p></p>      
<p></p> 

<div class="row"  id="mydiv">
  <div class="column" style="background-color:#aaa;">
    <h3 align="center">PAYMENT DETAILS</h3>
     <p> </p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${uid}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${uname}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${acscc}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${actualamount}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${dcc}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${dp}"/></p>
     <p style="text-align:center; font-weight: bold; color: #FF5733;"><c:out value="${payableamount}"/></p>
  </div>
  <div class="column" style="background-color:#bbb;">
  <div class = "ex10"><div id="paypal-button-container"></div><!-- </div> -->
  
	<div id="confirm">
	    <div> Ship to:</div>
	    <div><span id="recipient"></span>, <span id="line1"></span>, <span id="city"></span></div>
	    <div><span id="state"></span>, <span id="zip"></span>, <span id="country"></span></div>
	
	     <button id="confirmButton">Complete Payment</button>
	</div>
	
	<div id="thanks">  THANK YOU <span id="thanksname"></span>!
	</div>
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
             sandbox:   'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
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

                     return actions.payment.execute().then(function(paymentDetails) {

                         // Show a thank-you note
                         console.log("payment executed");
					     console.log(paymentDetails);	
					     
					     
					    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
					 	var csrfToken = $("meta[name='_csrf']").attr("content"); 
					 	var csrfHeader = $("meta[name='_csrf_header']").attr("content");  // THIS WAS ADDED
					 	var headers = {};
					 	headers[csrfHeader] = csrfToken; 
					     
					 	 
					 	 var payPalPaymentResponseDTO = {};
					 		 	
					 	 payPalPaymentResponseDTO["parentPaymentId"]=data.id;
					 	 payPalPaymentResponseDTO["paymentAmount"]=paymentDetails.transactions[0].amount.total;
					 	 payPalPaymentResponseDTO["paymentCurrency"]=paymentDetails.transactions[0].amount.currency;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleState"]=paymentDetails.transactions[0].related_resources[0].sale.state;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleUpdatetime"]=paymentDetails.transactions[0].related_resources[0].sale.update_time;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleCreatetime"]=paymentDetails.transactions[0].related_resources[0].sale.create_time;
					 	 payPalPaymentResponseDTO["payerPayerinfoEmail"]=paymentDetails.payer.payer_info.email;
					 	 payPalPaymentResponseDTO["payerPayerinfoName"]=paymentDetails.payer.payer_info.first_name;
					 	
					 		 
					 	 // payPalPaymentResponseDTO["saleAmountCurrency"]=data.transactions[0].related_resources[0].sale.amount.currency;
					 	/*  payPalPaymentResponseDTO["transactionsRelatedresourcesSaleAmountTotal"]=data.transactions[0].related_resources[0].sale.amount.total;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleId"]=data.transactions[0].related_resources[0].sale.id;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleCreatetime"]=data.transactions[0].related_resources[0].sale.create_time;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSalePaymentmode"]=data.transactions[0].related_resources[0].sale.payment_mode;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleProtectioneligibility"]=data.transactions[0].related_resources[0].sale.protection_eligibility;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleState"]=data.transactions[0].related_resources[0].sale.state;
					 	 payPalPaymentResponseDTO["transactionsRelatedresourcesSaleUpdatetime"]=data.transactions[0].related_resources[0].sale.update_time; */
					 	 payPalPaymentResponseDTO["transactionsResponse"]=JSON.stringify(paymentDetails);					 	 
					 	  
					 
					     //console.log(payPalPaymentResponseDTO); 
					     
					     $.ajax({
					    	     type: "POST",
		             		     headers:headers,
						         url: "json/savepaymentdata",
						         contentType: 'application/json',
						    	 data: JSON.stringify(payPalPaymentResponseDTO), 
							     success: function(pdata) 
							    {
							    	//console.log("DATA",data.id);
							    	//alert(pdata);
						        },
						        error: function(jqXHR, textStatus,errorThrown){
						        	 alert(jqXHR.status+jqXHR.responseJSON.message+jqXHR.responseJSON.reason);
						     }
							});
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