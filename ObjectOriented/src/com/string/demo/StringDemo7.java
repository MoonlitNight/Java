package com.string.demo;

public class StringDemo7 {
	public static void main(String[] args) {
		/* �����ַ��� */
		String str = "qwerty@gg.com";
		/* �����ַ�����@���ֵ����� */
		int f1 = str.indexOf("@");
		/* ��@���ֵ���������"."���ֵ�����λ�� */
		int f2 = str.indexOf(".", f1 + 1);
		if (f1 > 0 && f2 > 0) {
			System.out.println(str + "�������ַ");
		} else {
			System.out.println(str + "���������ַ");
		}
	}
}
