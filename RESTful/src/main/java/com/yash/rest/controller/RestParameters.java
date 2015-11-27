package com.yash.rest.controller;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.api.core.HttpContext;


@Path("/parameters")
public class RestParameters {
	
	@GET
	@Path("/pathparam/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPathParam(@PathParam("id") String id) {
		String message="Path param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/queryparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQueryParam(@QueryParam("id") String id) {
		String message="query param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/headerparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHeaderParam(@HeaderParam("id") String id) {
		String message="header param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/matrixparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatrixParam(@MatrixParam("id") String id) {
		String message="matrix param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/cookieparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCookieParam(@CookieParam("id") String id) {
		String message="cookie param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@POST
	@Path("/formparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFormParam(@FormParam("id") String id) {
		String message="Form param is: "+id;
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/contextparam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContextParam(@Context HttpContext http) {
		String message="context is: "+http.getRequest();
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/defaultvalue")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDefaultValue(@DefaultValue("yash") @QueryParam("value") String value ) {
	
		String message="value is: "+value;
		return Response.status(200).entity(message).build();
	}
}
