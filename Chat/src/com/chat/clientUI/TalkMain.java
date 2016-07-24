package com.chat.clientUI;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.chat.client.TcpClient;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TalkMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8580557452450574487L;
	public TcpClient client;// 客户端通讯服务
	private JPanel contentPane;
	private JTextArea area_talkRecord;
	private JTree tree_userList;
	private DefaultMutableTreeNode root=null;

	/**
	 * Create the frame.
	 */
	public TalkMain() {
		
		setResizable(false);
		setTitle("\u804A\u5929\u4FE1\u606F");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(client!=null){
					client.exit();
					}
				dispose();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				client.talk=area_talkRecord;
				client.onlineList=tree_userList;
				client.root=root;
				new Thread(client).start();
			}
		});

		JScrollPane scroll_tree = new JScrollPane();
		scroll_tree.setBounds(30, 40, 200, 400);
		contentPane.add(scroll_tree);
		tree_userList = new JTree();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		root=new DefaultMutableTreeNode("\u5728\u7EBF\u7528\u6237");
		tree_userList.setModel(new DefaultTreeModel(root));
		tree_userList.setFont(new Font("黑体", Font.PLAIN, 16));
		scroll_tree.setViewportView(tree_userList);
		tree_userList.expandRow(0);

		JScrollPane scroll_talkInfo = new JScrollPane();
		scroll_talkInfo.setBounds(280, 40, 460, 230);
		contentPane.add(scroll_talkInfo);

		area_talkRecord = new JTextArea();
		area_talkRecord.setEditable(false);
		area_talkRecord.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		scroll_talkInfo.setViewportView(area_talkRecord);

		JScrollPane scroll_sendInfo = new JScrollPane();
		scroll_sendInfo.setBounds(280, 310, 460, 80);
		contentPane.add(scroll_sendInfo);

		final JTextArea area_send = new JTextArea();
		area_send.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		scroll_sendInfo.setViewportView(area_send);

		JButton btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				area_send.setText(null);
			}
		});
		btn_cancel.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_cancel.setBounds(280, 410, 80, 30);
		contentPane.add(btn_cancel);

		JButton btn_send = new JButton("\u53D1\u9001");
		btn_send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = area_send.getText();
				if (message.length() != 0) {
					client.talk(message);
					area_send.setText(null);//发送后清空列表
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "请输入消息");// 消息窗口
				}
			}
		});
		btn_send.setFont(new Font("黑体", Font.PLAIN, 16));
		btn_send.setBounds(660, 410, 80, 30);
		contentPane.add(btn_send);

		JLabel lab_userList = new JLabel("\u767B\u9646\u7528\u6237");
		lab_userList.setFont(new Font("黑体", Font.PLAIN, 16));
		lab_userList.setBounds(30, 10, 80, 30);
		contentPane.add(lab_userList);

		JLabel lab_talkRecord = new JLabel("\u804A\u5929\u8BB0\u5F55\uFF1A");
		lab_talkRecord.setFont(new Font("黑体", Font.PLAIN, 16));
		lab_talkRecord.setBounds(280, 10, 80, 30);
		contentPane.add(lab_talkRecord);

		JLabel lab_sendInfo = new JLabel("\u53D1\u9001\u4FE1\u606F\uFF1A");
		lab_sendInfo.setFont(new Font("黑体", Font.PLAIN, 16));
		lab_sendInfo.setBounds(280, 280, 80, 30);
		contentPane.add(lab_sendInfo);

	}

}
