package com.photo.contest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.DiscountData;

@Repository
public class DiscountDataDAO {
	
 private static final Log log = LogFactory.getLog(PayStatusDAO.class);
     @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 
	 
	 public void persist(DiscountData transientInstance) {
			log.debug("persisting Domain instance");
			try {			
				  //Session session = sessionFactory.getCurrentSession();
				sessionFactory.getCurrentSession().save(transientInstance);
				 log.debug("persist successful");
			    } catch (RuntimeException re) {
				         log.error("persist failed", re);
				         throw re;
			             }
		}
	 
	 
	 public List findByExample(DiscountData instance) {
			log.debug("finding User instance by example");
			try {				
				  //Session session = sessionFactory.getCurrentSession();
				 List results = sessionFactory.getCurrentSession().createCriteria("com.photo.contest.model.DiscountData").add(Example.create(instance)).list();
				 log.debug("find by example successful, result size: " + results.size());
				return results;
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		}
	 

	 
	 public List<DiscountData> findAColumn(String nameOfColumn){
			try{
				 //Session session = sessionFactory.getCurrentSession();
				 Criteria cr =sessionFactory.getCurrentSession().createCriteria(DiscountData.class)
			    .setProjection(Projections.projectionList()		      
			    .add(Projections.property(nameOfColumn), nameOfColumn))
			    .setResultTransformer(Transformers.aliasToBean(DiscountData.class));
				
				 List<DiscountData> list = cr.list();
				 
				 //System.out.println("list= "+list);
				 
				 return list;
			   } catch (RuntimeException re) {
				                               log.error("get failed", re);
				                               throw re;
			                                  }		
		 }



	public void attachDirty(DiscountData discountData) {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
