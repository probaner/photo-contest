package com.photo.contest.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photo.contest.dto.FileDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.dto.UserDTO;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.service.DbServices;
import com.photo.contest.utility.CommonUtil;

@Controller
@SessionAttributes({"userForm","displayFileDTOMap"})
public class FileUploadController {

	@Autowired
	DbServices dbServices;
	@Autowired
	CommonUtil commonUtil;
	
	@PostMapping(value = "/json/saveimage")
	public @ResponseBody ResponseDTO uploadResourcesJson(@ModelAttribute FileDTO fileDTO,
			@ModelAttribute("userForm") UserDTO userDTO) throws IOException, BusinessException {

		ResponseDTO responseDTO = new ResponseDTO();
		if (fileDTO.getAction().equals("save")) {
			CommonsMultipartFile imagecm = fileDTO.getImages();
			if (fileDTO.getTitel().trim().length() > 1 && fileDTO.getTitel().trim().length() < 70) {
				
				commonUtil.imageDimentionValidation(fileDTO.getImages().getBytes());
				
				Integer fileid = dbServices.saveFileData(fileDTO, userDTO);
								
				if (fileid != 0) {
					
					responseDTO.setSuccess(true);
					responseDTO.setMessage("file upload is successful");
					fileDTO.setFileId(fileid);
					fileDTO.setImages(null);
					responseDTO.setData(fileDTO);
					
				} else {
					responseDTO.setSuccess(false);
					responseDTO.setMessage("title should not be same on same catagory");
				
				}
			

			} else if (fileDTO.getTitel() == null) {
				responseDTO.setSuccess(false);
				responseDTO.setMessage("Kindly enter a valid title");
				
			} else if (fileDTO.getTitel().trim().length() > 70) {				
				responseDTO.setSuccess(false);
				responseDTO.setMessage("enter title within 50 chareactere");
			}
		}
		return responseDTO;
	}

	@RequestMapping(value = "/json/deleteimage", headers = {
			"Accept=text/xml, application/json" }, produces = "application/json")
	public @ResponseBody ResponseDTO deleteResourcesJson(@RequestParam String action, HttpServletRequest servletRequest,
			HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, Model model,
			@ModelAttribute("userForm") UserDTO userDTO) throws IOException {

		ResponseDTO responseDTO = new ResponseDTO();

		if (action.equals("delete")) {

			String totalFileData = dbServices.deleteFileData(fileDTO, userDTO);// delete file
			//dbServices.updatePayStatusOfAUser(userDTO);
			responseDTO.setSuccess(true);
			responseDTO.setMessage(totalFileData);

		}

		return responseDTO;
	}

	@RequestMapping(value = "/json/loadimage", headers = {
			"Accept=text/xml, application/json" }, produces = "application/json")
	public @ResponseBody ResponseDTO loadResourcesJson(@RequestParam String action, HttpServletRequest servletRequest,
			HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, Model model,
			@ModelAttribute("userForm") UserDTO userDTO,@ModelAttribute("displayFileDTOMap") HashMap<String,FileDTO> displayFileDTOMap) throws IOException {

		ResponseDTO responseDTO = new ResponseDTO();

		if (action.equals("load")) {
			
			FileDTO d =displayFileDTOMap.get(fileDTO.getCatagoryName()+fileDTO.getPositionName());
			responseDTO.setData(d);
			responseDTO.setSuccess(true);
			//return responseDTO;
		}
			
		return responseDTO;
	}

	/*
	 * @RequestMapping(value = "/json/deleteimage", headers =
	 * {"Accept=text/xml, application/json"}, produces = "application/json")
	 * public @ResponseBody FileDTO deleteResourcesJson(@RequestParam String action,
	 * HttpServletRequest servletRequest, HttpServletResponse
	 * response, @ModelAttribute("product") FileDTO fileDTO, Model
	 * model,@ModelAttribute("userForm") UserDTO userDTO) throws IOException{
	 * FileDTO totalFileData = null; if (action.equals("delete")) {
	 * //System.out.println("fileDTO="+fileDTO.toString()); totalFileData =
	 * dbServices.deleteFileData(fileDTO, userDTO);//delete file
	 * 
	 * 
	 * dbServices.updatePayStatusOfAUser(userDTO);
	 * //System.out.println("totalFileData="+totalFileData); return totalFileData;
	 * }else return new FileDTO();
	 * 
	 * 
	 * }
	 */
}

// http://stackoverflow.com/questions/20193138/very-simple-spring-mvc-button-click