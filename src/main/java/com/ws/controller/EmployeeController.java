package com.ws.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.entity.Employee;
import com.ws.entity.Site;
import com.ws.service.EmployeeService;
import com.ws.service.SiteService;
import com.ws.util.RestUtil;

@RestController
@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private SiteService siteService;
	
	@GET
	@Path("")
	public Response listAll(){
		List<Employee> employees = service.listAll();
		return RestUtil.createSuccessResponse(employees);
	}
	
	@GET
	@Path("/sites/")
	public Response listAllSites(){
		List<Site> sites = siteService.listAll();
		return RestUtil.createSuccessResponse(sites);
	}
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id")int id){
		Employee employee = service.findById(id);
		return RestUtil.createSuccessResponse(employee);
	}
	
	@POST
	@Path("")
	public Response create(String json){
		try{
			Employee employee = new ObjectMapper().readValue(json, Employee.class);
			service.save(employee);
			return RestUtil.createSuccessResponse(employee);	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("")
	public Response update(Employee employee){
		try{
			service.save(employee);
			return RestUtil.createSuccessResponse(employee);	
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
