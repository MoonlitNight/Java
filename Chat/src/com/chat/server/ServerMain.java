package com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerUI su = new ServerUI();
		su.setVisible(true);
		TcpServer.log = su.txt_log;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8090);
			su.txt_log.append("��������ʼ�����" + System.getProperty("line.separator"));
		} catch (IOException e) {
			su.txt_log.append("��������ʼ������" + System.getProperty("line.separator"));
		}
		while (true) {
			try {
				Socket acc = ss.accept();// ���ܿͻ�������
				TcpServer tcpSer = new TcpServer(acc);
				new Thread(tcpSer).start();// ���յ��ͻ������������߳�
			} catch (Exception e) {
				su.txt_log.append("�ͻ������Ӵ���" + System.getProperty("line.separator"));
			}
		}
	}
}
