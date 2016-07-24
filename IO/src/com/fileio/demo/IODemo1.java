package com.fileio.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*自定义过滤器，实现FileFilter接口*/
class MyFileFilter implements FileFilter {

	private String regex;// 后缀名

	public MyFileFilter(String regex) {
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
		/* 判断如果是文件且文件名正则匹配则不过滤 */
		if (path.isFile() && path.getName().matches(regex)) {
			return true;
		}
		return false;
	}
}

public class IODemo1 {

	public static void main(String[] args) {
		File file = new File("D:\\图片\\Saved Pictures");// 创建Flie对象
		try {
			long start = System.currentTimeMillis();//获取开始复制时毫秒值
			getFile(file, new MyFileFilter(".+[.jpg|.png|.bmp]$"));
			long end = System.currentTimeMillis();//获取复制完成时毫秒值
			System.out.println("复制文件共计使用"+(end-start)+"毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		}
 }

	public static void getFile(File file, MyFileFilter myFileFilter) throws IOException {
		if (!file.exists()) // 判断是否存在文件或目录
		{
			throw new RuntimeException(file + "路径不存在");// 不存在则抛出异常
		}
		File[] data = file.listFiles(myFileFilter);// 按照过滤器过滤文件
		if (data == null) // 判断如果date为null则跳过本次操作
		{
			return;
		}
		// 遍历数组
		for (File file2 : data) {
			/* 如果是文件则复制到目的文件夹 */
			if (file2.isFile()) {
				copy(file2,new File("D:\\图片\\copy\\"+file2.getName()));
			} /*else if (file2.isDirectory()) {
				 如果是目录则递归调用 
				getFile(file2, myFileFilter);
			}*/
		}
	}
	public static void copy(File src , File dest) throws IOException {
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
