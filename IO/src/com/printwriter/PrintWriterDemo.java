package com.printwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
		//�����ַ���ӡ������
		PrintWriter pw = new PrintWriter(new FileWriter("D:/test/test.txt"),true);
		pw.write("������");
		pw.println("asdfg");
		pw.close();
	}

}
