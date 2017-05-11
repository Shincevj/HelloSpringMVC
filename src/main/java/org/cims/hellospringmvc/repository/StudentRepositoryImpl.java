/**
 * 
 */
package org.cims.hellospringmvc.repository;

/**
 * @author fx

 *
 */
import org.cims.hellospringmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.Map;
import javax.annotation.PostConstruct;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	private static String KEY="Student";
	
	private RedisTemplate<String, Student> redisTemplate;
	private HashOperations hashOps;
	
	@Autowired
	private StudentRepositoryImpl(RedisTemplate redisTemplate){
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void init(){
		hashOps = redisTemplate.opsForHash();
	}
	
	public void saveStudent(Student student){
		hashOps.put(KEY, student.getStudId(), student);
	}
	
	public void updateStudent(Student student){
		hashOps.put(KEY, student.getStudId(), student);
	}
	
	public Student findStudent(String studId){
		return (Student) hashOps.get(KEY, studId);
	}
	
	public Map<Object, Object> findAllStudents(){
		return hashOps.entries(KEY);
	}
	
	public void deleteStudent(String studId){
		hashOps.delete(KEY, studId);
	}
}
