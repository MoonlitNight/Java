package com.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

	public static void main(String[] args) throws Exception {
		// �������ն˵�Socket����
		DatagramSocket ds = new DatagramSocket(9190);
		//�������Packet����
		DatagramPacket df = new DatagramPacket(new byte[1024], 1024);
		ds.receive(df);
		String ip = df.getAddress().getHostAddress();//��ȡ������ip
		int port = df.getPort();
		String str = new String(df.getData(),0,df.getLength());
		System.out.println("IP��"+ip+"���˿ڣ�"+port+"���յ��������ǣ�"+str);
		ds.close();
	}

}
