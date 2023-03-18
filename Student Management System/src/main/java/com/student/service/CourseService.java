package com.student.service;

import java.util.List;

import com.student.entity.Course;

import com.student.model.CourseDTO;



public interface CourseService {

	String createCourse(Course coursename);

	
	CourseDTO updateCourse(int id, String coursename);
	
	List<CourseDTO> getAllCourse();
	
	void deleteAllCourse();


	String createCourse(String coursename);


	CourseDTO updateCourse(int id, Course course);
	
}
