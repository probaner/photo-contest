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
  <h3 align="center"><b>MICRO Circuit 2019</b></h3> 
  <h4 align="center">PSA 2019-066</h4>    
</div></div>



<div class="container">
  <div class="page-header">
  <h4 align="center"><b>SECTIONS</b></h4>      
  <p align="center">[A] MONOCHROME [PID-M]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [B] COLOUR [PID-C] &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [C] NATURE [ND]
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [D] TRAVEL [PTD]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </p>
</div></div>
  
  
  
  <div class="container">
  <div class="page-header">
  <h4 align="center"><b>EVENT CALENDAR</b></h4>      
  <p align="center">Closing Date  :	<b>07th March 2019</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Judging Date  :	<b>18th March to 20th March 2019</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Result Date  :	<b>APRIL 03, 2019 via E-mail only</b><br /><br/>
PDF Catalog on-line and awards mailed  : <b> By May 30, 2019</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp    
</div></div>
  
 <div class="page-header">
  <h4 align="center"><b>ENTRY FREE</b></h4>      
  <p align="center"><b>Entry Fee for Foreign Entrants $USD 25 for 2 Section $USD 35 for 3 Sections $USD 45 for 4 Section</b></p>
  <p align="center"><b>Entry Fee for Indian Entrants INR 1750 for 2 Section INR 2450 for 3 Sections INR 3150 for 4 Sections</b></p>
  <p align="center"><b>INDIAN PAYMENTS WILL BE SAME AS FOREIGN PAYMENTS.</b> Entries received without a fee will not be judged. Please check the Status Page on the website for verification of receipt of payment.</p>
<p></p>
<p></p>
<p align="center"><b>Discounts  :  </b>Discounts are available for groups of 3 or more. Please contact the Chair at E-mail: <b>obscurafotoclub@gmail.com</b></p>
</div></div> 


<div class="page-header">
  <h4 align="center"><b>AWARDS </b></h4>      
  <p align="center"><b>Each Section 10 Awards</b></p>
  <p align="center">1 Best of Show: PSA Gold </p>
  <p align="center">1 Circuit Gold  </p>
  <p align="center">1 Circuit Silver </p>
  <p align="center">1 Circuit Bronze </p>
  <p align="center">1 Chairman's Award  </p>
  <p align="center">3 Judge's Choice Awards  </p>
  <p align="center">2 Honourable  Mention Ribbons </p>
  <p align="center">more then 72 E-CM </p>
   
  
  <p align="center">Our target range of acceptance is to have 30-35% of the images accepted. </p>
  <p align="center"> We intend to award additional Circuit Silver and Circuit Bronze Medals in each section of each salon based upon quantity and quality of entries</p>
</div></div> 


<div class="container">
  <div class="page-header">
  <h4 align="center"><b>JUDGES</b></h4>      
  <p align="center">[1] BEAUTY BISWAS &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
                    [2] HARRY ORAN &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
                    [3] JHINKU MISHRA &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
                    </p>
  <p align="center">[4] NABANITA PRADHAN &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
                    [5] NIRMALYA BHATTACHARYA &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    [6] SASWATI CHAKRABORTY &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
                    </p>
  <p align="center">                  
                    [7] SUBRATA ADHIKARY &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    [8] SUDIPTA DAS &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    [9] TAMANNA BERA &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    </p>
</div></div>
<div class="container">
  <div class="page-header">
  <h4 align="center"><b>EVENT TERMS AND CONDITIONS</b></h4> 
  </br></br>
    <h4 align="center"><b>Image Files</b></h4>
    <p style="text-align: justify; font-weight: bold;">The images must be sent with the electronic entry form. No CD will be accepted.</p>
    <p style="text-align: justify">The images must be in JPG format. We urge you to submit your images in sRGB to assure that they conform to 
                                   how they will be displayed by our equipment. A maximum of 4 images may be submitted per section. The images do not 
                                   have to be renamed. The entry form will rename them for you. Each image must have a unique title. 
                                   Images must have titles; words such as “untitled” or “no title' are not acceptable as part or all of an 
                                   images title, nor are camera capture file names or titles consisting of only numbers. Once an image has 
                                   been accepted in a PSA recognized exhibition, that same image or a like “in camera” or a “reproduction” duplicate 
                                   may not be re-entered in any section of the same Division Star Ratings Class in that exhibition regardless of media, 
                                   format or title, nor may it be re-titled for entry in any other PSA recognized exhibition.</p>
     <p style="text-align: justify; font-weight: bold; color: #FF0000;">Image File Dimensions and Size</p> 
     <p style="text-align: justify;  color: #FF0000;">Maximum width: <b>1600</b> pixels Maximum height: <b>900</b> pixels  </p>                               
     <p style="text-align: justify; font-weight: bold; color: #FF0000;">We will judge all images at 100% of the image size submitted. We will not alter, 
                                   including resizing in either direction, any image either before or during judging; either by us or by our equipment. 
                                   Any image exceeding these maximums will be rejected. </p>
     <p style="text-align: justify;  color: #FF0000;">An entrant images will not be presented to the judges consecutively. An entrant’s four images will be 
     distributed throughout four rounds of judging for each section. Distribution of images shall be in the same round order as submitted by the entrant.</p>                              
                                  
   </br></br>
   
   <p align="center"><b>Entry Form  </b></p>
   
   <p style="text-align: justify">The entry form is available at <b>www.microcircuit.asia</b> and must be submitted electronically using the submit button together with the images.</p>
   <p style="text-align: justify">Instructions for filling out the entry form are included on the website. A list of all the entries received will be published on the Exhibition website. The status of the entry fee and the files received will be listed. Please check the status of your entries on the website about a week after sending.</p>
   <p>After you submit your entry, you will receive an E-mail with your identifying information, plus the image titles you typed in. Please review and, if you made any errors, please contact the Chair at <b>obscurafotoclub@gmail.com</b> to resolve.</p>
   </br></br> 
   
   <p align="center"><b>DATA PROTECTION  </b></p>
   <p style="text-align: justify">By entering this exhibition, you are explicitly consenting to the personal details you have supplied, including email addresses, being held, processed and used by the exhibition organizers for purposes associated with this exhibition. You also explicitly consent to such information being sent to organizations that have accorded official recognition, patronage or accreditation to this exhibition. You acknowledge and accept that entering this exhibition means that the status and results of your entry may be made public.</p>
   
   
   
  </br></br> 
   <p align="center"><b>General Rules </b></p>
   <p style="text-align: justify">The exhibition is open to anyone; however, an entry may be rejected when the sponsoring organization or its agent, in its reasonable discretion, believes the entry does not conform to the exhibition rules and conditions.
   
              An entrant’s images will not be presented to the judges consecutively. 
</br></br>An entrant four images will be distributed throughout four rounds of judging in that section. Distribution of images shall be in the same round order as submitted by the entrant.

</br><br>Entries must originate as photographs (image-captures of objects via light sensitivity) made by the entrant on photographic emulsion or acquired digitally. By virtue of submitting an entry, the entrant certifies the work as his own (aliases are not permitted). 
The entrant permits the sponsors to reproduce all or part of the entered material free of charge for publication and/or display in media related to the exhibition. This may include low resolution posting on a website. <b>Note: </b>Entrants who indicate that their images may not be reproduced or used “will not be eligible for awards” or inclusion in audio-visuals of the exhibition “and could be subject to disqualification” by the exhibition sponsors.

</br></br>The exhibition assumes no liability of any misuse of copyright. Images may be altered, either electronically or otherwise, by the maker. Artwork or computer graphics created by the entrant may be incorporated provided the photographic content predominates, subject to Nature, Photo Travel and Photojournalism divisional restrictions. All final work

must be on photographic film, or on electronic file, or on photographic or electronic print material, mounting excepted.

</br></br>No title or identification of the maker shall be visible anywhere on the face of an image, print mat or mount entered in a PSA Recognized exhibition.

</br></br>Each image must have a unique title. Once an image has been accepted in a PSA Recognized exhibition, that same image, or a like “in camera” or a “reproduction” duplicate of that image:

</br><b>i.</b> May not be entered or re-entered in any section of the same Division Star Ratings class in that exhibition regardless of media, format, or title.

</br><b>ii.</b> May not be re-titled for entry in any other PSA Recognized exhibition, including translation into another language.

</br><b>iii.</b> Images meeting the Monochrome Definition and non-manipulated color images from the same capture shall be considered the same image and must be given the same title.

</br><b>iv.</b> PSA members working on Galaxy and Diamond Star Ratings shall be allowed to continue using different titles of monochrome versions and color versions of the same capture that have already been accepted until the required number of acceptances for those titles have been completed.

<br>Words such as “Untitled” and “No Title” are not acceptable as part or all of an image’s title, nor are camera capture filenames. An image may be entered in only one section where acceptances of that image in multiple sections would be eligible for the same star path. </p>
   
   
   
   
   
   
   
   
   
   
                                   
 <!--  <p style="text-align: justify; font-weight: bold;"> 1. The exhibition is open to anyone; however, an entry may be rejected when the sponsoring organization or its agent, 
    in its reasonable discretion, believes the entry does not conform to the exhibition rules and conditions.</p>
   <p style="text-align: justify"><br /> 2. An entrant images will not be presented to the judges consecutively. An entrant’s four images will be distributed throughout four rounds of judging in that section. Distribution of 
   images shall be in the same round order as submitted by the entrant.</p>
   <p style="text-align: justify; font-weight: bold;"></p> -->
   
   
  </div></div>
 
  <!-- <div class="container">
  <div class="page-header">
  <h4 align="center">SECTIONS</h4>      
  <p align="center">[A] MONOCHROME [PID-M]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [B] COLOUR [PID-C] &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [C] NATURE [ND]
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [D] TRAVEL [PTD]&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp [E] SPECIAL THEME - CHILD [PJD]</p>
</div></div> -->


<!-- <div class="container">
  <div class="page-header">
  <h4 align="center">EVENT CALENDAR</h4>      
  <p align="center">Closing Date	:	<b>18th October 2017</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Judging Date	:	<b>4th to 6th November 2017</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
Result Date	:	<b>15th November 2017</b><br /><br/>
Catalogue & Award	:	<b>20th January 2018</b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp    
Exhibition Date	:	<b>20th January 2018</b><br/><br/><br/></p>
</div></div> -->
  
<!-- <div class="container">
  <div class="page-header">
  <h4 align="center">ENTRY FREE</h4>      
  <p align="center"><b>Entry Fee for Foreign Entrants $ 45 USD (UNIQUE) for all sections. Entry fees have to be sent online through the</b></p>
  <p align="center">If you want Special Printed Catalogue then you have to pay $25 [USD] or â¬25 [Euro] extra per entrant</p>
  <p align="center"><b>Entry Fee for Indian Entrants Rs. 1500/- (UNIQUE) for all sections</b></p>
  <p align="center">If you want Special Printed Catalogue then you have to pay Rs. 800.00 INR extra per entrant</p>
</div></div>   -->

<!-- <div class="container">
  <div class="page-header">
  <h4 align="center"><b>EVENT TERMS AND CONDITIONS</b></h4>      

<p style="text-align: justify; font-weight: bold;">1. Photographers from all over the world are entitled to participate. However, an entry may be rejected when the Organization, in its reasonable discretion, believes the entry does not conform to the contest rules and conditions.</p>
<p style="text-align: justify"><br />2. The Organization assumes no liability for any misuse of copyright. Digital sections images may be acquired digitally, or scanned from film by the entrant or a third party to create a digital file. Adjustments and cleaning to make the digital file match the original film image are allowed.</p>
<p style="text-align: justify; font-weight: bold; color: #FF0000;"><br />3. All parts of the image have to be photographed by the author who is holding the copyright of all works submitted</p>
<p style="text-align: justify"><br />4. Monochrome images submitted in Category A Free Subject, Colour (PID Color Division) WILL NOT be accepted, and no admission fee will be reimbursed.</p>
<p style="font-weight: bold; text-align: justify"><br />5. One image can be submitted in one and only category. Should it be submitted in both Category A Free Subject, Colour and Category B Free Subject, Monochrome, it will be judged in Category A Free Subject, Colour and subsequently excluded from Category B Free Subject, Monochrome.</p>
<p style="text-align: justify"><br />6. Image titles must not exceed 30 characters and shall not use âNOTITLEâ, âUNTITLEDâ or special characters in naming. Results will be published in website www.vibgyorcircuit.org and may be despatched via email to contestants.</p>
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
<p style="text-align: justify"><br />18. An entrantâs four images will be distributed throughout four rounds of judging for that section.</p>
<p style="text-align: justify; font-weight: bold;"><br />19.	There are no restrictions as to subject matter except as outlined in the rules and definitions of specific sections, or specified by law in the country where the exhibition is held.</p>
<p style="text-align: justify"><br />20.	Each image must have a unique title. Once an image has been accepted in a PSA Recognized exhibition, that same image, or a like âin cameraâ or a âreproductionâ duplicate of that image: i. May not be re-entered in any section of the same Division Star Ratings class in that exhibition regardless of media, format, or title. ii. May not be re-titled for entry in any other PSA Recognized exhibition</p>
<p style="text-align: justify; font-weight: bold;"><br />21.	All entrants in must provide name and country data exactly the same in each exhibition entered to receive proper credit.</p>
<p style="text-align: justify"><br />22.	Participating in the Circuit implies the clear and unconditional acceptance of these Rules and Conditions.</p>
</div></div> -->   
</body>
</html>