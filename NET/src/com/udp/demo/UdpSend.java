package com.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {
public static void main(String[] args) throws Exception {
	//创建Socket发送端端点对象
	DatagramSocket send = new DatagramSocket();
	//创建发送数据
	String date = "Hello Internet";
	//转为字节数组
	byte [] b = date.getBytes();
	int length = b.length;
	InetAddress address = InetAddress.getByName("192.168.0.255");
	//创建Packet数据打包对象
	DatagramPacket dp = new DatagramPacket(b, length, address, 9190);
	send.send(dp);//发送数据
	send.close();//关闭端口
}
}
