package com.flyonsky.jersery1guice.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flyonsky.jersery1guice.service.HelloService;

@Path("hello")
public class HelloResource {
	
	private HelloService service;
	
	@Inject
	public HelloResource(HelloService service) {
		this.service = service;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return service.hello();
	}
}
