package com.string.demo;

public class StringDemo9 {
	public static void main(String[] args) {
		/* �����ַ��� */
		String str = "qwehjksdhuosdjksdplsd";
		/* �������ͱ���count������indexΪ0��Ϊ����ֵ */
		int count = 0, index = 0;
		/*
		 * ѭ���жϣ�����ֵindex��Ϊ-1��Ϊ�����������֣�����count��һ��
		 * ����ֵindex��һ������������ֱ��indexΪ-1ʱ����ѭ��
		 */
		while (true) {
			index = str.indexOf("sd", index);
			if (index != -1) {
				count++;
				index += 1;
			} else
				break;
		}
		System.out.println(str+"��sd���ֵĴ���Ϊ" + count);
	}
}
