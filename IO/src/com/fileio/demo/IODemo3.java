package com.fileio.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo3 {

	public static void main(String[] args) {
		File src = new File("D:\\图片\\Saved Pictures");// 创建源文件Flie对象
		File dest = new File("D:\\图片\\copy");
		try {
			long start = System.currentTimeMillis();//获取开始复制时毫秒值
			copy(src,dest);
			long end = System.currentTimeMillis();//获取复制完成时毫秒值
			System.out.println("复制文件共计使用"+(end-start)+"毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		}
 }

	public static void copy(File src,File dest) throws IOException {
		if (!src.exists()) // 判断是否存在文件或目录
		{
			throw new RuntimeException(src + "路径不存在");// 不存在则抛出异常
		}
		if(!dest.exists())dest.mkdir();//判断目的目录是否存在，不存在则创建该目录
		File[] data = src.listFiles();// 获取源文件目录下的文件列表
		if (data == null) // 判断如果date为null则跳过本次操作
		{
			return;
		}
		// 遍历数组
		for (File file : data) {
			/* 如果是文件则输出文件的绝对路径 */
			if (file.isFile()) {
				rw(file,new File(dest,file.getName()));//复制文件至目的文件夹
			} else if (file.isDirectory()) {
				/*使用目的文件夹对象和file目录生成一个新的File对象 */
				File dir = new File(dest,file.getName());
				if(!dir.exists()){
				if(dir.mkdir())//创建该目录
				{
				copy(file,dir);//创建成功则递归调用复制该目录下的文件
				}else{
				System.out.println("创建副本文件夹失败，文件保存在根目录");
				copy(file,dest);//创建失败则复制到初始目的目录中
				}			
			}else 
			{
				copy(file,dir);//复制该目录下的文件
			}
				}
		}
	}
	public static void rw(File src , File dest) throws IOException {
		if(!src.exists()) throw new RuntimeException("源文件不存在");
		//创建字节流输入缓冲区对象
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		//创建字节流输出缓冲区对象
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		//创建读取字节数组
		byte [] ch = new byte [1024];	
		//创建变量count记录读取到的字节数
		int count = 0 ;
		while((count=bis.read(ch))!=-1)
		{
			bos.write(ch,0, count);//向字节流缓冲区写入数据
		}
		bos.close();//关闭缓冲区对象
		bis.close();//关闭缓冲区对象
	}

}
