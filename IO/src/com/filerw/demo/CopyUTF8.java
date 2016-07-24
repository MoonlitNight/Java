package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyUTF8 {

	public static void main(String[] args) {
		/* 创建源文件File对象 */
		File src = new File("D:\\Test\\UTF-8.txt");
		/* 创建目标文件对象 */
		File dest = new File("D:\\Test\\copy.txt");
		try {
			long start = System.currentTimeMillis();
			copy(src, dest);// 调用copy方法复制文件
			long end = System.currentTimeMillis();
			System.out.println("复制文件共计使用" + (end - start) + "毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copy(File src, File dest) throws IOException {
		// 如果源文件不存在则抛出异常
		if (!src.exists())
			throw new RuntimeException("目标文件不存在");
		/* 指定解码表，创建字符输入流缓冲区对象，用来读取源文件 */
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(src),"UTF-8"));
		/* 指定编码表，创建字符输出流缓冲区对象，用来写入新文件 */
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest),"UTF-8"));
		String str = "";
		// 读取一行字符串，判断返回值不为null则继续读取
		while ((str = r.readLine()) != null) {
			w.write(str);// 写入字符串
			w.newLine();// 写入换行符
			w.flush();// 刷新缓冲区
		}
		r.close();// 关闭对象
		w.close();// 关闭
	}

}
