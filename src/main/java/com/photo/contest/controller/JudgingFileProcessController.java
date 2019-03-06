package com.photo.contest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@SessionAttributes({"userForm","clubDataList","organizerclubList","categoryList","processDataType"})
@EnableWebMvc
public class JudgingFileProcessController {
	
	//@Autowired
	//private SelectData selectData;
	
	
	//@RequestMapping(value = "/admin/json/getjudgeprocessdropdown")
	
	//public @ResponseBody List<JudgeFileProcessDropDownDTO> getJudgeProcessDropdowJson() throws IOException {
		
		/* List<JudgeFileProcessDropDownDTO> list =selectData.judgeFileProcessType();
		 for(JudgeFileProcessDropDownDTO j: list)
			 System.out.println(j.toString());
		 
		 return list;*/
	//}
	
	
	/*@RequestMapping("/processFile")
	public String processFile(@RequestParam String action,
			                  @ModelAttribute("processFileDTO") ProcessFileDTO processFileDTO,
			                  @ModelAttribute("couponCode") CouponCode couponCodeBean, 
			                  @ModelAttribute("userForm") UserDTO userDTO,
			      			  @ModelAttribute("clubDataList") List<String> clubDataList,
			      			  @ModelAttribute("processDataType") Map<String, String> processDataType,
			                  HttpServletResponse response,
			                  HttpServletRequest request,
			                  Model model)throws IOException {
		
		if (action.equals("processJudgingFile")) {		
		     System.out.println("File processing=");
		     if(processFileDTO.getStatus().equals("0"))
		    	 model.addAttribute("processDataError", "Select Proper Option !"); 
		  else {
			     String judgingStartdate =configProperty.getJudgingStartdate(); 
			     String sysDate =commonUtil.getDateTime().substring(0,10).trim();
			     
			     System.out.println(judgingStartdate + "   " +sysDate);
			     long diff = commonUtil.findNumberofDaysBetweenTwoDate(judgingStartdate,sysDate);
			     
			     if(diff >0 && diff <=2) {
			    	                      String dayMinusOne = commonUtil.getPreviouDayDate(judgingStartdate, 1);
			    	                      String dayMinusTow = commonUtil.getPreviouDayDate(judgingStartdate, 2);
			    	                      model.addAttribute("processDataError", "Process will run from: "+ dayMinusTow + " to "+ dayMinusOne);
			                             }
			     
			     else {
			    	 
			    	     // new to write logic for process file
			    	 
			          }
			     
			    
		    	     
		       }
		     
		   }
		
		model.addAttribute("couponCode", new CouponCode());
		model.addAttribute("judgeCreationDTO",new JudgeCreationDTO());
		model.addAttribute("processDataType", processDataType);
		model.addAttribute("processFileDTO", new ProcessFileDTO());
		model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
				+ userDTO.getFirstname().toUpperCase());
		
		return "admin";
		
	}*/
}
