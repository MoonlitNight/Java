package com.tcp.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		//�����ͻ���Socket����
		Socket s = new Socket("192.168.1.25",8989);
		//��ȡ���������
		OutputStream os =s.getOutputStream();
		//д������
		os.write("TCP Test".getBytes());
		/*�����ǽ��շ���������*/
		//��ȡ����������
		InputStream is = s.getInputStream();
		//�����������ڴ洢����
		byte [] buf = new byte [1024];
		//���ֽ�����תΪ�ַ���
		String str = new String(buf,0,is.read(buf));
		//��ӡ�ַ���
		System.out.println(str);
		s.close();
	}

}
