<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-formhelpers.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/validation/screen.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/site-demos.css" />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">"></script>
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

.form-gap {
    padding-top: 70px;
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


</style>
</head>
<body>

<div class="container">
  <div class="page-header">
  <div class="header">  <img src="<c:url value="/resources/image/Logo.jpg" />" alt="logo" /> </div>
  <div class="headerr">  <img src="<c:url value="/resources/image/Logo 2.jpg" />" alt="logo" />   </div>    
  </div>      
</div>
 <p></p>      
 <p></p> 

  
  <div>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  </div>


<div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <c:choose>
				  <c:when test="${success=='true'}">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Reset Password?</h2>
                  <p>You can reset your password here</p>
                  </c:when>
                  <c:otherwise>
                  <h3><i class="glyphicon glyphicon-envelope"></i></h3>
                  <h2 class="text-center">Password Changed</h2>
                  <p>New password is Set</p>
                 </c:otherwise>
                  </c:choose>
                  <div class="panel-body">               
                     <form:form  action="resetpassword" id="resetpassword" method="post" modelAttribute="resetpasswordDTO">
    
                         <style>
                          .foo{
                                display: none;
                              }
                         </style>
                         <div style="margin-bottom: 25px" class="alert-danger" ><strong>${massage}</strong>
                         <!-- <a href="getForgetPasswordForm" class="alert-link"></a> -->
                         <P><span><strong><a href="<c:url value="/login" />">Login</a><strong></span></P>
                         <span></span>                                              
                         </div>
                         <script type="text/javascript">
                         var username = "${massage}";
                         $(document).ready(function () {
                         if (username  == "") {                       	
                              $(".alert-danger").addClass("foo");                             
                           }                        
                          });
                         </script>

									<c:choose>
									<c:when test="${success=='true'}">
                                                
										<form:input type="hidden" path="token" value="${token}" />

										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-eye-close"></i></span>
												<form:input path="password" id="password" type="password"
													name="password" placeholder="password" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-eye-close"></i></span>
												<form:input path="confirm_password" id="confirm_password"
													type="password" name="confirm_password"
													placeholder="confirm password" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<input name="recover-submit"
												class="btn btn-lg btn-primary btn-block"
												value="Get Password" type="submit">
										</div>

										<input type="hidden" class="hide" name="token" id="token"
											value="Submit">
											
									</c:when></c:choose>
															
								</form:form>   
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
<script>
$().ready(function() {
	 	$("#resetpassword").validate({
	 		rules: {
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
			    }
	 		},
	 messages: {	
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
			   }
		 
	           }
	 	});	 
});
</script>	 	
</body>
</html>

<!-- https://bootsnipp.com/snippets/kEr93 -->
