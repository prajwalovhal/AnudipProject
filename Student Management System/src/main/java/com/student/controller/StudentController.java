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
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.model.StudentDTO;
import com.student.service.StudentService;
import com.student.util.StudentConverter;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentConverter converter;

	// build create student REST API
	@PostMapping("/createStudent")
	public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO) {
		final Student student = converter.convertToEntity(studentDTO);
		studentService.createStudent(student);
		return new ResponseEntity<String>("New Student details added", HttpStatus.CREATED);
	}

	// build update student details REST API
	@PutMapping("/updateStudent/{identity}")
	public StudentDTO updateStudent(@PathVariable("identity") int id, @RequestBody StudentDTO studentDTO) {
		Student student1 = converter.convertToEntity(studentDTO);
		return studentService.updateStudent(id, student1);
	}

	// build get all student details REST API
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
		studentService.deleteAllStudents();
		return new ResponseEntity<String>("All students details " + "have been deleted", HttpStatus.OK);
	}

	@GetMapping("/getStudentsByCourseid/{courseid}")
	public List<StudentDTO> getStudentsByCourseid(@PathVariable("course") String courseid) {
		return studentService.getStudentsByCourseid(courseid);
	}

	@PostMapping("/assignCourseToStudent/{studentId}/{courseId}")
	public StudentDTO assignCourseToStudent(@PathVariable("studentId") int id, @PathVariable("courseId") int courseId) {
		return studentService.assignCourseToStudent(id, courseId);
	}
}
