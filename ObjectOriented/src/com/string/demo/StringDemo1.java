package com.string.demo;

public class StringDemo1 {
public static void main(String[] args) {
	/*定义字符串*/
	String str="sh.itcast.net";
	/*检索t第一次出现的角标*/
	int index1=str.indexOf('t');
	/*从第一次出现的索引位置检索t第二次出现的角标*/
	int index2=str.indexOf('t', index1+1);
		/* 输出打印 */
	System.out.println("第一次出现的位置"+index1+"第二次出现的位置"+index2);
}
}
