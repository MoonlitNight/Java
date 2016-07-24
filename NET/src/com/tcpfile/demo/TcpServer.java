package com.tcpfile.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws Exception {
		// ����������ServerSocket����
		ServerSocket ss = new ServerSocket(9494);
		while (true) {
			// ��ȡ�ͻ���Socket����
			final Socket s = ss.accept();
			new Thread(new Runnable() {
				public void run() {
					try {
						// ��ȡ�ͻ���ip
						String ip = s.getInetAddress().getHostAddress();
						// ��ȡ�ͻ���Socket�����ֽ�������
						InputStream input = s.getInputStream();
						// �������indexΪ�ж��Ƿ������ļ�
						int index = 1;
						// ����д���ļ�File����
						File file = new File("D:/test/" + ip + ".bmp");
						while (file.exists()) {
							file = new File("D:/test/" + ip + "(" + index + ")" + ".bmp");
							index++;
						}
						// ��������������򱾵ش���д������
						FileOutputStream fos = new FileOutputStream(file);
						// �����ֽ�����洢����
						byte[] data = new byte[1024];
						int len = 0;
						while ((len = input.read(data)) != -1) {
							fos.write(data, 0, len);
						}
						fos.close();
						// ��ȡ�ͻ���Socket�����ֽ������
						OutputStream output = s.getOutputStream();
						// д������
						output.write("�ϴ��ɹ�".getBytes());
						s.close();
					} catch (Exception e) {
						System.out.println("�ϴ�ʧ�ܷ���������");
					}
				}
			}).start();
		}
		// ss.close();
	}
}
