package com.string.demo;
import java.util.Arrays;

public class StringDemo6 {
	public static void main(String[] args) {
		/* �����ַ��� */
		String str = "JAVA���������ļң�ǿ���й����Ϻ����ң�����";
		/* ����String�е�split()���������и� */
		String[] ss = str.split("��");
		/* �����������򷽷�sort()������������ */
		Arrays.sort(ss);
		/* �����ַ���ƴ�ӷ���ƴ���ַ��� */
		String str2 = arrayToString(ss);
		System.out.println("ƴ�Ӻ���ַ���Ϊ��" + str2);// �����ӡ
	}

	public static String arrayToString(String[] s) {
		/* �½�StringBuilder�ַ������������� */
		StringBuilder temp = new StringBuilder();
		/* ����ƴ�� */
		for (int i = 0; i < s.length; i++) {
			/* ����StringBuilder�е�append()��������ַ��� */
			temp.append(s[i] + "��");
		}
		/* ����StringBuilder�е�delete()����ɾ�����һ���ַ� */
		temp.delete(temp.length() - 1, temp.length());
		/* ����ת��Ϊ�ַ����Ķ��� */
		return temp.toString();
	}
}
