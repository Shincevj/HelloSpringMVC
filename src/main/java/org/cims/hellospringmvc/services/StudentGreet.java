package org.cims.hellospringmvc.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StudentGreet {
  @Before("execution(* org.cims.hellospringmvc.services.StudentService.printStudentName(..))")
  public void pringHello() {
    System.out.println("hello before");
  }
}
