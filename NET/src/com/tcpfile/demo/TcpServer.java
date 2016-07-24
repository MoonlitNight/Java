package com.tcpfile.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws Exception {
		// 创建服务器ServerSocket对象
		ServerSocket ss = new ServerSocket(9494);
		while (true) {
			// 获取客户端Socket对象
			final Socket s = ss.accept();
			new Thread(new Runnable() {
				public void run() {
					try {
						// 获取客户端ip
						String ip = s.getInetAddress().getHostAddress();
						// 获取客户端Socket对象字节输入流
						InputStream input = s.getInputStream();
						// 定义变量index为判断是否是重文件
						int index = 1;
						// 定义写入文件File对象
						File file = new File("D:/test/" + ip + ".bmp");
						while (file.exists()) {
							file = new File("D:/test/" + ip + "(" + index + ")" + ".bmp");
							index++;
						}
						// 定义输出流对象向本地磁盘写入数据
						FileOutputStream fos = new FileOutputStream(file);
						// 定义字节数组存储数据
						byte[] data = new byte[1024];
						int len = 0;
						while ((len = input.read(data)) != -1) {
							fos.write(data, 0, len);
						}
						fos.close();
						// 获取客户端Socket对象字节输出流
						OutputStream output = s.getOutputStream();
						// 写入数据
						output.write("上传成功".getBytes());
						s.close();
					} catch (Exception e) {
						System.out.println("上传失败服务器挂了");
					}
				}
			}).start();
		}
		// ss.close();
	}
}
