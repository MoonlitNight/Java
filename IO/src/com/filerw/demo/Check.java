package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Check {
	public static void main(String[] args) {
		/* 创建源文件File对象 */
		File src = new File("D:\\Test\\kkk.txt");
		try {
			check(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void check(File src) throws IOException {
		// 如果源文件不存在则抛出异常
		if (!src.exists())
			throw new RuntimeException("目标文件不存在");
		/* 指定解码表，创建字符输入流缓冲区对象，用来读取源文件 */
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
		String temp = "";
		StringBuilder sb = new StringBuilder();
		// 读取一行字符串，判断返回值不为null则继续读取
		while ((temp = r.readLine()) != null) {
			String str = temp.replaceAll("SB|sb","**");
			str = str.replaceAll("tmd|TMD","***");
			sb.append(str);//保存在字符缓冲区
			sb.append(System.getProperty("line.separator"));//写入换行符
		}
		/* 指定编码表，创建字符输出流缓冲区对象，用来写入新文件 */
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src)));
		w.write(sb.toString());
		r.close();// 关闭对象
		w.close();// 关闭
	}
}
