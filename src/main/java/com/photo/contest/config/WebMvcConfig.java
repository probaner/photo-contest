package com.photo.contest.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.photo.contest"})
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	ConfigProperty configProperty;

	@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20848820);
        return multipartResolver;
    }
	
   @Bean
   public InternalResourceViewResolver ViewResolvers() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   /**
    * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
    */
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/resources/**")
                   .addResourceLocations("/static/")
                   .setCachePeriod(31556926);
   }


   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
   
   
  /* @Bean
   public JavaMailSender javaMailService() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("mail.vibgyorcircuit");
	    mailSender.setPort(587);//try with 25/587	     
	    mailSender.setUsername("support@vibgyorcircuit.co");
	    //mailSender.setPassword("password");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "false");//Put  false, if no https is needed
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
		
	}*/
   
   @Bean
   public JavaMailSender javaMailService() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);//try with 25/587	     
	    mailSender.setUsername(configProperty.getMailsender());
	    mailSender.setPassword(configProperty.getMailpassword());
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "false");//Put  false, if no https is needed
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
		
	}
   
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
       //this will map uri to jsp view directly without a controller
      /* registry.addViewController("/login").setViewName("login");*/
       registry.addViewController("/accessDenied").setViewName("accessDenied");
       /*registry.addViewController("/imageViewer").setViewName("imageViewer");*/
       registry.addViewController("/registrationconfirm").setViewName("registrationconfirm"); 
       registry.addViewController("/paymentSuccess").setViewName("paymentSuccess");   
   }
   
   
   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }
}
