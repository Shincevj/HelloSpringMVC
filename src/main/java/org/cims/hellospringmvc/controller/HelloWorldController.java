package org.cims.hellospringmvc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.cims.hellospringmvc.services.StudentService;
import org.cims.hellospringmvc.model.Student;

@Controller
public class HelloWorldController {
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		List<Student> students = this.studentService.findAllStudents();
		model.addAttribute("greeting", students);
		return "helloworld";
	}
}
