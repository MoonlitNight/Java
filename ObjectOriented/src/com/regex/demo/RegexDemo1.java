package com.regex.demo;

import java.util.Scanner;//�����

public class RegexDemo1 {
	public static void main(String[] args) {
		/* ����Scanner���� */
		Scanner input = new Scanner(System.in);
		/* �����ʾ��Ϣ */
		System.out.println("���������֤���룺");
		/* ɨ��¼����Ϣ */
		String id = input.nextLine();
		boolean f = flag(id);
		/* ��ӡ��Ϣ */
		System.out.println(f);
		/* �رն��󣬻�����Դ */
		input.close();
	}

	public static boolean flag(String id) {
		return id.matches("^[1-9]\\d{5}[1||2]\\d{3}(0[1-9]||1[0-2])([0-2]\\d||3[01])\\d{3}(\\d||X)$");
		
	}
}
