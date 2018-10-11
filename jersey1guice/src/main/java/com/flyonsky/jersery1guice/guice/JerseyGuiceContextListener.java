package com.flyonsky.jersery1guice.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class JerseyGuiceContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector( new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                // REST
                Map<String, String> params = new HashMap<String, String>();
//                params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.sun.jersey");
                params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.flyonsky.jersery1guice.resources");
                params.put("com.sun.jersey.config.property.WebPageContentRegex", "/(flex|images|js|css|jsp)/.*");
                params.put("com.sun.jersey.spi.container.ContainerRequestFilters", "com.sun.jersey.api.container.filter.GZIPContentEncodingFilter");
                params.put("com.sun.jersey.spi.container.ContainerResponseFilters", "com.sun.jersey.api.container.filter.GZIPContentEncodingFilter");
                filter("/*").through(GuiceContainer.class, params);
                bind(GuiceContainer.class).asEagerSingleton();
            }
		});
		return injector;
	}

}
