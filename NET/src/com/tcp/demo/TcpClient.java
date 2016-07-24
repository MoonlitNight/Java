package com.tcp.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		//创建客户端Socket对象
		Socket s = new Socket("192.168.1.25",8989);
		//获取输出流对象
		OutputStream os =s.getOutputStream();
		//写入数据
		os.write("TCP Test".getBytes());
		/*以下是接收服务器数据*/
		//获取输入流对象
		InputStream is = s.getInputStream();
		//定义数组用于存储数据
		byte [] buf = new byte [1024];
		//将字节数组转为字符串
		String str = new String(buf,0,is.read(buf));
		//打印字符串
		System.out.println(str);
		s.close();
	}

}
