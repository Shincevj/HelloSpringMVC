package org.cims.hellospringmvc.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class StudentGreet {
  private static final Logger logger = LoggerFactory.getLogger(StudentGreet.class);
  @Before("execution(* org.cims.hellospringmvc.services.StudentService.printStudentName(..))")
  public void pringHello() {
    //System.out.println("hello from aspect test");
    logger.info("test aspect and logger");
  }
}
