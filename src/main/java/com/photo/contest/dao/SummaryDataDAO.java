package com.photo.contest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.ImageRating;
import com.photo.contest.model.SummaryData;

@Repository
public class SummaryDataDAO {
	
	private static final Log log = LogFactory.getLog(SummaryDataDAO.class);
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Integer persist(SummaryData transientInstance) {
			log.debug("persisting Domain instance");
			try {			
				 //Session session = sessionFactory.getCurrentSession();
				 sessionFactory.getCurrentSession().save(transientInstance);
				 log.debug("persist successful");
				 return transientInstance.getId();
			    } catch (RuntimeException re ) {
				         log.error("persist failed", re);
				         throw re;
			             }
		}
		 
		 public void attachDirty(SummaryData instance)  {
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
		 
		 public Long getCount() {    	 
	    	 Criteria crit = sessionFactory.getCurrentSession().createCriteria(SummaryData.class);
	    	 crit.setProjection(Projections.rowCount());
	    	 return (Long) crit.uniqueResult();     	 
	     }
		 
		 public List getDistinctId(String type){
			 
			 Criteria criteria = 
					 sessionFactory.getCurrentSession().createCriteria(SummaryData.class).setProjection(
					        Projections.distinct(Projections.property(type)));
					List<?> rsList = criteria.list();
					System.out.println(rsList);
					
					return rsList;
			 
		 }
		 
		 
		 public SummaryData getSummaryData(SummaryData summaryData) {
		   		log.debug("getting User instance with ImageRating obj : " );
		   		try{
		   			@SuppressWarnings("deprecation")
		  			Criteria cr =sessionFactory.getCurrentSession().createCriteria(SummaryData.class)
		   					     .add(Restrictions.eq("imageId", summaryData.getImageId()))
		   					     .add(Restrictions.eq("orginizerClubId", summaryData.getOrginizerClubId()));
		   			
		   			@SuppressWarnings("unchecked")
		   			SummaryData instace=  (SummaryData) cr.uniqueResult();
		   				//System.out.println("instace="+instace);		
		   			return instace;      		
		   		   } catch (RuntimeException re) {
		   			log.error("get failed", re);
		   			throw re;
		   		   }		   			
		   	}
	 

}
