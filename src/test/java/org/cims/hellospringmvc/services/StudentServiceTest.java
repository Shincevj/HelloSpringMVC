package org.cims.hellospringmvc.services;

import java.util.*;
import org.junit.*;

import junit.framework.Assert;

import org.cims.hellospringmvc.model.Student;

public class StudentServiceTest {
	private static StudentService studentService;
	@BeforeClass
	public static void setup(){
		studentService = new StudentService();
	}
	@AfterClass
	public static void teardown(){
		studentService = null;
	}
	@Test
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students){
			System.out.println(student);
		}
	}
}
