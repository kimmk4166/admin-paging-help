package com.project.mentoring.dto;

import java.sql.Timestamp;

public class AdminUserListDto {
	String userId;
	String userName;
	String userPhone;
	String userEmail;
	String userCheck;
	Timestamp userInDate;
	Timestamp userOutDate;
	
	public AdminUserListDto() {
		
	}

	

	public AdminUserListDto(String userId, String userName, String userPhone, String userEmail, String userCheck,
			Timestamp userInDate, Timestamp userOutDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userCheck = userCheck;
		this.userInDate = userInDate;
		this.userOutDate = userOutDate;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserCheck() {
		return userCheck;
	}



	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}



	public Timestamp getUserInDate() {
		return userInDate;
	}



	public void setUserInDate(Timestamp userInDate) {
		this.userInDate = userInDate;
	}



	public Timestamp getUserOutDate() {
		return userOutDate;
	}



	public void setUserOutDate(Timestamp userOutDate) {
		this.userOutDate = userOutDate;
	}



	

	
	
}
