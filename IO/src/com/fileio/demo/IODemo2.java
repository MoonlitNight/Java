package com.fileio.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
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

/* 自定义过滤器，实现FileFilter接口 */
class MyFileFilter2 implements FileFilter {

	private String regex;// 后缀名

	public MyFileFilter2(String regex) {
		super();
		setRegex(regex);// 设置过滤正则表达式
	}

	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * @param regex
	 *            the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/* 重写accept()方法，自定义过滤规则 */
	public boolean accept(File path) {
		/* 判断如果是文件且文件名正则匹配或者是文件夹则不过滤 */
		if (path.isFile() && path.getName().matches(regex) || path.isDirectory()) {
			return true;
		}
		return false;
	}
}

public class IODemo2 {

	public static Queue queue = new Queue();// 创建队列对象
	public static MyFileFilter2 mff = new MyFileFilter2(".+(.java)$");// 创建过滤器对象

	public static void main(String[] args) {
		File file = new File("D:\\文档\\JAVA\\eclipse");// 创建Flie对象
		try {
			long start = System.currentTimeMillis();// 获取开始复制时毫秒值
			getFile(file);
			long end = System.currentTimeMillis();// 获取复制完成时毫秒值
			System.out.println("共计使用" + (end - start) + "毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getFile(File file) throws IOException {
		if (!file.exists()) // 判断是否存在文件或目录
		{
			throw new RuntimeException(file + "路径不存在");// 不存在则抛出异常
		}
		File[] data = file.listFiles(mff);// 按照过滤器过滤文件
		if (data == null) // 判断如果date为null则跳过本次操作
		{
			return;
		}
		// 遍历数组
		for (File file2 : data) {
			/* 如果是文件则输出文件的绝对路径 */
			if (file2.isFile()) {
				record(file2);
			} else if (file2.isDirectory()) {
				/* 如果是目录则将目录对象添加到队列中 */
				queue.add(file2);
			}
		}
		process();// 调用队列处理数据
	}

	/* 此方法为处理队列中的数据 */
	public static void process() throws IOException {
		// 判断队列中是否含有元素
		while (!queue.isEmpty()) {
			File file = queue.getFile();// 获取文件对象
			getFile(file);// 再次调用方法
		}
		return;
	}

	public static void record(File file) throws IOException {
		if (!file.exists())
			throw new RuntimeException("源文件不存在");
		// 创建字节流输出缓冲区对象
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\record.txt"), true));
		// 创建读取字节数组
		String path = file.getAbsolutePath() + System.getProperty("line.separator");
		byte[] ch = path.getBytes();
		bos.write(ch);// 向字节流缓冲区写入数据
		bos.flush();// 刷新次缓冲的输出流
		bos.close();// 关闭缓冲区对象
	}

}
