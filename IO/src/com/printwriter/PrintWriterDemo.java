package com.printwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
		//创建字符打印流对象
		PrintWriter pw = new PrintWriter(new FileWriter("D:/test/test.txt"),true);
		pw.write("喀喀喀");
		pw.println("asdfg");
		pw.close();
	}

}
