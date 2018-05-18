package com.photo.contest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.photo.contest.model.Category;
import com.photo.contest.model.DiscountData;
import com.photo.contest.model.File;
import com.photo.contest.model.PayStatus;
import com.photo.contest.model.Users;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.photo.contest.model")})
public class HibernateConfig {

	/*@Autowired
	private ApplicationContext context;*/

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		//factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setDataSource(dataSource());
		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.setAnnotatedClasses(Users.class,PayStatus.class,Category.class,DiscountData.class,File.class);
		/*factoryBean.setAnnotatedClasses(PayStatus.class);
		factoryBean.setAnnotatedClasses(Category.class);
		factoryBean.setAnnotatedClasses(DiscountData.class);
		factoryBean.setAnnotatedClasses(File.class);*/
		
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
    public DataSource dataSource() {

    	HikariDataSource ds = new HikariDataSource();
    	ds.setMaximumPoolSize(10);
    	ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
    	ds.addDataSourceProperty("url", "jdbc:mysql://127.0.0.1:3306/salontest?autoReconnect=true");
    	ds.addDataSourceProperty("user", "root");
    	ds.addDataSourceProperty("password", "root1234");
    	ds.addDataSourceProperty("cachePrepStmts", true);
    	ds.addDataSourceProperty("prepStmtCacheSize", 250);
    	ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    	ds.addDataSourceProperty("useServerPrepStmts", true);
    	return ds;
    }
	
	 @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	 Properties hibernateProperties() {
	      return new Properties() {
			{
				//setProperty("hibernate.hbm2ddl.auto", "create-drop");
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
				setProperty("hibernate.show_sql", "true");
				setProperty("hibernate.archive.autodetection", "class,hbm");
				//setProperty("hibernate.globally_quoted_identifiers", "true");
			}
	      };
	   }

}
