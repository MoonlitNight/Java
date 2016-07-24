package com.tcpreader.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {

	public static void main(String[] args) throws Exception {
		// ����������ServerSocket����
		ServerSocket ss = new ServerSocket(80);
		while (true) {
			// ��ȡ�ͻ���Socket����
			final Socket s = ss.accept();
			new Thread(new Runnable() {
				public void run() {
					try {
						// ��ȡ�ͻ���ip
						String ip = s.getInetAddress().getHostAddress();
						System.out.println("IP"+ip+"���ڷ��ʷ�����");
						//�����ļ������ṩ������鿴
						File file = new File("D:/Test/test.jpg");
						//�����ֽ����������ڶ�ȡ�����ļ�
						FileInputStream fis = new FileInputStream(file);
						//�ֽ�������������
						BufferedInputStream bis = new BufferedInputStream(fis);
						byte [] buf = new byte[1024];
						int len = 0;
						// ��ȡ�ͻ���Socket�����ֽ������
						OutputStream output = s.getOutputStream();
						BufferedOutputStream bos =new BufferedOutputStream(output);
						while((len=bis.read(buf))!=-1)
						{
							bos.write(buf,0,len);
						}
						bis.close();
						s.shutdownOutput();
						// д������
						output.write("�������".getBytes());
						s.close();
					} catch (Exception e) {
						System.out.println("����������");
					}
				}
			}).start();
		}
		// ss.close();
	}
}
