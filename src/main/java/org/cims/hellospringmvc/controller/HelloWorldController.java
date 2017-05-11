package org.cims.hellospringmvc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import org.cims.hellospringmvc.services.StudentService;
import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.repository.*;

@Controller
public class HelloWorldController {
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		List<Student> students = this.studentService.findAllStudents();
		model.addAttribute("greeting", students.toString());
		return "helloworld";
	}
	
	@RequestMapping("/redis")
	public @ResponseBody String helloredis(Model model) {
		Student student = this.studentService.findStudentById(1);
		studentRepository.saveStudent(student);
		return "redis succeed";
	}
}
