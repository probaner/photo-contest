<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="container">

		<ul class="nav nav-tabs" id="tab-container">
			<li class="active"><a href="#1" data-toggle="tab">Colour</a></li>
			<li>               <a href="#2" data-toggle="tab">Monochrome</a></li>
			<li>			   <a href="#3" data-toggle="tab">Nature</a></li>
			<li>			   <a href="#4" data-toggle="tab">Photo Journalism</a></li>
		</ul>

		<div class="tab-content">
			<div class="tab-pane active" id="1">
				<div class="row">
					<div id="myCarousel1" class="carousel slide carousel-fit" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>
						<div class="container" style="background-color:grey">
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
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
					<div id="myCarousel2" class="carousel slide  carousel-fit" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<div class="container" style="background-color:grey" >
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
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
				<div class="row">
					<div id="myCarousel3" class="carousel slide carousel-fit" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<div class="container" style="background-color:grey">
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
						</div>
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
					<div id="myCarousel4" class="carousel slide carousel-fit" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							
						</ol>

						<div class="container" style="background-color:grey">
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							
						</div>
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
<script>
$(document).ready(function()
		{
	
			var myCarousel1Loader = $('#1').loadingIndicator({
				useImage: false,
			}).data("loadingIndicator");

	
			 $.ajax({
				    url: "admin/json/fetchImagesForUser/${userId}",
				    dataType: "json",
		         	success: function(result){
		         		//console.log("Chandan+1");
		     		
		     		
		     	if(result.data){
		     		console.log(result.data);
		     		if(result.data['color']){
		     			result.data['color'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'"><div class="container"><div class="carousel-caption"><div class="form-group">   <label for="'+element.positionName+'">Title:</label>   <input type="text" class="form-control" id="'+element.positionName+'" value="'+element.titel+'">   <p><a class="btn btn-primary btn-sm" onClick="updateImageTitel(\''+element.positionName+'\','+element.fileId+')">save</a> </div></div></div>  </div>').appendTo('#myCarousel1 > .container > .carousel-inner');
			     		    $('<li data-target="#myCarousel1" data-slide-to="'+i+'"></li>').appendTo('#myCarousel1 > .carousel-indicators')
			     		});
			     		
			     		  $('#myCarousel1 > .container > .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel1 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel1').carousel();
			     		  myCarousel1Loader.hide();
		     		}
		     		
		     		if(result.data['monochrome']){  
		     		result.data['monochrome'].forEach(function(element, i) {
		     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'"><div class="container"><div class="carousel-caption"><div class="form-group">   <label for="'+element.positionName+'">Title:</label>   <input type="text" class="form-control" id="'+element.positionName+'" value="'+element.titel+'">   <p><a class="btn btn-primary btn-sm" onClick="#">save</a> </div></div></div></div>').appendTo('#myCarousel2 > .container > .carousel-inner');
		     		    $('<li data-target="#myCarousel2" data-slide-to="'+i+'"></li>').appendTo('#myCarousel2 > .carousel-indicators');
		     		});
		     		
		     		  $('#myCarousel2 > .container > .carousel-inner > .item').first().addClass('active');
		     		  $('#myCarousel2 > .carousel-indicators > li').first().addClass('active');
		     		  $('#myCarousel2').carousel();
		     		  myCarousel1Loader.hide();
		     		}
		     		
		     		if(result.data['nature']){  
		     		 result.data['nature'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'"><div class="container"><div class="carousel-caption"><div class="form-group">   <label for="'+element.positionName+'">Title:</label>   <input type="text" class="form-control" id="'+element.positionName+'" value="'+element.titel+'">   <p><a class="btn btn-primary btn-sm" onClick="#">save</a> </div></div></div></div>').appendTo('#myCarousel3 > .container > .carousel-inner');
			     		    $('<li data-target="#myCarousel3" data-slide-to="'+i+'"></li>').appendTo('#myCarousel3 > .carousel-indicators');
			     		});
			     		
			     		  $('#myCarousel3 > .container> .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel3 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel3').carousel();
			     		  myCarousel1Loader.hide();
		     		}	  
			     		  
		     		if(result.data['photojournalism']){    
		     		 result.data['photojournalism'].forEach(function(element, i) {
			     			$('<div class="item"><img src="data:image/jpg;base64,'+element.encodedString+'"><div class="container"><div class="carousel-caption"><div class="form-group">   <label for="'+element.positionName+'">Title:</label>   <input type="text" class="form-control" id="'+element.positionName+'" value="'+element.titel+'">   <p><a class="btn btn-primary btn-sm" onClick="#">save</a> </div></div></div></div>').appendTo('#myCarousel4 > .container> .carousel-inner');
			     		    $('<li data-target="#myCarousel4" data-slide-to="'+i+'"></li>').appendTo('#myCarousel4 > .carousel-indicators');
			     		});
			     		
			     		  $('#myCarousel4 > .container > .carousel-inner > .item').first().addClass('active');
			     		  $('#myCarousel4 > .carousel-indicators > li').first().addClass('active');
			     		  $('#myCarousel4').carousel();
			     		  myCarousel1Loader.hide();
		     		}
		     	}else{
		     		 myCarousel1Loader.hide();
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
		     		
		     		 /* var $item = $('img');
			     	 var $wHeight = $(window).height();
			     	 var $wWidth = $(window).width();
			     	 $item.height($wHeight);
			     	 $item.height($wWidth); 
			     	$item.addClass('full-img');*/
			     	 
			     	//var $item = $('img');
			     	//$item.addClass('full-img');
			     	//$item.addClass('img-responsive'); 
		          },
		             error: function(XMLHttpRequest, textStatus, errorThrown) { 
		             console.log("Status: " + textStatus,errorThrown); 
		          }  
			 });
		});
		
		function updateImageTitel(positionName,imageId){
			console.log("CC1->",positionName,imageId);
			console.log("CC2->",$("#"+positionName).val());
			
			var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
			var csrfToken = $("meta[name='_csrf']").attr("content"); 
			var csrfHeader = $("meta[name='_csrf_header']").attr("content");  // THIS WAS ADDED
			var headers = {};
			headers[csrfHeader] = csrfToken; 
			console.log(headers);
			//validation
			  $.ajax({
			        url: 'admin/json/updateimagetitel',
			        type: 'POST',
			        headers:headers,
			        contentType: 'application/json',
			        data: JSON.stringify({
			        	fileId:imageId,
			        	titel: $("#"+positionName).val()
			        }),
			        dataType: 'json',
			    	success: function(result){
			    		console.log("CC SUCCESS "+result);
			    	}
			    });
		}
</script>
</html>