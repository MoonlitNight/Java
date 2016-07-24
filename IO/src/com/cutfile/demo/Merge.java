package com.cutfile.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge {

	public static void main(String[] args) throws IOException {
		//定义字节输出流缓冲区对象
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:/test/temp.jpg")));
		//定义布尔变量f，为true时继续读取
		boolean f = true;
		//定义整型变量part，计算读取文件个数
		int part = 1;
		while(f)
		{
			//创建字节输入流缓冲区对象
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("D:/test/part"+part)));
			//定义字节数组用于存储数据
			byte[] buf = new byte [1024];
			//定义整形变量len用于接收读取到的字节数
			int len = 0;
			while((len = bis.read(buf))!=-1)
			{
				bos.write(buf, 0, len);
				bos.flush();
				if(len!=1024)//判断实际读取到的字节数不为1024个时则不再继续读取数据
					f=false;
			}
			part++;
			bis.close();
		}
		bos.close();
	}

}
