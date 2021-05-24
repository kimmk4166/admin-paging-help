package com.project.mentoring.dto;

import java.sql.Date;

public class AppointmentDto {
	String username;
	String reviewtitle;
	String reviewtext;
	int reviewscore;
	int reviewpk;
	Date indate;
	public AppointmentDto(int reviewpk, String username, String reviewtitle, String reviewtext, int reviewscore, Date indate) {
		super();
		this.reviewpk = reviewpk;
		this.username = username;
		this.reviewtitle = reviewtitle;
		this.reviewtext = reviewtext;
		this.reviewscore = reviewscore;
		this.indate = indate;
	}
	
	public int getReviewpk() {
		return reviewpk;
	}
	public void setReviewpk(int reviewpk) {
		this.reviewpk = reviewpk;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReviewtitle() {
		return reviewtitle;
	}
	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}
	public String getReviewtext() {
		return reviewtext;
	}
	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}
	public int getReviewscore() {
		return reviewscore;
	}
	public void setReviewscore(int reviewscore) {
		this.reviewscore = reviewscore;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
	
}