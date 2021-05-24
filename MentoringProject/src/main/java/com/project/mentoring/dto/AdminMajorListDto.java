package com.project.mentoring.dto;

public class AdminMajorListDto {
	
	String majorPk;
	String majorName;
	
	public AdminMajorListDto() {
		
		
	}

	public AdminMajorListDto(String majorPk, String majorName) {
		super();
		this.majorPk = majorPk;
		this.majorName = majorName;
	}

	public String getMajorPk() {
		return majorPk;
	}

	public void setMajorPk(String majorPk) {
		this.majorPk = majorPk;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	
	
}
