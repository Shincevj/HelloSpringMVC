package org.cims.hellospringmvc.services;

// import org.cims.hellospringmvc.config.ServletConfig;
import org.cims.hellospringmvc.config.DomainConfig;
import org.cims.hellospringmvc.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.util.Date;

import static org.hamcrest.Matchers.equalToIgnoringCase;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfig.class})
public class StudentServiceTest {
  @Autowired
  private StudentService studentService;

  // static final Logger logger = LoggerFactory.getLogger("testLogger");

  @Test
  public void testStudentService() {
    assertThat(this.studentService.printStudentName(1), equalToIgnoringCase("Tom"));
    assertThat(studentService, instanceOf(StudentService.class));
    // logger.debug("logger test");
  }

  @Test
  @Transactional
  public void testInsertStudent() {
    Student student = new Student();
    student.setStudId(44);
    student.setName("Unit");
    student.setEmail("Unit@test.com");
    student.setDob(new Date());
    this.studentService.insertStudent(student);
    assertThat(this.studentService.printStudentName(44), equalToIgnoringCase("Unit"));

  }
}
