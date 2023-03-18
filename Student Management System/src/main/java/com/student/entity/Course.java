package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String domain;;

	@Column(length = 50)
	private String coursename;

	@Column(length = 10)
	private int courseid;


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Course(String domain, String coursename, int courseid) {
		super();
		this.domain = domain;
		this.coursename = coursename;
		this.courseid = courseid;
	}


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCourseName() {
		return coursename;
	}

	public void setName(String name) {
		this.coursename = name;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	

}
