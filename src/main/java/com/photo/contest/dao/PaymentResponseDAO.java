package com.photo.contest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.PaymentResponse;

@Repository
public class PaymentResponseDAO {
	
	
	 private static final Log log = LogFactory.getLog(PaymentResponseDAO.class);
     
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }	 
	 
	 public String persist(PaymentResponse transientInstance) {
			log.debug("persisting Domain instance");
			try {							
				 sessionFactory.getCurrentSession().save(transientInstance);				 
				 log.debug("persist successful");
				 return transientInstance.getId();
			    } catch (RuntimeException re) {
				         log.error("persist failed", re);
				         throw re;
			             }
		}

}
