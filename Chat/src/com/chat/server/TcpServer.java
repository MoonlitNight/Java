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
	public static JTextArea log = null;// �����ϵͳ��־
	private static final long serialVersionUID = -2257937307607017151L;
	private Socket userClient;// �û��ͻ���ͨѶSocket
	private User user;// ��ǰ�ͻ��˵�½�û�
	private InputStream in;// TCP�ͻ���ͨѶ�ֽ�����������
	private OutputStream out;// TCP�ͻ���ͨѶ�ֽ����������
	private DataOutputStream send;// �������������
	private DataInputStream receive;// ��������������
	private static ArrayList<User> userList = new ArrayList<>();// ע���û�
	private static ArrayList<User> onlineUser = new ArrayList<>();// �����û�
	private static ArrayList<Socket> chat = new ArrayList<>();// ���ڸ��ͻ���Ⱥ����Ϣ

	// ��̬��������ڳ�ʼ��ʱ��ȡ�û��б����
	static {
		// �û�ע����Ϣ�ļ�����
		File user = new File("user");
		// �����л�����
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
					// �ر���
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
			out = userClient.getOutputStream();// ��ȡ�ͻ����ֽ����������
			in = userClient.getInputStream();// ��ȡ�ͻ����ֽ�����������
		} catch (IOException e) {
			log.append("��ͻ���IP:" + userClient.getInetAddress().getHostAddress() + "����ͨѶʧ��"
					+ System.getProperty("line.separator"));
		}
		send = new DataOutputStream(out);// ��ȡ�������������
		receive = new DataInputStream(in);// ��ȡ��������������
	}

	public void run() {
		try {
			// �ж�����ͻ��������ӷ�������ѭ��
			while (true) {
				checking();// �����ͻ��˷��͵���Ϣ��������Ӧ�ķ�������ͻ�������
			}
		} catch (Exception e) {
			exit();
		}
	}

	// ��ͻ��˷�������
	public void send(String data) {
		try {
			send.writeUTF(data);// д������
			send.flush();// ˢ����
		} catch (IOException e) {
			log.append("��ӦIP:" + userClient.getInetAddress().getHostAddress() + "�ͻ�������ʧ��"
					+ System.getProperty("line.separator"));
		}
	}

	// ��ͻ��˽���ͨ�Ų����ؿͻ��˷��͵���Ϣ
	public String receive() {
		String data = null;
		try {
			data = receive.readUTF();
		} catch (IOException e) {
			log.append("����IP:" + userClient.getInetAddress().getHostAddress() + "�ͻ�������ʧ��"
					+ System.getProperty("line.separator"));
		}
		return data;
	}

	// ���û�������Ϣд�뵽Ӳ����
	private void save(Object data) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("user")));
			oos.writeObject(data);
			oos.close();
			log.append("�ɹ�����ע���û���Ϣ" + System.getProperty("line.separator"));
		} catch (Exception e) {
			log.append(e.toString() + ":" + "����ע���û���Ϣʧ��" + System.getProperty("line.separator"));
		} finally {
			oos = null;
		}
	}

	// �����ͻ��˷��͵���Ϣ��������Ӧ�ķ�������ͻ�������
	private void checking() {
		String data = receive();// ��ȡ�ͻ��˷�������
		String[] temp = data.split("&", 2);
		if (temp[0].equals("login")) {
			login(data);// ���ô����¼����
		} else if (temp[0].equals("upPwd")) {
			updataPassword(data);// �����޸����뷽��
		} else if (temp[0].equals("register")) {
			registerNewUser(data);
		} else if (temp[0].equals("message")) {
			talk(temp);
		}
	}

	// �����û���¼
	public void login(String data) {
		String[] str = data.split("&");
		for (User user : userList) {
			if (user.getLoginName().equals(str[1])) {
				if (user.getPassword().equals(str[2])) {
					if (onlineUser.contains(user)) {
						send("���û�������");
						return;
					}
					this.user = user;// ��ֵ����ǰ�û�
					onlineUser.add(user);// ��ӵ������û�������
					chat.add(userClient);// ��½�ɹ���ѸĿͻ�����ӵ�Ⱥ�Ŀͻ�����
					send("��½�ɹ�");
					sendAll("message&" + user.getLoginName() + "������");
					log.append(user.getLoginName() + "������" + System.getProperty("line.separator"));
					onlineList();
					return;
				}
			}
		}
		send("�˺Ż��������");
	}

	// �����û�ע��
	public void registerNewUser(String data) {
		String[] str = data.split("&");
		User user = null;
		try {
			user = new User(str[1], str[2], str[3], str[4]);
			for (User u : userList) {
				if (user.getLoginName().equals(u.getLoginName())) {
					send("���˺��Ѵ���");
					return;
				}
			}
			userList.add(user);// ��ӵ�ע���û�
			save(userList); // ��������
			send("ע��ɹ�");
			log.append(user.getLoginName() + "ע�������û�" + System.getProperty("line.separator"));
		} catch (Exception e) {
			send(e.toString());
		}
	}

	// �����û��޸�����
	public void updataPassword(String data) {
		String[] str = data.split("&");
		for (User user : userList) {
			if (user.getLoginName().equals(str[1])) {
				if (user.getPassword().equals(str[2])) {
					try {
						user.setPassword(str[3]);
						send("�޸�����ɹ�");
					} catch (Exception e) {
						send(e.toString());
						return;
					}
				} else {
					send("ԭ�������");
					return;
				}
			}
		}
		send("�û�������");
	}

	// �����û�������Ϣ
	public void talk(String[] str) {
		String data = str[0] + "&" + user.getLoginName() + "��" + str[1];
		sendAll(data);
	}

	// Ⱥ����Ϣ
	public void sendAll(String data) {
		DataOutputStream out = null;
		// �����ͻ���д���ַ���
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

	// ��ͻ��˷��������û��б�
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
		onlineUser.remove(user);// �������û����Ƴ�
		chat.remove(userClient);// ��Ⱥ�����˳�
		String exitMessage = "message&" + user.getLoginName() + "���˳���¼";// �û��˳���Ϣ
		log.append(user.getLoginName() + "���˳���¼" + System.getProperty("line.separator"));
		onlineList();
		sendAll(exitMessage);// �㲥��Ϣ
	}

}
