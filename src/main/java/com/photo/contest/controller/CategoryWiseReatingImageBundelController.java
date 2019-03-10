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
import com.photo.contest.dto.DisplayReatingImageDTO;
import com.photo.contest.dto.ImageRatingDTOContainer;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.service.CommonServices;

@Controller
@SessionAttributes({"userForm"})
public class CategoryWiseReatingImageBundelController {
	
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private CommonServices commonService;
	
	@RequestMapping("/judge/judgeingcategory")
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
		  
		 
		  
		  List<DisplayReatingImageDTO> displayReatingImageDTOList = commonService.getImageReatingData (categoryDTO.getCategoryName());
		  ImageRatingDTOContainer container = new ImageRatingDTOContainer();
		  container.setImageList(displayReatingImageDTOList);
		   model.addAttribute("displayReatingImageDTOList", container);
		  		
				return "imagereating";
		
	}
	
	
	@RequestMapping(value = "/judge/rate", method = RequestMethod.POST)
	public String saveUsers(@ModelAttribute("displayReatingImageDTOList") ImageRatingDTOContainer imageRatingDTOContainer,Model model) throws Exception{
	    List<DisplayReatingImageDTO> displayReatingImageDTOList = imageRatingDTOContainer.getImageList();
	    for(DisplayReatingImageDTO displayReatingImageDTO : displayReatingImageDTOList) {
	        System.out.println("Image Id- " + displayReatingImageDTO.getImageId() + " Rating-> " +displayReatingImageDTO.getReating());
	    }
	    //insert to db
	    
	    model.addAttribute("message", "Rating saved successfully");
	    model.addAttribute("displayReatingImageDTOList", imageRatingDTOContainer);
	    return "imagereating";
	}

}