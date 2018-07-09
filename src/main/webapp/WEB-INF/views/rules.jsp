<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
</style>
</head>
<body>

<div class="container">
  <div class="page-header">
  <div class="header">  <img src="<c:url value="/resources/image/Logo.jpg" />" alt="logo" /> </div>
  <div class="headerr">  <img src="<c:url value="/resources/image/Logo 2.jpg" />" alt="logo" />   </div>    
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
  <h4 align="center">SECTIONS</h4>      
  <p align="center">[A] MONOCHROME [PID-M]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [B] COLOUR [PID-C] &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [C] NATURE [ND]
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [D] TRAVEL [PTD]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [E] SPECIAL THEME - CHILD [PJD]</p>
</div></div>


<div class="container">
  <div class="page-header">
  <h4 align="center">EVENT CALENDAR</h4>      
  <p align="center">Closing Date	:	<b>18th October 2017</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Judging Date	:	<b>4th to 6th November 2017</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Result Date	:	<b>15th November 2017</b><br /><br/>
Catalogue & Award	:	<b>20th January 2018</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp    
Exhibition Date	:	<b>20th January 2018</b><br/><br/><br/></p>
</div></div>
  
<div class="container">
  <div class="page-header">
  <h4 align="center">ENTRY FREE</h4>      
  <p align="center"><b>Entry Fee for Foreign Entrants $ 45 USD (UNIQUE) for all sections. Entry fees have to be sent online through the</b></p>
  <p align="center">If you want Special Printed Catalogue then you have to pay $25 [USD] or €25 [Euro] extra per entrant</p>
  <p align="center"><b>Entry Fee for Indian Entrants Rs. 1500/- (UNIQUE) for all sections</b></p>
  <p align="center">If you want Special Printed Catalogue then you have to pay Rs. 800.00 INR extra per entrant</p>
</div></div>  

<div class="container">
  <div class="page-header">
  <h4 align="center">EVENT TERMS AND CONDITIONS</h4>      

<p style="text-align: justify; font-weight: bold;">1. Photographers from all over the world are entitled to participate. However, an entry may be rejected when the Organization, in its reasonable discretion, believes the entry does not conform to the contest rules and conditions.</p>
<p style="text-align: justify"><br />2. The Organization assumes no liability for any misuse of copyright. Digital sections images may be acquired digitally, or scanned from film by the entrant or a third party to create a digital file. Adjustments and cleaning to make the digital file match the original film image are allowed.</p>
<p style="text-align: justify; font-weight: bold; color: #FF0000;"><br />3. All parts of the image have to be photographed by the author who is holding the copyright of all works submitted</p>
<p style="text-align: justify"><br />4. Monochrome images submitted in Category A Free Subject, Colour (PID Color Division) WILL NOT be accepted, and no admission fee will be reimbursed.</p>
<p style="font-weight: bold; text-align: justify"><br />5. One image can be submitted in one and only category. Should it be submitted in both Category A Free Subject, Colour and Category B Free Subject, Monochrome, it will be judged in Category A Free Subject, Colour and subsequently excluded from Category B Free Subject, Monochrome.</p>
<p style="text-align: justify"><br />6. Image titles must not exceed 30 characters and shall not use “NOTITLE”, “UNTITLED” or special characters in naming. Results will be published in website www.vibgyorcircuit.org and may be despatched via email to contestants.</p>
<p style="font-weight: bold; text-align: justify"><br />7. Each participant registration (filling in of registration form), image upload, entering of image title (no file renaming requested) and fee payment shall be performed directly on the website: www.vibgyorcircuit.org </p>
<p style="text-align: justify"><br />8. Only Western characters are allowed for both participant registration and image titles. The original file name shall be written in Western characters too when uploading the file. At the end of registration payment will be required. Participants may choose to pay either by 
credit card (Visa, MasterCard, PayPal, Moneybookers) or PayPal & Moneybookers account. Images from participants who are not up to date with the registration fee payment will not be accepted.</p>
<p style="font-weight: bold; text-align: justify"><br />9. The decision of the Panel of selectors is final and binding, no further appeal will be entertained</p>
<p style="text-align: justify; color: #0000FF;"><br />10. With the sole act of submitting his/her images or files to a salon under FIAP Patronage, 
the entrant accepts without exception and with no objection that the submitted images can be investigated by FIAP to establish if these obey to FIAP regulations and definitions even if the entrant is not a member of FIAP; that FIAP will use any means at its disposal for this undertaking; that any refusal to cooperate with FIAP or any refusal to 
submit the original files as captured by the camera, or failure to provide sufficient evidence, will be sanctioned by FIAP and that in case of sanctions following the non compliance with FIAP regulations, the name of the entrant will be released in any form useful to inform the breaches of the rules. It is recommended to leave the EXIF data in the submitted files intact in order to ease eventual investigations.</p>
<p style="font-weight: bold; text-align: justify"><br />11. Each photographer is responsible for the subject of all his/her entries. At the end of the event, all files will be destroyed 
excepting those admitted or awarded, which will be instead kept and exclusively used for contest-related non commercial purposes, such as 
projections, making of the PDF catalogue, exhibition of the awarded photographs, and organizing club newsletters (both on hardcopy and softcopy).</p>
<p style="text-align: justify; color: #FF0000;"><br />12. Special conditions granted to clubs with at least 20 (TWENTY) participants. The club concerned shall send a request to vibgyorcircuit@gmail.com indicating all participants' name and surname in English only. Each participant will get to enjoy a discount of 5.00 USD per author.</p>
<p style="text-align: justify; font-weight: bold;"><br />13. The Organization guarantees maximum care in handling the files received. However, it assumes no liability for any kind of damages or losses since the total procedures are done digitally.</p>
<p style="text-align: justify"><br />14. Uncollected awards will be shipped at the receiver's own risk. The shipping costs will be borne by the Organization. However once sent awards if returned will be the despatched by the sole discretion of the chairman.</p>
<p style="text-align: justify; font-weight: bold;"><br />15. At the end of the event, all contestants will be given the PDF catalogue containing all the award winning works and a selection of those admitted to the 3 contests.</p>
<p style="text-align: justify"><br />16. Please note that, pursuant to art. 13 of the INDIAN CYBER ACT 2000 (Personal Data Protection Code), the personal data provided within the contests being part of the Circuit will be gathered and recorded by the ORGANISERS on electronic and paper media. Data will be protected and handled by the implementation 
of measures appropriated to guarantee safety and confidentiality according to the relevant laws and regulations. Data might be published on-line (as provided for by the FIAP, PSA & FIP contest regulations) on the websites of the organizing clubs and on the Circuit Facebook page and on the means mentioned in point 10 of these Rules and Conditions.</p>
<p style="text-align: justify; font-weight: bold;"><br />17.	A projector will be used in judging still electronic images having the following minimum specifications : Resolution: XGA (or higher) 1024 X 768 pixels or higher with the native projector resolution matching or exceeding the maximum pixels specified for image submission Brightness: 1000 lumens (minimum) Contrast Ratio: 400:1 (minimum) and hence Images should be 1024 pixels X 768 pixels are acceptable.
File size is preferred within 1 MB. Image files shall be saved in the sRGB or RGB colour space and in jpg format, (no file renaming requested).</p>
<p style="text-align: justify"><br />18. An entrant’s four images will be distributed throughout four rounds of judging for that section.</p>
<p style="text-align: justify; font-weight: bold;"><br />19.	There are no restrictions as to subject matter except as outlined in the rules and definitions of specific sections, or specified by law in the country where the exhibition is held.</p>
<p style="text-align: justify"><br />20.	Each image must have a unique title. Once an image has been accepted in a PSA Recognized exhibition, that same image, or a like “in camera” or a “reproduction” duplicate of that image: i. May not be re-entered in any section of the same Division Star Ratings class in that exhibition regardless of media, format, or title. ii. May not be re-titled for entry in any other PSA Recognized exhibition</p>
<p style="text-align: justify; font-weight: bold;"><br />21.	All entrants in must provide name and country data exactly the same in each exhibition entered to receive proper credit.</p>
<p style="text-align: justify"><br />22.	Participating in the Circuit implies the clear and unconditional acceptance of these Rules and Conditions.</p>
</div></div>   
</body>
</html>