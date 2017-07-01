package com.wowwebapp.config;

import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${db.url}")
	private String DB_URL;
	
	@Value("${db.password}")
	private String DB_PASSWORD;
	
	@Value("${db.driver}")
	private String DB_DRIVER;
	
	@Value("${db.username}")
	private String DB_USERNAME;
	
	@Value("${hibernate.dialect}")
	private String HB_DIALECT;
	
	@Value("${hibernate.show_sql}")
	private String HB_SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;
	
	@Value("${entitymanager.packagesToScan}")
	private String PACKAGE_TO_SCAN;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Bean
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(getDataSource());
		sfb.setPackagesToScan(PACKAGE_TO_SCAN);
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", HB_DIALECT);
		prop.setProperty("hibernate.show_sql", HB_SHOW_SQL);
		prop.setProperty("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		prop.setProperty("hibernate.cache.use_second_level_cache", "false");
		sfb.setHibernateProperties(prop);
		return sfb;
	}
	
	@Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getListByCriteria(Class<T> classname, List<Criterion> criterion){
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session :" + session.isConnected());
		Criteria cr = session.createCriteria(classname);
		
		if(criterion != null){
			criterion.forEach((temp) ->{
				cr.add(temp);
			});	
		}
		
		return cr.list();
	}
	
	public int saveRecord(Object entity){
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session :" + session.isConnected());
		return (int) session.save(entity);
	}
	
	
}
