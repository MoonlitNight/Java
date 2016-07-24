package com.tcp.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {

	public static void main(String[] args) throws Exception {
		//创建服务器ServerSocket对象
		ServerSocket ss = new ServerSocket(80);
		while (true)
		{
		//获取客户端Socket对象
		 final Socket s = ss.accept();
		new Thread(new Runnable (){

			public void run() {
				try{
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
				}catch(Exception e){
					System.out.println("服务器挂掉了");
				}
			}
			
		}).start();
		
		}
		
		
	}

}
