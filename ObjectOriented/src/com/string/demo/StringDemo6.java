package com.string.demo;
import java.util.Arrays;

public class StringDemo6 {
	public static void main(String[] args) {
		/* 定义字符串 */
		String str = "JAVA，技术，哪家，强，中国，上海，找，传智";
		/* 调用String中的split()方法进行切割 */
		String[] ss = str.split("，");
		/* 调用数组排序方法sort()进行数组排序 */
		Arrays.sort(ss);
		/* 调用字符串拼接方法拼接字符串 */
		String str2 = arrayToString(ss);
		System.out.println("拼接后的字符串为：" + str2);// 输出打印
	}

	public static String arrayToString(String[] s) {
		/* 新建StringBuilder字符串缓冲区对象 */
		StringBuilder temp = new StringBuilder();
		/* 遍历拼接 */
		for (int i = 0; i < s.length; i++) {
			/* 调用StringBuilder中的append()方法添加字符串 */
			temp.append(s[i] + "，");
		}
		/* 调用StringBuilder中的delete()方法删除最后一个字符 */
		temp.delete(temp.length() - 1, temp.length());
		/* 返回转换为字符串的对象 */
		return temp.toString();
	}
}
