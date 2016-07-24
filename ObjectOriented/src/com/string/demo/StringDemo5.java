package com.string.demo;

public class StringDemo5 {
	public static void main(String[] args) {
		/* 定义字符串 */
		String str = "HelloWorld!";
		/* 定义整型变量count计数，index为0作为索引值 */
		int count = 0, index = 0;
		/*
		 * 循环判断，索引值index不为-1即为搜索到该数字，计数count加一，
		 * 索引值index加一，继续检索，直到index为-1时跳出循环
		 */
		while (true) {
			index = str.indexOf('l', index);
			if (index != -1) {
				count++;
				index += 1;
			} else
				break;
		}
		System.out.println(str+"中'l'出现的次数为" + count);
	}
}
