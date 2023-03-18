package com.student.model;

import com.student.entity.Course;

import lombok.Data;

@Data
public class StudentDTO {

	private int id;
	private String LName;
	private String FName;
	private String course;
	private Long phone;
	private String email;

}
