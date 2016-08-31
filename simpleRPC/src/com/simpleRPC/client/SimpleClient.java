package com.simpleRPC.client;

import java.util.Scanner;

import com.simpleRPC.ServiceInterface.SimpleService;
import com.simpleRPC.framework.SimpleRPCFramework;

public class SimpleClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		SimpleService reference = SimpleRPCFramework.reference(SimpleService.class, "127.0.0.1", 8181);
		String result = reference.echo(str);
		System.out.println(result);
	}

}
