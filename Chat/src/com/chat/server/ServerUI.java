package com.chat.server;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class ServerUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7159723955597624087L;
	private JPanel contentPane;
	public JTextArea txt_log = null;

	/**
	 * Create the frame.
	 */
	public ServerUI() {
		setTitle("\u670D\u52A1\u5668\u65E5\u5FD7");
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		txt_log = new JTextArea();
		txt_log.setEditable(false);
		txt_log.setFont(new Font("ºÚÌå", Font.PLAIN, 16));
		scrollPane.setViewportView(txt_log);
	}
}
