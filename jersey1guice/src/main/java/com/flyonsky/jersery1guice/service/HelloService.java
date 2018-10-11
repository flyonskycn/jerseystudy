package com.flyonsky.jersery1guice.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloServiceImp.class)
public interface HelloService {

	String hello();
}
