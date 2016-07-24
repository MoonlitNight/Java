package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {

	public static void main(String[] args) {
		/* 创建源文件File对象 */
		File src = new File("D:\\Test\\明朝那些事儿.txt");
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
		/* 创建字符输入流缓冲区对象，用来读取源文件 */
		BufferedReader r = new BufferedReader(new FileReader(src));
		/* 创建字符输出流缓冲区对象，用来写入新文件 */
		BufferedWriter w = new BufferedWriter(new FileWriter(dest));
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
