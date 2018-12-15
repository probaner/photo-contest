<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
 <title>${titel}</title>
<link rel="icon" href="${titelImage}" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="<c:url value="/resources/css/flipclock.css" />">



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



 .outer-div
{
     padding: 90px;
}
.inner-div
{
     margin: 0 auto;
     max-width: 450px; 
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
        <li><a href="getfipdefination"> COMPETITION DIVITION & DEFINITION </a></li> 
        <!--  <li><a href="getjudges"> JUDGES </a></li> -->                      
      </ul>
    </li>
	<li><a href="getloginForm">Perticipate/Login</a></li>
	<li><a href="getUserTable">Entry Status</a></li>
	<li><a href="getDownload"> Result </a></li>   
    <li><a href="getContuctUs">Contuct Us</a></li>
  </ul>
</div>
  
  
  <div class="form-container">
        <h1></h1>
         
        <br/><br/>
     </div>    
         
         
<div class="outer-div"><div class="inner-div"><div class="clock-builder-output"></div></div></div>


<script src="<c:url value="/resources/javaScript/flipclock.js" />"></script>
<style text="text/css">body .flip-clock-wrapper ul li a div div.inn, body .flip-clock-small-wrapper ul li a div div.inn { color: #CCCCCC; background-color: #333333; } body .flip-clock-dot, body .flip-clock-small-wrapper .flip-clock-dot { background: #323434; } body .flip-clock-wrapper .flip-clock-meridium a, body .flip-clock-small-wrapper .flip-clock-meridium a { color: #323434; }</style>
<script type="text/javascript">
$(function(){
	FlipClock.Lang.Custom = { days:'Days', hours:'Hours', minutes:'Minutes', seconds:'Seconds' };
	var opts = {
		clockFace: 'DailyCounter',
		countdown: true,
		language: 'Custom'
	};  	
	opts.classes = {
			active: 'flip-clock-active',
			before: 'flip-clock-before',
			divider: 'flip-clock-divider',
			dot: 'flip-clock-dot',
			label: 'flip-clock-label',
			flip: 'flip',
			play: 'play',
			wrapper: 'flip-clock-small-wrapper'
		};
	
	var countdown = 1543896180 - ((new Date().getTime())/1000); <%--   from: 12/04/2018 09:33 am +0530  --%>
	console.log(countdown);
	
	countdown = Math.max(1, countdown);
	$('.clock-builder-output').FlipClock(countdown, opts);
});
</script>    
        
 <%--   from: 06/09/2018 04:20 pm +0530 --%     // http://www.dwuser.com/education/content/easy-javascript-jquery-countdown-clock-builder/>
         
  <%-- 
   
   <div>       
        <a href="<c:url value='/download/internal' />">Download This File (located inside project)</a> 
        
        <a href="<c:url value='/download/external' />">Download This Result File </a> 
        
   
         
    </div>  --%>
    
   
    
  
  
</body>
</html>