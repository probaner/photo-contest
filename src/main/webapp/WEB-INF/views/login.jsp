<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Salon</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/css/bootstrap-formhelpers.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/js/bootstrap-formhelpers.min.js"></script>
<script src="<c:url value="/resources/javaScript/utility.js" />"></script>
<script
	src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>

<style>
div.redplaceholder ::-webkit-input-placeholder {
	color: red !important;
}

div.redplaceholder :-moz-placeholder { /* Firefox 18- */
	color: red !important;
}

div.redplaceholder ::-moz-placeholder { /* Firefox 19+ */
	color: red !important;
}

div.redplaceholder :-ms-input-placeholder {
	color: red !important;
}
</style>

</head>
<body>

	<div class="container">
		<div class="page-header">
			<h2>Example Page Header</h2>
		</div>
		<p></p>
		<p></p>
	</div>

	<div class="container">
		<h4></h4>
		<ul class="nav nav-tabs">
			<li class="active"><a href="home">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Rules & Regulations <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="getrulesandregulations"> RULES & REGULATIONS 2017 </a></li>
					<li><a href="getfipdefination"> FIAP DEFINITIONS OF DIVISIONS </a></li>
				</ul></li>
			<li><a href="getloginForm">Perticipate/Login</a></li>
			<li><a href="getUserTable">Entry Status</a></li>
			<li><a href="getDownload">Result</a></li>
			<li><a href="getContuctUs">Contuct Us</a></li>
		</ul>
	</div>

	<div>
		<p class="big"></p>
		<p class="big"></p>
		<p class="big"></p>
	</div>



	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="getForgetPasswordForm"><strong>Forgot
								password?</strong></a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<!--   <form id="loginform" class="form-horizontal" role="form"> -->
					<div class="login-container">
						<div class="login-card">
							<div class="login-form">
								<c:url var="loginUrl" value="/login" />
								<form action="${loginUrl}" method="post" class="form-horizontal">
									<c:if test="${param.error != null}">
										<div class="alert alert-danger">
											<p>Invalid username and password.</p>
										</div>
									</c:if>
									<c:if test="${param.logout != null}">
										<div class="alert alert-success">
											<p>You have been logged out successfully.</p>
										</div>
									</c:if>
									<div class="input-group input-sm">
										<label class="input-group-addon" for="username"><i
											class="fa fa-user"></i></label> <input type="text"
											class="form-control" id="username" name="username"
											placeholder="Enter Username" required>
									</div>
									<div class="input-group input-sm">
										<label class="input-group-addon" for="password"><i
											class="fa fa-lock"></i></label> <input type="password"
											class="form-control" id="password" name="password"
											placeholder="Enter Password" required>
									</div>
									<div class="input-group input-sm">
										<div class="checkbox">
											<label><input type="checkbox" id="rememberme"
												name="remember-me"> Remember Me</label>
										</div>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />

									<div class="form-actions">
										<input type="submit"
											class="btn btn-block btn-primary btn-default" value="Log in">
									</div>
									<div class="form-group">
										<div class="col-md-12 control">
											<div
												style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
												<strong> Don't have an account! </strong> <a
													href="getRegistrationForm"> <!-- onClick="$('#loginbox').hide(); $('#signupbox').show()"> -->
													<strong> Sign Up Here </strong>
												</a>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
</body>
</html>




