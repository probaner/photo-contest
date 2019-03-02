<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->

<!------ Include the above in your HEAD tag ---------->

<html lang="en">
    <head> 
    
    <title>${titel}</title>
    <link rel="icon" href="${titelImage}" />
    
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link rel="stylesheet" href="<c:url value="/resources/css/validation/screen.css"/>">
		       
        <script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/javaScript/bootstrap-formhelpers.min.js" />"></script>
        <script src="<c:url value="/resources/javaScript/jquery.validate.js" />"></script>
        <script src="<c:url value="/resources/javaScript/additional-methods.min.js" />"></script>
        <script src="<c:url value="/resources/javaScript/jquery.form.js" />"></script>
        
     
		
<style>
body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background-color: #d3d3d3;
 	font-family: 'Oxygen', sans-serif;
}

.main{
 	margin-top: 70px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}
</style>		
		
		
	</head>
	<body>
	
		<div class="container">		
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h2 class="title">Register Judge</h2>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form:form class="form-horizontal" method="post" id="judgesignupForm" action="registerjudge" modelAttribute="judgeRegisterDTO">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="judgeName" id="judgeName" path="judgeName" placeholder="Enter your Name" readonly="true" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="judgeEmail" id="judgeEmail" path="judgeEmail" placeholder="Enter your Email" readonly="true" />
								</div>
							</div>
						</div>
						

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<form:input type="password" class="form-control" name="password" id="judgePassword" path="judgePassword" placeholder="Enter your Password"/>
								</div>
							</div>
						</div>
						
						
					
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="judgeAddress" id="judgeAddress" path="judgeAddress" placeholder="Enter your Address"   />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">City</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="judgeCity" id="judgeCity" path="judgeCity" placeholder="Enter your City"   />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">PIN</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="judgePin" id="judgePin" path="judgePin" placeholder="Enter your PIN"   />
								</div>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Country</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:select class="form-control" path="judgeCountry" id="judgeCountry"  items="${countryList}"  />
								</div>
							</div>
						</div>
						
						<form:input type="hidden" path="judgeToken" value="${token}" />

						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						
						<input type="hidden" class="hide" name="token" id="token" value="Submit">
						
					</form:form>
				</div>
			</div>
		</div>

	
<script>

	$().ready(function() {
		
		
		$.validator.addMethod(
		        "regex",
		        function(value, element, regexp) {
		            var re = new RegExp(regexp);
		            return this.optional(element) || re.test(value);
		        },
		        "Please check your input."
		);
		
		 
		$("#judgesignupForm").validate({
			rules: {					
					
				judgeAddress: { required:{
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				                          }
				                        },
		                       minlength: 4,
		                       maxlength: 120
		                      /*  regex: /^[\w\-\s]+$/ */
	                         },
	            judgeCity: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
	                        minlength: 3,
	                        maxlength: 50,
	                        lettersonly: true
                          },
               judgePassword: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
					            minlength: 6,
		                        maxlength: 25
			                  },            
			   confirm: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
		                                minlength: 6,
		                                maxlength: 25,
		                                equalTo: "#judgePassword"
	                                  },
				
	           judgePin: {
					       required: true,
					       minlength: 4,
					       maxlength: 12,
					       digits: true
				         },
				           
			  judgeCountry: { 
					           required: true
					        }
			        
			},
			messages: {
			
				judgeAddress: {required: "Please enter your address",
		                  minlength: "Your address must be at least 4 characters long",
                          maxlength: "Your address not more then 120 characters"                        
	                     },
	            judgeCity: {required: "Please enter your city",
		               minlength: "Your city must be at least 4 characters long",
                       maxlength: "Your city not more then 50 characters",
		               lettersonly: "Only letter are allowed"
	                  },
	            judgePin: { 
					   required: "Please enter your valide ZIP Code/PIN",
					   minlength: "Your ZIP Code/PIN must be at least 4 digits long",
					   maxlength: "Your ZIP Code/PIN not more then 12 digits",
					   digits: "Your ZIP Code/PIN not digits"
				     },
				judgePassword: {
					required: "Please provide a password",
					minlength: "Your password must be at least 6 characters long",
					maxlength: "Your password not more then 25 characters"
				},
				confirm: {
					required: "Please provide a password",
					minlength: "Your password must be at least 6 characters long",
					maxlength: "Your password not more then 25 characters",
					equalTo: "Please enter the same password as above"
				},
			
				judgeCountry : {
					required: "Select your Counter" 
				          }
			}
			
		});
		
	});
	</script>    
	</body>
</html>