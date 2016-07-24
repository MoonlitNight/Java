package com.io.demo;

import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;
import java.util.Date;

/*自定义过滤器，实现FileFilter接口*/
class MyFileFilter2 implements FileFilter {
	/* 重写accept()方法，自定义过滤规则 */
	public boolean accept(File path) {
		// 获取最后修改时间的年份
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(path.lastModified()));
		int year = c.get(Calendar.YEAR);
		// 判断该文件为文件且最后修改时间年份为2014或者是文件夹
		if (path.isFile() && (year==2014)||path.isDirectory()) {
			return true;
		}
		return false;
	}
}

public class IODemo3 {
	public static void main(String[] args) {
		File file = new File("D:\\Backup\\ISO");// 创建Flie对象
		getFile(file, new MyFileFilter2());// 调用方法获取后缀为.jpg文件方法
	}

	public static void getFile(File file, MyFileFilter2 myFileFilter) {
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
