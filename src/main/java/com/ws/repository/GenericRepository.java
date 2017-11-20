package com.ws.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.entity.GenericEntity;
import com.ws.entity.Site;

@Repository
public interface GenericRepository<T extends GenericEntity> {
	public List<T> listAll();
	public T findById(int id);
	public T save(T entity);
	public void delete(T entity);
}
