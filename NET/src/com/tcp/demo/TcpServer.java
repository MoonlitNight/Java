package com.tcp.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws Exception {
		//����������ServerSocket����
		ServerSocket ss = new ServerSocket(8989);
		//��ȡ�ͻ���Socket����
		Socket s = ss.accept();
		//��ȡ�ͻ���Socket�����ֽ�������
		InputStream input = s.getInputStream();
		//�����ֽ�����洢����
		byte [] data = new byte [1024]; 
		String str = new String(data,0,input.read(data));
		System.out.println(str);
		//��ȡ�ͻ���Socket�����ֽ������
		OutputStream output = s.getOutputStream();
		//д������
		output.write("���������յ�".getBytes());
		s.close();
		ss.close();
	}

}
