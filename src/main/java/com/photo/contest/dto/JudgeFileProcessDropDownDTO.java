package com.photo.contest.dto;

public class JudgeFileProcessDropDownDTO {
	
	private String statement;
	private String count;
			
	public JudgeFileProcessDropDownDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public JudgeFileProcessDropDownDTO(String statement, String count) {
		super();
		this.statement = statement;
		this.count = count;
	}




	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "JudgeFileProcessDropDownDTO [statement=" + statement + ", count=" + count + "]";
	}
	
	
		

}
