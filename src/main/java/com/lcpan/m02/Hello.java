package com.lcpan.m02;

import javax.ws.rs.*;

@Path("/")
public class Hello {
	@GET
	@Path("/hello/{name}")
	@Produces("text/plain")
	public String sayHello(@PathParam("name") String name){
		return "Hello, " + name;
	}
}
