package com.string.demo;

public class StringDemo8 {
	public static void main(String[] args) {
		/* �����ַ��� */
		String str = "njkaf;78~_po";
		/* ����toCharArray()�������ַ���ת��Ϊchar�������� */
		char[] c = str.toCharArray();
		/* ����count()���������ַ����� */
		int[] x = count(c);
		/* �����ӡ��Ϣ */
		System.out.println(str + "�����ַ����������ַ���" + x[0] + "������ĸ�ַ���" + x[1] + "���������ַ���" + x[2] + "��");
	}

	public static int[] count(char[] c) {
		/* ���������ͳ����Ϣ������0Ϊ�����ַ�ͳ�ƣ�����1Ϊ��ĸ�ַ�ͳ�ƣ�����2Ϊ�����ַ�ͳ�� */
		int[] temp = new int[3];
		/* �����ж�������Ϣ */
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= '0' && c[i] <= '9') {
				temp[0]++;
			} else if ((c[i] >= 'A' && c[i] < 'Z') || (c[i] >= 'a' && c[i] <= 'z')) {
				temp[1]++;
			} else {
				temp[2]++;
			}
		}
		return temp;
	}
}
