package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FName", nullable = false)
	private String FName;

	@Column(name = "LName", nullable = false)
	private String LName;
	
	@Column(name = "phone", nullable = false)
	private Long phone;
	
	@Column(name = "email", nullable = false)
	private String email;



	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Course course;



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Builder
	public Student(int id, String fName, String lName, Long phone, String email, Course course) {
		super();
		this.id = id;
		FName = fName;
		LName = lName;
		this.phone = phone;
		this.email = email;
		this.course = course;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFName() {
		return FName;
	}



	public void setFName(String fName) {
		FName = fName;
	}



	public String getLName() {
		return LName;
	}



	public void setLName(String lName) {
		LName = lName;
	}



	public Long getPhone() {
		return phone;
	}



	public void setPhone(Long phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
