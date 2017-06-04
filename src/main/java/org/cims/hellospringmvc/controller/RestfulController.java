package org.cims.hellospringmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.services.StudentService;

import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RestfulController {
  @Autowired
  private StudentService studentService;

  @RequestMapping("/greeting")
  public Student greeting() {
    Student student = this.studentService.findStudentById(1);
    this.studentService.printStudentName(1); //test AOP
    return student;
  }

  @RequestMapping("/record")
  public Student recordStudent(@RequestParam("stud_id") Integer stud_id,
      @RequestParam("name") String name, @RequestParam("email") String email,
      @RequestParam("dob") String dob) throws ParseException {
    Student student = new Student();
    student.setStudId(stud_id);
    student.setName(name);
    student.setEmail(email);
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
    System.out.println(date);
    student.setDob(date);
    studentService.insertStudent(student);
    Student retrieveStudent = this.studentService.findStudentById(stud_id);
    System.out.println(retrieveStudent.getDob());
    return retrieveStudent;
  }
}
