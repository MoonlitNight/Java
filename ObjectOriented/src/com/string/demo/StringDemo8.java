package com.string.demo;

public class StringDemo8 {
	public static void main(String[] args) {
		/* 定义字符串 */
		String str = "njkaf;78~_po";
		/* 调用toCharArray()方法将字符串转换为char类型数组 */
		char[] c = str.toCharArray();
		/* 调用count()方法进行字符计数 */
		int[] x = count(c);
		/* 输出打印信息 */
		System.out.println(str + "：此字符串中数字字符有" + x[0] + "个，字母字符有" + x[1] + "个，其他字符有" + x[2] + "个");
	}

	public static int[] count(char[] c) {
		/* 定义出租存放统计信息，索引0为数字字符统计，索引1为字母字符统计，索引2为其他字符统计 */
		int[] temp = new int[3];
		/* 遍历判断数组信息 */
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
