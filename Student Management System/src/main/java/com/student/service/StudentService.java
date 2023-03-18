package com.student.service;

import com.student.entity.Student;
import com.student.model.StudentDTO;

import java.util.List;

import com.student.entity.Student;
import com.student.model.StudentDTO;


public interface StudentService {

	String createStudent(Student student);

	StudentDTO updateStudent(int id, Student student);

	List<StudentDTO> getAllStudents();

	void deleteAllStudents();

	List<StudentDTO> getStudentsByCourseName(String courseName);

	StudentDTO assignCourseToStudent(int id, int courseId);

	List<StudentDTO> getStudentsByCourseid(String courseid);

	List<StudentDTO> getStudentsByCourseid(int courseid);

}
