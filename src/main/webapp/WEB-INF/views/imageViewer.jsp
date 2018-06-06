<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- a block container is required -->
<!-- 
https://stackoverflow.com/questions/24177572/add-slides-to-bootstrap-3-carousel-dynamically-using-jquery
 -->	<div class="container">

		<ul class="nav nav-tabs" id="tab-container">
			<li class="active"><a href="#1" data-toggle="tab">Colour</a></li>
			<li>               <a href="#2" data-toggle="tab">Monochrome</a></li>
			<li>			   <a href="#3" data-toggle="tab">Nature</a></li>
		</ul>

		<div class="tab-content ">
			<div class="tab-pane active" id="1">
				<div class="row">
					<div id="myCarousel1" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel1" data-slide-to="1"></li>
							<li data-target="#myCarousel1" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="<c:url value="/resources/image/tulips.jpeg" />"
									alt="Los Angeles" class="center"> <input
									id="titelcolour1" class="form-control"
									placeholder="Enter Title" value="" required />
							</div>

							<div class="item">
								<img
									src="<c:url value="/resources/image/garden-rose-red.jpeg" />"
									alt="Chicago" class="center"> <input id="titelcolour2"
									class="form-control" placeholder="Enter Title" value=""
									required />
							</div>

							<div class="item">
								<img src="<c:url value="/resources/image/rose-flower.jpeg" />"
									alt="New York" class="center"> <input id="titelcolour3"
									class="form-control" placeholder="Enter Title" value=""
									required />
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel1"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel1"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="2">
				<div class="row">
					<div id="myCarousel2" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel2" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel2" data-slide-to="1"></li>
							<li data-target="#myCarousel2" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="<c:url value="/resources/image/tulips.jpeg" />"
									alt="Los Angeles" class="center"> <input
									id="titelcolour1" class="form-control"
									placeholder="Enter Title" value="" required />
							</div>

							<div class="item">
								<img
									src="<c:url value="/resources/image/garden-rose-red.jpeg" />"
									alt="Chicago" class="center"> <input id="titelcolour2"
									class="form-control" placeholder="Enter Title" value=""
									required />
							</div>

							<div class="item">
								<img src="<c:url value="/resources/image/rose-flower.jpeg" />"
									alt="New York" class="center"> <input id="titelcolour3"
									class="form-control" placeholder="Enter Title" value=""
									required />
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel2"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel2"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="3">
				<h3>add clearfix to tab-content (see the css)</h3>
			</div>
		</div>


	</div>
</body>
<script>
$(document).ready(function()
{
	
});
</script>
</html>