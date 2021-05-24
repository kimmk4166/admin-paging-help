package com.project.mentoring.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class PaymentDto {
	
	String username;
	String majorname;
	String submajorname;
	String mentorgender;
	String mentoraddress;
	Date mentorbirth;
	int productpk;
	int starttime;
	int endtime;
	Date startday;
	int schedulepk;
	String endday;
	int totalprice;
	String title;
	String introduce;
	int price;
	int mentor_mentorpk;
	String paymentpk;
	Date paymentpaydate;
	
	public PaymentDto() {
		
	}

	

	public PaymentDto(String username, String majorname, String submajorname, int starttime, int endtime, Date startday,
			int schedulepk, int totalprice, String title, String paymentpk, Date paymentpaydate) {
		super();
		this.username = username;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.startday = startday;
		this.schedulepk = schedulepk;
		this.totalprice = totalprice;
		this.title = title;
		this.paymentpk = paymentpk;
		this.paymentpaydate = paymentpaydate;
	}



	public PaymentDto(String username, String majorname, String submajorname, int starttime, int endtime, Date startday,
			int totalprice, String title) {
		super();
		this.username = username;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.startday = startday;
		this.totalprice = totalprice;
		this.title = title;
	}

	public PaymentDto(String username, String majorname, String submajorname, int productpk) {
		super();
		this.username = username;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.productpk = productpk;
	}

	

	public PaymentDto(String username, String majorname, String submajorname, String mentorgender, String mentoraddress,
			Date mentorbirth) {
		super();
		this.username = username;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.mentorgender = mentorgender;
		this.mentoraddress = mentoraddress;
		this.mentorbirth = mentorbirth;
	}



	public PaymentDto(String username, String majorname, String submajorname, Date startday, int starttime, int endtime) {
		super();
		this.username = username;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public PaymentDto(int schedulepk, Date startday, int starttime, int endtime) {
		super();
		this.schedulepk = schedulepk;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
	}




public PaymentDto(int schedulepk, Date startday, int starttime, int endtime, int totalprice) {
		super();
		this.schedulepk = schedulepk;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalprice = totalprice;
	}



public PaymentDto(int schedulepk, Date startday, String endday, int starttime, int endtime) {
		super();
		this.schedulepk = schedulepk;
		this.startday = startday;
		this.endday = endday;
		this.starttime = starttime;
		this.endtime = endtime;
	}
public PaymentDto(String title, String majorname, String submajorname, int productpk, int price) {
	super();
	this.title = title;
	this.majorname = majorname;
	this.submajorname = submajorname;
	this.productpk = productpk;
	this.price = price;
}
public PaymentDto(String title, String majorname, String submajorname, int productpk, int price, String introduce) {
	super();
	this.title = title;
	this.majorname = majorname;
	this.submajorname = submajorname;
	this.productpk = productpk;
	this.price = price;
	this.introduce=introduce;
}
//-----------------------------------------------------------------------------------------------------

public String getUsername() {
	return username;
}

public String getPaymentpk() {
	return paymentpk;
}

public void setPaymentpk(String paymentpk) {
	this.paymentpk = paymentpk;
}

public Date getPaymentpaydate() {
	return paymentpaydate;
}

public void setPaymentpaydate(Date paymentpaydate) {
	this.paymentpaydate = paymentpaydate;
}

public void setUsername(String username) {
	this.username = username;
}

public String getMajorname() {
	return majorname;
}

public void setMajorname(String majorname) {
	this.majorname = majorname;
}

public String getSubmajorname() {
	return submajorname;
}

public void setSubmajorname(String submajorname) {
	this.submajorname = submajorname;
}

public String getMentorgender() {
	return mentorgender;
}

public void setMentorgender(String mentorgender) {
	this.mentorgender = mentorgender;
}

public String getMentoraddress() {
	return mentoraddress;
}

public void setMentoraddress(String mentoraddress) {
	this.mentoraddress = mentoraddress;
}

public Date getMentorbirth() {
	return mentorbirth;
}

public void setMentorbirth(Date mentorbirth) {
	this.mentorbirth = mentorbirth;
}

public int getProductpk() {
	return productpk;
}

public void setProductpk(int productpk) {
	this.productpk = productpk;
}

public int getStarttime() {
	return starttime;
}

public void setStarttime(int starttime) {
	this.starttime = starttime;
}

public int getEndtime() {
	return endtime;
}

public void setEndtime(int endtime) {
	this.endtime = endtime;
}

public Date getStartday() {
	return startday;
}

public void setStartday(Date startday) {
	this.startday = startday;
}

public int getSchedulepk() {
	return schedulepk;
}

public void setSchedulepk(int schedulepk) {
	this.schedulepk = schedulepk;
}

public String getEndday() {
	return endday;
}

public void setEndday(String endday) {
	this.endday = endday;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getIntroduce() {
	return introduce;
}

public void setIntroduce(String introduce) {
	this.introduce = introduce;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getMentor_mentorpk() {
	return mentor_mentorpk;
}

public void setMentor_mentorpk(int mentor_mentorpk) {
	this.mentor_mentorpk = mentor_mentorpk;
}

public int getTotalprice() {
	return totalprice;
}

public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
	
	
}//------------------------------------------------------------------------