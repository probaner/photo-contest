package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.photo.contest.dto.ClubDTO;
import com.photo.contest.dto.CouponCode;
import com.photo.contest.dto.Login;
import com.photo.contest.dto.LogingResponseDTO;
import com.photo.contest.dto.PaymentDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.model.Users;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.SelectData;



@Controller 
@SessionAttributes({"userForm","clubDataList","displayFileDTOMap"})
public class UserLoginController {
	
	@Autowired
	CommonServices 	commonServices;
	@Autowired
	private DbServices dbServices;
	@Autowired
	SelectData selectData;
	
	 @Autowired
	 AuthenticationTrustResolver authenticationTrustResolver;
	
	
	 @GetMapping("/getloginFormAfterRegister")
		public String viewLoginAfterRegister(Map<String, Object> model) throws IOException {
			Login loginForm = new Login();
			model.put("loginForm", loginForm);	
			return "login";		
		  }
	 
	 
	
	@GetMapping("/getloginForm")
		public String viewLogin(Map<String, Object> model) throws IOException {
			Login loginForm = new Login();
			model.put("loginForm", loginForm);	
			return "login";		
		  }
	
	/**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String loginPage(Model model) throws IOException{
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
		} else {

			String email = getCurrentUser();
			if (email != null) {
				LogingResponseDTO logingResponseDTO = dbServices.getUserData(email);
				/*System.out.println("PROSENJIT");
				System.out.println(logingResponseDTO.getHm());*/
				Users user = logingResponseDTO.getUser();
				if (user != null) {

					UserDTO userDTO = commonServices.createCurrentUserDTO(user, new UserDTO());
					model.addAttribute("userForm", userDTO);

					if (userDTO.getRole().equals("participate") /*&& commonServices.getExpairStatus()*/) {
                        
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
								+ userDTO.getFirstname().toUpperCase());
						model.addAttribute("paymentDetail", new PaymentDTO());
						model.addAttribute("displayFileDTOMap", logingResponseDTO.getHm());
						
						return "registrationsuccess";
					} 
					else if (userDTO.getRole().equals("admin")) {
						CouponCode couponCode = new CouponCode();
						model.addAttribute("couponCode", couponCode);
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
								+ userDTO.getFirstname().toUpperCase());
						List<ClubDTO> clubDTOData = dbServices.getClubData();
						List<String> clubDataList = selectData.clubData(clubDTOData);

						model.addAttribute("clubDataList", clubDataList);
						return "admin";

					} /*else {
						model.addAttribute("error", "Last Login Date is Over");
					}*/

				} else {
					     model.addAttribute("error", "Invalid Details");
				       }

			} else {
				     model.addAttribute("error", "Please enter Details");
			       }

			return "login";
		}
        }
	
	
	/*@PostMapping(value = "/loginSucess")
	public String executeLogin( Model model, @ModelAttribute("loginForm") Login loginBean, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		
		
		
		if (loginBean != null && loginBean.getUsername() != null && loginBean.getPassword() != null) {
			
		
			LogingResponseDTO logingResponseDTO= dbServices.getUserData(loginBean);
			
			Users user =  logingResponseDTO.getUser();
		
			if(user != null) {
				
				UserDTO userDTO = commonServices.createCurrentUserDTO( user , new UserDTO());
				model.addAttribute("userForm", userDTO);
				
				if(userDTO.getRole().equals("participate")  && commonServices.getExpairStatus()) {
					
					
					model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
					model.addAttribute("paymentDetail", new PaymentDTO());
					model.addAttribute("displayFileDTOMap", logingResponseDTO.getHm());
										
					return "registrationsuccess";
				  }
				else if (userDTO.getRole().equals("admin")){
					                                         CouponCode couponCode =new CouponCode();
					                                         model.addAttribute("couponCode", couponCode);
				                                             model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
				                                             List<ClubDTO> clubDTOData =dbServices.getClubData();
				                                             List<String> clubDataList = selectData.clubData(clubDTOData);
				                                             
				                                             model.addAttribute("clubDataList", clubDataList);					     
				        	    
				                                             return "admin";
					
				                                           }
				else {
					    model.addAttribute("error", "Last Login Date is Over");
				     }
				
				
				
				
			  }else {
				       model.addAttribute("error", "Invalid Details");
			        }
			
			
		}else {
		        model.addAttribute("error", "Please enter Details");
	          }
		
		return "login";
		
		
		
	}*/
	
	
	
		
	/*@PostMapping(value = "/loginSucess")
	public String executeLogin1( Model model, @ModelAttribute("loginForm") Login loginBean, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		System.out.println("GELO");

		if (loginBean != null && loginBean.getUsername() != null && loginBean.getPassword() != null) {
			
			
			if (dbServices.getUserData(loginBean).size() == 1) {
				UserDTO userDTO = commonServices.createCurrentUserDTO(dbServices.getUserData(loginBean).get(0), new UserDTO());
				if(userDTO==null) {
					model.addAttribute("error", "Invalid Details");
					return "login";
				   }
				model.addAttribute("userForm", userDTO);
				if ((dbServices.getUserData(loginBean).get(0).getRole()).equals("participate")) {
					if (commonServices.getExpairStatus()) {// check expairy date
						dbServices.updateCurrentTimeStamp(dbServices.getUserData(loginBean));// update current time stamp																								 																								 																								 
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
						model.addAttribute("product", new FileDTO());
						model.addAttribute("paymentDetail", new PaymentDTO());
						//System.out.println("In login page="+userDTO.toString());						
						HashMap<String, LinkedList<DisplayFileDTO>> displayFileDTOMap = dbServices.getDisplayFileData(userDTO);

						if (displayFileDTOMap.size() > 0) {
							for (Map.Entry<String, LinkedList<DisplayFileDTO>> entry : displayFileDTOMap.entrySet()) {
                                 String k = entry.getKey();
                                 LinkedList<DisplayFileDTO> v = entry.getValue();                  
                                 for(DisplayFileDTO dfdto : v){
                                	 byte[] encoded=Base64.encodeBase64( dfdto.getItemImage());
                                	 String encodedString = new String(encoded);
                                	 model.addAttribute("image_"+dfdto.getPosition(), encodedString);
                                	 model.addAttribute("titel_"+dfdto.getPosition(), dfdto.getTitel());
                                	 model.addAttribute("id_"+dfdto.getPosition(), dfdto.getFileId());
                                	 //System.out.println("image_"+dfdto.getPosition()+ "    "+"titel_"+dfdto.getPosition()+"  "+dfdto.getTitel());                               	     
                                    }                                
							     }							
							model.addAttribute("size",displayFileDTOMap.size());
							
							//check user status paid or not
							List<PayStatus> ufd = dbServices.getPayStatusOfAUser(userDTO);
							if(!(ufd.get(0).getPayingStatus()).equals("Being Check")){
								model.addAttribute("statue", "lock");
							   }
							else{
								  model.addAttribute("statue", "open");
							   // }
							
							
						}else{
							   model.addAttribute("size", "0");
					         }
					} else {
						model.addAttribute("error", "Last Login Date is Over");
						return "login";
					}
						
					return "registrationsuccess";
				} else if ((dbServices.getUserData(loginBean).get(0).getRole()).equals("admin")) {
			        CouponCode couponCode =new CouponCode();
			        model.addAttribute("couponCode", couponCode);
			        dbServices.updateCurrentTimeStamp(dbServices.getUserData(loginBean));
			        model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
			       
			          List<ClubDTO> clubDTOData =dbServices.getClubData();
			        
			          List<String> clubDataList = selectData.clubData(clubDTOData);
			          model.addAttribute("clubDataList", clubDataList);					     
			        	    
			        return "admin";// return to admin page
		           } else {
					                return "registrationsuccess";// need to create judge page
				                  }

			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
*/
	
	
	 /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    
    private String getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
	
}
		

