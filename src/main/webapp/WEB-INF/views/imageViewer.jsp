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
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
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
			<li>			   <a href="#4" data-toggle="tab">Photo Journalism</a></li>
		</ul>

		<div class="tab-content ">
			<div class="tab-pane active" id="1">
				<div class="row">
					<div id="myCarousel1" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
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
							
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
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
				<div class="row">
					<div id="myCarousel3" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel3"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel3"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="4">
				<div class="row">
					<div id="myCarousel4" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel4"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel4"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>


	</div>
</body>
<script>
$(document).ready(function()
		{
	
	

	
			 $.ajax({
				    url: "admin/json/fetchImagesForUser/100020806",
				    dataType: "json",
		         	success: function(result){
		     		console.log(result.data);
		     		
		     		if(result.data['color']){
		     			result.data['color'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'" class="center" ><div class="carousel-caption trickcenter">'+element.titel+'</div>   </div>').appendTo('#myCarousel1 > .carousel-inner');
			     		    $('<li data-target="#myCarousel1" data-slide-to="'+i+'"></li>').appendTo('#myCarousel1 > .carousel-indicators')
			     		});
			     		
			     		  $('#myCarousel1 > .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel1 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel1').carousel();
		     		}
		     		
		     		if(result.data['monochrome']){  
		     		result.data['monochrome'].forEach(function(element, i) {
		     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'" class="center" ><div class="carousel-caption d-none d-md-block"> <input type="text" id="'+element.positionName+'" value="'+element.titel+'"/></div>   </div>').appendTo('#myCarousel2 > .carousel-inner');
		     		    $('<li data-target="#myCarousel2" data-slide-to="'+i+'"></li>').appendTo('#myCarousel2 > .carousel-indicators');
		     		});
		     		
		     		  $('#myCarousel2 > .carousel-inner > .item').first().addClass('active');
		     		  $('#myCarousel2 > .carousel-indicators > li').first().addClass('active');
		     		  $('#myCarousel2').carousel();
		     		}
		     		
		     		if(result.data['nature']){  
		     		 result.data['nature'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'" class="center" ><div class="carousel-caption d-none d-md-block trickcenter">'+element.titel+'</div>   </div>').appendTo('#myCarousel3 > .carousel-inner');
			     		    $('<li data-target="#myCarousel3" data-slide-to="'+i+'"></li>').appendTo('#myCarousel3 > .carousel-indicators');
			     		});
			     		
			     		  $('#myCarousel3 > .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel3 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel3').carousel();
		     		}	  
			     		  
		     		if(result.data['photojournalism']){    
		     		 result.data['photojournalism'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'" class="center" ><div class="carousel-caption d-none d-md-block trickcenter">'+element.titel+'</div>   </div>').appendTo('#myCarousel4 > .carousel-inner');
			     		    $('<li data-target="#myCarousel4" data-slide-to="'+i+'"></li>').appendTo('#myCarousel4 > .carousel-indicators');
			     		});
			     		
			     		  $('#myCarousel4 > .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel4 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel4').carousel();
		     		}
		     		/* var $item = $('.item');
		     		var $wHeight = $(window).height();

		     		$item.height($wHeight);
		     		$item.addClass('full-screen');

		     		$('.carousel img').each(function() {
		     		  var $src = $(this).attr('src');
		     		  var $color = $(this).attr('data-color');
		     		  $(this).parent().css({
		     		    'background-image' : 'url(' + $src + ')',
		     		    'background-color' : $color
		     		  });
		     		  $(this).remove();
		     		});  */
		     		
		     		 var $item = $('img');
			     	 var $wHeight = $(window).height();
			     	 var $wWidth = $(window).width();
			     	 $item.height($wHeight);
			     	 $item.height($wWidth);
			     	$item.addClass('full-img');
		          },
		             error: function(XMLHttpRequest, textStatus, errorThrown) { 
		             console.log("Status: " + textStatus,errorThrown); 
		          }  
			 });
		});
</script>
</html>