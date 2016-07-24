package com.io.demo;

import java.io.File;
import java.io.FileFilter;

/*自定义过滤器，实现FileFilter接口*/
class MyFileFilter3 implements FileFilter {

	public MyFileFilter3(String suffix) {
		super();
		setSuffix(suffix);// 设置过滤后缀名
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	private String suffix;// 后缀名

	/* 重写accept()方法，自定义过滤规则 */
	public boolean accept(File path) {
		/*判断如果是文件且文件名后缀匹配或者是文件夹则不过滤*/
		if (path.isFile() && path.getName().endsWith(suffix)||path.isDirectory()) {
			return true;
		}
		return false;
	}

}

public class IODemo4 {

	public static void main(String[] args) {
		File file = new File("D:\\文档\\JAVA\\eclipse");// 创建Flie对象
		getFile(file, new MyFileFilter3(".class"));// 调用方法获取后缀为.jpg文件方法
		getFile(file, new MyFileFilter3(".java"));// 调用方法获取后缀为.png文件方法
	}

	public static void getFile(File file, MyFileFilter3 myFileFilter) {
		if (!file.exists()) // 判断是否存在文件或目录
		{
			throw new RuntimeException(file + "路径不存在");// 不存在则抛出异常
		}
		File[] data = file.listFiles(myFileFilter);// 按照过滤器过滤文件
		if(data==null)//判断如果date为null则跳过本次操作
		{
			return;
		}
		// 遍历数组
		for (File file2 : data) {
			/* 如果是文件则输出文件的绝对路径 */
			if (file2.isFile()) {
				System.out.println(file2.getAbsolutePath());
			} else if (file2.isDirectory()) {
				/* 如果是目录则递归调用 */
				getFile(file2, myFileFilter);
			}
		}
	}

}
