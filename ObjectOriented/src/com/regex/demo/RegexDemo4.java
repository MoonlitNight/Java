package com.regex.demo;

import java.util.Scanner;//�����

public class RegexDemo4 {
	public static void main(String[] args) {
		/* ����Scanner���� */
		Scanner input = new Scanner(System.in);
		/* �����ʾ��Ϣ */
		System.out.println("�����룺");
		/* ɨ��¼����Ϣ */
		String e = input.nextLine();
		boolean f = flag(e);
		/* ��ӡ��Ϣ */
		System.out.println(f);
		/* �رն��󣬻�����Դ */
		input.close();
	}

	public static boolean flag(String e) {
		return e.matches("[a-zA-Z]+$");
	}
}
