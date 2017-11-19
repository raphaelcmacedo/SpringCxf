package com.ws.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;

@Repository
public class SiteDAO extends GenericDAO<Site> implements SiteRepository {

	public List<Site> listAll() {
		Criteria criteria = super.getCurrentSession().createCriteria(Site.class);
        List<Site> result = (List<Site>) criteria.list();
        return result;
	}

}
