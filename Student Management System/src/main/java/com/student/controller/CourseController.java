package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Course;
import com.student.model.CourseDTO;
import com.student.service.CourseService;
import com.student.util.CourseConverter;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseConverter courseConverter;

	// build create course details REST API
	@PostMapping("/createCourse")
	public String createCourse(@RequestBody CourseDTO courseDTO) {
		final Course course = courseConverter.convertToCourseEntity(courseDTO);
		return courseService.createCourse(course);
	}

	// build update course details REST API
	@PutMapping("/updateCourse/{identity}")
	public CourseDTO updateCourse(@PathVariable("identity") int id, @RequestBody CourseDTO courseDTO) {
		Course course1 = courseConverter.convertToCourseEntity(courseDTO);
		return courseService.updateCourse(id, course1);
	}

	// build get all course details REST API
	@GetMapping("/getAllCourses")
	public List<CourseDTO> getAllCourse() {
		return courseService.getAllCourse();
	}

	// build delete student details REST API
	@DeleteMapping("/deleteAllCourses")
	public ResponseEntity<String> deleteAllCourse() {
		courseService.deleteAllCourse();
		return new ResponseEntity<String>("All courses" + "have been deleted", HttpStatus.OK);
	}
}
