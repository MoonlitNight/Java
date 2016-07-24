package com.filerw.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
	static long count = 0;
	public static void main(String[] args) {
		//创建需要统计的文件对象
		File file = new File("D:\\Test\\UTF-8.txt");
		System.out.println("请输入需要统计的字符串：");
		String key = input();
		try {
			count(file,key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+file.toString()+"]中包含\""+key+"\"的共计:"+count+"个。");
	}
	public static String input() {
		//获取字节输入流，并把字节流转换为字符流
		InputStreamReader isr = new InputStreamReader(System.in);
		//创建字符输入流缓冲区对象
		BufferedReader br = new BufferedReader(isr);
		String str = "";
		try {
			str = br.readLine();//读取一行字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	public static void count(File file, String key) throws IOException {
		//创建字符输入流缓冲区
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTf-8"));
		//读取一行字符串，返回值不为null则继续读取
		String str = "";
		while((str=br.readLine())!=null)
		{
			regex(str,key);//判断字符串中是否有相关的序列
		}
		br.close();//关闭对象，回收资源
	}
	public static void regex(String str,String key) {
		/*根据正则表达式获取Pattern类实例*/
		Pattern p = Pattern.compile(key);
		/*根据Pattern实例获取匹配器（Matcher）对象*/
		Matcher m = p.matcher(str);
		while(m.find())//寻找符合规则的序列
		{
			count++;//计数器加一
		}
	}

}
