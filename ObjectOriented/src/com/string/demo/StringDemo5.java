package com.string.demo;

public class StringDemo5 {
	public static void main(String[] args) {
		/* �����ַ��� */
		String str = "HelloWorld!";
		/* �������ͱ���count������indexΪ0��Ϊ����ֵ */
		int count = 0, index = 0;
		/*
		 * ѭ���жϣ�����ֵindex��Ϊ-1��Ϊ�����������֣�����count��һ��
		 * ����ֵindex��һ������������ֱ��indexΪ-1ʱ����ѭ��
		 */
		while (true) {
			index = str.indexOf('l', index);
			if (index != -1) {
				count++;
				index += 1;
			} else
				break;
		}
		System.out.println(str+"��'l'���ֵĴ���Ϊ" + count);
	}
}
