package com.project.mentoring.dto;

public class HomePageMentorListDto {
	
	int productPk;
	String mentorImage;
	String mentorTitle;
	String mentorMajor;
	String mentorSubMajor;
	String mentorName;
	
	
	public HomePageMentorListDto() {
		
		
	}
	
	

	public HomePageMentorListDto(int productPk, String mentorImage, String mentorTitle, String mentorMajor,
			String mentorSubMajor, String mentorName) {
		super();
		this.productPk = productPk;
		this.mentorImage = mentorImage;
		this.mentorTitle = mentorTitle;
		this.mentorMajor = mentorMajor;
		this.mentorSubMajor = mentorSubMajor;
		this.mentorName = mentorName;
		
	}



	public int getProductPk() {
		return productPk;
	}

	public void setProductPk(int productPk) {
		this.productPk = productPk;
	}

	public String getMentorImage() {
		return mentorImage;
	}

	public void setMentorImage(String mentorImage) {
		this.mentorImage = mentorImage;
	}

	public String getMentorTitle() {
		return mentorTitle;
	}

	public void setMentorTitle(String mentorTitle) {
		this.mentorTitle = mentorTitle;
	}

	public String getMentorMajor() {
		return mentorMajor;
	}

	public void setMentorMajor(String mentorMajor) {
		this.mentorMajor = mentorMajor;
	}

	public String getMentorSubMajor() {
		return mentorSubMajor;
	}

	public void setMentorSubMajor(String mentorSubMajor) {
		this.mentorSubMajor = mentorSubMajor;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}


	
	
	
	
	

}
