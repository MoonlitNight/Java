package com.tcp.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws Exception {
		//创建服务器ServerSocket对象
		ServerSocket ss = new ServerSocket(8989);
		//获取客户端Socket对象
		Socket s = ss.accept();
		//获取客户端Socket对象字节输入流
		InputStream input = s.getInputStream();
		//定义字节数组存储数据
		byte [] data = new byte [1024]; 
		String str = new String(data,0,input.read(data));
		System.out.println(str);
		//获取客户端Socket对象字节输出流
		OutputStream output = s.getOutputStream();
		//写入数据
		output.write("服务器已收到".getBytes());
		s.close();
		ss.close();
	}

}
