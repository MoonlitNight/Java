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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class UpPwd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2545382757868525711L;
	private JPanel contentPane;
	private JPasswordField txt_oldPwd;
	private JPasswordField txt_newPwd;
	private JPasswordField txt_upPwd;
	private Login login;// µÇÂ½´°¿Ú¶ÔÏó
	private JTextField txt_loginName;

	/**
	 * Create the frame.
	 */
	public UpPwd() {
		setResizable(false);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				login.setVisible(true);// ·µ»ØµÇÂ½´°¿Ú²¢ÉèÖÃ¿É¼û
				dispose();
			}
		});

		JLabel lab_title = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lab_title.setHorizontalAlignment(SwingConstants.CENTER);
		lab_title.setFont(new Font("¿¬Ìå", Font.BOLD, 20));
		lab_title.setBounds(180, 10, 90, 30);
		contentPane.add(lab_title);

		JLabel lab_loginName = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lab_loginName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lab_loginName.setBounds(70, 50, 80, 30);
		contentPane.add(lab_loginName);

		JLabel lab_oldPwd = new JLabel("\u539F \u5BC6 \u7801\uFF1A");
		lab_oldPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lab_oldPwd.setBounds(70, 95, 80, 30);
		contentPane.add(lab_oldPwd);

		JLabel lab_newPwd = new JLabel("\u65B0 \u5BC6 \u7801\uFF1A");
		lab_newPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lab_newPwd.setBounds(70, 140, 80, 30);
		contentPane.add(lab_newPwd);

		JLabel lab_upPwd = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lab_upPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lab_upPwd.setBounds(70, 185, 80, 30);
		contentPane.add(lab_upPwd);

		txt_loginName = new JTextField();
		txt_loginName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		txt_loginName.setBounds(150, 50, 200, 30);
		contentPane.add(txt_loginName);
		txt_loginName.setColumns(10);

		txt_oldPwd = new JPasswordField();
		txt_oldPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		txt_oldPwd.setBounds(150, 95, 200, 30);
		contentPane.add(txt_oldPwd);

		txt_newPwd = new JPasswordField();
		txt_newPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		txt_newPwd.setBounds(150, 140, 200, 30);
		contentPane.add(txt_newPwd);

		txt_upPwd = new JPasswordField();
		txt_upPwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		txt_upPwd.setBounds(150, 185, 200, 30);
		contentPane.add(txt_upPwd);

		JButton btn_submit = new JButton("\u786E\u8BA4");
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String oldPwd = new String(txt_oldPwd.getPassword(), 0, txt_oldPwd.getPassword().length);// ×ªÎª×Ö·û´®
				String newPwd = new String(txt_newPwd.getPassword(), 0, txt_newPwd.getPassword().length);// ×ªÎª×Ö·û´®
				String upPwd = new String(txt_upPwd.getPassword(), 0, txt_upPwd.getPassword().length);// ×ªÎª×Ö·û´®
				if (!newPwd.equals(upPwd)) {
					JOptionPane.showMessageDialog(getContentPane(), "ÊäÈëÃÜÂë²»Ò»ÖÂ");// ÏûÏ¢´°¿Ú
				} else {
					String mes = login.client.upPwd(txt_loginName.getText(), oldPwd, upPwd);
					JOptionPane.showMessageDialog(getContentPane(), mes);// ÏûÏ¢´°¿Ú
				}
			}
		});
		btn_submit.setFont(new Font("ºÚÌå", Font.PLAIN, 16));
		btn_submit.setBounds(80, 225, 80, 40);
		contentPane.add(btn_submit);

		JButton btn_cancel = new JButton("\u91CD\u7F6E");
		btn_cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_loginName.setText(null);
				txt_oldPwd.setText(null);
				txt_newPwd.setText(null);
				txt_upPwd.setText(null);
			}
		});
		btn_cancel.setFont(new Font("ºÚÌå", Font.PLAIN, 16));
		btn_cancel.setBounds(290, 225, 80, 40);
		contentPane.add(btn_cancel);
	}

	public UpPwd(Login login) {
		this();
		this.login = login;
	}
}
