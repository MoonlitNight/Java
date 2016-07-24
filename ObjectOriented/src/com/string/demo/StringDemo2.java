package com.string.demo;

public class StringDemo2 {
public static void main(String[] args) {
/*	定义字符串*/
	String str="http://sh.itcast.cn";
/*	使用startsWith()方法判断是否为网址*/
	boolean flag1=str.startsWith("http://");
	boolean flag2=str.endsWith(".cn");
	boolean flag3=str.endsWith(".com");
	boolean flag4=str.endsWith(".net");
	if(flag1&&(flag2||flag3||flag4))
	{
		System.out.println(str+"是网址");//为true打印该字符串是网址
	}else
	{
		System.out.println(str+"不是网址");//为false则不是网址
	}
}
}
