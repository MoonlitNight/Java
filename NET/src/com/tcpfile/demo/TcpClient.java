package com.tcpfile.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		//创建客户端Socket对象
		Socket s = new Socket("192.168.0.102",9201);
		//获取输出流对象
		OutputStream os =s.getOutputStream();
		//创建输入流读取本地数据
		FileInputStream fii = new FileInputStream("D:/Test/test.txt");
		//定义字节数组
		byte [] b = new byte [1024] ;
		int len = 0;
		while((len = fii.read(b))!=-1)
		{
			os.write(b, 0, len);//写入数据
		}
		//客户端数据发送完成，需发送标记表示已经发送数据完毕
		s.shutdownOutput();
		fii.close();//关闭读取流
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
