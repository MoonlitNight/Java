package com.regex.demo;

import java.util.Scanner;//�����

public class RegexDemo3 {
	public static void main(String[] args) {
		/* ����Scanner���� */
		Scanner input = new Scanner(System.in);
		/* �����ʾ��Ϣ */
		System.out.println("�����룺");
		/* ɨ��¼����Ϣ */
		String cn = input.nextLine();
		boolean f = flag(cn);
		/* ��ӡ��Ϣ */
		System.out.println(f);
		/* �رն��󣬻�����Դ */
		input.close();
	}

	public static boolean flag(String cn) {
		return cn.matches("^[\u4E00-\u9FA5]+$");
	}
}
