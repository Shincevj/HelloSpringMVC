package org.cims.hellospringmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.log4j.lf5.util.Resource;
import org.cims.hellospringmvc.mappers.StudentMapper;
import org.cims.hellospringmvc.model.Student;
import org.cims.hellospringmvc.services.StudentGreet;
import org.cims.hellospringmvc.services.StudentService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableAspectJAutoProxy
@MapperScan("org.cims.hellospringmvc.mappers")
@ComponentScan(basePackages = {"org.cims.hellospringmvc.repository"})
@PropertySource("classpath:/mysql.properties")
public class DomainConfig {
  @Autowired
  Environment env;
  
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl(env.getProperty("spring.datasource.windows.url"));
    dataSource.setUsername(env.getProperty("spring.datasource.name"));
    dataSource.setPassword(env.getProperty("spring.datasource.password"));
    return dataSource;
  }
  
  @Bean
  public DataSourceTransactionManager transactionManager(DriverManagerDataSource dataSource) {
	  DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
	  return transactionManager;
  }
  
  @Bean
  public Student student() {
    return new Student();
  }
  
  //MyBatis
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    sqlSessionFactory.setDataSource(dataSource());
    sqlSessionFactory.setTypeAliasesPackage("org.cims.hellospringmvc.model");
    
    //ClassPathResource classpathresource = new ClassPathResource("classpath:/META-INF/mappers/StudentMapper.xml");
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/META-INF/mappers/*.xml"));
    return (SqlSessionFactory) sqlSessionFactory.getObject();
  }
  
  @Bean
  public StudentService studentService(StudentMapper studentMapper) {
    StudentService studentService = new StudentService();
    studentService.setStudentMapper(studentMapper);
    return studentService;
  }
  
  //Redis
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    jedisConnectionFactory.setUsePool(true);
    jedisConnectionFactory.setHostName("localhost");
    jedisConnectionFactory.setPort(6379);
    
    return jedisConnectionFactory;
  }
  
  @Bean
  public RedisTemplate<String, Student> redisTemplate() {
    RedisTemplate<String, Student> redisTemplate = new RedisTemplate<String, Student>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }
  
  @Bean
  public StudentGreet studentGreet() {
    return new StudentGreet();
  }

}
