<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.9/slick.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/slick/slick-theme.css" />"/>
<style type="text/css">
html, body{
  background-color: #e74c3c
}
.wrapper{
  width:100%;
  padding-top: 20px;
  text-align:center;
}
h2{
  font-family:sans-serif;
  color:#fff;
}
.carousel{
  width:90%;
  margin:0px auto;
}
/* .slick-slide{
  margin:10px;
} */
.slick-slide img{
  width:99%;
  border: 2px solid #fff;
}

.opaque {
background: rgba(0, 0, 0, 0.2);
}

.slick-slide  {
  opacity: 0;
}
.slick-center  {
 opacity: 1;
 border-style: dotted;
}
</style>

</head>
<body>
<div class="wrapper">
<h2>Category<h2>
<form:form method="POST" action="rate" modelAttribute="displayReatingImageDTOList">
<div class="images-for-judge">
     <c:forEach items="${displayReatingImageDTOList.imageList}" var="displayReatingImageDTO"  varStatus="tagStatus"> 
         <div>
         <img src="data:image/jpg;base64,${displayReatingImageDTO.image}">
         Rating
         <form:hidden path="imageList[${tagStatus.index}].imageId" />
         <%-- <form:input STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; background-color: #72A4D2;"  
         path="imageList[${tagStatus.index}].reating"/> --%>
         <form:select path="imageList[${tagStatus.index}].reating" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; background-color: #72A4D2;">
            <form:option value="0" label="Select" />
            <form:option value="1" label="1" />
            <form:option value="2" label="2" />
            <form:option value="3" label="3" />
            <form:option value="4" label="4" />
            <form:option value="5" label="5" />
         </form:select>
         </div>
     </c:forEach>
</div>
<br>
<span class="pagingInfo"></span>
<br><br><br>
<input type="submit" value="Save"/>
</div>

</form:form>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.9/slick.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
      $('.images-for-judge').slick({
	    	  dots: true,
	      	  slidesToShow: 1,
	      	  adaptiveHeight: true,
	      	  variableWidth: true,
	      	  centerMode: true,
	      	  centerPadding : '0px',
	      	  draggable:false,
	      	  focusOnSelect: true,
	      	  infinite:false,
    	    customPaging : function(slider, i) {
    	    var thumb = $(slider.$slides[i]).data();
    	    return '<a>'+(i+1)+'</a>';
    	            }
    	});
    });
    
    $('.images-for-judge')
    .on('init', function(event, slick){
        // let's do this after we init the banner slider
        console.log('slider was initialized');
        //$('.slick-active').prev().addClass('opaque');
        //$('.slick-active').next().addClass('opaque');
    })
    .on('beforeChange', function(event, slick, currentSlide, nextSlide){
        // then let's do this before changing slides
        console.log('before change');
    })
    .on('afterChange', function(event, slick, currentSlide, nextSlide){
        // finally let's do this after changing slides
        console.log('after change');
        //$('.slick-active').prev().addClass('opaque');
        //$('.slick-active').next().addClass('opaque');
    });
    
    
  //custom function showing current slide
    var $status = $('.pagingInfo');
    var $slickElement = $('.images-for-judge');

    $slickElement.on('init reInit afterChange', function (event, slick, currentSlide, nextSlide) {
        //currentSlide is undefined on init -- set it to 0 in this case (currentSlide is 0 based)
        var i = (currentSlide ? currentSlide : 0) + 1;
        $status.text(i + '/' + slick.slideCount);
    });
    
    
  /*   function setSlideVisibility() {
    	
    	console.log("called");
    	  //Find the visible slides i.e. where aria-hidden="false"
    	  var visibleSlides = $('.slick-slide[aria-hidden="true"]');
    	  //Make sure all of the visible slides have an opacity of 1
    	  $(visibleSlides).each(function() {
    		  console.log("got");
    	    $(this).css('opacity', 1);
    	  });
    	  //Set the opacity of the first and last partial slides.
    	  $(visibleSlides).first().prev().css('opacity', 0);
    	  $(visibleSlides).last().next().css('opacity', 0);
    	}

    	$(setSlideVisibility()); */

    	
    
    
/*     
    $('.images-for-judge').on('beforeChange', function(event, slick, currentSlide, nextSlide){
    	// console.log($('.slick-slide slick-current slick-active slick-center > #imageList[0].imageId').val());
    	var cur = $(".slider").slick("slickCurrentSlide");
    	console.log(cur);
		var $slides = $(".slider").slick("getSlick").$slides;
		//console.log()
		//var id = $slides.eq( cur ).get(0).id;
    	  console.log(slick);
    	  console.log(currentSlide);
    	  console.log(nextSlide);
    	}); */
  </script>
</body>
</html>