package com.ws.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ws.entity.GenericEntity;

@Repository
public abstract class GenericDAO<T extends GenericEntity> {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		//return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}
	
	public T save(T entity){
		Session s = this.getCurrentSession();
		s.saveOrUpdate(entity);
		return entity;
	}
	
	public void delete (T entity){
		Session s = this.getCurrentSession();
		s.delete(entity);
	}
	
	public Query createQuery (String query){
		Session s = this.getCurrentSession();
		return s.createQuery(query);
	}

}
