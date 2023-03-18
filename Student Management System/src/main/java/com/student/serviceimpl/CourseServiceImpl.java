package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Course;
import com.student.model.CourseDTO;
import com.student.repository.CourseRepository;
import com.student.service.CourseService;
import com.student.util.CourseConverter;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseConverter courseConverter;

	@Override
	public String createCourse(Course course) {
		String message = null;
		courseRepository.save(course);
		if (course != null) {
			message = "New course saved successfully!!";
		} else {
			message = "Course is not saved!!";
		}
		return message;
	}

	@Override
	public CourseDTO updateCourse(int id, Course course) {
		// TODO Auto-generated method stub

		Course existingCourse = courseRepository.findById(id).get();
		existingCourse.setDomain(course.getDomain());
		existingCourse.setName(course.getCourseName());
		existingCourse.setCourseid(course.getCourseid());

		courseRepository.save(existingCourse);
		return courseConverter.convertToCourseDTO(existingCourse);

	}

	@Override
	public List<CourseDTO> getAllCourse() {
		// TODO Auto-generated method stub
		List<Course> courses = courseRepository.findAll();
		List<CourseDTO> cDTO = new ArrayList<>();
		for (Course c : courses) {
			cDTO.add(courseConverter.convertToCourseDTO(c));
		}
		return cDTO;
	}

	@Override
	public void deleteAllCourse() {
		// TODO Auto-generated method stub
		courseRepository.deleteAll();

	}

	@Override
	public String createCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO updateCourse(int id, String course) {
		// TODO Auto-generated method stub
		return null;
	}

}
