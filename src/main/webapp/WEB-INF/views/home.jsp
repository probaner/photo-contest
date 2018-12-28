<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
 

<title>${titel}</title>
<link rel="icon" href="${titelImage}" />

 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
  <script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>

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
  
  
 <div class="col-xs-3 col-sm-3 col-md-4 col-sm-offset-1 col-md-offset-1">    
 <img align="middle" src="<c:url value="${homePageImage}" />" alt="logo" style="width:900px;height:600px;" />
</div>
</div> 
</body>
</html>