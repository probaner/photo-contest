<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<sec:csrfMetaTags/>
 <title>${titel}</title>
<link rel="icon" href="${titelImage}" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />   
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script> -->

<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />"> --%>
<link rel="stylesheet" type="text/css" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.loading-indicator.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jsgrid.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/validation/screen.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/site-demos.css" />">
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jsgrid-theme.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/modal-fullscreen.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/carousel-fit.css" />">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/jsgrid.min.js" />"></script> 
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/jquery.loading-indicator.min.js" />"></script> 
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script> 
<script src="<c:url value="/resources/javaScript/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/javaScript/additional-methods.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/jquery.form.js" />"></script>
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>  -->
 <style>

div.ex1 {
    padding: 50px 100px 0px 100px;
}

div.ex2 {
    padding: 0px 100px 10px 100px;
}

div.ex3 {
    padding: 50px 100px 20px 115px;
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

div.ex7 {
    padding: 20px 100px 20px 230px;
}

div.ex8 {
    padding: 20px 100px 50px 450px;
}
div.ex9 {
    padding: 0px 0px 0px 50px;
}
div.ex10 {
    padding: 10px 0px 0px 50px;
}
div.ex11 {
    padding: 30px 410px 20px 410px;
}
.cellContainer {
  width: 25%;
  float: left;
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


.material-switch > input[type="checkbox"] {
    display: none;   
}

.material-switch > label {
    cursor: pointer;
    height: 0px;
    position: relative; 
    width: 40px;  
}

.material-switch > label::before {
    background: rgb(0, 0, 0);
    box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5);
    border-radius: 8px;
    content: '';
    height: 16px;
    margin-top: -8px;
    position:absolute;
    opacity: 0.3;
    transition: all 0.4s ease-in-out;
    width: 40px;
}
.material-switch > label::after {
    background: rgb(255, 255, 255);
    border-radius: 16px;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
    content: '';
    height: 24px;
    left: -4px;
    margin-top: -8px;
    position: absolute;
    top: -4px;
    transition: all 0.3s ease-in-out;
    width: 24px;
}
.material-switch > input[type="checkbox"]:checked + label::before {
    background: inherit;
    opacity: 0.5;
}
.material-switch > input[type="checkbox"]:checked + label::after {
    background: inherit;
    left: 20px;
}
</style>

 
</head>
<body>

<div class="container">
  <div class="page-header">
<%--  <div class="header">  <img src="<c:url value="${headerLeft}" />" alt="logo" /> </div>
  <div class="headerm">  <img src="<c:url value="${headerMiddle}" />" alt="logo" />   </div>
  <div class="headerr">  <img src="<c:url value="${headerRight}" />" alt="logo" />   </div>     --%> 
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
				<!-- <a href="imageViewer/500031101">Image Viewer</a> -->
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
						<form:form id="couponeCodeForm" action="createCoupon" method="post"
							modelAttribute="couponCode">


							<div class="col-sm-6">
						   <div class="col-sm-9"> <div style="color: red">${clubcouponCodeError}</div></div>
								<div class="ex3">
									<form:select class="form-control" id="clubData"  path="clubData"
										items="${clubDataList}" />
									<p></p>
									<p></p>
									<p></p>
									<p></p>
									<input type="text" class="form-control" id="persent"
										name="persent" placeholder="Enter discount persent(%)"
										required="autofocus" />

									
									<div class="ex6">
										<label class="btn btn-danger">Submit<input
											type="submit" id="creatrColubcouponcode"
											style="display: none;" name="action" value="createClubCoupon" /></label>
									</div>
									<div class="ex5"></div>
								</div>
							</div>
						</form:form>
						<form:form action="createCoupon" method="post"
							modelAttribute="couponCode">
							<div class="col-sm-6">
							  <div class="col-sm-9"><div style="color: red">${couponCodeError}</div></div>
								<div class="ex3">
									<div class=style=
										"margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
										<input type="text" class="form-control" id="userId"
											name="userId" placeholder="Enter perticipant id"
											required="autofocus">
										<p></p>
										<p></p>
										<p></p>
										<p></p>

										<input type="text" class="form-control" id="persent"
											name="persent" placeholder="Enter discount persent(%)"
											required="autofocus" />
									</div>

									<div class="ex6">
										
										<label class="btn btn-danger">Submit<input
											type="submit" id="creatrsinglecouponcode"
											style="display: none;" name="action" value="createSigle" /></label>
									</div>
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


	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse3">Judge Registration</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">

					<div class="row">
						<form:form action="createJudge" method="post" id="judgeCreateForm"
							modelAttribute="judgeCreationDTO">

							<div class="col-sm-9">
							<div class="ex7"><div style="color: red">${judgeCreationError}</div></div>
								<div class="ex7">
									<input type="text" style="display: inline; text-align: center;"
										class="form-control" id="firstname" name="firstname"
										placeholder="Enter First Name" required="autofocus" />
									<p></p>
									<p></p>
									<input type="text" style="display: inline; text-align: center;"
										class="form-control" id="lastname" name="lastname"
										placeholder="Enter Last Name" required="autofocus" />
									<p></p>
									<p></p>
									<input type="text" style="display: inline; text-align: center;"
										class="form-control" id="email" name="email"
										placeholder="Enter Email" required="autofocus" />
									<p></p>
									<p></p>
									<form:select class="form-control" path="organizerclubName" id="organizerclubName"
										items="${organizerclubList}" />
									<p></p>
									<p></p>
								</div>
								<div class="container">
									<div
										class="col-xs-15 col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-3">
										<div class="panel panel-default">
											<!-- Default panel contents -->
											<div class="panel-heading">Select Section</div>

											<!-- List group -->
											<ul class="list-group">
												<li class="list-group-item">
												<c:forEach items="${categoryList}" var="categoryListValue">                   
                                                          ${categoryListValue}
                                                          <div class="material-switch pull-right">
														  <input id=${categoryListValue } name=category
																type="checkbox" value="${categoryListValue}" /> <label
																for=${categoryListValue } class="label-success"></label>
														</div>
														<p></p>
													</c:forEach></li>
											</ul>
										</div>
									</div>
								</div>

								<div class="ex8">																	
									<label class="btn btn-danger">Submit<input
										type="submit" id="registerJudge" style="display: none;"
										name="action" value="registerJudge" /></label>
								</div>
							</div>
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
						<a data-toggle="collapse" href="#collapse12">Judge Table</a>
					</h4>
                     <div id="collapse12" class="panel-collapse collapse">
						<div class="row">
							<div id="jsGrid1"></div>
						</div>
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
          <a data-toggle="collapse" href="#collapse4">Payment Status Graph</a>
        </h4></div>
       <div id="collapse4" class="panel-collapse collapse">
       
       <div id="container" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
       
       </div>
      </div>
      </div>
      </div>
      
      
 <div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse8">Process Judging File</a>
					</h4>
				</div>
				<%-- <div id="collapse8" class="panel-collapse collapse">
					<div class="row">
						<form:form action="processFile" method="post" modelAttribute="processFileDTO" id="processFileForm">
						      </div>
								<div class="ex11">
								    <div style="color: red">${processDataError}</div>
									<form:select class="form-control" path="status" id = "status"
										items="${processDataType}" />
									<div class="ex6">
										<label class="btn btn-danger">Submit<input
											type="submit" id="creatrColubcouponcode"
											style="display: none;" name="action" value="processJudgingFile" /></label>
									</div>
									<div class="ex5"></div>
						</form:form>					
					</div>
				</div> --%>
			</div>
		</div>
	</div>


<!-- /.container -->
<div class="modal fade modal-fullscreen" id="myModalFullscreen"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<!-- <h4 class="modal-title">Modal title</h4> -->
			</div>
			<div class="modal-body">
				<p>One fine body&hellip;</p>
			</div>
			
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->




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
    		 
    				      $("#jsGrid").jsGrid({
    				         width: "100%",
    				         height: "auto",
    				         autoload: true,
    				         paging: true,
    				         pageLoading: true,
    				         pageSize: 10,
    				         pageButtonCount: 5,
    				         pageIndex: 2,
    				         heading: true,
    				         filtering: false,
    				         inserting: false,
    				         editing: true,
    				         sorting: true,
    				         fields: [
    				        	
    				        	 { name: "userId", 
    			                        itemTemplate: function(value) {
    			                        	return $("<button>").text(value)
    			                    		.on("click", function(e) {
    			                    			console.log('Link Clicked');
    					        	            e.preventDefault(); //To prevent the default anchor tag behaviour
    					        	            var url = 'imageViewer/'+value;
    					        	            $('.modal-body').load(url,function(){
    					        	                $('#myModalFullscreen').modal({
    					        	                    show: true, 
    					        	                    backdrop: 'static',
    					        	                    keyboard: true
    					        	                 });
    					        	            });
    			                          return false;
    			                        });
    			                        } , width: 50,  validate: "required", editing: false ,align: "center"},
    				             { name: "firstName", type: "text", width: 50, validate: "required" ,align: "center"},
    				             { name: "lastName", type: "text", width: 50, validate: "required" ,align: "center"},
    				             { name: "address", type: "text", width: 100 , validate: "required",align: "center"},
    				             { name: "city", type: "text", width: 50 , validate: "required",align: "center"},
    				             { name: "state", type: "text", width: 50 , validate: "required",align: "center"},
    				             { name: "payingStatus", type: "select", items: pay, valueField: "Name", textField: "Name" ,align: "center"},
    				             { type: "control" , deleteButton: false , align: "center", width: 5}
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
    								    	alert(data.message);
    							        },
    							        error: function(jqXHR, textStatus,errorThrown){
    							            //console.debug(jqXHR.status,jqXHR.responseJSON); 
    							        	 alert(jqXHR.status+jqXHR.responseJSON.message+jqXHR.responseJSON.reason);
    							     }
    								});
    				             }
    				         },
    				         onDataLoaded: function(grid,data) {
    				             //after data loading
    				        	 console.log('data loaded');
    				         }
    				     });
    			        }
    	});
    

    $.ajax({
	         url: "admin/json/getpaystatusgraphdata",
	         type: "GET",
	         dataType: "json",
	
	        	 success: function(graphdata) 
			    {
	        		   //console.log(graphdata);
	        		   
	        		 Highcharts.chart('container', {
	        			  chart: {
	        			    type: 'bar'
	        			  },
	        			  title: {
	        			    text: 'Paystatus Graph'
	        			  },
	        			  xAxis: {
	        			    categories: graphdata.country
	        			  },
	        			  yAxis: {
	        			    min: 0,
	        			    title: {
	        			      text: 'Total fruit consumption'
	        			    }
	        			  },
	        			  legend: {
	        			    reversed: true
	        			  },
	        			  plotOptions: {
	        			    series: {
	        			      stacking: 'normal'
	        			    }
	        			  },
	        			  series: [{
	        			    name: 'Paid',
	        			    data: graphdata.paid
	        			  }, {
	        			    name: 'Unpaid',
	        			    data: graphdata.unpaid
	        			  }]
	        			});
			    }
     });
    
    $.ajax({
        url: "admin/json/getjudgetabledata",
        type: "GET",
        dataType: "json",

       	 success: function(data) 
		    {
       		 
       		//console.log(data);
       		var newData = data.data.map(function (judge, index, array){
       			var categoryObj = judge.category;
       	     	Object.keys(categoryObj).map(function (category, index, categoryArray){       	     		
       	     	judge[category] = categoryObj[category]=='Y'?true:false;
       	     	})
       			return judge
       		});
       		
       		var organizerclublist = data.organigerClubList;	
       	   
       	var jsonObj = data.data[0].category;
       	var fieldsGenerated = [];
       	 fieldsGenerated.push( { name: "judgeId", type: "number", width: 10 , align: "center" , editing: false});
       	 fieldsGenerated.push(  { name: "judgeFirstname", type: "text", width: 20 , align: "center", editing: false});
       	 fieldsGenerated.push(  { name: "judgeLastname", type: "text", width: 20 , align: "center", editing: false});
       	 /* fieldsGenerated.push( { name: "organizerclubName", type: "text", width: 25 , align: "center", editing: false}); */
       	 fieldsGenerated.push( { name: "organizerclubName", type: "select", items: organizerclublist, valueField: "organizerClubName", textField: "organizerClubName",width: 20 ,align: "center"});
       	
       	for (var key in jsonObj) {
       		fieldsGenerated.push( { name: key, type: "checkbox",  width: 5 , sorting: false });
     	 }
       	 fieldsGenerated.push({ type: "control" , deleteButton: false,align: "center",width: 5} );
      
       		
       		 $("#jsGrid1").jsGrid({
		         width: "100%",
		         height: "auto",
		         autoload: true,
		         paging: true,
		         pageLoading: true,
		         pageSize: 5,
		         pageIndex: 2,
		         pageButtonCount: 5,
		         heading: true,
		         filtering: false,
		         inserting: false,
		         editing: true,
		         sorting: true,
		         fields:fieldsGenerated,
		         data: newData,
		         controller: {
		        	  updateItem: function(data) { 
			             	console.log("UPDATE DATA 1",data);
			             	var dataModified = Object.assign({}, data);
			             	Object.keys(data.category).map(function (categoryKey, index, categoryArray){
			             		console.log(categoryKey,data.category[categoryKey]);
			             		dataModified.category[categoryKey] = data[categoryKey] === true ? 'Y': 'N'
			           	     	})
			             	//console.log("UPDATE DATA 2",dataModified);
			             	var myData = {};
			             	myData['judgeTableDTO'] = data;
			                	$.ajax({
			             		type: "POST",
			             		headers:headers,
							    url: "admin/json/updatejudgetable",
							    contentType: 'application/json',
						    	data: JSON.stringify(data), 
							    success: function(data) 
							    {
							    	
							    	alert(data.message);
						        },
						        error: function(jqXHR, textStatus,errorThrown){
						            console.debug(jqXHR.status,jqXHR.responseJSON); 
						        	 alert(jqXHR.status+jqXHR.responseJSON.message+jqXHR.responseJSON.reason);
						     }
							}); 
			             }
		         }
	           
             });
		    }
});
    
    $('#myModalFullscreen').on('hidden.bs.modal', function () {
        // do something…
    })
    
    
    $.validator.addMethod(
		        "regex",
		        function(value, element, regexp) {
		            var re = new RegExp(regexp);
		            return this.optional(element) || re.test(value);
		        },
		        "Please check your input."
		);
		
		 
		$("#judgeCreateForm").validate({
			rules: {					
					firstname: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
						         minlength: 1,
						         maxlength: 50,
						         lettersonly: false 
					           },
					lastname: { required: {
				        depends:function(){
				            $(this).val($.trim($(this).val()));
				            return true;
				        }
				    },
				                minlength: 1,
				                maxlength: 50,
				                lettersonly: false
				                
			                  },
			                  email: {
							             required: true,
							             email: true
						           },
				organizerclubName: { 
							           required: true
							        }
					        
					},
					messages: {
						firstname: {required: "Please enter your firstname",
							        minlength: "Your firstname must be at least 1 characters long",
					                maxlength: "Your firstname not more then 50 characters",
							        lettersonly: "Only letter are allowed"
						           }, 
						lastname: {required: "Please enter your lastname",
					               minlength: "Your lastname must be at least 1 characters long",
			                       maxlength: "Your lastname not more then 50 characters",
					               lettersonly: "Only letter are allow"
				                  },
				                  
				               email: "Please enter a valid email address",
			  organizerclubName : "Select a club for judge" 
								  
								
								
							}
							
						});
	
});
</script>
</body>
</html>