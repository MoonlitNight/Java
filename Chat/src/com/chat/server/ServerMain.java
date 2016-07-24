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
			su.txt_log.append("服务器初始化完成" + System.getProperty("line.separator"));
		} catch (IOException e) {
			su.txt_log.append("服务器初始化错误" + System.getProperty("line.separator"));
		}
		while (true) {
			try {
				Socket acc = ss.accept();// 接受客户端请求
				TcpServer tcpSer = new TcpServer(acc);
				new Thread(tcpSer).start();// 接收到客户端请求则开启线程
			} catch (Exception e) {
				su.txt_log.append("客户端连接错误！" + System.getProperty("line.separator"));
			}
		}
	}
}
