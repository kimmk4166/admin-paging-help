package com.project.mentoring.dto;

import java.sql.Timestamp;

public class AdminAnnouncementListDto {
	int noticepk;
	int admin_adminpk;
	String noticetitle;
	String noticetext;
	Timestamp indate;
	Timestamp outdate;
	
	public AdminAnnouncementListDto() {

	}

	

	public AdminAnnouncementListDto(int noticepk, int admin_adminpk, String noticetitle, String noticetext, Timestamp indate, Timestamp outdate) {
		super();
		this.noticepk = noticepk;
		this.admin_adminpk = admin_adminpk;
		this.noticetitle = noticetitle;
		this.noticetext = noticetext;
		this.indate = indate;
		this.outdate = outdate;
	}

	public int getnoticepk() {
		return noticepk;
	}
	
	public void setnoticepk(int noticepk) {
		this.noticepk = noticepk;
	}

	public int getadmin_adminpk() {
		return admin_adminpk;
	}
	
	public void setadmin_adminpk(int admin_adminpk) {
		this.admin_adminpk = admin_adminpk;
	}

	public String getnoticetitle() {
		return noticetitle;
	}


	public void setnoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}


	public String getnoticetext() {
		return noticetext;
	}

	public void setnoticetext(String noticetext) {
		this.noticetext = noticetext;
	}

	public Timestamp getindate() {
		return indate;
	}

	public void setindate(Timestamp indate) {
		this.indate = indate;
	}
	
	public Timestamp getoutdate() {
		return outdate;
	}
	
	public void setoutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	
}