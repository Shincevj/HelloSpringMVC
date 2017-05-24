package org.cims.hellospringmvc.controller;

import org.cims.hellospringmvc.model.Student;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RestfulController {
  @RequestMapping("/greeting")
  public Student greeting() {
	return new Student();
  }
}
