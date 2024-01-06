package com.telusko.Demi;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String course;
	private String durations;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String course, String durations) {
		super();
		this.course = course;
		this.durations = durations;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDurations() {
		return durations;
	}
	public void setDurations(String durations) {
		this.durations = durations;
	}

}
