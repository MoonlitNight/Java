package com.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {
public static void main(String[] args) throws Exception {
	//����Socket���Ͷ˶˵����
	DatagramSocket send = new DatagramSocket();
	//������������
	String date = "Hello Internet";
	//תΪ�ֽ�����
	byte [] b = date.getBytes();
	int length = b.length;
	InetAddress address = InetAddress.getByName("192.168.0.255");
	//����Packet���ݴ������
	DatagramPacket dp = new DatagramPacket(b, length, address, 9190);
	send.send(dp);//��������
	send.close();//�رն˿�
}
}
