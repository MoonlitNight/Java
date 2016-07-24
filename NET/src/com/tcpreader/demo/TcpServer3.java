package com.tcpreader.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer3 {

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
						System.out.println("IP:["+ip+"]正在访问服务器");
						//创建文件对象提供浏览器查看
						File file = new File("D:/Test/test.txt");
						//创建字节输入流用于读取本地文件
						FileInputStream fis = new FileInputStream(file);
						//创建转换流
						LineNumberReader inr = new LineNumberReader(new InputStreamReader(fis));
						String str = null;
						// 获取客户端Socket对象字节输出流
						OutputStream output = s.getOutputStream();
						//创建转换流向客户端写入信息
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(output));
						bw.write("欢迎访问！\n");
						bw.write("您的IP是：["+ip+"]\n");
						while((str = inr.readLine())!=null)
						{
							bw.write(inr.getLineNumber()+"："+str);
							bw.newLine();
							bw.flush();
						}
						inr.close();
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
