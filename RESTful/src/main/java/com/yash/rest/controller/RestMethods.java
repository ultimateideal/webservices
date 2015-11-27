package com.yash.rest.controller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.yash.User;
import com.yash.service.Service;



@Path("/methods")
public class RestMethods {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMethod() {	
		
		List<User> userList=Service.get();
		CacheControl control = new CacheControl();
		control.setMaxAge(60);
		return Response.status(200).entity(userList).cacheControl(control).build();
	}
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostData(User user) {
		Service.add(user);
		String result="Record create successfully ";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON(User user) {
		boolean flag= Service.update(user);
		int statusCode=204;
		String statusMessage=null;
		
		if(flag) {
			statusMessage="Record updated succefully";
			statusCode=200;
		}
		return Response.status(statusCode).entity(statusMessage).build();
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(User user) {
		
		boolean flag= Service.delete(user);
		int statusCode=204;
		String statusMessage=null;
		
		if(flag) {
			statusMessage="Record deleted succefully";
			statusCode=200;
		}
		return Response.status(statusCode).entity(statusMessage).build();
	}
}