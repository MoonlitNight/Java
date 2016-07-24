package com.string.demo;

public class StringDemo7 {
	public static void main(String[] args) {
		/* 定义字符串 */
		String str = "qwerty@gg.com";
		/* 检索字符串中@出现的索引 */
		int f1 = str.indexOf("@");
		/* 从@出现的索引检索"."出现的索引位置 */
		int f2 = str.indexOf(".", f1 + 1);
		if (f1 > 0 && f2 > 0) {
			System.out.println(str + "是邮箱地址");
		} else {
			System.out.println(str + "不是邮箱地址");
		}
	}
}
