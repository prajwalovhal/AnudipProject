package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Course;
import com.student.entity.Student;
import com.student.exception.ResourceNotFoundException;
import com.student.model.StudentDTO;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.StudentConverter;

@Service
public  class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentConverter studentConverter;

	@Override
	public String createStudent(Student student) {
		// TODO Auto-generated method stub
		String message = null;
		studentRepository.save(student);
		if (student != null) {
			message = "Student details saved successfully";
		}
		return message;
	}

	@Override
	public StudentDTO updateStudent(int id, Student student) {
		// TODO Auto-generated method stub

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setFName(student.getFName());
		existingStudent.setLName(student.getLName());

		studentRepository.save(existingStudent);
		return studentConverter.convertToStudentDTO(existingStudent);

	}

	@Override
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();

		List<StudentDTO> sDTO = new ArrayList<>();
		for (Student s : students) {
			sDTO.add(studentConverter.convertToStudentDTO(s));
		}
		return sDTO;
	}

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		studentRepository.deleteAll();

	}

	@Override
	public List<StudentDTO> getStudentsByCourseName(String courseName) {
		List<Student> allStudents = studentRepository.findAll().stream()
				.filter(s -> s.getCourse().getCourseName().equalsIgnoreCase(courseName)).collect(Collectors.toList());
		List<StudentDTO> studentDTOs = new ArrayList<>();
		for (Student s : allStudents) {
			studentDTOs.add(studentConverter.convertToStudentDTO(s));
		}
		return studentDTOs;
	}

	@Override
	public StudentDTO assignCourseToStudent(int id, int courseId) {
		Student student = studentRepository.findById(id).get();
		Course course = courseRepository.findById(courseId).get();
		student.setCourse(course);
		studentRepository.save(student);
		return studentConverter.convertToStudentDTO(student);
	}

	@Override
	public List<StudentDTO> getStudentsByCourseid(int courseid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getStudentsByCourseid(String courseid) {
		// TODO Auto-generated method stub
		return null;
	}

}
