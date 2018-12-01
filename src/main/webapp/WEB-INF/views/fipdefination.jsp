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
        <li><a href="getrulesandregulations"> RULES & REGULATIONS 2017 </a></li>
        <li><a href="getfipdefination"> FIAP DEFINITIONS OF DIVISIONS </a></li>  
        <li><a href="getjudges"> JUDGES </a></li>                     
      </ul>
    </li>
	<li><a href="getloginForm">Perticipate/Login</a></li>
	<li><a href="getUserTable">Entry Status</a></li>
	<li><a href="getDownload">Result</a></li>   
    <li><a href="getContuctUs">Contuct Us</a></li>
  </ul>
</div>
  
  <div class="container">
  <div class="page-header">
  <h2 align="center">DEFINATION</h2>   
  
  <span class="style1"><b>FIAP MONOCHROME</b></span>
    <br />
    <br />
    A black and white work fitting from the very dark grey (black) to the very clear grey (white) is a monochrome work with the various shades of grey. A black and white work toned entirely in a single colour will remain a monochrome work able to stand in the black and white category; such a work can be reproduced in black and white in the catalogue of a salon under FIAP Patronage. On the other hand a black and white work modified by a partial toning or by the addition of one colour becomes a colour work (polychrome) to stand in the colour category; such a work requires colour reproduction in the catalogue of a salon under FIAP Patronage.
    <br />
    <br />
    
    <span class="style1"><b>PSA MONOCHROME</b></span>
    <br />
    <br />
    A monochrome image is defined as having varying shades of no more than one color (various shades of that color from very light to very dark) but it may be any single color. Multi-toned images (various shades of two or more colors) and greyscale images with added an accent color are not acceptable in Monochrome Class sections and must be entered in Color Class sections.<br />
    
    <br />
    <span class="style1"><b>PSA PHOTO TRAVEL</b></span>
    <br />
    <br />
A Photo Travel image expresses the characteristic features or culture of a land as they are found naturally. There are no geographic limitations. 
Images from events or activities arranged specifically for photography, or of subjects directed or hired for photography are not appropriate. 
Close up pictures of people or objects must include features that provide information about the environment. Techniques that add, relocate, replace 
or remove any element of the original image, except by cropping, are not permitted. The only allowable adjustments are removal of dust or digital noise, 
restoration of the appearance of the original scene, and complete conversion to greyscale monochrome. Other derivations, including infrared, are not 
permitted. All allowed adjustments must appear natural.
    <br />
    <br />
    <span class="style1"><b>PSA, FIAP, and RPS Nature Definition</b></span>
    <br />
    <br />
Nature photography is restricted to the use of the photographic process to depict all branches ofnatural history, except anthropology and archeology, in such a fashion that a well-informed
person will be able to identify the subject material and certify its honest presentation. The story
telling value of a photograph must be weighed more than the pictorial quality while maintaininghigh technical quality. Human elements shall not be present, except where those human elementsare 
integral parts of the nature story such as nature subjects, like barn owls or storks, adaptedto an environment modified by humans, or where those human elements are in situations depictingnatural 
forces, like hurricanes or tidal waves. Scientific bands, scientific tags or radio collars onwild animals are permissible. Photographs of human created hybrid plants, cultivated plants,feral 
animals, domestic animals, or mounted specimens are ineligible, as is any form ofmanipulation that alters the truth of the photographic statement. No techniques that add,relocate, replace, or 
remove pictorial elements except by cropping are permitted. Techniques thatenhance the presentation of the photograph without changing the nature story or the pictorialcontent, or without 
altering the content of the original scene, are permitted including HDR, focusstacking and dodging/burning. Techniques that remove elements added by the camera, such asdust spots, digital 
noise, and film scratches, are allowed. Stitched images are not permitted. Allallowed adjustments must appear natural. Color images can be converted to greyscalemonochrome. Infrared images, 
either direct captures or derivations, are not allowed.

Images entered in Nature sections meeting the Nature Photography Definition above can havelandscapes, geologic formations, weather phenomena, and extant organisms as the primarysubject matter. 
This includes images taken with the subjects in controlled conditions, such as zoos,game farms, botanical gardens, aquariums and any enclosure where the subjects are totallydependent on man for food
    <br />
    <br />
    <span class="style1"><b>PSA PHOTO JOURNALISM - [ THEME CHILD IS APPROVED UNDER PJD SECTION ]</b></span>
    <br />
    <br />
Photojournalism entries shall consist of images with informative content and emotional impact, reflecting the human presence in our world. 
The journalistic (story-telling) value of the image shall receive priority over pictorial quality. In the interest of credibility, images 
that misrepresent the truth, such as those from events or activities specifically arranged for photography or of subjects directed or hired 
for photography, are not eligible. Techniques that add, relocate, replace or remove any element of the original image, except by cropping, 
are not permitted. The only allowable modifications are removal of dust, scratches or digital noise, restoration of the existing appearance
 of the original scene, sharpening that is not obvious, and conversion to greyscale monochrome. Derivations, including infrared, are not 
 eligible.   
 
</div></div>
  
  
</body>
</html>