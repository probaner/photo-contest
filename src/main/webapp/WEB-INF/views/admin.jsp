<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<sec:csrfMetaTags/>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />   
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>

 
 
 <style>

div.ex1 {
    padding: 50px 100px 0px 100px;
}

div.ex2 {
    padding: 0px 100px 10px 100px;
}

div.ex3 {
    padding: 50px 100px 0px 115px;
}

div.ex4 {
    padding: 50px 0px 10px 0px;
}

div.ex5 {
    padding: 0px 0px 30px 0px;
}
div.ex6 {
    padding: 50px 100px 0px 90px;
}


.cellContainer {
  width: 25%;
  float: left;
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



<div class="ex1">
		<div class="well">
			<h4>
				<c:out value="${sucessMagssage}" />
			</h4>
			<div
				style="float: right; font-size: 120%; position: relative; top: -10px">
				<a href="<%=request.getContextPath()%>/logout"> Log Out </a>
			</div>
		</div>
	</div>

<div class="container">  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Create Coupon Code</a>
        </h4>
      </div>
   <div id="collapse1" class="panel-collapse collapse">
  <div class="row">
 <form:form  action="createCoupon" method="post" modelAttribute="couponCode">
       
	   
      <div class="col-sm-6">
	   <div class="ex3">	  
       <form:select class="form-control" path="clubData" items="${clubDataList}" />
       
        
             <input type="text" class="form-control" id="persent" name="persent" placeholder="Enter discount persent(%)" required="autofocus"/>                                        
            
		<div style="color: red"> ${clubcouponCodeError} </div>
		<div class="ex6">
		<label class="btn btn-danger">Submit<input type="submit" id="creatrColubcouponcode" style="display: none;" name="action" value="createClubCoupon"  /></label>
		</div>
		<div class="ex5"></div>
	   </div>
	   </div>
	   </form:form>
	  <form:form  action="createCoupon" method="post" modelAttribute="couponCode">
	   <div class="col-sm-6">
	   <div class="ex3">
	   <div class="form-group">
    		
    		<div class=style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
    			<input type="text" class="form-control" id="userId" name="userId" placeholder="Enter perticipant id" required="autofocus">
    		</div>
    		 <div class="cellContainer"></div>
    		 <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
             <input type="text" class="form-control" id="persent" name="persent" placeholder="Enter discount persent(%)" required="autofocus"/>                                        
            </div>
            
    	</div>
    	<div style="color: red"> ${couponCodeError} </div>
		 <label class="btn btn-danger">Submit<input type="submit" id="creatrsinglecouponcode" style="display: none;" name="action" value="createSigle"  /></label>
		<div class="ex5"></div>
	   </div>
	   </div>
	   
         <!--end of row -->
        </form:form>
        </div>
      </div>          
    </div>
  </div>
</div>



<div class="container">  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2">User Data Table</a>
        </h4>
        <div id="collapse2" class="panel-collapse collapse">
       <div class="row">

		<div id="jsGrid"></div>
       
      </div>
      </div>
      </div>
      </div>
      </div>
      </div>

 <script type="text/javascript">
$(document).ready(function($)
{
     
	var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
	var csrfToken = $("meta[name='_csrf']").attr("content"); 
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");  // THIS WAS ADDED
	var headers = {};
	headers[csrfHeader] = csrfToken; 
	
    var countries = [];
    var pay = [
        { Name: "Being Check", Id: 1 },
        { Name: "Paid", Id: 2 },      
    ];
    
    $.ajax({
    	  url: "admin/json/getcountrylist",
    	  type: "GET",
    	  dataType: "json",
    	  success: function(countrylist) 
    				    {
    				     countrylist.forEach(function(item,index){
    				    	 countries.push({ Name: item, Id: index});
    				     })
    				     //console.log(countries);
    				      $("#jsGrid").jsGrid({
    				         width: "100%",
    				         height: "400px",
    				         autoload: true,
    				         paging: true,
    				         pageLoading: true,
    				         pageSize: 15,
    				         pageIndex: 2,
    				         heading: true,
    				         filtering: false,
    				         inserting: false,
    				         editing: true,
    				         sorting: true,
    				         fields: [
    				        	 { name: "userId", type: "text", width: 50, validate: "required", editing: false },
    				             { name: "firstName", type: "text", width: 50, validate: "required"},
    				             { name: "lastName", type: "text", width: 50, validate: "required" },
    				             { name: "address", type: "text", width: 100 },
    				             { name: "city", type: "text", width: 50 },
    				             { name: "state", type: "text", width: 50 },
    				             /* { name: "country", type: "select", items: countries, valueField: "Name", textField: "Name" }, */
    				             { name: "payingStatus", type: "select", items: pay, valueField: "Name", textField: "Name" },
    				             { type: "control" , deleteButton: false }
    				         ],
    				         controller: {
    				             loadData: function(filter) {
    				                var d = $.Deferred();
    				                 $.ajax({
    				                 	type: "GET",
    				                     url: "admin/json/getedittabledata",
    				                     dataType: "json",
    				                     data: filter
    				                 }).done(function(response) {
    				                 	//console.log("KI BOLCHO"+response);
    				                     d.resolve(response);
    				                     return;
    				                 });
    				                 return d.promise(); 
    				               /*   return $.ajax({
    				                     type: "GET",
    				                     url: "json/getedittabledata",
    				                     data: filter,
    				                     dataType: "JSON"
    				                 }) */
    				             },
    				             updateItem: function(data) { 
    				             	//console.log("updateItem",data);
    				             	var myData = {};
    				             	myData['editTableDataDTO'] = data;
    				             	$.ajax({
    				             		type: "POST",
    				             		 headers:headers,
    								    url: "admin/json/updateedittable",
    								    contentType: 'application/json',
    							    	data: JSON.stringify(data), 
    								    success: function(data) 
    								    {
    								    	//console.log("success",data);
    								    	 alert("successfully edited");
    							        },
    							        error: function(jqXHR, textStatus,errorThrown){
    							            //console.debug(jqXHR.status,jqXHR.responseJSON); 
    							        	 alert(jqXHR.status+jqXHR.responseJSON.message+jqXHR.responseJSON.reason);
    							     }
    								});
    				             }
    				         }
    				     });
    			        }
    	});

});
</script>
       

</body>
</html>