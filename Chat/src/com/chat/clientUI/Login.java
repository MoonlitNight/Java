package com.chat.clientUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.chat.client.TcpClient;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4981800872785168402L;
	private JPanel contentPane;
	private JPasswordField txt_password;
	private JTextField txt_loginName;
	public TcpClient client;// 客户端通讯服务
	private JTextField txt_ip;// 服务器ip
	private boolean flag = false;// 标志位判断与服务器是否成功建立连接

	/**
	 * Create the frame.
	 */
	public Login() {

		setTitle("\u5C40\u57DF\u7F51\u804A\u5929\u7CFB\u7EDF");
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (client != null) {
					client.exit();
				}
				dispose();
			}
		});

		JLabel lab_loginTitle = new JLabel("\u7528\u6237\u767B\u5F55");
		lab_loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lab_loginTitle.setFont(new Font("楷体", Font.BOLD, 20));
		lab_loginTitle.setBounds(170, 10, 87, 27);
		contentPane.add(lab_loginTitle);

		JLabel lab_loginName = new JLabel("\u8D26  \u53F7\uFF1A");
		lab_loginName.setHorizontalAlignment(SwingConstants.CENTER);
		lab_loginName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_loginName.setBounds(70, 65, 60, 30);
		contentPane.add(lab_loginName);

		JLabel lab_loginPwd = new JLabel("\u5BC6  \u7801\uFF1A");
		lab_loginPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lab_loginPwd.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_loginPwd.setBounds(70, 115, 60, 30);
		contentPane.add(lab_loginPwd);

		JLabel lab_register = new JLabel("\u70B9\u51FB\u6CE8\u518C");
		lab_register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					setTcp();// 连接服务器
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getContentPane(), e1.toString());// 消息窗口
				}
				if (flag) {
					new UserRegister(Login.this).setVisible(true);// 打开注册窗口并设置可见
					setVisible(false);// 登陆窗口隐藏
				}
			}
		});
		lab_register.setForeground(Color.BLUE);
		lab_register.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_register.setBounds(350, 65, 70, 30);
		contentPane.add(lab_register);

		JLabel lab_upPwd = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lab_upPwd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					setTcp();// 连接服务器
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getContentPane(), e1.toString());// 消息窗口
				}
				if (flag) {
					new UpPwd(Login.this).setVisible(true);// 打开修改密码窗口并设置可见
					setVisible(false);// 登陆窗口隐藏
				}
			}
		});
		lab_upPwd.setForeground(Color.RED);
		lab_upPwd.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_upPwd.setBounds(350, 115, 70, 30);
		contentPane.add(lab_upPwd);

		JLabel lab_ip = new JLabel("\u670D\u52A1\u5668IP:");
		lab_ip.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_ip.setBounds(10, 240, 50, 20);
		contentPane.add(lab_ip);

		txt_ip = new JTextField();
		txt_ip.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ip.setText("192.168.1.45");
		txt_ip.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txt_ip.setBounds(60, 240, 80, 20);
		contentPane.add(txt_ip);
		txt_ip.setColumns(10);

		txt_loginName = new JTextField();
		txt_loginName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_loginName.setBounds(130, 65, 200, 30);
		contentPane.add(txt_loginName);
		txt_loginName.setColumns(10);

		txt_password = new JPasswordField();
		txt_password.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_password.setBounds(130, 115, 200, 30);
		contentPane.add(txt_password);

		JButton btn_login = new JButton("\u767B\u9646");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (client == null) {
					try {
						setTcp();// 连接服务器
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getContentPane(), e1.toString());// 消息窗口
					}
				}
				String mes = client.login(txt_loginName.getText(), txt_password.getPassword());
				if (flag) {
					if (mes.equals("登陆成功")) {
						TalkMain talkMain = new TalkMain();
						talkMain.client = client;
						talkMain.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(getContentPane(), mes);// 消息窗口
					}
				}
			}
		});
		btn_login.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_login.setBounds(110, 180, 80, 40);
		contentPane.add(btn_login);

		JButton btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (client != null) {
					client.exit();
				}
				dispose();// 鼠标单击取消则关闭登陆窗口
			}
		});
		btn_cancel.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_cancel.setBounds(270, 180, 80, 40);
		contentPane.add(btn_cancel);
	}

	// 建立通讯服务
	private void setTcp() throws Exception {
		String ip = txt_ip.getText();
		if (!ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
			JOptionPane.showMessageDialog(getContentPane(), "非法地址");// 消息窗口
			return;
		}
		client = new TcpClient(ip);// 初始化连接
		flag = true;
	}
}
