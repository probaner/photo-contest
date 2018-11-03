package com.photo.contest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.contest.dto.ClubDTO;
import com.photo.contest.dto.PaystatusGraphDTO;
import com.photo.contest.model.Users;



@Repository
public class UsersDAO {
	
	 private static final Log log = LogFactory.getLog(UsersDAO.class);
      
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
		
	 public Integer persist(Users transientInstance) {
		log.debug("persisting Domain instance");
		try {			
			 //Session session = sessionFactory.getCurrentSession();
			 sessionFactory.getCurrentSession().save(transientInstance);
			 log.debug("persist successful");
			 return transientInstance.getUserId();
		    } catch (RuntimeException re) {
			         log.error("persist failed", re);
			         throw re;
		             }
	}
	 
	 public void attachDirty(Users instance) {
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
	 
	 
	public Users findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		Users instance = new Users();
		try{
			//Session session = sessionFactory.getCurrentSession();
			 instance = (Users) sessionFactory.getCurrentSession().get("com.photo.contest.model.Users", id);
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
	
	public List<Users> findAColumn(String nameOfColumn){
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
		    .setProjection(Projections.projectionList()		      
		    .add(Projections.property(nameOfColumn), nameOfColumn))
		    .setResultTransformer(Transformers.aliasToBean(Users.class));
			
			 List<Users> list = cr.list();
			 
			 return list;
		   } catch (RuntimeException re) {
			                               log.error("get failed", re);
			                               throw re;
		                                  }		
	 }
	
	
	public String findPassword(String email){
		String password =null;
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class);
					     cr.add(Restrictions.eq("email", email));
			             cr.setProjection(Property.forName("password")).uniqueResult();
			             password = (String) cr.list().get(0);		             			            
		}catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
           }
		return password;
	}
	
	
	public Users findByUserId(Integer usersId) {
		log.debug("getting User instance with id: " + usersId);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
					     .add(Restrictions.eq("user_id", usersId));
			Users Users = (Users) cr.uniqueResult();
						
			return Users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	
	public Users findByforgetPasswAuthToken(String forgetPasswAuthToken) {
		log.debug("getting User instance with id: " + forgetPasswAuthToken);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
					     .add(Restrictions.eq("forgetPasswAuthToken", forgetPasswAuthToken));
			Users Users = (Users) cr.uniqueResult();
						
			return Users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	
	public Users findJudgeByRegisterURLToken(String judgeRegisterURLToken) {
		log.debug("getting User instance with id: " + judgeRegisterURLToken);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
					     .add(Restrictions.eq("judgeRegistrationToken", judgeRegisterURLToken));
			Users Users = (Users) cr.uniqueResult();
						
			return Users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	public Users findByEmail(String email) {
		log.debug("getting User instance with email: " + email);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
					     .add(Restrictions.eq("email", email));
			Users Users = (Users) cr.uniqueResult();
						
			return Users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	
	public Optional<Users> findByEmailOptional(String email) {
		log.debug("getting User instance with email: " + email);
		try{
			 //Session session = sessionFactory.getCurrentSession();
			Criteria cr =sessionFactory.getCurrentSession().createCriteria(Users.class)
					     .add(Restrictions.eq("email", email));
			Optional<Users> users = (Optional<Users>) cr.uniqueResult();
						
			return users;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	public List findByExample(Users instance) {
		log.debug("finding User instance by example");
		try {
			 //Session session = sessionFactory.getCurrentSession();
			 List results = sessionFactory.getCurrentSession().createCriteria("com.photo.contest.model.Users").add(Example.create(instance)).list();
			 log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<ClubDTO> fetchSql(String sql) {
		try {
			//Session session = sessionFactory.getCurrentSession();
			
			@SuppressWarnings("unchecked")
			List<ClubDTO> results = sessionFactory.getCurrentSession().createSQLQuery(sql)
					                         .addScalar("members_count", StandardBasicTypes.INTEGER)
					                         .addScalar("club", StandardBasicTypes.STRING)
					                         .setResultTransformer( Transformers.aliasToBean(ClubDTO.class))
											 .list();
			 
			 //System.out.println("results.size="+results.size());
			if(results.size()>0)
			   return results;
			else
				return new ArrayList<ClubDTO>();
		}catch (RuntimeException re) {
			log.error("finding Category Wise FileCount of a User", re);
			throw re;
		}
	}
	
	
	
	public List<PaystatusGraphDTO> fetchSqlforGraph(String sql) {
		try {			
			@SuppressWarnings("unchecked")
			List<PaystatusGraphDTO> results = sessionFactory.getCurrentSession().createSQLQuery(sql)
					                         .addScalar("country", StandardBasicTypes.STRING)
					                         .addScalar("paid", StandardBasicTypes.INTEGER)
					                         .addScalar("unpaid", StandardBasicTypes.INTEGER)
					                         .setResultTransformer( Transformers.aliasToBean(PaystatusGraphDTO.class))
											 .list();
			 
			 //System.out.println("results.size="+results.size());
			if(results.size()>0)
			   return results;
			else
				return new ArrayList<PaystatusGraphDTO>();
		}catch (RuntimeException re) {
			log.error("finding Category Wise FileCount of a User", re);
			throw re;
		}
	}
	
	
	public List<Users> getAllUsersList(String tableName){
	    String jpql = "SELECT t FROM " + tableName+ " t";
	    Query query = sessionFactory.getCurrentSession().createQuery(jpql);
	    List<Users> list = query.getResultList();
	    //rest of the code    
		return list;
	}
	
	
	public List findUserByRole(String role) {
		log.debug("getting User instance with role: " + role);
		try{
			
			
			List results = sessionFactory.getCurrentSession().createCriteria("com.photo.contest.model.Users")
					.add(Restrictions.eq("role", role)).list();
			
			return results;      		
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
			
	}
	
	
	/*public List findByExample(Users instance) {
		log.debug("finding User instance by example");
		try {
			 //Session session = sessionFactory.getCurrentSession();
			 List results = sessionFactory.getCurrentSession().createCriteria("com.photo.contest.model.Users").add(Example.create(instance)).list();
			 log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/

}
