package com.ws.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class SiteDAO extends GenericDAO<Site> implements SiteRepository {

	public List<Site> listAll() {
		Criteria criteria = super.getCurrentSession().createCriteria(Site.class);
        List<Site> result = (List<Site>) criteria.list();
        return result;
	}
	
	public Site findById(int id){
		Site site = (Site) super.getCurrentSession().get(Site.class, id);
		return site;
	}

}
