<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>${titel}</title>
<link rel="icon" href="${titelImage}" />

 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-formhelpers.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/validation/screen.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/site-demos.css" />">
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
        <!--  <li><a href="getjudges"> JUDGES </a></li> -->                   
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


<div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can get your password here.</p>
                  <div class="panel-body">               
                     <form:form  action="processForgetPassword" id="forgetpassword"  method="post" modelAttribute="getPassword">
    
                         <style>
                          .foo{
                                display: none;
                              }
                         </style>
                         <div style="margin-bottom: 25px" class="alert-danger" ><strong>${massage}</strong>
                         <!-- <a href="getForgetPasswordForm" class="alert-link"></a> -->
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
    
    
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <form:input path="email" id="email" type="text" name="email" size="35" placeholder="email address" class="form-control" />
                        </div>
                      </div>
                      <div class="form-group">
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Get Password" type="submit">
                      </div>
                      
                      <!-- <input type="hidden" class="hide" name="token" id="token" value="Submit">  -->
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
	 	$("#forgetpassword").validate({
			rules: { email:{
				             required: true,
	                         email: true
	                      }
				    
		           },
			messages: {email: "Please enter a valid email address"}
				
			});	 
	});
</script>
</body>
</html>

<!-- https://bootsnipp.com/snippets/kEr93 -->
