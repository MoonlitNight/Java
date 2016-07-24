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
 * @author � TCPClient�����ڿͻ����������ͨѶ
 */
public class TcpClient implements Runnable {

	public JTextArea talk = null;
	public JTree onlineList = null;// �����û��б�
	public DefaultMutableTreeNode root = null;// �����û�����
	private Socket client;// ����ͻ���Socket����
	private OutputStream out;// �ͻ����ֽ����������
	private InputStream in;// �ͻ����ֽ�����������
	private DataOutputStream send;// �������������
	private DataInputStream receive;// ��������������

	public TcpClient(String ip) throws Exception {
		try {
			client = new Socket(ip, 8090);// ����Socket����
			out = client.getOutputStream();// ��ȡ�ͻ����ֽ����������
			in = client.getInputStream();// ��ȡ�ͻ����ֽ�����������
			send = new DataOutputStream(out);// ��ȡ�������������
			receive = new DataInputStream(in);// ��ȡ��������������
		} catch (Exception e) {
			throw new Exception("����������ʧ��");
		}
	}

	// ���������������
	public void send(String data) {
		try {
			send.writeUTF(data);// д������
			send.flush();// ˢ����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �����������ͨ�Ų����ط��������͵���Ϣ
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

	// �ͻ���Socket�����½����
	public String login(String name, char[] password) {
		// תΪ�ַ���������
		send("login&" + name + "&" + new String(password, 0, password.length));// ��������
		return receive();
	}

	// ����ע�᷽��
	public String register(User user) {
		send("register&" + user.toString());// ��������
		return receive();
	}

	// �����޸����뷽��
	public String upPwd(String loginName, String oldPwd, String upPwd) {
		send("upPwd&" + loginName + "&" + oldPwd + "&" + upPwd);
		return receive();
	}

	// ��������Ϣ����
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
				talk.setCaretPosition(talk.getText().length());// �����ı����� �Զ��ƶ�
			} else if (message[0].equals("list")) {
				String[] list = temp.split("&");
				root.removeAllChildren();// �Ƴ������ӽڵ�
				for (int i = 1; i < list.length; i++) {
					root.add(new DefaultMutableTreeNode(list[i]));// ����ӽڵ�
				}
				onlineList.updateUI();// ˢ��ui
			}
		}
	}

	// �û��˳��رտͻ���Socket
	public void exit() {
		try {
			client.close();
		} catch (Exception e) {
			System.out.println("�˳��쳣");
		} finally {
			client = null;
		}
	}

}
