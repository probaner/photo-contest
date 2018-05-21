package com.photo.contest.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class DisplayFileDTO {
	
		private Integer fileId;
		private String categoryname;
		private String titel;
		private String time;
		private String position;
		private String encodedString;
		
		
		public DisplayFileDTO() {
			super();
			// TODO Auto-generated constructor stub
		}


		


		public DisplayFileDTO(Integer fileId, String categoryname, String titel, String time, String position,
				String encodedString) {
			super();
			this.fileId = fileId;
			this.categoryname = categoryname;
			this.titel = titel;
			this.time = time;
			this.position = position;
			this.encodedString = encodedString;
		}





		public Integer getFileId() {
			return fileId;
		}





		public void setFileId(Integer fileId) {
			this.fileId = fileId;
		}





		public String getCategoryname() {
			return categoryname;
		}





		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}





		public String getTitel() {
			return titel;
		}





		public void setTitel(String titel) {
			this.titel = titel;
		}





		public String getTime() {
			return time;
		}





		public void setTime(String time) {
			this.time = time;
		}





		public String getPosition() {
			return position;
		}





		public void setPosition(String position) {
			this.position = position;
		}





		public String getEncodedString() {
			return encodedString;
		}





		public void setEncodedString(String encodedString) {
			this.encodedString = encodedString;
		}





	
			

}
