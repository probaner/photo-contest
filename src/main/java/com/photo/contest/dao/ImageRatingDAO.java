package com.photo.contest.dao;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.ImageRating;

@Repository
public class ImageRatingDAO {
	
	 private static final Log log = LogFactory.getLog(CategoryDAO.class);
     @Autowired
	 private SessionFactory sessionFactory;
     
     
     public Integer persist(ImageRating transientInstance) {
 		log.debug("persisting Domain instance");
 		try {			
 			 //Session session = sessionFactory.getCurrentSession();
 			 sessionFactory.getCurrentSession().save(transientInstance);
 			 log.debug("persist successful");
 			 return transientInstance.getId();
 		    } catch (RuntimeException re) {
 			         log.error("persist failed", re);
 			         throw re;
 		             }
 	}

     
     
     public void attachDirty(ImageRating instance) {
			log.debug("attaching dirty User instance");
			try {				 
				 //Session session = sessionFactory.getCurrentSession();
				 sessionFactory.getCurrentSession().saveOrUpdate(instance);
				 log.debug("attach successful");
			} catch (RuntimeException re) {
				log.error("attach failed", re);
				throw re;
			}
		}
     
     /*public Long getRowCount() {
    	 
    	@SuppressWarnings("deprecation")
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(ImageRating.class);
    	crit.setProjection(Projections.rowCount());
    	return (Long)crit.uniqueResult();
     }*/
     
     public void truncate(String tableName) { 
    	 log.debug("truncate ImageRating instance");
			try {
				  sessionFactory.getCurrentSession().createSQLQuery("truncate table "+tableName).executeUpdate();
			    } catch (RuntimeException re) {
		         log.error("persist failed", re);
		         throw re;
	             }
     }
     
     
     public Long getCount() {    	 
    	 Criteria crit = sessionFactory.getCurrentSession().createCriteria(ImageRating.class);
    	 crit.setProjection(Projections.rowCount());
    	 return (Long) crit.uniqueResult();     	 
     }
     
     
     public Optional<List<ImageRating>> getRettinStatusofAJudge(int judgeId){
     	@SuppressWarnings("unchecked")
 		List<ImageRating> results = sessionFactory.getCurrentSession().createCriteria("com.photo.contest.model.ImageRating")
 					.add(Restrictions.eq("judgeId", judgeId)).list();
     	 
     	return Optional.of(results);		
     	 
      }
     
     
}
