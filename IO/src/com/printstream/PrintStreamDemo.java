package com.printstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		// 创建字节打印流对象
		PrintStream ps = new PrintStream(new FileOutputStream("D:/test/test.txt"));
		ps.print("sdddsdd");
		
	}

}
