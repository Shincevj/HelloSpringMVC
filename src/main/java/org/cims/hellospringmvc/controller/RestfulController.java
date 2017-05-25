package org.cims.hellospringmvc.controller;

import java.util.Date;

import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.services.StudentService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RestfulController {
  @Autowired
  private StudentService studentService;
	
  @RequestMapping("/greeting")
  public Student greeting() {
	Student student = this.studentService.findStudentById(1);
	return student;
  }
  
  @RequestMapping("/record")
  public Student recordStudent(@RequestParam("stud_id") Integer stud_id,
		                       @RequestParam("name") String name,
		                       @RequestParam("email") String email
		                       ) {
	  Student student = new Student();
	  student.setStudId(stud_id);
	  student.setName(name);
	  student.setEmail(email);
	  student.setDob(new Date());
	  studentService.insertStudent(student);
	  Student retrieveStudent = this.studentService.findStudentById(stud_id);
	  return retrieveStudent;
  }
}
