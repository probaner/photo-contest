<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<sec:csrfMetaTags/>

<title>${titel}</title>
<link rel="icon" href="${titelImage}" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
	
<link href="http://hayageek.github.io/jQuery-Upload-File/4.0.11/uploadfile.css" rel="stylesheet">
<script src="http://hayageek.github.io/jQuery-Upload-File/4.0.11/jquery.uploadfile.min.js"></script> --%>


<link rel="stylesheet" type="text/css" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/uploadfile.css" />">
<script src="<c:url value="/resources/javaScript/jquery.min.js" />"></script>
<script src="<c:url value="/resources/javaScript/bootstrap.min.js" />"></script>
<%-- <script src="<c:url value="/resources/javaScript/jquery.uploadfile.min.js" />"></script> --%>
<script src="<c:url value="/resources/javaScript/jquery.uploadfile.js" />"></script>

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

div.ex6 {
	padding: 0px 100px 10px 100px;
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

p.b { 
    word-spacing: 10px;
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
 


<script type="text/javascript">
		var isDisabledAll = "${statue}";
</script>


	<div class="ex1">
		<div class="well well-sm">
			<h4>
				<c:out value="${sucessMagssage}" />
				
			</h4>						
			<div style="float: right; font-size: 100%; position: relative; top: -12px">			   
			   <a href="#" data-toggle="tooltip" data-placement="top" title="Click after upload compleate" id ="confirm_upload_mail">Confirm Upload Mail </a>
			    &nbsp;
                &nbsp;
				<a href="#" data-toggle="tooltip" data-placement="top" title="Click after upload compleate" id ="payment_id"> Payment </a>
				&nbsp;
                &nbsp;	
              <a href="#" data-toggle="tooltip" data-placement="top" title="Click on result date" id ="download_result">Download Result</a>  
                &nbsp;
                &nbsp;            
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



<!-- Start of row phototravel -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Photo Travel</h4>
		</div>
	</div>

	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelphototravel1" class="form-control" placeholder="Enter Title" value="" required/>	  
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_phototravel1"></div>
			   </div>
		 </div>


		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelphototravel2" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_phototravel2"></div>
			 </div>
		</div>
	</div>	
				
	<!-- End of row one of nature -->
	
	<!-- Start of row two of nature -->


	<div class="row">

	    <div class="col-sm-6">
			  <div class="ex2">
				   <div class="col-sm-12">
						<input id="titelphototravel3" class="form-control" placeholder="Enter Title" value="" required/>
				   </div>
			  </div>
			  <div class="ex3">
			   <div  id="upload_image_phototravel3"></div>
			   </div>
		 </div>

		<div class="col-sm-6">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <input id="titelphototravel4" class="form-control" placeholder="Enter Title" value="" required/>
				  </div>
			 </div> 
			 <div class="ex3">	
			 <div  id="upload_image_phototravel4"></div>
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
		{"catagoryName":"nature","positionName":"nature4"},
		
		{"catagoryName":"phototravel","positionName":"phototravel1"}, 
		{"catagoryName":"phototravel","positionName":"phototravel2"},
		{"catagoryName":"phototravel","positionName":"phototravel3"},
		{"catagoryName":"phototravel","positionName":"phototravel4"}] 
	
		
	var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
	var csrfToken = $("meta[name='_csrf']").attr("content"); 
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");  // THIS WAS ADDED
	var headers = {};
	headers[csrfHeader] = csrfToken; 
	
	$('[data-toggle="tooltip"]').tooltip(); 
	 
	 $("#confirm_upload_mail" ).click(function(e) {
		 e.preventDefault();		 
		 $.ajax({
		   	  url: "json/getconfirmuploadmail",
		   	  type: "GET",
		   	  dataType: "json",
		   	  contentType: 'application/json',	  
		   	  success: function(uploadmail) {
		   		                                
		   		                               console.log("uploadmail=", uploadmail);
		   		                                alert(uploadmail.message);   
		   		                            
		   	                           }
		       });
		 
	 });
	 
	 
	 
	 $("#payment_id" ).click(function(e) {
		 e.preventDefault();		 
		 $.ajax({
		   	  url: "json/getpaystatu",
		   	  type: "GET",
		   	  dataType: "json",
		   	  success: function(ispay) {
		   		                         if(ispay){
		   		                        	        <%--console.log("ispay="+ispay); 
		   		                             	     //$(location).attr("href", "getpay");
		   		                             	    window.location.href("<%=request.getContextPath()%>/getpay"); --%>
		   		                             	    window.location.href = "<%=request.getContextPath()%>/getpay";
		   		                             	     
		   		                                  }
		   	                           }
		       });
		 
	 });
	 
	 
	 $("#download_result" ).click(function(e) {
		 e.preventDefault();		 
		 $.ajax({
		   	  url: "json/downloadresult",
		   	  type: "GET",
		   	  dataType: "json",
		   	  contentType: 'application/json',	  
		   	  success: function(isresult) {		
		   		                            if(isresult) {
		   		                                           window.location.href = "<%=request.getContextPath()%>/downloadresult";
		   		                                         }
		   	                              }
		       });
		 
	 });
	
	
	$("#upload_image_color1").uploadFile({
	url:"json/saveimage",
	returnType:"json",
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
	showFileCounter:false,
	errorClass: "alert-danger",
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
		$("#upload_image_color1").hide();
		$('#titelcolour1').prop('disabled', true);
		fileUploadConfigs[0]['fileId'] = data.data.fileId;
		
	},
    onError: function (files, status, message, pd) 
    {
    	console.log("pbbbb");
    	console.log(message);
    	pd.cancel.show();
    	//console.log("onError",files, status, message, pd);
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
			    	//console.log(data);
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[0]['fileId'] = data.data.fileId;
				    	$("#titelcolour1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_color1").hide();
						$('#titelcolour1').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelcolour1').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_color1 *').prop('disabled',true);
			    		  }
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[1]['action'] = "save";
			fileUploadConfigs[1][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[1]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelcolour2').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_color2").hide();
			$('#titelcolour2').prop('disabled', true);
			fileUploadConfigs[1]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[1]['action'] = "load";
			    		return fileUploadConfigs[1];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[1]['fileId'] = data.data.fileId;
					    	$("#titelcolour2").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_color2").hide();
							$('#titelcolour2').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelcolour2').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_color2 *').prop('disabled',true);
				    		  }
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
			        		$("#upload_image_color2").show();
			        		$('#titelcolour2').prop('disabled', false); 
			        		$("#titelcolour2").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	
	
	
	$("#upload_image_color3").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[2]['action'] = "save";
			fileUploadConfigs[2][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[2]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelcolour3').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_color3").hide();
			$('#titelcolour3').prop('disabled', true);
			fileUploadConfigs[2]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[2]['action'] = "load";
			    		return fileUploadConfigs[2];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[2]['fileId'] = data.data.fileId;
					    	$("#titelcolour3").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_color3").hide();
							$('#titelcolour3').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelcolour3').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_color3 *').prop('disabled',true);
				    		  }
				    	    }	
				    	
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
			        		$("#upload_image_color3").show();
			        		$('#titelcolour3').prop('disabled', false); 
			        		$("#titelcolour3").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	
	
	$("#upload_image_color4").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[3]['action'] = "save";
			fileUploadConfigs[3][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[3]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelcolour4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelcolour4').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_color4").hide();
			$('#titelcolour4').prop('disabled', true);
			fileUploadConfigs[3]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[3]['action'] = "load";
			    		return fileUploadConfigs[3];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[3]['fileId'] = data.data.fileId;
					    	$("#titelcolour4").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_color4").hide();
							$('#titelcolour4').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelcolour4').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_color4 *').prop('disabled',true);
				    		  }
				    	    }	
				    	
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
			        		$("#upload_image_color4").show();
			        		$('#titelcolour4').prop('disabled', false); 
			        		$("#titelcolour4").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	
	////////////////////////////monochrome starts////////////////////////////
	
	
$("#upload_image_monochrome1").uploadFile({
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[4]['action'] = "save";
		fileUploadConfigs[4][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[4]);
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
		fileUploadConfigs[4]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[4]['action'] = "load";
		    		return fileUploadConfigs[4];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[4]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_monochrome1").hide();
						$('#titelmonochrome1').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelmonochrome1').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_monochrome1 *').prop('disabled',true);
			    		  }
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[5]['action'] = "save";
		fileUploadConfigs[5][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[5]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelmonochrome2').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelmonochrome2').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_monochrome2").hide();
		$('#titelmonochrome2').prop('disabled', true);
		fileUploadConfigs[5]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[5]['action'] = "load";
		    		return fileUploadConfigs[5];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[5]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome2").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_monochrome2").hide();
						$('#titelmonochrome2').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelmonochrome2').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_monochrome2 *').prop('disabled',true);
			    		  }
			    	    }	
			    	
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
		        		$("#upload_image_monochrome2").show();
		        		$('#titelmonochrome2').prop('disabled', false); 
		        		$("#titelmonochrome2").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
$("#upload_image_monochrome3").uploadFile({
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[6]['action'] = "save";
		fileUploadConfigs[6][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[6]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelmonochrome3').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelmonochrome3').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_monochrome3").hide();
		$('#titelmonochrome3').prop('disabled', true);
		fileUploadConfigs[6]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[6]['action'] = "load";
		    		return fileUploadConfigs[6];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[6]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome3").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_monochrome3").hide();
						$('#titelmonochrome3').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelmonochrome3').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_monochrome3 *').prop('disabled',true);
			    		  }
			    	    }	
			    	
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
		        		$("#upload_image_monochrome3").show();
		        		$('#titelmonochrome3').prop('disabled', false); 
		        		$("#titelmonochrome3").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
$("#upload_image_monochrome4").uploadFile({
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[7]['action'] = "save";
		fileUploadConfigs[7][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[7]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelmonochrome4').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelmonochrome4').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_monochrome4").hide();
		$('#titelmonochrome4').prop('disabled', true);
		fileUploadConfigs[7]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[7]['action'] = "load";
		    		return fileUploadConfigs[7];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[7]['fileId'] = data.data.fileId;
				    	$("#titelmonochrome4").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_monochrome4").hide();
						$('#titelmonochrome4').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelmonochrome4').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_monochrome4 *').prop('disabled',true);
			    		  }
			    	    }	
			    	
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
		        		$("#upload_image_monochrome4").show();
		        		$('#titelmonochrome4').prop('disabled', false); 
		        		$("#titelmonochrome4").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	///////////////////////////monochrome ends//////////////////////////////
	
	
	
	//////////////////////////////nature starts////////////////////////////
	
	$("#upload_image_nature1").uploadFile({
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[8]['action'] = "save";
		fileUploadConfigs[8][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[8]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelnature1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelnature1').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_nature1").hide();
		$('#titelnature1').prop('disabled', true);
		fileUploadConfigs[8]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[8]['action'] = "load";
		    		return fileUploadConfigs[8];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[8]['fileId'] = data.data.fileId;
				    	$("#titelnature1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_nature1").hide();
						$('#titelnature1').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelnature1').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_nature1 *').prop('disabled',true);
			    		  }
			    	    }	
			    	
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
		        		$("#upload_image_nature1").show();
		        		$('#titelnature1').prop('disabled', false); 
		        		$("#titelnature1").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	
	
	$("#upload_image_nature2").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[9]['action'] = "save";
			fileUploadConfigs[9][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[9]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelnature2').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_nature2").hide();
			$('#titelnature2').prop('disabled', true);
			fileUploadConfigs[9]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[9]['action'] = "load";
			    		return fileUploadConfigs[9];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[9]['fileId'] = data.data.fileId;
					    	$("#titelnature2").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_nature2").hide();
							$('#titelnature2').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelnature2').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_nature2 *').prop('disabled',true);
				    		  }
				    	    }	
				    	
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
			        		$("#upload_image_nature2").show();
			        		$('#titelnature2').prop('disabled', false); 
			        		$("#titelnature2").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_nature3").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[10]['action'] = "save";
			fileUploadConfigs[10][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[10]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelnature3').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_nature3").hide();
			$('#titelnature3').prop('disabled', true);
			fileUploadConfigs[10]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[10]['action'] = "load";
			    		return fileUploadConfigs[10];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[10]['fileId'] = data.data.fileId;
					    	$("#titelnature3").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_nature3").hide();
							$('#titelnature3').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelnature3').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_nature3 *').prop('disabled',true);
				    		  }
				    	    }	
				    	
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
			        		$("#upload_image_nature3").show();
			        		$('#titelnature3').prop('disabled', false); 
			        		$("#titelnature3").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_nature4").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[11]['action'] = "save";
			fileUploadConfigs[11][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[11]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelnature4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelnature4').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_nature4").hide();
			$('#titelnature4').prop('disabled', true);
			fileUploadConfigs[11]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[11]['action'] = "load";
			    		return fileUploadConfigs[11];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[11]['fileId'] = data.data.fileId;
					    	$("#titelnature4").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_nature4").hide();
							$('#titelnature4').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelnature4').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_nature4 *').prop('disabled',true);
				    		  }
				    	    }	
				    	
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
			        		$("#upload_image_nature4").show();
			        		$('#titelnature4').prop('disabled', false); 
			        		$("#titelnature4").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	//////////////////////////////nature ends//////////////////////////////
	
	//////////////////////////////phototravel start//////////////////////////////
	$("#upload_image_phototravel1").uploadFile({
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
	showFileCounter:false,
	errorClass: "alert-danger",
	uploadErrorStr: "Upload is not allowed.Enter Title.",
	headers: headers,
	formData: (function() { 
		fileUploadConfigs[12]['action'] = "save";
		fileUploadConfigs[12][csrfParameter] = csrfToken;
		return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[12]);
	})(),
	dynamicFormData: function()
	{
		var title = $('#titelphototravel1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		var title = $('#titelphototravel1').val();
		if(title.length==0){
			return false;
		}
		
	},
	onSuccess:function(files,data,xhr,pd)
	{
		//console.log(data);
		$("#upload_image_phototravel1").hide();
		$('#titelphototravel1').prop('disabled', true);
		fileUploadConfigs[12]['fileId'] = data.data.fileId;
		
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
		    		fileUploadConfigs[12]['action'] = "load";
		    		return fileUploadConfigs[12];
		    	})(), 
			    success: function(data) 
			    {
			    	if(data.data.fileId){ //File is available
			    		fileUploadConfigs[12]['fileId'] = data.data.fileId;
				    	$("#titelphototravel1").val(data.data.titel);
				    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
				    	pd.filename.html("");
				    	$("#upload_image_phototravel1").hide();
						$('#titelphototravel1').prop('disabled', true);
						if(!data.data.editable){
							pd.del.hide();						
						   }
						else{
							  pd.del.show();
						    }
			    	}else{
			    		if(!data.data.editable){
			    		   $('#titelphototravel1').prop('disabled', true);	
			    		   //$('#upload_image_color1').addClass("disabledbutton");
			    		   $('#upload_image_phototravel1 *').prop('disabled',true);
			    		  }
			    	    }	
			    	
		        }
			});
	  },
	  deleteCallback: function (data, pd) {
		   $.ajax({
			    url: "json/deleteimage",
			    dataType: "json",
	        	data:  (function() { 
		    		fileUploadConfigs[12]['action'] = "delete";
		    		return fileUploadConfigs[12];
		    	})(),
	        	success: function(result){
		        		$("#upload_image_phototravel1").show();
		        		$('#titelphototravel1').prop('disabled', false); 
		        		$("#titelphototravel1").val('');
	                   pd.statusbar.hide(); //You choice. */
	        }});

		}
	});
	
	
	$("#upload_image_phototravel2").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[13]['action'] = "save";
			fileUploadConfigs[13][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[13]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelphototravel2').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelphototravel2').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_phototravel2").hide();
			$('#titelphototravel2').prop('disabled', true);
			fileUploadConfigs[13]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[13]['action'] = "load";
			    		return fileUploadConfigs[13];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[13]['fileId'] = data.data.fileId;
					    	$("#titelphototravel2").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_phototravel2").hide();
							$('#titelphototravel2').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelphototravel2').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_phototravel2 *').prop('disabled',true);
				    		  }
				    	    }
				    	
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[13]['action'] = "delete";
			    		return fileUploadConfigs[13];
			    	})(),
		        	success: function(result){
			        		$("#upload_image_phototravel2").show();
			        		$('#titelphototravel2').prop('disabled', false); 
			        		$("#titelphototravel2").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	
	$("#upload_image_phototravel3").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[14]['action'] = "save";
			fileUploadConfigs[14][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[14]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelphototravel3').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelphototravel3').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_phototravel3").hide();
			$('#titelphototravel3').prop('disabled', true);
			fileUploadConfigs[14]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[14]['action'] = "load";
			    		return fileUploadConfigs[14];
			    	})(), 
				    success: function(data) 
				    {
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[14]['fileId'] = data.data.fileId;
					    	$("#titelphototravel3").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_phototravel3").hide();
							$('#titelphototravel3').prop('disabled', true);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    		   $('#titelphototravel3').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_phototravel3 *').prop('disabled',true);
				    		  }
				    	    }  	
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[14]['action'] = "delete";
			    		return fileUploadConfigs[14];
			    	})(),
		        	success: function(result){
			        		$("#upload_image_phototravel3").show();
			        		$('#titelphototravel3').prop('disabled', false); 
			        		$("#titelphototravel3").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		});
	
	$("#upload_image_phototravel4").uploadFile({
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
		showFileCounter:false,
		errorClass: "alert-danger",
		uploadErrorStr: "Upload is not allowed.Enter Title.",
		headers: headers,
		formData: (function() { 
			fileUploadConfigs[15]['action'] = "save";
			fileUploadConfigs[15][csrfParameter] = csrfToken;
			return $.extend({/*  _csrf : csrfToken */}, fileUploadConfigs[15]);
		})(),
		dynamicFormData: function()
		{
			var title = $('#titelphototravel4').val();
			return {"titel":title};
		},
		onSubmit:function(files)
		{
			var title = $('#titelphototravel4').val();
			if(title.length==0){
				return false;
			}
			
		},
		onSuccess:function(files,data,xhr,pd)
		{
			//console.log(data);
			$("#upload_image_phototravel4").hide();
			$('#titelphototravel4').prop('disabled', true);
			fileUploadConfigs[15]['fileId'] = data.data.fileId;
			
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
			    		fileUploadConfigs[15]['action'] = "load";
			    		return fileUploadConfigs[15];
			    	})(), 
				    success: function(data) 
				    {
				    	
				    	if(data.data.fileId){ //File is available
				    		fileUploadConfigs[15]['fileId'] = data.data.fileId;
					    	$("#titelphototravel4").val(data.data.titel);
					    	var pd = obj.createProgress("","data:image/jpg;base64,"+ data.data.encodedString,"");// name,src,size
					    	pd.filename.html("");
					    	$("#upload_image_phototravel4").hide();
							$('#titelphototravel4').prop('disabled', true);
							//console.log("prosenjit :",data.data.editable);
							if(!data.data.editable){
								pd.del.hide();						
							   }
							else{
								  pd.del.show();
							    }
				    	}else{
				    		if(!data.data.editable){
				    			console.log("prosenjit :",data.data.editable);
				    		   $('#titelphototravel4').prop('disabled', true);	
				    		   //$('#upload_image_color1').addClass("disabledbutton");
				    		   $('#upload_image_phototravel4 *').prop('disabled',true);
				    		  }
				    	    }  	
				    	
			        }
				});
		  },
		  deleteCallback: function (data, pd) {
			   $.ajax({
				    url: "json/deleteimage",
				    dataType: "json",
		        	data:  (function() { 
			    		fileUploadConfigs[15]['action'] = "delete";
			    		return fileUploadConfigs[15];
			    	})(),
		        	success: function(result){
		        		
			        		$("#upload_image_phototravel4").show();
			        		$('#titelphototravel4').prop('disabled', false); 
			        		$("#titelphototravel4").val('');
		                   pd.statusbar.hide(); //You choice. */
		        }});

			}
		  
		  
		  
		  
		});
	
	//////////////////////////////phototravel ends//////////////////////////////
	
	
});
</script>
</html>