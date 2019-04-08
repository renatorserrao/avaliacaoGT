package br.com.cadastro.conf;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean entityMnagerFactory(){
	 * LocalContainerEntityManagerFactoryBean factoryBean = new
	 * LocalContainerEntityManagerFactoryBean(); JpaVendorAdapter vendorAdapter =
	 * new HibernateJpaVendorAdapter();
	 * 
	 * factoryBean.setJpaVendorAdapter(vendorAdapter);
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setUsername("root"); dataSource.setPassword("root");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/gt4w");
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * 
	 * factoryBean.setDataSource(dataSource);
	 * 
	 * Properties props = new Properties(); props.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL5Dialect");
	 * props.setProperty("hibernate.show_sql", "true");
	 * props.setProperty("hibernate.hbm2ddl.auto", "update");
	 * 
	 * factoryBean.setJpaProperties(props);
	 * 
	 * factoryBean.setPackagesToScan("br.com.cadastro.models");
	 * 
	 * return factoryBean; }
	 */
	
	/*
	 * @Bean public DataSource dataSource(){ DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/gt4ws");
	 * dataSource.setUsername("root"); dataSource.setPassword("root"); return
	 * dataSource; }
	 * 
	 * 
	 * 
	 * @Bean public JpaVendorAdapter jpaVendorAdapter(){ HibernateJpaVendorAdapter
	 * adapter = new HibernateJpaVendorAdapter();
	 * adapter.setDatabase(Database.MYSQL); adapter.setShowSql(true);
	 * adapter.setGenerateDdl(false);
	 * adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	 * adapter.setPrepareConnection(true); return adapter; }
	 */

	
	/*
	 * @Bean public JpaTransactionManager transactionManager(EntityManagerFactory
	 * emf){ return new JpaTransactionManager(emf); }
	 */

}
