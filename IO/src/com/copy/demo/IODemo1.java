package com.copy.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

class Queue {
	LinkedList<File> queue = new LinkedList<>();// 创建LinkedList链表集合模拟队列结构

	public void add(File file)// 向集合中添加文件对象
	{
		queue.addFirst(file);// 从头开始添加
	}

	public File getFile()// 从集合中获取文件对象
	{
		return queue.removeLast();
	}

	public boolean isEmpty()// 判断集合中是否为空
	{
		return queue.isEmpty();
	}
}

public class IODemo1 {
	
	public static Queue queue = new Queue();// 创建队列对象
	public static void main(String[] args) {
		File src = new File("D:\\视频\\fs 2014巡演 舞濱場");// 创建源文件Flie对象
		File dest = new File("D:\\copy");
		try {
			long start = System.currentTimeMillis();// 获取开始复制时毫秒值
			copy(src, dest);
			long end = System.currentTimeMillis();// 获取复制完成时毫秒值
			System.out.println("复制文件共计使用" + (end - start) + "毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copy(File src, File dest) throws IOException {
		if (!src.exists()) // 判断是否存在文件或目录
		{
			throw new RuntimeException(src + "路径不存在");// 不存在则抛出异常
		}
		if (!dest.exists()){
			if(dest.mkdir())// 判断目的目录是否存在，不存在则创建该目录
			{
				System.out.println("创建"+dest.getAbsolutePath()+"路径成功！");
			}else{
				System.out.println("创建"+dest.getAbsolutePath()+"路径失败！\n文件保存到上级目录");
				rw(src,dest.getParentFile());// 复制文件至上级目录
			}
		}
		if(src.isFile()){
			rw(src, dest);// 复制文件至目的文件夹
		}else if (src.isDirectory()){
		File[] data = src.listFiles();// 获取源文件目录下的文件列表
		if (data == null) // 判断如果date为null则跳过本次操作
		{
			return;
		}
		// 遍历数组
		for (File file : data) {
			/* 如果是文件则输出文件的绝对路径 */
			if (file.isFile()) {
				rw(file, new File(dest, file.getName()));// 复制文件至目的文件夹
			} else if (file.isDirectory()) {
				queue.add(file);//向集合中添加目录对象
		}
			process(src);//处理队列中的目录对象
		}
	}
	}

	public static void rw(File src, File dest) throws IOException {
		if (!src.exists())
			throw new RuntimeException("源文件不存在");
		// 创建字节流输入缓冲区对象
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		// 创建字节流输出缓冲区对象
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		// 创建读取字节数组
		byte[] ch = new byte[1024];
		// 创建变量count记录读取到的字节数
		int count = 0;
		while ((count = bis.read(ch)) != -1) {
			bos.write(ch, 0, count);// 向字节流缓冲区写入数据
		}
		bos.close();// 关闭缓冲区对象
		bis.close();// 关闭缓冲区对象
	}

	/* 此方法为处理队列中的数据 */
	public static void process(File src) throws IOException {
		// 判断队列中是否含有元素
		while (!queue.isEmpty()) {
			File file = queue.getFile();// 获取文件对象
			copy(src,file);// 再次调用方法
		}
		return;
	}
}
