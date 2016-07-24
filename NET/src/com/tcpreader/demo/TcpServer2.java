package com.tcpreader.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {

	public static void main(String[] args) throws Exception {
		// 创建服务器ServerSocket对象
		ServerSocket ss = new ServerSocket(80);
		while (true) {
			// 获取客户端Socket对象
			final Socket s = ss.accept();
			new Thread(new Runnable() {
				public void run() {
					try {
						// 获取客户端ip
						String ip = s.getInetAddress().getHostAddress();
						System.out.println("IP"+ip+"正在访问服务器");
						//创建文件对象提供浏览器查看
						File file = new File("D:/Test/test.jpg");
						//创建字节输入流用于读取本地文件
						FileInputStream fis = new FileInputStream(file);
						//字节输入流缓冲区
						BufferedInputStream bis = new BufferedInputStream(fis);
						byte [] buf = new byte[1024];
						int len = 0;
						// 获取客户端Socket对象字节输出流
						OutputStream output = s.getOutputStream();
						BufferedOutputStream bos =new BufferedOutputStream(output);
						while((len=bis.read(buf))!=-1)
						{
							bos.write(buf,0,len);
						}
						bis.close();
						s.shutdownOutput();
						// 写入数据
						output.write("本文完结".getBytes());
						s.close();
					} catch (Exception e) {
						System.out.println("服务器挂了");
					}
				}
			}).start();
		}
		// ss.close();
	}
}
