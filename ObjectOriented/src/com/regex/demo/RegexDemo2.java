package com.regex.demo;

import java.util.Scanner;//�����

public class RegexDemo2 {
	public static void main(String[] args) {
		/* ����Scanner���� */
		Scanner input = new Scanner(System.in);
		/* �����ʾ��Ϣ */
		System.out.println("������Email��");
		/* ɨ��¼����Ϣ */
		String mail = input.nextLine();
		boolean f = flag(mail);
		/* ��ӡ��Ϣ */
		System.out.println(f);
		/* �رն��󣬻�����Դ */
		input.close();
	}

	public static boolean flag(String mail) {
		return mail.matches("^([a-zA-Z]|[1-9])\\w+@([a-zA-z]|(\\d))+\\.[a-zA-Z]+$");
	}
}
