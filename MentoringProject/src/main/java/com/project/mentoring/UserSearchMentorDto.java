package com.project.mentoring.dto;

public class UserSearchMentorDto {
	
	String mentorImage;
	String mentorMajor;
	String mentorTitle;
	String subMajor;
	String productPk;
	String mentorName;
	String mentorPrice;
	
	public UserSearchMentorDto(String mentorImage, String mentorMajor, String mentorTitle, String subMajor,
			String productPk, String mentorName, String mentorPrice) {
		super();
		this.mentorImage = mentorImage;
		this.mentorMajor = mentorMajor;
		this.mentorTitle = mentorTitle;
		this.subMajor = subMajor;
		this.productPk = productPk;
		this.mentorName = mentorName;
		this.mentorPrice = mentorPrice;
	}
	
	public String getMentorImage() {
		return mentorImage;
	}
	public void setMentorImage(String mentorImage) {
		this.mentorImage = mentorImage;
	}
	public String getMentorMajor() {
		return mentorMajor;
	}
	public void setMentorMajor(String mentorMajor) {
		this.mentorMajor = mentorMajor;
	}
	public String getMentorTitle() {
		return mentorTitle;
	}
	public void setMentorTitle(String mentorTitle) {
		this.mentorTitle = mentorTitle;
	}
	public String getSubMajor() {
		return subMajor;
	}
	public void setSubMajor(String subMajor) {
		this.subMajor = subMajor;
	}
	public String getProductPk() {
		return productPk;
	}
	public void setProductPk(String productPk) {
		this.productPk = productPk;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getMentorPrice() {
		return mentorPrice;
	}
	public void setMentorPrice(String mentorPrice) {
		this.mentorPrice = mentorPrice;
	}
	
	
	
	
}
