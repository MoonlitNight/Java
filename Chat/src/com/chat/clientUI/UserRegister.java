package com.chat.clientUI;

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

import com.chat.user.User;

public class UserRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -451637170330359176L;
	private JPanel contentPane;
	private JTextField txt_loginName;
	private JTextField txt_phone;
	private JTextField txt_email;
	private JPasswordField txt_newPwd;
	private JPasswordField txt_upPwd;
	private Login login;// 登陆窗口对象

	/**
	 * Create the frame.
	 */
	public UserRegister() {
		setTitle("\u6CE8\u518C");
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				login.setVisible(true);// 返回登陆窗口并设置可见
				dispose();
			}
		});

		JLabel lab_title = new JLabel("\u7528\u6237\u6CE8\u518C");
		lab_title.setHorizontalAlignment(SwingConstants.CENTER);
		lab_title.setFont(new Font("楷体", Font.BOLD, 20));
		lab_title.setBounds(150, 10, 120, 30);
		contentPane.add(lab_title);

		JLabel lab_loginName = new JLabel("\u8D26    \u53F7\uFF1A");
		lab_loginName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_loginName.setBounds(50, 50, 80, 30);
		contentPane.add(lab_loginName);

		JLabel lab_password = new JLabel("\u5BC6    \u7801\uFF1A");
		lab_password.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_password.setBounds(50, 100, 80, 30);
		contentPane.add(lab_password);

		JLabel lab_upPwd = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lab_upPwd.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_upPwd.setBounds(50, 150, 80, 30);
		contentPane.add(lab_upPwd);

		JLabel lab_phone = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lab_phone.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_phone.setBounds(50, 200, 80, 30);
		contentPane.add(lab_phone);

		JLabel lab_email = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		lab_email.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lab_email.setBounds(50, 250, 80, 30);
		contentPane.add(lab_email);

		txt_loginName = new JTextField();
		txt_loginName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_loginName.setBounds(130, 50, 200, 30);
		contentPane.add(txt_loginName);
		txt_loginName.setColumns(10);

		txt_phone = new JTextField();
		txt_phone.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_phone.setColumns(10);
		txt_phone.setBounds(130, 200, 200, 30);
		contentPane.add(txt_phone);

		txt_email = new JTextField();
		txt_email.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_email.setColumns(10);
		txt_email.setBounds(130, 250, 200, 30);
		contentPane.add(txt_email);

		txt_newPwd = new JPasswordField();
		txt_newPwd.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_newPwd.setBounds(130, 100, 200, 30);
		contentPane.add(txt_newPwd);

		txt_upPwd = new JPasswordField();
		txt_upPwd.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		txt_upPwd.setBounds(130, 150, 200, 30);
		contentPane.add(txt_upPwd);

		JButton btn_register = new JButton("\u6CE8\u518C");
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = getUser();
				if (user != null) {
					String mes = login.client.register(user);
					JOptionPane.showMessageDialog(getContentPane(), mes);// 消息窗口
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "注册失败");// 消息窗口
				}
			}
		});
		btn_register.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_register.setBounds(70, 310, 80, 40);
		contentPane.add(btn_register);

		JButton btn_reset = new JButton("\u91CD\u7F6E");
		btn_reset.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_loginName.setText(null);
				txt_newPwd.setText(null);
				txt_upPwd.setText(null);
				txt_phone.setText(null);
				txt_email.setText(null);
			}
		});
		btn_reset.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_reset.setBounds(240, 310, 80, 40);
		contentPane.add(btn_reset);
	}

	public UserRegister(Login login) {
		this();
		this.login = login;
	}

	private User getUser() {
		User user = null;
		String newPwd = new String(txt_newPwd.getPassword(), 0, txt_newPwd.getPassword().length);// 转为字符串
		String upPwd = new String(txt_upPwd.getPassword(), 0, txt_upPwd.getPassword().length);// 转为字符串
		if (!newPwd.equals(upPwd)) {
			JOptionPane.showMessageDialog(getContentPane(), "输入的密码不一致");// 消息窗口
			return null;
		} else {
			user = new User();// 创建新用户
			try {
				user.setLoginName(txt_loginName.getText());
				user.setPassword(upPwd);
				user.setPhone(txt_phone.getText());
				user.setEmail(txt_email.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(getContentPane(), e.toString());// 消息窗口
				return null;
			}
		}
		return user;
	}
}
