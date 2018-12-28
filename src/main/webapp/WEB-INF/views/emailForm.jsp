<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
  <link rel="stylesheet" href="<c:url value="/resources/css/emailformstyle.css" />">
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
</div>
 
 <div class="container">  
    <h1></h1>      
  </div>
  <p></p>      
  <p></p>  
  <p></p>      
  <p></p>      
</div>  
    
<div>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  </div>
  
  
 <div class="container">
<div class="row">
  
  <form:form  action="processmail" method="post" modelAttribute="mailRecipientform">
  
    <div class="col-lg-6">
      <!-- <div class="well well-sm"><strong><i class="glyphicon glyphicon-ok form-control-feedback"></i> Required Field</strong></div> -->
      <div class="form-group">
        <div class="input-group">
          <input type="text" class="form-control" name="subject" id="InputName" placeholder="Enter Subject" required>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <input type="email" class="form-control" id="InputEmail" name="sender" placeholder="Enter Email" required  >
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputMessage">Message</label>
        <div class="input-group"
>
          <textarea name="message" id="InputMessage" class="form-control" rows="5" required></textarea>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
       <div style="margin-top:10px" class="form-group">
      <div style="color: red"> ${massage} </div> 
      <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-default btn-primary submit">
      </div>
    </div>
  </form:form>
  <hr class="featurette-divider hidden-lg">
  <div class="col-lg-5 col-md-push-1">
    <address>
    <h3>Contact Person</h3>
    <p class="lead">Salon Chairman<br>
       Bela Mukherjee<br>
       11 JUGOL KISHOR DAS LANE<br> 
       KOLKATA 700006, INDIA<br>
       Phone: +91 9804199918<br></p>
    </address>
  </div>
</div>

</div> 
   
</body>
</html>