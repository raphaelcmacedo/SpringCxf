package com.ws.util;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {
	public static Response createSuccessResponse(Object entity){
		try{
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(entity);
			return Response.status(201).entity(json).build();
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
