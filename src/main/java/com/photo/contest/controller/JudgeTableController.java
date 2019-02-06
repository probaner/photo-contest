package com.photo.contest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photo.contest.dto.JudgeTableDTO;
import com.photo.contest.dto.OrganizerClubDTO;
import com.photo.contest.service.DbServices;

@Controller
public class JudgeTableController {
	
	@Autowired
	DbServices dbServices;
	
	
	@RequestMapping(value = "/admin/json/getjudgetabledata")
	public @ResponseBody LoadDataWrapper judgeTableResourcesJson() throws IOException {
		
		LoadDataWrapper wrapper = new LoadDataWrapper();
		List<JudgeTableDTO> judgeTableDTOList = dbServices.getJudgeTableData();
		List<OrganizerClubDTO> organigerClubList = dbServices.getOrganizerClubDTOList();
		if(null!= judgeTableDTOList && judgeTableDTOList.size()>0 && organigerClubList!=null && organigerClubList.size()>0) {
			wrapper.setData(judgeTableDTOList);
			wrapper.setItemsCount(judgeTableDTOList.size());
			wrapper.setOrganigerClubList(organigerClubList);
			
		}
		return wrapper;
		
	}
	
	
	class LoadDataWrapper {
		List<JudgeTableDTO> data;
		List<OrganizerClubDTO> organigerClubList;
		Integer itemsCount;
		public List<JudgeTableDTO> getData() {
			return data;
		}
		public void setData(List<JudgeTableDTO> data) {
			this.data = data;
		}
		public Integer getItemsCount() {
			return itemsCount;
		}
		public void setItemsCount(Integer itemsCount) {
			this.itemsCount = itemsCount;
		}
		public List<OrganizerClubDTO> getOrganigerClubList() {
			return organigerClubList;
		}
		public void setOrganigerClubList(List<OrganizerClubDTO> organigerClubList) {
			this.organigerClubList = organigerClubList;
		}
		
		
		
	}

}
