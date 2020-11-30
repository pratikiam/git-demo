package com.crs.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
public class DataConfig {
	
		@Value("${spring.datasource.driver-class-name}")
		private String DB_DRIVER;
		
		@Value("${spring.datasource.url}")
		private   String DB_URL = "url";
		
		@Value("${spring.datasource.username}")
		private   String DB_USERNAME = "root";
		
		@Value("${spring.datasource.password}")
		private   String DB_PASSWORD = "password";
		
		@Value("${spring.jpa.show-sql}")
		private   String HIBERNATE_SHOW_SQL;
		
		@Value("${spring.jpa.hibernate.ddl-auto}")
		private   String HIBERNATE_HBM2DDL_AUTO;

//		@Autowired
//		Environment environment;

//		@Bean
//		LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//			LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
//			lfb.setDataSource(dataSource());
//			lfb.setPersistenceProviderClass(HibernatePersistence.class);
//			lfb.setPackagesToScan("com.journaldev.spring.model");
//			lfb.setJpaProperties(hibernateProps());
//			return lfb;
//		}

		@Bean
		DataSource dataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(DB_DRIVER);
			ds.setUrl(DB_URL);
			ds.setUsername(DB_USERNAME);
			ds.setPassword(DB_PASSWORD);
			return ds;			
		}

//		Properties hibernateProps() {
//			Properties properties = new Properties();
//			properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
//			properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
//			return properties;
//		}

		@Bean
		JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
			JpaTransactionManager transactionManager = new JpaTransactionManager();
			transactionManager.setEntityManagerFactory(entityManagerFactory);
			return transactionManager;
		}
	
	
	
}
