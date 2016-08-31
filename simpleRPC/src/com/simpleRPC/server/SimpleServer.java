package com.simpleRPC.server;

import com.simpleRPC.ServiceInterface.impl.SimpleServiceImpl;
import com.simpleRPC.framework.SimpleRPCFramework;

public class SimpleServer {

	public static void main(String[] args) throws Throwable {
		SimpleRPCFramework.export(new SimpleServiceImpl(), 8181);
	}

}
