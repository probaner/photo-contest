package com.photo.contest.dto;

public class JudgeFileProcessDropDownDTO {
	
	private String statement;
	private Integer count;
			
	public JudgeFileProcessDropDownDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JudgeFileProcessDropDownDTO(String statement, Integer count) {
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "JudgeFileProcessDropDownDTO [statement=" + statement + ", count=" + count + "]";
	}
	
	
		

}
