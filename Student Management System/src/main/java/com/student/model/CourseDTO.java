package com.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Data
public class CourseDTO {

	private String domain;

	@NotNull
	@Size(min = 1)
	private String coursename;

	@NotNull
	@Size(min = 1)
	private int courseid;

	
}
