package com.string.demo;

public class StringDemo3 {
public static void main(String[] args) {
	/*�����ַ���*/
	String str="xiaoming";
/*	ʹ��toCharArray()�������ַ���ת��Ϊ����*/
	char [] c=str.toCharArray();
/*	����ð������*/
	sort(c);
/*	ʹ��String()���췽���������ַ���*/
	String str2=new String(c);
/*	��ӡ���*/
	System.out.print(str2);
}
/*ð�����򷽷�*/
public static void sort(char [] c) {
	for(int i=0;i<c.length-1;i++)
		for (int j = 0; j < c.length-1-i; j++) {
			char r;
			if (c[j]>c[j+1])
			{
				r=c[j];
				c[j]=c[j+1];
				c[j+1]=r;
			}
		}
}
}
