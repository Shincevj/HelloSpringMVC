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
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping("/hello")
  public String hello(Model model) {
    List<Student> students = this.studentService.findAllStudents();
    model.addAttribute("greeting", students);
    return "helloworld";
  }

  @RequestMapping("/redis")
  public @ResponseBody String helloredis(Model model) {
    Student student = this.studentService.findStudentById(1);
    studentRepository.saveStudent(student);
    return "redis succeed";
  }

  @RequestMapping("/redis_find")
  public String helloreids_find(Model model) {
    Student student = studentRepository.findStudent(1);
    model.addAttribute("redis_find", student);
    return "redis_page";
  }

  @RequestMapping("/welcomeForm")
  public String welcomeForm() {
    return "welcomeForm";
  }

}
