package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryBean", basePackages = {
		"com.demo.first.Dao" }, transactionManagerRef = "transactionManager")
public class MySQLconfig {

	@Autowired
	private Environment enviroment; // read the content of properties file

	// datasouce
	@Bean
	@Primary
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(enviroment.getProperty("spring.second.datasource.url"));
		dataSource.setUsername(enviroment.getProperty("spring.second.datasource.username"));
		dataSource.setPassword(enviroment.getProperty("spring.second.datasource.password"));
		dataSource.setDriverClassName(enviroment.getProperty("spring.second.datasource.driver-class-name"));
		return dataSource;
	}

	// entityManagerFactory
	@Primary
	@Bean(name = "entityManagerFactoryBean")
//the EntityManagerFactory can then be passed to JPA-based DAOs via dependency injection. 
// provide instance of entityManeger connection with same database	
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() { // thats create jpa
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); // pass the Specific behaviour into the //
																	// entitymanagerfactory
		bean.setJpaVendorAdapter(adapter);

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		bean.setJpaPropertyMap(props);
		bean.setPackagesToScan("com.demo.first.entity");
		return bean;

	}

	// platform TransactionManager
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}
}
