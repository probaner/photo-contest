package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.photo.contest.config.ConfigProperty;
import com.photo.contest.dto.CategoryDTO;
import com.photo.contest.dto.DisplayAwardImageDTO;
import com.photo.contest.dto.ImageRatingDTOContainer;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.CommonServices;
import com.photo.contest.service.DbServices;

@Controller
@SessionAttributes({"userForm","displayAwardImageDTOList","categoryJudge"})
public class CategoryWiseAwardImageBundelController {
	
	
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private CommonServices commonService;
	@Autowired
	DbServices dbServices;
	
	
	@RequestMapping("/judge/judgeingcategoryawards")
	public String getImageBundel(
			Model model,
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		  model.addAttribute("titel",configProperty.getIndexName());
		  model.addAttribute("titelImage",configProperty.getIndexImage());
		  model.addAttribute("headerLeft",configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle",configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight",configProperty.getHeaderRight());
		  
		  
		  List<DisplayAwardImageDTO> displayAwardImageDTOList = commonService.getImageAwardData (categoryDTO.getCategoryName(),userDTO);
		  //System.out.println(displayAwardImageDTOList.size());
		  ImageAwardContainerDTO container = new ImageAwardContainerDTO();
		  container.setImageList(displayAwardImageDTOList);
		  model.addAttribute("displayAwardImageDTOList", container);
		  model.addAttribute("categoryJudge", categoryDTO.getCategoryName());
		   
		  				
		return "imagecomment";
		
	}
	
	
	@RequestMapping(value = "/judge/awards", method = RequestMethod.POST)
	public String saveUsers(@ModelAttribute("displayAwardImageDTOList") ImageAwardContainerDTO imageAwardContainerDTO,
			                @ModelAttribute("userForm") UserDTO userDTO,			               
			                Model model) throws Exception{
		
		
		dbServices.updateImageAward(imageAwardContainerDTO.getImageList(), userDTO);
		
		List<String>  judgeCategory = dbServices.getCategoryListofaJudge(userDTO.getUserid()); 
 	    java.util.Collections.sort(judgeCategory); 
	    model.addAttribute("categoryList",judgeCategory);
 	    model.addAttribute("categoryDTO", new CategoryDTO());
 	    model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "
					+ userDTO.getFirstname().toUpperCase());
				
		  model.addAttribute("titel","/"+configProperty.getIndexName());
		  model.addAttribute("titelImage","/"+configProperty.getIndexImage());
		  model.addAttribute("headerLeft","/"+configProperty.getHeaderLeft());
		  model.addAttribute("headerMiddle","/"+configProperty.getHeaderMiddle());
		  model.addAttribute("headerRight","/"+configProperty.getHeaderRight());
		  
	      model.addAttribute("message", "Rating saved successfully");
	      model.addAttribute("displayAwardImageDTOList", imageAwardContainerDTO);
		
		
								return "judgeawards";
		
	}

}
