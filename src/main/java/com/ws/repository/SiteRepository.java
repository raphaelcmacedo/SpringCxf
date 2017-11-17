package com.ws.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.entity.Site;

@Repository
public interface SiteRepository {
	public List<Site> listAll();
}
