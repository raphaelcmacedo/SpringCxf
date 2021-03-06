package com.ws.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ws.entity.Site;
import com.ws.repository.SiteRepository;
import com.ws.service.SiteService;

@RestController
@Path("site")
@Consumes("text/xml")
@Produces("text/xml")
public class SiteController {

	@Autowired
	private SiteService service;
	
	@GET
	@Path("")
	public List<Site> listAll(){
		return service.listAll();
	}
	
	@GET
	@Path("{id}")
	public Site findById(@PathParam("id")int id){
		return service.findById(id);
	}
	
	@POST
	@Path("")
	public Response create(Site site){
		try{
			service.save(site);
			return Response.ok(site).build();	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("")
	public Response update(Site site){
		try{
			service.save(site);
			return Response.ok(site).build();	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id")int id){
		try{
			service.delete(id);
			return Response.ok().build();	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
