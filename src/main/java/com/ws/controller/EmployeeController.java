package com.ws.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ws.entity.Employee;
import com.ws.entity.Employees;
import com.ws.service.EmployeeService;

@RestController
@Path("employee")
@Consumes("text/xml")
@Produces("text/xml")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GET
	@Path("")
	public Employees listAll(){
		Employees list = new Employees(service.listAll());
		return list;
	}
	
	@GET
	@Path("{id}")
	public Employee findById(@PathParam("id")int id){
		return service.findById(id);
	}
	
	@POST
	@Path("")
	public Response create(Employee site){
		try{
			service.save(site);
			return Response.ok(site).build();	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("")
	public Response update(Employee site){
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
