package com.student.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.student.entity.Course;
import com.student.model.CourseDTO;

@Component
public class CourseConverter {

	// convert from courseDTO to entity(course)
	public Course convertToCourseEntity(CourseDTO courseDTO) {
		Course course = new Course();
		if (courseDTO != null) {
			BeanUtils.copyProperties(courseDTO, course);
		}
		return course;
	}

	// convert from entity to courseDTO
	public CourseDTO convertToCourseDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		if (course != null) {
			BeanUtils.copyProperties(course, courseDTO);
		}
		return courseDTO;
	}

}
