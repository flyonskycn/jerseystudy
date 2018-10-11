package com.flyonsky.deploy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.flyonsky.deploy.resouces.HelloWorldResource;

public class MyApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(HelloWorldResource.class);
		return s;
	}
}
