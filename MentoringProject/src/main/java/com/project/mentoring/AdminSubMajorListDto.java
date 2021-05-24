package com.project.mentoring.dto;

public class AdminSubMajorListDto {
	String submajorPk;
	String submajorName;
	
	public AdminSubMajorListDto() {
		
	}
	

	public AdminSubMajorListDto(String submajorName) {
		super();
		this.submajorName = submajorName;
	}


	public AdminSubMajorListDto(String submajorPk, String submajorName) {
		super();
		this.submajorPk = submajorPk;
		this.submajorName = submajorName;
	}

	public String getSubmajorPk() {
		return submajorPk;
	}

	public void setSubmajorPk(String submajorPk) {
		this.submajorPk = submajorPk;
	}

	public String getSubmajorName() {
		return submajorName;
	}

	public void setSubmajorName(String submajorName) {
		this.submajorName = submajorName;
	}
	
	
	
	
}
