package com.ws.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;

@Repository
public class SiteDAO implements SiteRepository {

	private List<Site> dataSource = new ArrayList<Site>();
	
	public SiteDAO() {
		this.fillDataSource();
	}

	private void fillDataSource(){
		Site s1 = new Site(1,"Rio de Janeiro, Brazil");
		Site s2 = new Site(2, "London, UK");
		Site s3 = new Site(3, "Brussels, Belgium");
		
		dataSource.add(s1);
		dataSource.add(s2);
		dataSource.add(s3);
		
	}


	public List<Site> listAll() {
		return this.dataSource;
	}

}
