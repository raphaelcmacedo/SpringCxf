package com.ws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;

@Controller
@Path("site")
@Produces("text/xml")	
public class SiteService {

	@Autowired
	private SiteRepository repository;
	
	@GET
	@Path("")
	public List<Site> listAll(){
		return repository.listAll();
	}
}
