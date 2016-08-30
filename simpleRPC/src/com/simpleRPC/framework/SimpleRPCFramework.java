/**
 * Copyright (c) 2016 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.simpleRPC.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>一个简单的RPC框架</p>
 * @author jin.wang
 *
 */
@SuppressWarnings("all")
public class SimpleRPCFramework {
	/**
	 * 暴露服务
	 * @param service 服务对象
	 * @param port 服务端口
	 * @throws Throwable 
	 */
	public static void export(final Object service,int port) throws Throwable{
		if(service==null)
			throw new IllegalArgumentException("service instance is null");
		if(port<0 || port>65535)
			throw new IllegalArgumentException("invalid port :"+port);
		System.out.println("export service "+service.getClass().getName()+"on port:"+port);
		ServerSocket server = new ServerSocket(port);
		while(true){
			final Socket client = server.accept();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ObjectInputStream input = new ObjectInputStream( client.getInputStream());
						ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
						try {
							try {
								String methodName = input.readUTF();
								Class<?>[] parameterTypes = (Class<?>[])input.readObject();
								Object[] arguments =(Object[]) input.readObject();
								Method method = service.getClass().getMethod(methodName, parameterTypes);
								Object result = method.invoke(service, arguments);
								output.writeObject(result);
							} catch (Throwable e) {
								output.writeObject(e);
							}finally{
								output.close();
							}
						} finally{
							input.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
	/**
	 * 获取服务引用
	 * @param interfaceClass
	 * @param host
	 * @param port
	 * @return
	 */
	public static <T> T referer(final Class<?> interfaceClass,final String host,final int port){
		if(interfaceClass==null)
			throw new IllegalArgumentException("interface Class is null");
		if(!interfaceClass.isInterface())
			throw new IllegalArgumentException(interfaceClass.getName()+"is not interface");
		if(host==null||host.trim().length()==0)
			throw new IllegalArgumentException("invalid host:"+host);
		if(port<0 || port>65535)
			throw new IllegalArgumentException("invalid port :"+port);
		return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class<?>[] {interfaceClass}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Socket socket = new Socket(host, port);
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				output.writeUTF(method.getName());
				output.writeObject(method.getParameterTypes());
				output.writeObject(args);
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Object result = input.readObject();
				input.close();
				output.close();
				socket.close();
				if(result instanceof Throwable)
					throw (Throwable)result;
				return result;
			}
		});
	}
}
