package org.cims.hellospringmvc.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.mappers.StudentMapper;

public class StudentService {
  private Logger logger = LoggerFactory.getLogger(getClass());
  private StudentMapper studentMapper;

  public void setStudentMapper(StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
  }

  public List<Student> findAllStudents() {
    return this.studentMapper.findAllStudents();
  }

  public Student findStudentById(Integer studId) {
    logger.debug("Select Student Student By ID :{}", studId);
    return this.studentMapper.findStudentById(studId);
  }

  public void insertStudent(Student student) {
    this.studentMapper.insertStudent(student);
  }
}
