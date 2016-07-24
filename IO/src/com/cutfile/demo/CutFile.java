package com.cutfile.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CutFile {

	public static void main(String[] args) throws IOException {
		//根据源文件路径创建File类对象
		File src = new File("D:/test/test.jpg");
		//创建字节输入流缓冲区对象
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		//定义切割文件part号
		int part = 1;
		//定义一个byte数组一次读取多个字节存储在数组中
		byte [] buf = new byte[1024*100];
		//定义int型变量记录实际读取到的字节数
		int len = 0 ;
		while((len=bis.read(buf))!=-1)
		{
			//定义字节输出流缓冲区对象
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(src.getParent(),"part"+part)));
			bos.write(buf, 0, len);
			bos.flush();
			bos.close();
			part++;
		}
		bis.close();
	}

}
