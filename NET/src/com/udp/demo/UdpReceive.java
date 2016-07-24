package com.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

	public static void main(String[] args) throws Exception {
		// 创建接收端点Socket对象
		DatagramSocket ds = new DatagramSocket(9190);
		//创建解包Packet对象
		DatagramPacket df = new DatagramPacket(new byte[1024], 1024);
		ds.receive(df);
		String ip = df.getAddress().getHostAddress();//获取发送者ip
		int port = df.getPort();
		String str = new String(df.getData(),0,df.getLength());
		System.out.println("IP："+ip+"，端口："+port+"接收到的数据是："+str);
		ds.close();
	}

}
