/**
 * 
 */
package org.cims.hellospringmvc.repository;

/**
 * @author FuXin
 *
 */
import org.cims.hellospringmvc.model.Student;

import java.util.Map;

public interface StudentRepository {
  void saveStudent(Student student);

  void updateStudent(Student student);

  Student findStudent(Integer studId);

  Map<Integer, Student> findAllStudents();

  void deleteStudent(Integer studId);
}
