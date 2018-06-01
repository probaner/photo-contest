package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.dto.EditTableDataDTO;
import com.photo.contest.dto.ResponseDTO;
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
