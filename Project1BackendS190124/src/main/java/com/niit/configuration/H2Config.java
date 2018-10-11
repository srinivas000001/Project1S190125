package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Product;

@Configuration

@EnableTransactionManagement
public class H2Config 
{
	@Bean(name="dataSource")
	
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/BatchS190124");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
		}
   @Bean
	public SessionFactory sessionFactory(){
	
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class};
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
		
	}
   @Bean
  // @Transactional
   public HibernateTransactionManager hibTransManagement(){
	   return new HibernateTransactionManager(sessionFactory());  
	   
   }
}
