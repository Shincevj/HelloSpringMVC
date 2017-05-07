package org.cims.hellospringmvc.persist;

import java.io.IOException;
import java.io.InputStream;

import org.cims.hellospringmvc.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisInsert {
	public static void main(String args[]) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session = sqlSessionFactory.openSession();
		
		//create a new student object
		Student student = new Student("Mohammad", "It", 80, 984803322, "Mohammad@gmail.com");
		session.insert("Student.insert", student);
		System.out.println("record inserted successfully");
		session.commit();
		session.close();
	}
}