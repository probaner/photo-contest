<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

 <title>${titel}</title>
 <link rel="icon" href="${titelImage}" />
  
  
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/validation/screen.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/site-demos.css" />">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap-formhelpers.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/javaScript/additional-methods.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/jquery.form.js" />"></script>
    
<style> 
div.redplaceholder ::-webkit-input-placeholder {
color: red !important;
}
 
div.redplaceholder :-moz-placeholder { /* Firefox 18- */
color: red !important;  
}
 
div.redplaceholder ::-moz-placeholder {  /* Firefox 19+ */
color: red !important;  
}
 
div.redplaceholder :-ms-input-placeholder {  
color: red !important;  
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

 <div class="container">
  <h4></h4>
  <ul class="nav nav-tabs">
    <li class="active"><a href="home">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Rules & Regulations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="getrulesandregulations"> RULES & REGULATIONS </a></li>
        <li><a href="getfipdefination"> COMPETITION DIVISION & DEFINITION </a></li>                       
      </ul>
    </li>
	<li><a href="getloginForm">Participate/Login</a></li>
	<li><a href="getUserTable">Entry Status</a></li>
	<li><a href="getDownload">Result</a></li>   
    <li><a href="getContuctUs">Contact Us</a></li>
  </ul>
</div> 
  
  <div>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  </div>
  
<div class="container" > 

 

<div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="getloginForm" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                         </div> 
                         <div class="panel-body">
                         <form:form action="processRegistration" id="signupForm" method="post" modelAttribute="userForm">
                         
                          <style>
                          .foo{
                                display: none;
                              }
                         </style>
                         <div style="margin-bottom: 25px" class="alert-danger" >${error} 
                         <a href="getForgetPasswordForm" class="alert-link"><strong>  click here to get password</strong></a>
                         <span></span>                                              
                         </div>
                         <script type="text/javascript">
                         var username = "${error}";
                         $(document).ready(function () {
                         if (username  == "") {                       	
                              $(".alert-danger").addClass("foo");                             
                           }                        
                          });
                         </script>
                         
                               
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                         
                                        <form:input path="email" id="email" type="text" class="form-control" name="email" value="" placeholder="* Email Address" required="autofocus" />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <form:input path="password" id="password" type="password" class="form-control" name="password" value="" placeholder="* Password" />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <input  id="confirm_password" type="password" class="form-control" name="confirm_password" value=""  placeholder="* Confirm Password" />                                        
                                    </div>  
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="firstname" id="firstname" type="text" class="form-control" name="firstname" value="" placeholder="* First Name" />                                        
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="lastname" id="lastname" type="text" class="form-control" name="lastname" value="" placeholder="* Last Name" />                                        
                                    </div> 
                                      
                                    <div style="margin-bottom: 25px" class="col-sm-12">
                                     <form:select class="form-control" path="gender" items="${genderList}" />
                                    </div> 
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="address" id="address" type="text" class="form-control" name="address" value="" placeholder="* Address" />                                        
                                   </div>
                                   
                                   <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="city" id="city" type="text" class="form-control" name="city" value="" placeholder="* City" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="pin" id="pin" type="text" class="form-control" name="pin" value="" placeholder="* ZIP/PIN Code" />                                        
                                   </div>
                                   
                                   <div style="margin-bottom: 25px" class="col-sm-12">
                                     <form:select class="form-control" path="country" id="country"  items="${countryList}"  />
                                    </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12"> 
                                        <form:input path="club" id="club" type="text" class="form-control" name="club" value="" placeholder=" Club" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12" > 
                                        <form:input path="honer" id="honer" type="text" class="form-control" name="honer" value="" placeholder=" Honour" />                                        
                                   </div>
                                   
                                   <div style="margin-top:10px" class="form-group">
                                   <div class="col-md-offset-5 col-md-12">
                                   <input class="btn btn-default btn-primary submit" type="submit" value="Submit" />
                                   </div>
                                   </div>
                            
                         </form:form>                         
                         </div>
                         

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
		
		 
		$("#signupForm").validate({
			rules: {					
					firstname: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
						         minlength: 1,
						         maxlength: 50,
						         lettersonly: false 
					           },
					lastname: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
				                minlength: 1,
				                maxlength: 50,
				                lettersonly: false
				                
			                  },
					address: { required:{
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				                          }
				                        },
		                       minlength: 4,
		                       maxlength: 120
		                      /*  regex: /^[\w\-\s]+$/ */
	                         },
					city: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
	                        minlength: 3,
	                        maxlength: 50,
	                        lettersonly: true
                          },
				    password: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
					            minlength: 6,
		                        maxlength: 25
			                  },            
				    confirm_password: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
		                                minlength: 6,
		                                maxlength: 25,
		                                equalTo: "#password"
	                                  },
					                  
				    email: {
					        required: true,
					        email: true
				           },
				    pin: {
					       required: true,
					       minlength: 4,
					       maxlength: 12,
					       digits: true
				         },
				           
				   country: { 
					           required: true
					        }
			        
			},
			messages: {
				firstname: {required: "Please enter your firstname",
					        minlength: "Your firstname must be at least 1 characters long",
			                maxlength: "Your firstname not more then 50 characters",
					        lettersonly: "Only letter are allowed"
				           }, 
				lastname: {required: "Please enter your lastname",
			               minlength: "Your lastname must be at least 1 characters long",
	                       maxlength: "Your lastname not more then 50 characters",
			               lettersonly: "Only letter are allow"
		                  },
				address: {required: "Please enter your address",
		                  minlength: "Your address must be at least 4 characters long",
                          maxlength: "Your address not more then 120 characters"                        
	                     },
				city: {required: "Please enter your city",
		               minlength: "Your city must be at least 4 characters long",
                       maxlength: "Your city not more then 50 characters",
		               lettersonly: "Only letter are allowed"
	                  },
				pin: { 
					   required: "Please enter your valide ZIP Code/PIN",
					   minlength: "Your ZIP Code/PIN must be at least 4 digits long",
					   maxlength: "Your ZIP Code/PIN not more then 12 digits",
					   digits: "Your ZIP Code/PIN not digits"
				     },
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 6 characters long",
					maxlength: "Your password not more then 25 characters"
				},
				confirm_password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 6 characters long",
					maxlength: "Your password not more then 25 characters",
					equalTo: "Please enter the same password as above"
				},
				email: "Please enter a valid email address",
				country : {
					required: "Select your Counter" 
				          }
				
				
			}
			
		});
		
	});
	</script>                     
</body>
</html>

<!-- https://jqueryvalidation.org -->