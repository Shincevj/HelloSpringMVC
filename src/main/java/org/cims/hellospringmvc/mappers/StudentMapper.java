package org.cims.hellospringmvc.mappers;

import java.util.List;
import org.cims.hellospringmvc.model.Student;

public interface StudentMapper {
  List<Student> findAllStudents();

  Student findStudentById(Integer id);

  void insertStudent(Student student);
}
