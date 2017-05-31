package org.cims.hellospringmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
public class DomainConfig {
  
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource datasource = new DriverManagerDataSource();
    datasource.setDriverClassName("com.mysql.jdbc.Driver");
    //datasource.setUrl("jdbc:mysql://localhost:3306/MySQL");
    datasource.setUrl("jdbc:mysql://localhost:3306/hellospring");
    datasource.setUsername("root");
    datasource.setPassword("234458");
    return datasource;
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
  public RedisTemplate redisTemplate() {
    RedisTemplate redisTemplate = new RedisTemplate();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }
  
  @Bean
  public StudentGreet studentGreet() {
    return new StudentGreet();
  }

}
