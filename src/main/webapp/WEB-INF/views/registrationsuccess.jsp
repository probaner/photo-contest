<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<sec:csrfMetaTags/>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javaScript/utility.js" />"></script>
<script
	src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
	
<link href="http://hayageek.github.io/jQuery-Upload-File/4.0.11/uploadfile.css" rel="stylesheet">
<script src="http://hayageek.github.io/jQuery-Upload-File/4.0.11/jquery.uploadfile.min.js"></script>
<style>
div.ex1 {
	padding: 50px 100px 0px 100px;
}

div.ex2 {
	padding: 0px 100px 10px 100px;
}

div.ex3 {
	padding: 50px 10px 0px 115px;
}

div.ex4 {
	padding: 0px 100px 10px 700px;
}

div.ex5 {
	padding: 0px 100px 10px 100px;
}
</style>




</head>
<body onload="dissableField(); dissablePayField();dissableImageArea();lockPage(); ">

	<div class="container">
		<div class="page-header">
			<h2>Example Page Header</h2>
		</div>
		<p></p>
		<p></p>
	</div>


<script type="text/javascript">
		var isDisabledAll = "${statue}";
</script>


	<div class="ex1">
		<div class="well">
			<h4>
				<c:out value="${sucessMagssage}" />
				<c:out value="${_csrf.parameterName}" /> <c:out value="${_csrf.token}" />
			</h4>
			<div
				style="float: right; font-size: 120%; position: relative; top: -10px">
				<a href="<%=request.getContextPath()%>/logout"> Log Out </a>
			</div>
		</div>
	</div>

	<!-- Start of row colour -->

	<div class="ex2">
		 <div class="page-header">
			  <h4>Colour</h4>
		 </div>
	</div>
	
	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelcolour1" class="form-control" placeholder="Enter Title" value="" required/>	  
				   </div>
			  </div>
			   <div class="ex3">
			   <div  id="upload_image_color1"></div>
			   </div>
		 </div>


		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelcolour2" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
				
			 <div class="ex3" >
			 <div  id="upload_image_color2"></div>
			 </div>
		</div>
	</div>	
				
	<!-- End of row one of colour -->
	
	<!-- Start of row two of colour -->

	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelcolour3" class="form-control" placeholder="Enter Title" value="" required/>
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_color3"></div>
			   </div>
		 </div>

		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelcolour4" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			<div class="ex3">	
			 <div  id="upload_image_color4"></div>
			 </div>
		</div>
	</div>		
	
	<!-- End of row two -->
	<!-- End of row color -->


	<!-- Start of row moncrome -->
	
	
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	
	
	<div class="ex2">
		<div class="page-header">
			<h4>Monocrome</h4>
		</div>
	</div>

	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelmonochrome1" class="form-control" placeholder="Enter Title" value="" required/>	  
				   </div>
			  </div>
			  <div class="ex3">
			  <div  id="upload_image_monochrome1"></div>
			  </div>
		 </div>


		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelmonochrome2" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_monochrome2"></div>
			 </div>
		</div>
	</div>	
				
	<!-- End of row one of monochrome -->
	
	<!-- Start of row two of monochrome -->


	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelmonochrome3" class="form-control" placeholder="Enter Title" value="" required/>
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_monochrome3"></div>
			   </div>
		 </div>

		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelmonochrome4" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_monochrome4"></div>
			 </div>
		</div>
	</div>		
	
	<!-- End of row two -->
	<!-- End of row monochrome -->


	<!-- Start of row Nature -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Nature</h4>
		</div>
	</div>

	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelnature1" class="form-control" placeholder="Enter Title" value="" required/>	  
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_nature1"></div>
			   </div>
		 </div>


		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelnature2" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_nature2"></div>
			 </div>
		</div>
	</div>	
				
	<!-- End of row one of nature -->
	
	<!-- Start of row two of nature -->


	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelnature3" class="form-control" placeholder="Enter Title" value="" required/>
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_nature3"></div>
			   </div>
		 </div>

		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelnature4" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_nature4"></div>
			 </div>
		</div>
	</div>		
	
	<!-- End of row two -->
	<!-- End of row nature -->



	<script type="text/javascript">
		var isDisabledPayment = "${size}";
	</script>


	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex5">
		<div class="page-header">
			<h4>Payment Area</h4>
		</div>
	</div>

	<%-- <form:form id="mypayment_form" action="payment" method="post" --%>
	<form:form id="mypayment_form" action="payment" method="post" modelAttribute="paymentDetail">
		
		<div class="col-sm-2"></div>
		<div class="col-sm-6">
			<div class="ex5">
				<div class="col-sm-12" required autofocus>
					<form:input path="couponCode" id="couponCodeId"
						class="form-control" placeholder="Enter coupon code if available" />
				</div>
			</div>
			<div class="ex5">
				<div class="col-sm-12">
					<!-- <input type="image" id="paySubmit" name="action" value="payment"
						src="<c:url value="/resources/image/pay.jpg" />" width="400"
						height="80" border="0" /> -->
						<a href='<c:url value="/payment/${payurl}" />'>Home</a>
						
				</div>
			</div>
			<div class="ex3">
				<div class="page-header">
					<h4></h4>
				</div>
			</div>
		</div>
	</form:form>


</body>
<script>
$(document).ready(function()
{
	var fileUploadConfigs = [
		{"catagoryName":"color","positionName":"color1"}, 
		{"catagoryName":"color","positionName":"color2"},
		{"catagoryName":"color","positionName":"color3"},
		{"catagoryName":"color","positionName":"color4"},
		
		{"catagoryName":"monochrome","positionName":"monochrome1"}, 
		{"catagoryName":"monochrome","positionName":"monochrome2"},
		{"catagoryName":"monochrome","positionName":"monochrome3"},
		{"catagoryName":"monochrome","positionName":"monochrome4"},
		
		{"catagoryName":"nature","positionName":"nature1"}, 
		{"catagoryName":"nature","positionName":"nature2"},
		{"catagoryName":"nature","positionName":"nature3"},
		{"catagoryName":"nature","positionName":"nature4"}] 
	
	/* var csrfParam   = $("meta[name='_csrf_parameter']").attr("content");
	var csrfToken  = $("meta[name='_csrf']").attr("content"); */
	
	var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
	var csrfToken = $("meta[name='_csrf']").attr("content"); 
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");  // THIS WAS ADDED
	var headers = {};
	headers[csrfHeader] = csrfToken; 
	
	$("#upload_image_color1").uploadFile({
	url:"json/saveimage",
	dragDrop: true,
	multiple:false,
	maxFileCount:1,
	fileName:"images",
	acceptFiles:"image/*",
	showPreview:true,
	showDelete: true,
	previewHeight: "100px",
	previewWidth: "100px",
	allowedTypes:"jpg,jpeg",
	maxFileSize:20848820,
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[0]['action'] = "save";
		fileUploadConfigs[0][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[0]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelcolour1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelcolour1').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_color1").hide();
		$('#titelcolour1').prop('disabled', true);
		fileUploadConfigs[0]['fileId'] = data.data.fileId;
		
	},
    onError: function (files, status, message, pd) 
    {
    	console.log("onError",files, status, message, pd);
    },
	onLoad:function(obj,pd)
	   {
	   	$.ajax({
		    	cache: false,
			    url: "json/loadimage",
		    	dataType: "json",
		    	data: (function() { 
		    		fileUploadConfigs[0]['action'] = "load";
		    		return fileUploadConfigs[0];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data){ //File is available
			    		fileUploadConfigs[0]['fileId'] = data.data.fileId;
				    	$("#titelcolour1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_color1").hide();
						$('#titelcolour1').prop('disabled', true);
			    	}else{
			    		
			    	}
			    	
		        }
			});
	  },
	  deleteCallback: function (data, pd) {
		   $.ajax({
			    url: "json/deleteimage",
			    dataType: "json",
	        	data:  (function() { 
		    		fileUploadConfigs[0]['action'] = "delete";
		    		return fileUploadConfigs[0];
		    	})(),
	        	success: function(result){
		        		$("#upload_image_color1").show();
		        		$('#titelcolour1').prop('disabled', false); 
		        		$("#titelcolour1").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	$("#upload_image_color2").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[1]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[1]);
			return $.extend({}, fileUploadConfigs[1]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			console.log(data);
			//console.log(pd);
			$("#upload_image_color2").hide();
			$('#titelcolour2').prop('disabled', true);
			fileUploadConfigs[1]['fileId'] = data.data.fileId;
			
		},
		 onError: function (files, status, message, pd) 
		    {
		    	console.log("onError",files, status, message, pd);
		    },
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[1]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[1]);
			    		return fileUploadConfigs[1];
			    	})(), 
				    success: function(data) 
				    {
				    	//console.log("PB onLoad 2",data);
				    	if(data){ //File is available
					    	fileUploadConfigs[1]['fileId'] = data.data.fileId;
					    	$("#titelcolour2").val(data.data.titel);
					    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	$("#upload_image_color2").hide();
							$('#titelcolour2').prop('disabled', true);
				    	}else{
				    		
				    	}
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[1]['action'] = "delete";
			    		return fileUploadConfigs[1];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_color3").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[2]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[2]);
			return $.extend({}, fileUploadConfigs[2]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[2]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[2]);
			    		return fileUploadConfigs[2];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[2]['fileId'] = data.data.fileId;
				    	$("#titelcolour3").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[2]['action'] = "delete";
			    		return fileUploadConfigs[2];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_color4").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[3]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[3]);
			return $.extend({}, fileUploadConfigs[3]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[3]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[3]);
			    		return fileUploadConfigs[3];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[3]['fileId'] = data.data.fileId;
				    	$("#titelcolour4").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[3]['action'] = "delete";
			    		return fileUploadConfigs[3];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	
	////////////////////////////monochrome starts////////////////////////////
	
	
$("#upload_image_monochrome1").uploadFile({
	url:"json/saveimage",
	multiple:false,
	maxFileCount:1,
	fileName:"images",
	acceptFiles:"image/*",
	showPreview:true,
	showDelete: true,
	previewHeight: "100px",
	previewWidth: "100px",
	allowedTypes:"jpg,jpeg",
	maxFileSize:20848820,
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	formData: (function() { 
		fileUploadConfigs[4]['action'] = "save";
		//console.log("Form Data Upload",fileUploadConfigs[4]);
		return $.extend({}, fileUploadConfigs[4]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelmonochrome1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelmonochrome1').val();
		if(title.length==0){
			return false;
		}
	},
	onSuccess:function(files,data,xhr,pd)
	{

		//console.log(data);
		$("#upload_image_monochrome1").hide();
		$('#titelmonochrome1').prop('disabled', true);
		fileUploadConfigs[0]['fileId'] = data.data.fileId;
		
	},
	onError: function (files, status, message, pd) 
	    {
	    	console.log("onError",files, status, message, pd);
	    },
	onLoad:function(obj)
	   {
	   	$.ajax({
		    	cache: false,
			    url: "json/loadimage",
		    	dataType: "json",
		    	data: (function() { 
		    		fileUploadConfigs[4]['action'] = "load";
		    		//console.log("Data onLoad",fileUploadConfigs[4]);
		    		return fileUploadConfigs[4];
		    	})(), 
			    success: function(data) 
			    {
					if(data){ //File is available
			    		fileUploadConfigs[4]['fileId'] = data.data.fileId;
			    	    $("#titelmonochrome1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_monochrome1").hide();
						$('#titelmonochrome1').prop('disabled', true);
			    	}else{
			    		
			    	}
			    	
			    	
		        }
			});
	  },
	  deleteCallback: function (data, pd) {
		   $.ajax({
			    url: "json/deleteimage",
			    dataType: "json",
	        	data:  (function() { 
		    		fileUploadConfigs[4]['action'] = "delete";
		    		return fileUploadConfigs[4];
		    	})(),
	        	success: function(result){
					    $("#upload_image_monochrome1").show();
		        		$('#titelmonochrome1').prop('disabled', false); 
		        		$("#titelmonochrome1").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	$("#upload_image_monochrome2").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[1]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[5]);
			return $.extend({}, fileUploadConfigs[5]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelmonochrome2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[5]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[5]);
			    		return fileUploadConfigs[5];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[5]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome2").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[5]['action'] = "delete";
			    		return fileUploadConfigs[5];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_monochrome3").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[6]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[6]);
			return $.extend({}, fileUploadConfigs[6]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelmonochrome3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[6]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[6]);
			    		return fileUploadConfigs[6];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[6]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome3").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[6]['action'] = "delete";
			    		return fileUploadConfigs[6];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_monochrome4").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[7]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[7]);
			return $.extend({}, fileUploadConfigs[7]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelmonochrome4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[7]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[7]);
			    		return fileUploadConfigs[7];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[7]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome4").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[7]['action'] = "delete";
			    		return fileUploadConfigs[7];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	///////////////////////////monochrome ends//////////////////////////////
	
	
	
	//////////////////////////////nature starts////////////////////////////
	
	$("#upload_image_nature1").uploadFile({
	url:"json/saveimage",
	multiple:false,
	maxFileCount:1,
	fileName:"images",
	acceptFiles:"image/*",
	showPreview:true,
	showDelete: true,
	previewHeight: "100px",
	previewWidth: "100px",
	allowedTypes:"jpg,jpeg",
	maxFileSize:20848820,
	formData: (function() { 
		fileUploadConfigs[8]['action'] = "save";
		//console.log("Form Data Upload",fileUploadConfigs[8]);
		return $.extend({}, fileUploadConfigs[8]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelnature1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
		//console.log('onSubmit');
	},
	onSuccess:function(files,data,xhr,pd)
	{

		$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
		//console.log('onSuccess ' +JSON.stringify(data));
		
	},
	onLoad:function(obj)
	   {
	   	$.ajax({
		    	cache: false,
			    url: "json/loadimage",
		    	dataType: "json",
		    	data: (function() { 
		    		fileUploadConfigs[8]['action'] = "load";
		    		//console.log("Data onLoad",fileUploadConfigs[8]);
		    		return fileUploadConfigs[8];
		    	})(), 
			    success: function(data) 
			    {
			    	fileUploadConfigs[8]['fileId'] = data.data.fileId;
			    	$("#titelnature1").val(data.data.titel);
			    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
		        }
			});
	  },
	  deleteCallback: function (data, pd) {
		   $.ajax({
			    url: "json/deleteimage",
			    dataType: "json",
	        	data:  (function() { 
		    		fileUploadConfigs[8]['action'] = "delete";
		    		return fileUploadConfigs[8];
		    	})(),
	        	success: function(result){
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	$("#upload_image_nature2").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[1]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[9]);
			return $.extend({}, fileUploadConfigs[9]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[9]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[9]);
			    		return fileUploadConfigs[9];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[9]['fileId'] = data.data.fileId;
				    	$("#titelnature2").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[9]['action'] = "delete";
			    		return fileUploadConfigs[9];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_nature3").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[10]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[10]);
			return $.extend({}, fileUploadConfigs[10]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[10]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[10]);
			    		return fileUploadConfigs[10];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[10]['fileId'] = data.data.fileId;
				    	$("#titelnature3").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[10]['action'] = "delete";
			    		return fileUploadConfigs[10];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_nature4").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		showDelete: true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: (function() { 
			fileUploadConfigs[11]['action'] = "save";
			//console.log("Form Data Upload",fileUploadConfigs[11]);
			return $.extend({}, fileUploadConfigs[11]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			//$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
			//console.log('onSubmit');
		},
		onSuccess:function(files,data,xhr,pd)
		{

			$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Success for: "+data.message);
			//console.log('onSuccess ' +JSON.stringify(data));
			
		},
		onLoad:function(obj)
		   {
		   	$.ajax({
			    	cache: false,
				    url: "json/loadimage",
			    	dataType: "json",
			    	data: (function() { 
			    		fileUploadConfigs[11]['action'] = "load";
			    		//console.log("Data onLoad",fileUploadConfigs[11]);
			    		return fileUploadConfigs[11];
			    	})(), 
				    success: function(data) 
				    {
				    	fileUploadConfigs[11]['fileId'] = data.data.fileId;
				    	$("#titelnature4").val(data.data.titel);
				    	obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[11]['action'] = "delete";
			    		return fileUploadConfigs[11];
			    	})(),
		        	success: function(result){
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	//////////////////////////////nature ends//////////////////////////////

});
</script>
</html>