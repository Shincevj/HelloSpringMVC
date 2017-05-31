package org.cims.hellospringmvc.services;

//import org.cims.hellospringmvc.config.ServletConfig;
import org.cims.hellospringmvc.config.DomainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfig.class})
public class StudentServiceTest {
  @Autowired
  private StudentService studentService;
  
  @Test
  public void testStudentService() {
    //this.studentService.printStudentName();
    assertThat(studentService, instanceOf(StudentService.class));
  }
}
