<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/uploadfile.css" />">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
<%-- <script src="<c:url value="/resources/javaScript/jquery.uploadfile.min.js" />"></script> --%>
<script src="<c:url value="/resources/javaScript/jquery.uploadfile.js" />"></script>

<style>

<style>
* {
    box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
    float: left;
    width: 50%;
    padding: 10px;
    height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

#mydiv {
    top: 45%;
    left: 35%;
    width:60em;
    height:22em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
     border: 0px solid #ccc;
    background-color: #f3f3f3; 
    position:fixed;
}


</style>

</head>
<body>


<div class="row"  id="mydiv">
  <div class="column" style="background-color:#aaa;">
    <h3 align="center">PAYMENT DETAILS</h3>
     <p> </p>
     <p align="center"><c:out value="${uid}"/></p>
     <p align="center"><c:out value="${uname}"/></p>
     <p align="center"><c:out value="${acscc}"/></p>
     <p align="center"><c:out value="${actualamount}"/></p>
     <p align="center"><c:out value="${dcc}"/></p>
     <p align="center"><c:out value="${dp}"/></p>
     <p align="center"><c:out value="${payableamount}"/></p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Column 2</h2>
    <p>Some text..</p>
  </div>
</div>

</body>
</html>