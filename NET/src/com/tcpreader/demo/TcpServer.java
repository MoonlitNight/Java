package com.tcpreader.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

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
						System.out.println("IP:["+ip+"]���ڷ��ʷ�����");
						//�����ļ������ṩ������鿴
						File file = new File("D:/Test/test.txt");
						//�����ֽ����������ڶ�ȡ�����ļ�
						FileInputStream fis = new FileInputStream(file);
						//����ת����
						LineNumberReader inr = new LineNumberReader(new InputStreamReader(fis));
						String str = null;
						// ��ȡ�ͻ���Socket�����ֽ������
						OutputStream output = s.getOutputStream();
						//����ת������ͻ���д����Ϣ
						BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(output));
						while((str = inr.readLine())!=null)
						{
							bw.write(inr.getLineNumber()+"��"+str);
							bw.newLine();
							bw.flush();
						}
						inr.close();
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
