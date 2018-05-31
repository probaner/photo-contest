package com.photo.contest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] {WebMvcConfig.class , HibernateConfig.class, SecurityConfiguration.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { /*WebMvcConfig.class*/ };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}
