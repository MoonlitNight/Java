package com.string.demo;
import java.util.Arrays;
public class StringDemo4 {
public static void main(String[] args) {
	/*�����ַ���*/
	String str="xiaoming";
/*	ʹ��toCharArray()�������ַ���ת��Ϊ����*/
	char [] c=str.toCharArray();
/*	����Arrays.sort()��������*/
	Arrays.sort(c);
/*	ʹ��String()���췽���������ַ���*/
	String str2=new String(c);
/*	��ӡ���*/
	System.out.print(str2);
}
}
