package com.reflect.demo;

public class Demo {

	public static void main(String[] args) {
		String str = new String("amit");
		System.out.println(str.replace('m', 'r'));
		System.out.println(str);
		String s3 = "amit";
		String s4 = "amit";
		String s2 = str.replace('m', 'r');
		System.out.println(s2==s3);
		System.out.println(s4==s3);
	}

}
