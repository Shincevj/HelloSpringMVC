package org.cims.hellospringmvc.persist;

import org.cims.hellospringmvc.services.StudentService;
import org.cims.hellospringmvc.model.Student;

import java.util.*;

public class MybatisMain {
	public static void main(String args[]){
		StudentService studentService = new StudentService();
		List<Student> students = studentService.findAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("MyBatis test succeeds!");
	}
}
