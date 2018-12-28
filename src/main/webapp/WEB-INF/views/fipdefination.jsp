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
  <div class="page-header">
  <h3 align="center"><b>PROJECTED IMAGE DIVISION </b></h3>   
  
  <span class="style1"><b>PSA PID Monochrome Definition</b></span>
    <br />
    <br />
    <p>An image is considered to be Monochrome only if it gives the impression of having no color (i.e. contains only shades of gray which can include pure black and pure white) 
    OR it gives the impression of being a grayscale image that has been toned in one color across the entire image. 
    (For example by Sepia, red, gold, etc.). </p>
    <p>A grayscale or multi-colored image modified or giving the impression of having been modified by partial toning, multi toning or by the inclusion of spot coloring does 
        not meet the definition of monochrome and shall be classified as a Color Work. </p>
    <p> Scientific bands, scientific tags or radio collars on wild animals are permissible.</p>    
    <br />
    <br />
    
    <span class="style1"><b>Nature Division Definition </b></span>
    <br />
    <span class="style1"><p align="center"><b>All images used in International Exhibition sections recognized by the PSA Nature Division must meet the PSA Nature Definition as follows: </b></p></span>  
    <br />
  <p> Nature photography is restricted to the use of the photographic process to depict all branches of natural history, 
   except anthropology and archeology, in such a fashion that a well-informed person will be able to identify the 
   subject material and certify its honest presentation.</p>
   <br />
   <p><b> 1.</b> The story telling value of a photograph must be weighed more than the pictorial quality while maintaining high technical quality.</p> 
   <p><b> 2.</b> Human elements shall not be present, except where those human elements are integral parts of the nature story such as nature subjects, 
        like barn owls or storks, adapted to an environment modified by humans, or where those human elements are in situations depicting natural 
        forces, like hurricanes or tidal waves.</p>
   <p><b> 3.</b> Scientific bands, scientific tags or radio collars on wild animals are permissible.</p>   
   <p><b> 4.</b> Photographs of human created hybrid plants, cultivated plants, feral animals, domestic animals, or mounted specimens are ineligible, as is any form of manipulation that alters the truth of the photographic statement.</p>
   <p><b> 5.</b> No techniques that add, relocate, replace, or remove pictorial elements except by cropping are permitted</p>
   <p><b> 6.</b> Techniques that enhance the presentation of the photograph without changing the nature story or the pictorial content, or without altering the content of the original scene, are permitted including HDR, focus stacking and dodging/burning.</p>
   <p><b> 7.</b> Techniques that remove elements added by the camera, such as dust spots, digital noise, and film scratches, are allowed.</p>
   <p><b> 8.</b> Stitched images are not permitted.</p>
   <p><b> 9.</b> All allowed adjustments must appear natural.</p>
   <p><b> 10.</b> Color images can be converted to greyscale monochrome.</p>
   <p><b> 11.</b> Infrared images, either direct-captures or derivations, are not allowed.</p>
   <p><b> 12.</b> Images entered in Nature sections meeting the Nature Photography Definition above can have landscapes, geologic formations, weather phenomena, 
                   and extant organisms as the primary subject matter. This includes images taken with the subjects in controlled conditions, such as zoos, game farms, enclosures that make the subjects dependent on man for food, and botanical gardens.</p>
   
    <br />
    <span class="style1"><b>Photo Travel Division Definition</b></span>
    <br />
<p align="center"><b>Subject matter must include Photo Travel, and confirm to the following definition:</b></p>
<p>A Photo Travel image expresses the characteristic features or culture of a land as they are found naturally. 
There are no geographic limitations. Images from events or activities arranged specifically for photography, 
or of subjects directed or hired for photography are not appropriate. Close up pictures of people or objects 
must include features that provide information about the environment. Techniques that add, relocate, replace or 
remove any element of the original image, except by cropping, are not permitted. The only allowable adjustments 
are removal of dust or digital noise, restoration of the appearance of the original scene, and complete conversion 
to greyscale monochrome. Other derivations, including infrared, are not permitted. All allowed adjustments must appear 
natural.Images may be acquired on traditional film and scanned to a digital file or acquired with a digital camera.</p>


    <br />
    <br />
   
  
  
</body>
</html>