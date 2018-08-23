package com.photo.contest.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.OrganizerClub;
import com.photo.contest.model.Users;



@Repository
public class OrganizerClubDAO {
	
	
	
	private static final Log log = LogFactory.getLog(OrganizerClubDAO.class);
    @Autowired
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
       }
	
    public List<OrganizerClub> getOrganizerClubList(String tableName){
	    String jpql = "SELECT t FROM " + tableName+ " t";
	    Query query = sessionFactory.getCurrentSession().createQuery(jpql);
	    List<OrganizerClub> list = query.getResultList();
		return list;
    }
    
    
    public OrganizerClub findByOrganizerClubName(String organizerClubName) {
		log.debug("getting OrganizerClub instance with organizerClubName: " + organizerClubName);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(OrganizerClub.class)
					     .add(Restrictions.eq("organizerclubname", organizerClubName));
			OrganizerClub organizerClub = (OrganizerClub) cr.uniqueResult();						
			return organizerClub;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
    
}
