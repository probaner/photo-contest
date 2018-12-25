package com.photo.contest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.dto.CategoryCountMap;
import com.photo.contest.model.File;
import com.photo.contest.model.Users;

@Repository
public class FileDetailDAO {
	
	 private static final Log log = LogFactory.getLog(FileDetailDAO.class);
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 public Integer persist(File transientInstance){
		 log.debug("persisting Domain instance");
		 try {			
			 //Session session = sessionFactory.getCurrentSession();
			 sessionFactory.getCurrentSession().save(transientInstance);
			 log.debug("persist successful");			
			 return transientInstance.getFileId();
		    } catch (RuntimeException re) {
			         log.error("persist failed", re);
			         throw re;
		            }		 
	 }
	 
	 
	 public void attachDirty(File instance) {
			log.debug("attaching dirty User instance");
			try {				 
				  sessionFactory.getCurrentSession().saveOrUpdate(instance);
				  log.debug("attach successful");
				  
			    }catch (RuntimeException re) {
				log.error("attach failed", re);
				throw re;
			}
		}
	 
	 
	 
	 @SuppressWarnings("deprecation")
	public void deletebyID(Integer fileId) {
		 
		 log.debug("deleting File instance");
			try {	
				 Session session = sessionFactory.getCurrentSession();
		         String hql = "delete from File where fileId= :fileId";
		         session.createQuery(hql).setInteger("fileId", fileId).executeUpdate();
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				throw re;
			}
	 }
	 
	 
	 
	 public void delete(File persistentInstance) {
		     
			log.debug("deleting File instance");
			try {				
				 Session session = sessionFactory.getCurrentSession();
				 session.delete(persistentInstance);
				 log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				throw re;
			}
		}
	 
	 
	 public File findFile(File fileDetail){
		 log.debug("File instance"); 
		 try {	 
			    Session session = sessionFactory.getCurrentSession();
			    Criteria criteria = session.createCriteria(File.class);
			                     criteria.add(Restrictions.eq("users",fileDetail.getUsers()));
			                     criteria.add(Restrictions.eq("category", fileDetail.getCategory()));
			                     //criteria.add(Restrictions.like("categoryIndex", fileDetail.getOriginalFileName()));
			                     criteria.add(Restrictions.eq("categoryIndex", fileDetail.getCategoryIndex()));
			                     //criteria.setProjection(Property.forName("fileId"));
			                     
			                     File result = (File) criteria.uniqueResult(); 
			                     //System.out.println("result=========++++++++++++"+result);
			                     return result;
		 } catch (RuntimeException re) {
	         log.error("get file_id failed", re);
	         throw re;
          }		 
	 }
	 
	 public List<String> findTitelListOfaCatagory(File fileDetail){
		 
		 log.debug("File instance");		 
		  try {	 
			    Session session = sessionFactory.getCurrentSession();
			    Criteria criteria = session.createCriteria(File.class);
			                     criteria.add(Restrictions.eq("users",fileDetail.getUsers()));
			                     criteria.add(Restrictions.eq("category", fileDetail.getCategory()));
			                     criteria.setProjection(Property.forName("titel"));
			                     
			   List<String> listOfTitel =  criteria.list();            
			   		   
			   System.out.println("value="+listOfTitel); 
			   
			   return listOfTitel;
		      } catch (RuntimeException re) {
		         log.error("File_Name failed", re);
		         throw re;
	          }
			 
		 }
	 
	 
	 
	 public File findById(java.lang.Integer id) {
			log.debug("getting File instance with id: " + id);
			File instance = new File();
			try{
				//Session session = sessionFactory.getCurrentSession();
				 instance = (File) sessionFactory.getCurrentSession().get("com.photo.contest.model.File", id);
				if (instance == null) {
					log.debug("get successful, no instance found");
				} else {
					log.debug("get successful, instance found");
				    }
				
			   } catch (RuntimeException re) {
				log.error("get failed", re);
				throw re;
			   }
			return instance;
			
		}
	 
	 
	 
	 public List<File> findByExample(File instance) {
		 log.debug("finding User instance by example");
			try {
				   Session session = sessionFactory.getCurrentSession();
				   Criteria criteria = session.createCriteria(File.class);
				                     criteria.add(Restrictions.eq("users",instance.getUsers()));
				                     criteria.addOrder(Order.asc("uploadTime"));
				                     
			   List<File> result = criteria.list();
			      
			   return result;
				
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		 
	 }
	 
	
	 public List<CategoryCountMap> getCategoryWiseFileCount(File fileDetail) {
		 log.debug("finding Category Wise FileCount of a User");
		String sql = "select  category_id, count(category_id) file_id from vibgyorci_salon.file where user_id="+fileDetail.getUsers().getUserId() +" group by category_id";	
	
		try {
			Session session = sessionFactory.getCurrentSession();
			
			
			@SuppressWarnings("unchecked")
			List<CategoryCountMap> results = session.createSQLQuery(sql)
					                         .addScalar("category_id", StandardBasicTypes.INTEGER)
					                         .addScalar("file_id", StandardBasicTypes.INTEGER)
					                         .setResultTransformer( Transformers.aliasToBean(CategoryCountMap.class))
											 .list();
			 
			 //System.out.println(results.size());
			if(results.size()>0)
			   return results;
			else
				return new ArrayList<CategoryCountMap>();
		}catch (RuntimeException re) {
			log.error("finding Category Wise FileCount of a User", re);
			throw re;
		}
		
		 
	 }
	 
	 
	 public List<CategoryCountMap> getCategoryWiseFileCountUsingUserID(Integer userID) {
		 log.debug("finding Category Wise FileCount of a User");
		String sql = "select  category_id, count(category_id) file_id from vibgyorci_salon.file where user_id="+userID +" group by category_id";	
	
		try {
			Session session = sessionFactory.getCurrentSession();
			
			
			@SuppressWarnings("unchecked")
			List<CategoryCountMap> results = session.createSQLQuery(sql)
					                         .addScalar("category_id", StandardBasicTypes.INTEGER)
					                         .addScalar("file_id", StandardBasicTypes.INTEGER)
					                         .setResultTransformer( Transformers.aliasToBean(CategoryCountMap.class))
											 .list();
			 
			 //System.out.println(results.size());
			if(results.size()>0)
			   return results;
			else
				return new ArrayList<CategoryCountMap>();
		}catch (RuntimeException re) {
			log.error("finding Category Wise FileCount of a User", re);
			throw re;
		}
		
		 
	 }
}
