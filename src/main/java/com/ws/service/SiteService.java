package com.ws.service;

import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SiteService {

	@Autowired
	private SiteRepository repository;

	public List<Site> listAll() {
		return repository.listAll();
	}

	public Site findById(@PathParam("id") int id) {
		return repository.findById(id);
	}

	public Site save(Site site) {
		return repository.save(site);
	}

	public Response delete(@PathParam("id") int id) {
		Site site = repository.findById(id);
		repository.delete(site);
		return Response.ok().build();
	}
}
