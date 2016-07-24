package com.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.chat.user.User;

/**
 * @author 瑾 TCPClient类用于客户端与服务器通讯
 */
public class TcpClient implements Runnable {

	public JTextArea talk = null;
	public JTree onlineList = null;// 在线用户列表
	public DefaultMutableTreeNode root = null;// 在线用户根树
	private Socket client;// 定义客户端Socket对象
	private OutputStream out;// 客户端字节输出流对象
	private InputStream in;// 客户端字节输入流对象
	private DataOutputStream send;// 数据输出流对象
	private DataInputStream receive;// 数据输入流对象

	public TcpClient(String ip) throws Exception {
		try {
			client = new Socket(ip, 8090);// 创建Socket对象
			out = client.getOutputStream();// 获取客户端字节输出流对象
			in = client.getInputStream();// 获取客户端字节输入流对象
			send = new DataOutputStream(out);// 获取数据输出流对象
			receive = new DataInputStream(in);// 获取数据输入流对象
		} catch (Exception e) {
			throw new Exception("服务器连接失败");
		}
	}

	// 向服务器发送数据
	public void send(String data) {
		try {
			send.writeUTF(data);// 写入数据
			send.flush();// 刷新流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 与服务器进行通信并返回服务器发送的消息
	public String receive() {
		String data = null;
		try {
			data = receive.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	// 客户端Socket处理登陆方法
	public String login(String name, char[] password) {
		// 转为字符串并发送
		send("login&" + name + "&" + new String(password, 0, password.length));// 发送数据
		return receive();
	}

	// 处理注册方法
	public String register(User user) {
		send("register&" + user.toString());// 发送数据
		return receive();
	}

	// 处理修改密码方法
	public String upPwd(String loginName, String oldPwd, String upPwd) {
		send("upPwd&" + loginName + "&" + oldPwd + "&" + upPwd);
		return receive();
	}

	// 处理发送消息方法
	public void talk(String message) {
		send("message&" + message);
	}

	@Override
	public void run() {
		while (true) {
			String temp = receive();
			String[] message = temp.split("&", 2);
			if (message[0].equals("message")) {
				talk.append(message[1] + System.getProperty("line.separator"));
				talk.setCaretPosition(talk.getText().length());// 根据文本长度 自动移动
			} else if (message[0].equals("list")) {
				String[] list = temp.split("&");
				root.removeAllChildren();// 移除所有子节点
				for (int i = 1; i < list.length; i++) {
					root.add(new DefaultMutableTreeNode(list[i]));// 添加子节点
				}
				onlineList.updateUI();// 刷新ui
			}
		}
	}

	// 用户退出关闭客户端Socket
	public void exit() {
		try {
			client.close();
		} catch (Exception e) {
			System.out.println("退出异常");
		} finally {
			client = null;
		}
	}

}
