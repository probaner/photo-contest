package com.photo.contest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.photo.contest.model.Category;
import com.photo.contest.model.DiscountData;
import com.photo.contest.model.File;
import com.photo.contest.model.PayStatus;
import com.photo.contest.model.Users;



@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.photo.contest.model")})
public class HibernateConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
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

}
