package org.cims.hellospringmvc.services;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.mappers.StudentMapper;
import org.cims.hellospringmvc.util.MyBatisSqlSessionFactory;

public class StudentService {
	private Logger logger = 
	LoggerFactory.getLogger(getClass());
	
	public List<Student> findAllStudents(){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		}finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentById(Integer studId){
		logger.debug("Select Student Student By ID :{}", studId);
		SqlSession sqlSession = 
		MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = 
			sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	public void createStudent(Student student){
		SqlSession sqlSession = 
		MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper =
			sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
