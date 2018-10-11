package com.flyonsky.deploy;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/")
public class MyApplication extends PackagesResourceConfig{

	public MyApplication() {
		super("com.flyonsky.deploy.resouces");
	}
}
