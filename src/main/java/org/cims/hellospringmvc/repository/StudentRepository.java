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
	Map<Object, Object> findAllStudents();
	void deleteStudent(Integer studId);
}
