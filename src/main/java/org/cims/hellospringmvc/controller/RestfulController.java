package org.cims.hellospringmvc.controller;

import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.services.StudentService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RestfulController {
  @Autowired
  private StudentService studentService;
	
  @RequestMapping("/greeting")
  public Student greeting() {
	Student student = this.studentService.findStudentById(1);
	return student;
  }
}
