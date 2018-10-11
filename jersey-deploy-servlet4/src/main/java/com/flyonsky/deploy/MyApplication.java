package com.flyonsky.deploy;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class MyApplication extends PackagesResourceConfig{

	public MyApplication() {
		super("com.flyonsky.deploy.resouces");
	}
}
