package com.flyonsky.deploy.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class FirstFilter implements ContainerRequestFilter{

	@Context 
    private HttpServletRequest servletRequest;
	@Context
	private HttpServletResponse servletResponse;
	
	@Override
	public ContainerRequest filter(ContainerRequest creq) {
		System.out.println("FirstFilter Request:" + creq);
		if(!servletRequest.getRequestURL().toString().endsWith("/login") 
				&& !servletRequest.getMethod().equals("OPTIONS")){
			Response response = Response.ok("error").status(401).type(MediaType.TEXT_PLAIN).build();
			throw new WebApplicationException(response); // Throw new UnAuthorized 
		}
		return creq;
	}
}
