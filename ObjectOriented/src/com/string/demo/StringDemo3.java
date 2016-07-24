package com.string.demo;

public class StringDemo3 {
public static void main(String[] args) {
	/*定义字符串*/
	String str="xiaoming";
/*	使用toCharArray()方法将字符串转换为数组*/
	char [] c=str.toCharArray();
/*	调用冒泡排序*/
	sort(c);
/*	使用String()构造方法创建新字符串*/
	String str2=new String(c);
/*	打印输出*/
	System.out.print(str2);
}
/*冒泡排序方法*/
public static void sort(char [] c) {
	for(int i=0;i<c.length-1;i++)
		for (int j = 0; j < c.length-1-i; j++) {
			char r;
			if (c[j]>c[j+1])
			{
				r=c[j];
				c[j]=c[j+1];
				c[j+1]=r;
			}
		}
}
}
