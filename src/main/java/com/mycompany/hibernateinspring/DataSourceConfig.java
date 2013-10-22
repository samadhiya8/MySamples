/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateinspring;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Samadhiya
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass=true, mode=AdviceMode.PROXY)
public class DataSourceConfig {
    
    @Bean(name="dataSource")
    public org.apache.commons.dbcp.BasicDataSource dataSource(){
        
        org.apache.commons.dbcp.BasicDataSource ds= new org.apache.commons.dbcp.BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/firstexample");
        ds.setUsername("root");
        ds.setPassword("samadhiya");
        ds.setMaxActive(20);
        return ds;
        
    }
    @Bean
    public org.springframework.jdbc.core.JdbcTemplate jdbcTemplate(){
        return new org.springframework.jdbc.core.JdbcTemplate(dataSource()) ;
        
    }
   
   /* @Bean
    public SessionFactory sessionFactory(){
        org.springframework.orm.hibernate4.LocalSessionFactoryBuilder sessionF= new
                org.springframework.orm.hibernate4.LocalSessionFactoryBuilder(dataSource());
        //sessionF.setDataSource(new com.mycompany.dbinspring.DataSourceConfig().dataSource());
        sessionF.scanPackages("com.mycompany.hibernateinspring");
        sessionF.setProperties(hibernateProperties());
        return sessionF.buildSessionFactory();
    }*/
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionF= new LocalSessionFactoryBean();
        sessionF.setDataSource(dataSource());
        sessionF.setPackagesToScan("com.mycompany.hibernateinspring");
        sessionF.setHibernateProperties(hibernateProperties());
        //sessionF.setJtaTransactionManager(jtaTrxManager());
        return sessionF;
    }
    @Bean
    public Properties hibernateProperties(){
        Properties p = new Properties();
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        //p.setProperty("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");
        //p.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        return p;
    }
   @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager manager= new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory().getObject());
       // manager.setSessionFactory( sessionFactory());
        return manager;
    }
    @Bean 
    public EmployeeDAO eDAO(){
        EmployeeDAO ed= new EmployeeDAO();
        ed.setSessionFactory(sessionFactory().getObject());
        return ed;
    }
    @Bean
    public Employee Ramesh(){
        Employee ramesh=new Employee();
        ramesh.setAge(34);
        ramesh.setDeptId(2300);
        ramesh.setEmpNo(3456);
        ramesh.setName("Sitaram yechuri");
        ramesh.setPost("PM");
        return ramesh;
    }
    
    @Bean
    public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator(){
      AnnotationAwareAspectJAutoProxyCreator annotationAspect= new AnnotationAwareAspectJAutoProxyCreator();
      annotationAspect.setProxyTargetClass(true);
      return annotationAspect;
    }
    
    @Bean 
    public LoggerAspect loggerAspect(){
    	return new LoggerAspect();
    }
    
}
