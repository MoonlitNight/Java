package com.string.demo;

public class StringDemo2 {
public static void main(String[] args) {
/*	�����ַ���*/
	String str="http://sh.itcast.cn";
/*	ʹ��startsWith()�����ж��Ƿ�Ϊ��ַ*/
	boolean flag1=str.startsWith("http://");
	boolean flag2=str.endsWith(".cn");
	boolean flag3=str.endsWith(".com");
	boolean flag4=str.endsWith(".net");
	if(flag1&&(flag2||flag3||flag4))
	{
		System.out.println(str+"����ַ");//Ϊtrue��ӡ���ַ�������ַ
	}else
	{
		System.out.println(str+"������ַ");//Ϊfalse������ַ
	}
}
}
