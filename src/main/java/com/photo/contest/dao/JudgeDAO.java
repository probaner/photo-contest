package com.photo.contest.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.Judge;
import com.photo.contest.model.Users;


@Repository
public class JudgeDAO {
	
	 private static final Log log = LogFactory.getLog(JudgeDAO.class);
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	 
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	
	 
	 
	 public Integer persist(Judge transientInstance) {
			log.debug("persisting Domain instance");
			try {							 
				 sessionFactory.getCurrentSession().save(transientInstance);
				 log.debug("persist successful");
				 return transientInstance.getJudgeId();
			    } catch (RuntimeException re) {
				         log.error("persist failed", re);
				         throw re;
			            }
		}
	 
	 
	 
	 public Judge findByJudgeId(String email) {
			log.debug("getting User instance with id: " + email);
			try{
				Criteria cr =sessionFactory.getCurrentSession().createCriteria(Judge.class)
						     .add(Restrictions.eq("judgeEmail", email));
				Judge judge = (Judge) cr.uniqueResult();							
				return judge;      		
			   } catch (RuntimeException re) {
				log.error("get failed", re);
				throw re;
			   }				
		}
	 
	 
	 public Judge findByforgetPasswAuthToken(String forgetPasswAuthToken) {
			log.debug("getting User instance with id: " + forgetPasswAuthToken);
			try{
				 //Session session = sessionFactory.getCurrentSession();
				Criteria cr =sessionFactory.getCurrentSession().createCriteria(Judge.class)
						     .add(Restrictions.eq("judgePasswordChangeToken", forgetPasswAuthToken));
				Judge Judge = (Judge) cr.uniqueResult();
							
				return Judge;      		
			   } catch (RuntimeException re) {
				log.error("get failed", re);
				throw re;
			   }
				
		}
	 
	 public Judge findByRegisterURLToken(String judgeRegisterURLToken) {
			log.debug("getting Judge instance with registerURLToken: " + judgeRegisterURLToken);
			try{
				 //Session session = sessionFactory.getCurrentSession();
				Criteria cr =sessionFactory.getCurrentSession().createCriteria(Judge.class)
						     .add(Restrictions.eq("judgeRegistrationToken", judgeRegisterURLToken));
				Judge Judge = (Judge) cr.uniqueResult();
							
				return Judge;      		
			   } catch (RuntimeException re) {
				log.error("get failed", re);
				throw re;
			   }
				
		}

}
