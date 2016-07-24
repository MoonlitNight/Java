package com.string.demo;
import java.util.Arrays;
public class StringDemo4 {
public static void main(String[] args) {
	/*定义字符串*/
	String str="xiaoming";
/*	使用toCharArray()方法将字符串转换为数组*/
	char [] c=str.toCharArray();
/*	调用Arrays.sort()方法排序*/
	Arrays.sort(c);
/*	使用String()构造方法创建新字符串*/
	String str2=new String(c);
/*	打印输出*/
	System.out.print(str2);
}
}
