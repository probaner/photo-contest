package com.photo.contest.utility;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.photo.contest.config.ConfigProperty;

@Component
public class HtmlData {
	
	@Autowired
	ConfigProperty configProperty;
	
	   public Optional<String> getHeader(String name, String username, String password) {
				
		String s = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+
				   "<html xmlns=\"http://www.w3.org/1999/xhtml\">"+
		           "<head>"+
		           "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"+
		           "<title></title>"+
		           "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>"+
		           "<link rel=\"stylesheet\" href=\"<c:url value=\"/resources/css/WelcomeEmail.css\" />\">"+
		           "</head>"+
		           "<body bgcolor=\"#FFFFFF\">"+
		           "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" style=\"background-color: #FFFFFF\" width=\"100%\">"+
		           "<tr><td>"+   
		           "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"content\" style=\"background-color: #FFFFFF\">"+
		           "<tr>"+
		           "<td align=\"center\" valign=\"top\">"+
	               "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"brdBottomPadd-two\" id=\"templateContainer\" width=\"100%\">"+
		           "<tr>"+
		           "<td class=\"bodyContent\" valign=\"top\" mc:edit=\"welcomeEdit-02\">"+
		           "<p>Hi "+name+"</p>"+
                   "<h3>"+configProperty.getRegistrarionsuccesscomment()+"</h3>"+
                   "</td>"+
                   "</tr>"+
		           "<tr>"+
                   "<td align=\"center\">"+
                   "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"brdBottomPadd-two\" id=\"templateContainerMiddl\" width=\"100%\">"+
                   "<tr valign=\"top\">"+
                   "<td align=\"center\" class=\"bodyContentTicks\">"+
                   "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
                   "<tr valign=\"top\">"+
                   "<td valign=\"top\" mc:edit=\"welcomeEditImgFirst\" style=\"width:19%;color:#505050;font-family:Helvetica;font-size:14px;padding-bottom:1.143em;\">"+
                   "<p style=\"text-align:center;margin:0 0 15px 0;padding:0;\">"+
		           "<img height=\"\" src=\"<c:url value=\"${"+configProperty.getRegistrarionsuccessimage()+"}\" />\" alt=\"logo\" /> width=\"71\"></p></td>"+
		           "<td valign=\"top\" style=\"width:5%;\">&nbsp;</td>"+
                   "<td valign=\"top\" mc:edit=\"welcomeEditTxtFirst\" style=\"width:71%;color:#505050;font-family:Helvetica;font-size:14px;padding-top:0.714em;\">"+
                   "<h3><strong>User Name </strong></h3>"+
                   "<h4>"+username+"</h4>"+
                   "</td>"+
                   "<td valign=\"top\" style=\"width:5%;\">&nbsp;</td>"+
                   "</tr>"+
                   "<tr valign=\"top\">"+
                   "<td valign=\"top\" mc:edit=\"welcomeEditImgFirst\" style=\"width:19%;color:#505050;font-family:Helvetica;font-size:14px;padding-bottom:1.143em;\">"+
                   "<p style=\"text-align:center;margin:0 0 15px 0;padding:0;\">"+
                   "<img height=\"\" src=\"<c:url value=\"${"+configProperty.getRegistrarionsuccessimage()+"}\" />\" alt=\"logo\" /> width=\"71\"></p></td>"+
                   "<td valign=\"top\" style=\"width:5%;\">&nbsp;</td>"+
                   "<td valign=\"top\" mc:edit=\"welcomeEditTxtFirst\" style=\"width:71%;color:#505050;font-family:Helvetica;font-size:14px;padding-top:0.714em;\">"+
                   "<h3><strong>Password</strong></h3>"+
				   "<h4>"+ password +"</h4></td>"+
				   "<td valign=\"top\" style=\"width:5%;\">&nbsp;</td>"+
                   "</tr></table> </td></tr></table> </td></tr>"+    
                   "<tr>"+
                   "<td align=\"center\" valign=\"top\">"+
                   "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateContainerMiddleBtm\" width=\"100%\">"+
                   "<tr><td class=\"bodyContent\" valign=\"top\" mc:edit=\"welcomeEdit-11\">"+
                   "<h5><strong>N.B.:This is an automatically generated email. Please do not reply to this.</strong></h5>"+
                   "<h5>For any queries visit <a href=\"https://"+configProperty.getSitename()+"/\" ><strong>"+configProperty.getSitename()+"</strong></a></h5>"+
                   "</td></tr></table></td></tr></table></td></tr></table>"+
                   "</body>" + 
                   "</html>";
		
		
                      
		return Optional.of(s);
	}

}
