package com.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

import com.chat.user.User;

public class TcpServer implements Serializable, Runnable {
	/**
	 * 
	 */
	public static JTextArea log = null;// 服务端系统日志
	private static final long serialVersionUID = -2257937307607017151L;
	private Socket userClient;// 用户客户端通讯Socket
	private User user;// 当前客户端登陆用户
	private InputStream in;// TCP客户端通讯字节输入流对象
	private OutputStream out;// TCP客户端通讯字节输出流对象
	private DataOutputStream send;// 数据输出流对象
	private DataInputStream receive;// 数据输入流对象
	private static ArrayList<User> userList = new ArrayList<>();// 注册用户
	private static ArrayList<User> onlineUser = new ArrayList<>();// 在线用户
	private static ArrayList<Socket> chat = new ArrayList<>();// 用于给客户端群发消息

	// 静态代码块用于初始化时读取用户列表对象
	static {
		// 用户注册信息文件对象
		File user = new File("user");
		// 反序列化对象
		ObjectInputStream ois = null;
		if (user.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(user));
				try {
					userList = (ArrayList<User>) ois.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// 关闭流
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					ois = null;
				}
			}
		}
	}

	public TcpServer(Socket client) {
		super();
		this.userClient = client;
		try {
			out = userClient.getOutputStream();// 获取客户端字节输出流对象
			in = userClient.getInputStream();// 获取客户端字节输入流对象
		} catch (IOException e) {
			log.append("与客户端IP:" + userClient.getInetAddress().getHostAddress() + "建立通讯失败"
					+ System.getProperty("line.separator"));
		}
		send = new DataOutputStream(out);// 获取数据输出流对象
		receive = new DataInputStream(in);// 获取数据输入流对象
	}

	public void run() {
		try {
			// 判断如果客户端在连接服务器则循环
			while (true) {
				checking();// 检索客户端发送的信息并调用相应的方法处理客户端请求
			}
		} catch (Exception e) {
			exit();
		}
	}

	// 向客户端发送数据
	public void send(String data) {
		try {
			send.writeUTF(data);// 写入数据
			send.flush();// 刷新流
		} catch (IOException e) {
			log.append("回应IP:" + userClient.getInetAddress().getHostAddress() + "客户端请求失败"
					+ System.getProperty("line.separator"));
		}
	}

	// 与客户端进行通信并返回客户端发送的消息
	public String receive() {
		String data = null;
		try {
			data = receive.readUTF();
		} catch (IOException e) {
			log.append("接收IP:" + userClient.getInetAddress().getHostAddress() + "客户端请求失败"
					+ System.getProperty("line.separator"));
		}
		return data;
	}

	// 将用户数据信息写入到硬盘中
	private void save(Object data) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("user")));
			oos.writeObject(data);
			oos.close();
			log.append("成功保存注册用户信息" + System.getProperty("line.separator"));
		} catch (Exception e) {
			log.append(e.toString() + ":" + "保存注册用户信息失败" + System.getProperty("line.separator"));
		} finally {
			oos = null;
		}
	}

	// 检索客户端发送的信息并调用相应的方法处理客户端请求
	private void checking() {
		String data = receive();// 读取客户端发送数据
		String[] temp = data.split("&", 2);
		if (temp[0].equals("login")) {
			login(data);// 调用处理登录方法
		} else if (temp[0].equals("upPwd")) {
			updataPassword(data);// 调用修改密码方法
		} else if (temp[0].equals("register")) {
			registerNewUser(data);
		} else if (temp[0].equals("message")) {
			talk(temp);
		}
	}

	// 处理用户登录
	public void login(String data) {
		String[] str = data.split("&");
		for (User user : userList) {
			if (user.getLoginName().equals(str[1])) {
				if (user.getPassword().equals(str[2])) {
					if (onlineUser.contains(user)) {
						send("该用户已在线");
						return;
					}
					this.user = user;// 赋值给当前用户
					onlineUser.add(user);// 添加到在线用户集合中
					chat.add(userClient);// 登陆成功则把改客户端添加到群聊客户端中
					send("登陆成功");
					sendAll("message&" + user.getLoginName() + "已上线");
					log.append(user.getLoginName() + "已上线" + System.getProperty("line.separator"));
					onlineList();
					return;
				}
			}
		}
		send("账号或密码错误");
	}

	// 处理用户注册
	public void registerNewUser(String data) {
		String[] str = data.split("&");
		User user = null;
		try {
			user = new User(str[1], str[2], str[3], str[4]);
			for (User u : userList) {
				if (user.getLoginName().equals(u.getLoginName())) {
					send("此账号已存在");
					return;
				}
			}
			userList.add(user);// 添加到注册用户
			save(userList); // 保存数据
			send("注册成功");
			log.append(user.getLoginName() + "注册了新用户" + System.getProperty("line.separator"));
		} catch (Exception e) {
			send(e.toString());
		}
	}

	// 处理用户修改密码
	public void updataPassword(String data) {
		String[] str = data.split("&");
		for (User user : userList) {
			if (user.getLoginName().equals(str[1])) {
				if (user.getPassword().equals(str[2])) {
					try {
						user.setPassword(str[3]);
						send("修改密码成功");
					} catch (Exception e) {
						send(e.toString());
						return;
					}
				} else {
					send("原密码错误");
					return;
				}
			}
		}
		send("用户名错误");
	}

	// 处理用户聊天信息
	public void talk(String[] str) {
		String data = str[0] + "&" + user.getLoginName() + "：" + str[1];
		sendAll(data);
	}

	// 群发消息
	public void sendAll(String data) {
		DataOutputStream out = null;
		// 遍历客户端写入字符串
		for (Socket s : chat) {
			try {
				out = new DataOutputStream(s.getOutputStream());
				out.writeUTF(data);
			} catch (IOException e) {
				log.append(e.toString() + System.getProperty("line.separator"));
			} finally {
				try {
					out.flush();
				} catch (IOException e) {
					log.append(e.toString() + System.getProperty("line.separator"));
				}
			}
		}
	}

	// 向客户端发送在线用户列表
	public void onlineList() {
		StringBuffer sb = new StringBuffer();
		sb.append("list&");
		for (Iterator<User> it = onlineUser.iterator(); it.hasNext();) {
			User temp = it.next();
			sb.append(temp.getLoginName() + "&");
		}
		sb.delete(sb.length() - 1, sb.length());
		sendAll(sb.toString());
	}

	public void exit() {
		if (user == null && onlineUser.isEmpty())
			return;
		onlineUser.remove(user);// 从在线用户中移除
		chat.remove(userClient);// 从群聊中退出
		String exitMessage = "message&" + user.getLoginName() + "已退出登录";// 用户退出消息
		log.append(user.getLoginName() + "已退出登录" + System.getProperty("line.separator"));
		onlineList();
		sendAll(exitMessage);// 广播消息
	}

}
