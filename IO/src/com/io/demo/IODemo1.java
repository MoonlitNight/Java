package com.io.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IODemo1 {

	public static void main(String[] args) {
		File file = new File("D:\\����\\��������\\jdk-7u80-windows-x64.exe");
		long time = file.lastModified();
		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
		System.out.println(str);// �����ӡ
	}

}
