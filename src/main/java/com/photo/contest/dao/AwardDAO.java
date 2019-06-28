package com.photo.contest.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.model.Awards;


@Repository
public class AwardDAO {
	
	 private static final Log log = LogFactory.getLog(AwardDAO.class);
     @Autowired
	 private SessionFactory sessionFactory;
	
	
	public List<Awards> getAllAwards(String tableName){
		String jpql = "SELECT t FROM " + tableName+ " t";
	    Query query = sessionFactory.getCurrentSession().createQuery(jpql);
	    List<Awards> list = query.getResultList();
	    //System.out.println(list);  
		return list;
	}
	
	
	

}
