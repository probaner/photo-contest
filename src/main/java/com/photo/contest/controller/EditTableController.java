package com.photo.contest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.dto.EditTableDataDTO;
import com.photo.contest.dto.FileDTO;
import com.photo.contest.dto.ResponseDTO;
import com.photo.contest.exception.ApplicationException;
import com.photo.contest.exception.BusinessException;
import com.photo.contest.service.DbServices;

@Controller
public class EditTableController {
	
	@Autowired
	DbServices dbServices;
	
	
	@RequestMapping(value = "/admin/json/getedittabledata")
	public @ResponseBody LoadDataWrapper editTableResourcesJson() throws IOException {
		
		LoadDataWrapper wrapper = new LoadDataWrapper();
		List<EditTableDataDTO> editTableDataDTOList = dbServices.getEditTableData();
		if(null!= editTableDataDTOList && editTableDataDTOList.size()>0) {
			wrapper.setData(editTableDataDTOList);
			wrapper.setItemsCount(editTableDataDTOList.size());
			//System.out.println("editTableDataDTOList.size()="+editTableDataDTOList.size());
		}
		
		
		return wrapper;		
	}
	
	
	
	@RequestMapping(value = "/admin/json/updateedittable")
	public @ResponseBody ResponseDTO updateedittableJson(@RequestBody EditTableDataDTO editTableDataDTO) throws  BusinessException {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		if(editTableDataDTO != null) {
		   dbServices.updateUserDataByEditTable(editTableDataDTO);
		   responseDTO.setSuccess(true);
		  }
		return responseDTO;
		
}
	@GetMapping(value = "/admin/json/fetchImagesForUser/{userId}")
	public @ResponseBody ResponseDTO fetchAllImagesForUser(@PathVariable(name = "userId") String userId) throws  BusinessException, ApplicationException {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		if(userId != null) {
			HashMap<String,List<FileDTO>> result = dbServices.getAllImagesOfaUser(userId);
			if(result.size()>0)
				responseDTO.setData(result);
			    responseDTO.setSuccess(true);
		  }
		return responseDTO;
		
}
	
	@GetMapping(value = "/imageViewer/{userId}")
	public String fetchAllImagesPageForUser(@PathVariable(name = "userId") String userId,Map<String, Object> model) throws  BusinessException, ApplicationException {
		
		model.put("userId", userId);	
		return "imageViewer";
		
}
	
	
	class LoadDataWrapper {
		List<EditTableDataDTO> data;
		Integer itemsCount;
		public List<EditTableDataDTO> getData() {
			return data;
		}
		public void setData(List<EditTableDataDTO> data) {
			this.data = data;
		}
		public Integer getItemsCount() {
			return itemsCount;
		}
		public void setItemsCount(Integer itemsCount) {
			this.itemsCount = itemsCount;
		}
		
	}
	
	
	

}
