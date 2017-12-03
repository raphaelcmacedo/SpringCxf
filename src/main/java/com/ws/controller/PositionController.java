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
import com.ws.entity.Position;
import com.ws.entity.Site;
import com.ws.service.PositionService;
import com.ws.util.RestUtil;

@RestController
@Path("position")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PositionController {

	@Autowired
	private PositionService service;
	
	@GET
	@Path("")
	public Response listAll(){
		List<Position> positions = service.listAll();
		return RestUtil.createSuccessResponse(positions);
	}
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id")int id){
		Position position = service.findById(id);
		return RestUtil.createSuccessResponse(position);
	}
	
	@POST
	@Path("")
	public Response create(String json){
		try{
			Position position = new ObjectMapper().readValue(json, Position.class);
			service.save(position);
			return RestUtil.createSuccessResponse(position);	
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("")
	public Response update(String json){
		try{
			Position position = new ObjectMapper().readValue(json, Position.class);
			service.save(position);
			return RestUtil.createSuccessResponse(position);	
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
