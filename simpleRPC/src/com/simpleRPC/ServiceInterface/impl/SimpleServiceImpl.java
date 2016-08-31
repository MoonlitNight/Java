package com.simpleRPC.ServiceInterface.impl;

import com.simpleRPC.ServiceInterface.SimpleService;

public class SimpleServiceImpl implements SimpleService {

	@Override
	public String echo(String str) {
		return "echo="+str;
	}

}
