package com.string.demo;

public class StringDemo1 {
public static void main(String[] args) {
	/*�����ַ���*/
	String str="sh.itcast.net";
	/*����t��һ�γ��ֵĽǱ�*/
	int index1=str.indexOf('t');
	/*�ӵ�һ�γ��ֵ�����λ�ü���t�ڶ��γ��ֵĽǱ�*/
	int index2=str.indexOf('t', index1+1);
		/* �����ӡ */
	System.out.println("��һ�γ��ֵ�λ��"+index1+"�ڶ��γ��ֵ�λ��"+index2);
}
}
